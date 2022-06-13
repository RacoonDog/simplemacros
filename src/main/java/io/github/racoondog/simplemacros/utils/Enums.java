package io.github.racoondog.simplemacros.utils;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.lwjgl.glfw.GLFW;

import java.util.function.Function;

@Environment(EnvType.CLIENT)
public class Enums {
    public enum Modifier {
        None(0),
        Shift(1),
        Ctrl(2),
        ShiftCtrl(3),
        Alt(4),
        ShiftAlt(5),
        CtrlAlt(6),
        ShiftCtrlAlt(7);
        public final int modifierIdentifier;

        Modifier(int modifierIdentifier) {
            this.modifierIdentifier = modifierIdentifier;
        }

        public static boolean isShift(Enums.Modifier modifier) {
            return modifier.equals(Shift) || modifier.equals(ShiftCtrl) || modifier.equals(ShiftAlt) || modifier.equals(ShiftCtrlAlt);
        }

        public static boolean isCtrl(Enums.Modifier modifier) {
            return modifier.equals(Ctrl) || modifier.equals(ShiftCtrl) || modifier.equals(CtrlAlt) || modifier.equals(ShiftCtrlAlt);
        }

        public static boolean isAlt(Enums.Modifier modifier) {
            return modifier.equals(Alt) || modifier.equals(ShiftAlt) || modifier.equals(CtrlAlt) || modifier.equals(ShiftCtrlAlt);
        }

        public static Modifier fromIndex(int index) {
            for (var modifier : Modifier.values()) {
                if (index == modifier.modifierIdentifier) return modifier;
            }
            return null;
        }
    }

    public enum ActionType {
        Press(0, num -> num == GLFW.GLFW_PRESS),
        Release(1, num -> num == GLFW.GLFW_RELEASE),
        Repeat(2, num -> num == GLFW.GLFW_REPEAT),
        PressRelease(3, num -> num == GLFW.GLFW_PRESS || num == GLFW.GLFW_RELEASE),
        PressRepeat(4, num -> num == GLFW.GLFW_PRESS || num == GLFW.GLFW_REPEAT),
        ReleaseRepeat(5, num -> num == GLFW.GLFW_RELEASE || num == GLFW.GLFW_REPEAT),
        PressReleaseRepeat(6, num -> true);
        public final Function<Integer, Boolean> isValid;
        public final int index;

        ActionType(int index, Function<Integer, Boolean> isValid) {
            this.isValid = isValid;
            this.index = index;
        }

        public static int functionToIndex(Function<Integer, Boolean> function) {
            for (var actionType : Enums.ActionType.values()) {
                if (actionType.isValid.equals(function)) return actionType.index;
            }
            return Press.index;
        }
        public static Function<Integer, Boolean> indexToFunction(int index) {
            return switch (index) {
                default -> Press.isValid;
                case 1 -> Release.isValid;
                case 2 -> Repeat.isValid;
                case 3 -> PressRelease.isValid;
                case 4 -> PressRepeat.isValid;
                case 5 -> ReleaseRepeat.isValid;
                case 6 -> PressReleaseRepeat.isValid;
            };
        }
    }

    public enum Key {
        Space(GLFW.GLFW_KEY_SPACE),
        Apostrophe(GLFW.GLFW_KEY_APOSTROPHE),
        Comma(GLFW.GLFW_KEY_COMMA),
        Minus(GLFW.GLFW_KEY_MINUS),
        Period(GLFW.GLFW_KEY_PERIOD),
        Slash(GLFW.GLFW_KEY_SLASH),
        Zero(GLFW.GLFW_KEY_0),
        One(GLFW.GLFW_KEY_1),
        Two(GLFW.GLFW_KEY_2),
        Three(GLFW.GLFW_KEY_3),
        Four(GLFW.GLFW_KEY_4),
        Five(GLFW.GLFW_KEY_5),
        Six(GLFW.GLFW_KEY_6),
        Seven(GLFW.GLFW_KEY_7),
        Eight(GLFW.GLFW_KEY_8),
        Nine(GLFW.GLFW_KEY_9),
        Semicolon(GLFW.GLFW_KEY_SEMICOLON),
        Equal(GLFW.GLFW_KEY_EQUAL),
        A(GLFW.GLFW_KEY_A),
        B(GLFW.GLFW_KEY_B),
        C(GLFW.GLFW_KEY_C),
        D(GLFW.GLFW_KEY_D),
        E(GLFW.GLFW_KEY_E),
        F(GLFW.GLFW_KEY_F),
        G(GLFW.GLFW_KEY_G),
        H(GLFW.GLFW_KEY_H),
        I(GLFW.GLFW_KEY_I),
        J(GLFW.GLFW_KEY_J),
        K(GLFW.GLFW_KEY_K),
        L(GLFW.GLFW_KEY_L),
        M(GLFW.GLFW_KEY_M),
        N(GLFW.GLFW_KEY_N),
        O(GLFW.GLFW_KEY_O),
        P(GLFW.GLFW_KEY_P),
        Q(GLFW.GLFW_KEY_Q),
        R(GLFW.GLFW_KEY_R),
        S(GLFW.GLFW_KEY_S),
        T(GLFW.GLFW_KEY_T),
        U(GLFW.GLFW_KEY_U),
        V(GLFW.GLFW_KEY_V),
        W(GLFW.GLFW_KEY_W),
        X(GLFW.GLFW_KEY_X),
        Y(GLFW.GLFW_KEY_Y),
        Z(GLFW.GLFW_KEY_Z),
        LeftBracket(GLFW.GLFW_KEY_LEFT_BRACKET),
        BackSlash(GLFW.GLFW_KEY_BACKSLASH),
        RightBracket(GLFW.GLFW_KEY_RIGHT_BRACKET),
        GraveAccent(GLFW.GLFW_KEY_GRAVE_ACCENT),
        Enter(GLFW.GLFW_KEY_ENTER),
        Tab(GLFW.GLFW_KEY_TAB),
        ArrowRight(GLFW.GLFW_KEY_RIGHT),
        ArrowLeft(GLFW.GLFW_KEY_LEFT),
        ArrowDown(GLFW.GLFW_KEY_DOWN),
        ArrowUp(GLFW.GLFW_KEY_UP),
        PageUp(GLFW.GLFW_KEY_PAGE_UP),
        PageDown(GLFW.GLFW_KEY_PAGE_DOWN),
        Home(GLFW.GLFW_KEY_HOME),
        End(GLFW.GLFW_KEY_END),
        CapsLock(GLFW.GLFW_KEY_CAPS_LOCK),
        ScrollLock(GLFW.GLFW_KEY_SCROLL_LOCK),
        NumLock(GLFW.GLFW_KEY_NUM_LOCK),
        PrintScreen(GLFW.GLFW_KEY_PRINT_SCREEN),
        Pause(GLFW.GLFW_KEY_PAUSE),
        F1(GLFW.GLFW_KEY_F1),
        F2(GLFW.GLFW_KEY_F2),
        F3(GLFW.GLFW_KEY_F3),
        F4(GLFW.GLFW_KEY_F4),
        F5(GLFW.GLFW_KEY_F5),
        F6(GLFW.GLFW_KEY_F6),
        F7(GLFW.GLFW_KEY_F7),
        F8(GLFW.GLFW_KEY_F8),
        F9(GLFW.GLFW_KEY_F9),
        F10(GLFW.GLFW_KEY_F10),
        F11(GLFW.GLFW_KEY_F11),
        F12(GLFW.GLFW_KEY_F12),
        F13(GLFW.GLFW_KEY_F13),
        F14(GLFW.GLFW_KEY_F14),
        F15(GLFW.GLFW_KEY_F15),
        F16(GLFW.GLFW_KEY_F16),
        F17(GLFW.GLFW_KEY_F17),
        F18(GLFW.GLFW_KEY_F18),
        F19(GLFW.GLFW_KEY_F19),
        F20(GLFW.GLFW_KEY_F20),
        F21(GLFW.GLFW_KEY_F21),
        F22(GLFW.GLFW_KEY_F22),
        F23(GLFW.GLFW_KEY_F23),
        F24(GLFW.GLFW_KEY_F24),
        F25(GLFW.GLFW_KEY_F25),
        KeyPad0(GLFW.GLFW_KEY_KP_0),
        KeyPad1(GLFW.GLFW_KEY_KP_0),
        KeyPad2(GLFW.GLFW_KEY_KP_2),
        KeyPad3(GLFW.GLFW_KEY_KP_3),
        KeyPad4(GLFW.GLFW_KEY_KP_4),
        KeyPad5(GLFW.GLFW_KEY_KP_5),
        KeyPad6(GLFW.GLFW_KEY_KP_6),
        KeyPad7(GLFW.GLFW_KEY_KP_7),
        KeyPad8(GLFW.GLFW_KEY_KP_8),
        KeyPad9(GLFW.GLFW_KEY_KP_9),
        KeyPadDecimal(GLFW.GLFW_KEY_KP_DECIMAL),
        KeyPadDivide(GLFW.GLFW_KEY_KP_DIVIDE),
        KeyPadMultiply(GLFW.GLFW_KEY_KP_MULTIPLY),
        KeyPadSubtract(GLFW.GLFW_KEY_KP_SUBTRACT),
        KeyPadAdd(GLFW.GLFW_KEY_KP_ADD),
        KeyPadEnter(GLFW.GLFW_KEY_KP_ENTER),
        KeyPadEqual(GLFW.GLFW_KEY_KP_EQUAL),
        LeftShift(GLFW.GLFW_KEY_LEFT_SHIFT),
        LeftControl(GLFW.GLFW_KEY_LEFT_CONTROL),
        LeftAlt(GLFW.GLFW_KEY_LEFT_ALT),
        RightShift(GLFW.GLFW_KEY_RIGHT_SHIFT),
        RightControl(GLFW.GLFW_KEY_RIGHT_CONTROL),
        RightAlt(GLFW.GLFW_KEY_RIGHT_ALT),
        Menu(GLFW.GLFW_KEY_MENU),
        MouseLeft(GLFW.GLFW_MOUSE_BUTTON_LEFT),
        MouseRight(GLFW.GLFW_MOUSE_BUTTON_RIGHT),
        MouseMiddle(GLFW.GLFW_MOUSE_BUTTON_MIDDLE),
        Mouse4(GLFW.GLFW_MOUSE_BUTTON_4),
        Mouse5(GLFW.GLFW_MOUSE_BUTTON_5),
        Mouse6(GLFW.GLFW_MOUSE_BUTTON_6),
        Mouse7(GLFW.GLFW_MOUSE_BUTTON_7),
        Mouse8(GLFW.GLFW_MOUSE_BUTTON_8);
        public final int keyIdentifier;
        Key(int keyIdentifier) {
            this.keyIdentifier = keyIdentifier;
        }

        public static Key fromIndex(int index) {
            for (var key : Key.values()) {
                if (index == key.keyIdentifier) return key;
            }
            return null;
        }
    }
}
