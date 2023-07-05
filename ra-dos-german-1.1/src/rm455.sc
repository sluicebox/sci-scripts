;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 455)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm455 0
)

(instance rm455 of LBRoom
	(properties
		picture 555
	)

	(method (init)
		(LoadMany rsVIEW 470 563)
		(LoadMany rsSOUND 6)
		(super init:)
		(gGame points: 1 134)
		(self setScript: sFindPippin)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(screamAndLook fade: 0 12 30 1)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(proc0_8 0)
		(screamAndLook fade: 0 12 30 1)
		(wrapMusic dispose: 1)
		(super newRoom: newRoomNumber)
	)
)

(instance sFindPippin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic2 number: 82 flags: 5 loop: 1 play:)
				(wrapMusic init: -1 1 6)
				(= seconds 3)
			)
			(1
				(gGame handsOn:)
				(proc0_8 1)
				(gCurRoom drawPic: 470)
				(gCurRoom picture: 470)
				(drip init: setCycle: Fwd)
				(pipMummy init:)
				(leftEye init:)
				(rightEye init:)
				(nose init:)
				(moustache init:)
				(mouthOpen init:)
				(ear init:)
				(hair init:)
				(dagger init:)
				(jacket init:)
				(pants init:)
				(vest init:)
				(flesh init:)
				(shirt init:)
				(flower init:)
			)
			(2
				(gCurRoom newRoom: 454)
			)
		)
	)
)

(instance drip of Prop
	(properties
		x 180
		y 100
		noun 2
		view 470
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pipMummy of Feature
	(properties
		x 1
		y 1
		noun 13
		onMeCheck -32768
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftEye of Feature
	(properties
		x 1
		y 1
		noun 14
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightEye of Feature
	(properties
		x 1
		y 1
		noun 8
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nose of Feature
	(properties
		x 1
		y 1
		noun 11
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance moustache of Feature
	(properties
		x 1
		y 1
		noun 9
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mouthOpen of Feature
	(properties
		x 1
		y 1
		noun 10
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ear of Feature
	(properties
		x 1
		y 1
		noun 3
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hair of Feature
	(properties
		x 1
		y 1
		noun 6
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dagger of Feature
	(properties
		x 1
		y 1
		noun 1
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jacket of Feature
	(properties
		x 1
		y 1
		noun 7
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (gEgo has: 21) ; pippin_sPad
					(gMessager say: 7 1 2) ; "By removing the notepad from Pippin's pocket, you have improved the appearance of his tuxedo jacket. If he were still alive, he'd certainly thank you."
				else
					(gMessager say: 7 1 1) ; "There's a slight bulge in Pippin's jacket, as if he's carrying something in an inside pocket."
				)
			)
			(8 ; magnifier
				(if (gEgo has: 21) ; pippin_sPad
					(gMessager say: 7 8 2) ; "The jacket is free of blood, but there is a bluish stain on one lapel. A close look and sniff at the stain makes you think that it's grape juice."
				else
					(gMessager say: 7 8 1) ; "The jacket is free of blood, but there is a bluish stain on one lapel. A close look and sniff at the stain makes you think that it's grape juice."
				)
			)
			(4 ; Do
				(if (gEgo has: 21) ; pippin_sPad
					(gMessager say: 7 4 2) ; "There is nothing else in Pippin's tuxedo jacket except lint, which you don't need."
				else
					(gCurRoom setInset: inNotepad)
				)
			)
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pants of Feature
	(properties
		x 1
		y 1
		noun 12
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vest of Feature
	(properties
		x 1
		y 1
		noun 16
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flesh of Feature
	(properties
		x 1
		y 1
		noun 4
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shirt of Feature
	(properties
		x 1
		y 1
		noun 15
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flower of Feature
	(properties
		x 1
		y 1
		noun 5
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(sFindPippin cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inNotepad of Inset
	(properties
		view 563
		loop 2
		cel 2
		x 118
		y 79
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
		(gMessager say: 7 4 1) ; "When you reach into Pippin's tuxedo jacket, you find a notepad in his inner pocket."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self dispose:)
				(gGame points: 1 135)
				((ScriptID 21 0) doit: 790) ; addCluesCode, Pippin's Notepad
				(gEgo get: 21) ; pippin_sPad
			)
			(1 ; Look
				(gMessager say: 45 1 0 0 0 15) ; "A notepad made of good quality paper. There's an imprint on the paper from the previous message written on the pad, but it's too faint to read."
			)
			(8 ; magnifier
				(gMessager say: 45 8 0 0 0 15) ; "Unreadable words are imprinted on the paper."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wrapMusic of WrapMusic
	(properties)

	(method (init)
		(= wrapSound screamAndLook)
		(super init: &rest)
	)
)

(instance screamAndLook of Sound
	(properties)
)

