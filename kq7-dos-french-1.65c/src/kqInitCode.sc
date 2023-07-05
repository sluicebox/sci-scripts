;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use ExitButton)
(use aEgoTalker)
(use n098)
(use Styler)
(use Str)
(use Print)
(use User)
(use System)

(public
	kqInitCode 0
)

(instance kqInitCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp1 (Str newWith: 16 {}))
		(= gUserFont 4)
		(User alterEgo: KQEgo canControl: 0 canInput: 0)
		(if (DoSound sndGET_AUDIO_CAPABILITY)
			(= gMsgType 2)
			(DoAudio 12 0) ; AudMixCheck
			(DoAudio audRATE 22050)
			(DoAudio 10 16) ; AudBits
		else
			(= gMsgType 1)
		)
		(= gUseSortedFeatures 1)
		(Styler divisions: 20)
		(= gScore 0)
		(gGame masterVolume: 15)
		(Print font: 999 back: 0 fore: 94 skip: 254)
		(if (IsHiRes)
			(SetFlag 22)
			(SetFontRes 640 480)
		)
		(= global106 (DoSound sndGET_POLYPHONY))
		(temp1 format: {%d.scr} 99)
		(if (or (proc98_9) (FileIO fiEXISTS (temp1 data:)))
			(= gDebugging 1)
		else
			(= gDebugging 0)
		)
		(temp1 dispose:)
		(= gEatMice 2)
		(SetPalStyleRange 0 103)
		(DisposeScript 10)
	)
)

