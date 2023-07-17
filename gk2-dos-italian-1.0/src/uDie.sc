;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 666)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use Osc)
(use Sound)
(use Actor)

(public
	uDie 0
)

(instance howl of Sound
	(properties)
)

(instance uDie of GK2Room
	(properties
		picture 12090
	)

	(method (init)
		(proc11_12)
		(Palette 2 0 255 0) ; PalIntensity
		((gUser sel_715:) sel_717: 60 352 627 475)
		(resetButton init:)
		(restoreButton init:)
		(quitButton init:)
		(super init: &rest)
		(howl setLoop: 1 number: 603 play:)
		((gUser sel_715:) sel_719: 0)
		((gUser sel_715:) sel_737:)
		(gThePlane setRect: 0 0 640 480 priority: 202)
		(gGame sel_849:)
		((ScriptID 0 9) active: 0) ; logo
		((ScriptID 0 7) active: 0) ; movieButton
		((ScriptID 0 5) active: 0) ; recButton
		(UpdatePlane gThePlane)
		(proc11_13)
	)

	(method (dispose)
		(gGame sel_849: 0)
		((ScriptID 0 9) active: 1) ; logo
		((ScriptID 0 7) active: 1) ; movieButton
		((ScriptID 0 5) active: 1) ; recButton
		(gThePlane setRect: 12 15 627 349 priority: 1)
		((gUser sel_715:) sel_719: 1 sel_717: 0)
		(super dispose: &rest)
	)
)

(instance resetButton of Prop
	(properties
		x 129
		y 445
		view 12090
	)

	(method (doVerb)
		(self setCycle: Osc 1 self)
	)

	(method (cue)
		(proc11_12)
		(gCurRoom drawPic: -1)
		(cond
			((IsFlag 407)
				(= global144 0)
				(if (== global136 651)
					(gCurRoom newRoom: 651) ; hravineRm
				else
					(gCurRoom newRoom: 631) ; hwoods7Rm
					(if (IsFlag 1086)
						(-= gScore 3)
						(gGame changeScore:)
						(ClearFlag 1086)
					)
				)
			)
			((== gPrevRoomNum 665) ; gabeNews
				(if (IsFlag 1136)
					(ClearFlag 1136)
					(-= gScore 1)
				)
				(if (IsFlag 1147)
					(ClearFlag 1147)
					(-= gScore 2)
				)
				(if (IsFlag 1137)
					(ClearFlag 1137)
					(-= gScore 1)
				)
				(if (IsFlag 1166)
					(ClearFlag 1166)
					(-= gScore 5)
				)
				(if (IsFlag 1156)
					(ClearFlag 1156)
					(-= gScore 3)
				)
				(if (IsFlag 1167)
					(ClearFlag 1167)
					(-= gScore 5)
				)
				(gGame changeScore:)
				(gCurRoom newRoom: 1160) ; dressingRm
			)
			((or (IsFlag 810) (== gPrevRoomNum 11871))
				(ClearFlag 810)
				(if (IsFlag 1168)
					(ClearFlag 1168)
					(-= gScore 5)
					(gGame changeScore:)
				)
				(gCurRoom newRoom: 15001)
			)
			((== gPrevRoomNum 1300) ; endGameRm
				(if (IsFlag 1138)
					(ClearFlag 1138)
					(-= gScore 1)
				)
				(if (IsFlag 1139)
					(ClearFlag 1139)
					(-= gScore 1)
				)
				(if (IsFlag 1148)
					(ClearFlag 1148)
					(-= gScore 2)
				)
				(gGame changeScore:)
				(gCurRoom newRoom: 1300) ; endGameRm
			)
			(else
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance restoreButton of Prop
	(properties
		x 256
		y 445
		view 12090
		loop 1
	)

	(method (doVerb)
		(self setCycle: Osc 1 self)
	)

	(method (cue)
		(gGame restore:)
		((gUser sel_715:) sel_719: 0)
	)
)

(instance quitButton of Prop
	(properties
		x 386
		y 445
		view 12090
		loop 2
	)

	(method (doVerb)
		(self setCycle: Osc 1 self)
	)

	(method (cue)
		(gGame quitGame:)
		((gUser sel_715:) sel_719: 0)
	)
)

