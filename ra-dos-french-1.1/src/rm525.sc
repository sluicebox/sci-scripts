;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 525)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Feature)
(use LoadMany)
(use Timer)
(use Sound)
(use Actor)
(use System)

(public
	rm525 0
)

(local
	local0
)

(procedure (localproc_0)
	(proc0_8 1)
	(if (not (gEgo has: 31)) ; grapes
		(grapes init:)
	)
	(feIntercom init:)
	(feDocBottom init:)
	(feDocTop init:)
	(feDesk init:)
	(feDocDesk init:)
	(feDocLeft init:)
	(feBody init:)
	(feAnkle init:)
	(feLeg init:)
	(feHands init:)
	(feFace init:)
	(gGame handsOn:)
	(gTheIconBar disable: 7)
)

(instance rm525 of LBRoom
	(properties
		picture 525
	)

	(method (init)
		(gTheIconBar disable: 7)
		(LoadMany rsVIEW 520 523 524 525 526)
		(LoadMany rsPIC 556 525)
		(LoadMany rsSOUND 520 524 4 6 85)
		(self setRegions: 90) ; MuseumRgn
		(= local0 gDoVerbCode)
		(= gDoVerbCode exitDoVerbCode)
		(if (SetFlag 69)
			(= picture 525)
			(gGameMusic1 number: 6 loop: -1 flags: 1 play:)
			(localproc_0)
		else
			(= picture 556)
			(wrapMusic init: -1 4 6)
			(sFX number: 85 flags: 5 loop: 1 play:)
			((Timer new:) setReal: self 3)
		)
		(super init:)
	)

	(method (cue)
		(self drawPic: (= picture 525))
		(localproc_0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(self newRoom: 520)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(= gDoVerbCode local0)
		(if inset
			(inset dispose:)
		)
		(gTheIconBar enable: 7)
		(if (gSounds contains: wrapSong)
			(wrapMusic dispose: 1)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance grapes of View
	(properties
		x 224
		y 154
		noun 15
		view 526
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: inGrapes)
			)
			(8 ; magnifier
				(gCurRoom setInset: inGrapes)
			)
			(4 ; Do
				(gCurRoom setInset: inGrapes)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance feIntercom of Feature
	(properties
		y 1
		noun 10
		sightAngle 40
		onMeCheck 4
	)
)

(instance feDocBottom of Feature
	(properties
		y 1
		noun 4
		sightAngle 40
		onMeCheck 16
	)
)

(instance feDocTop of Feature
	(properties
		y 1
		noun 7
		sightAngle 40
		onMeCheck 32
	)
)

(instance feDesk of Feature
	(properties
		y 1
		noun 3
		sightAngle 40
		onMeCheck 128
	)
)

(instance feDocDesk of Feature
	(properties
		y 1
		noun 5
		sightAngle 40
		onMeCheck 256
	)
)

(instance feDocLeft of Feature
	(properties
		y 1
		noun 6
		sightAngle 40
		onMeCheck 512
	)
)

(instance feBody of Feature
	(properties
		y 1
		noun 2
		sightAngle 40
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; magnifier
				(if (not (gEgo has: 13)) ; smellingSalts
					(gCurRoom setInset: inSmellingSalts)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance feAnkle of Feature
	(properties
		y 1
		noun 1
		sightAngle 40
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; magnifier
				(gCurRoom setInset: inFeAnkle)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance feLeg of Feature
	(properties
		y 1
		noun 11
		sightAngle 40
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; magnifier
				(gCurRoom setInset: inFeAnkle)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance feHands of Feature
	(properties
		y 1
		noun 9
		sightAngle 40
		onMeCheck 16384
	)
)

(instance feFace of Feature
	(properties
		y 1
		noun 8
		sightAngle 40
		onMeCheck -32768
	)
)

(instance inGrapes of Inset
	(properties
		view 526
		x 210
		y 144
		disposeNotOnMe 1
		noun 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 520)
			)
			(4 ; Do
				(gGame points: 1 165)
				(gEgo get: 31) ; grapes
				((ScriptID 21 0) doit: 800) ; addCluesCode, Grapes
				((ScriptID 22 0) doit: $0010) ; triggerAndClock
				(grapes dispose:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inSmellingSalts of Inset
	(properties
		view 526
		loop 1
		x 121
		y 41
		disposeNotOnMe 1
		noun 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 520)
			)
			(4 ; Do
				(gGame points: 1 166)
				(gEgo get: 13) ; smellingSalts
				((ScriptID 21 0) doit: 782) ; addCluesCode, Smelling Salts
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inFeAnkle of Inset
	(properties
		view 526
		loop 2
		x 117
		y 133
		disposeNotOnMe 1
		noun 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 520)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inIntercom of Inset ; UNUSED
	(properties
		view 520
		x 162
		y 79
		disposeNotOnMe 1
		noun 13
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 520)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wrapMusic of WrapMusic
	(properties)

	(method (init)
		(= wrapSound wrapSong)
		(super init: &rest)
	)
)

(instance wrapSong of Sound
	(properties)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

(instance exitDoVerbCode of Code
	(properties)

	(method (doit param1 param2)
		(if (== param1 13)
			(proc0_8 0)
			(gCurRoom newRoom: 520)
		else
			(proc0_6 param2 param1)
		)
	)
)

