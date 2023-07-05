;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 391)
(include sci.sh)
(use Main)
(use n013)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Cursor)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm391 0
)

(local
	local0
	local1
	[local2 2] = [1 1]
	local4
	local5 = 1
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
)

(instance rm391 of Room
	(properties
		modNum 390
		noun 24
		picture 395
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 390)
		(clockFace init:)
		(leftExit init:)
		(rightExit init:)
		(theDial init: cel: (mod global213 12))
		(bigHand init: cel: (mod (/ global213 12) 12))
		(littleHand init: cel: (/ global213 144))
		(drawerFeature init:)
		(theKey init:)
		(Load rsVIEW 396)
		(Load rsVIEW 3961)
		(= local10 gTheCursor)
	)

	(method (doit)
		(super doit:)
		(if (and local5 (not inset))
			(cond
				(
					(or
						(rightExit onMe: gMouseX (- gMouseY 10))
						(leftExit onMe: gMouseX (- gMouseY 10))
					)
					(if (not local4)
						(= local4 1)
						(= local10 gTheCursor)
					)
					(if (!= gTheCursor myInsetExitCursor)
						(gGame setCursor: myInsetExitCursor 1)
					)
				)
				(local4
					(gGame setCursor: local10 1)
					(= local4 0)
				)
			)
		)
	)

	(method (dispose)
		(= local5 0)
		(gGame setCursor: local10 1)
		(DisposeScript 64956)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 206)
					(gMessager say: noun theVerb 10 0 0 390) ; "Grandad's clock still isn't running, but Gabriel's learned a thing or two from it anyway."
					(return 1)
				else
					(gMessager say: noun theVerb 9 0 0 390) ; "An elaborate mechanical clock--probably of German origin--is among the discarded treasures of the attic."
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance moveTheDial of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(SetCursor 0 0 319 155)
		(if
			(and
				(== (littleHand cel:) 3)
				(== (bigHand cel:) 0)
				(== (theDial cel:) 2)
			)
			(= local0 1)
		else
			(= local0 0)
		)
	)

	(method (doit)
		(super doit:)
		(= local6 (GetAngle 172 62 gMouseX gMouseY))
		(= local11 (- local7 local6))
		(if (>= (Abs local11) 23)
			(cond
				((<= (- local7 local6) -180)
					(-- local8)
				)
				((>= (- local7 local6) 180)
					(++ local8)
				)
				((> local7 local6)
					(-- local8)
				)
				(else
					(++ local8)
				)
			)
			(theDial cel: local8)
			(if (> local8 11)
				(= local8 0)
			)
			(if (< local8 0)
				(= local8 11)
			)
			(= local7 local6)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theDial init:)
				(takeDialEvents init:)
				(SetCursor 132 36 215 105)
				(gTheIconBar disable: 1 2 0 3 6 8 9)
				(= local10 gTheCursor)
				((gTheIconBar at: 7) cursorView: myCursor)
				(gGame setCursor: myCursor)
			)
			(1
				(gTheIconBar enable: 1 2 0 3 6 8 9)
				((gTheIconBar at: 7) cursorView: local10)
				(gGame setCursor: local10)
				(SetCursor 0 0 319 155)
				(takeDialEvents dispose:)
				(self dispose:)
			)
		)
	)
)

(instance moveTheBigHand of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(SetCursor 0 0 319 155)
		(if
			(and
				(== (littleHand cel:) 3)
				(== (bigHand cel:) 0)
				(== (theDial cel:) 2)
			)
			(= local0 1)
		else
			(= local0 0)
		)
	)

	(method (doit)
		(super doit:)
		(= local6 (GetAngle 172 61 gMouseX gMouseY))
		(cond
			((or (<= 0 local6 15) (<= 344 local6 359))
				(= local8 0)
			)
			((<= 16 local6 46)
				(= local8 1)
			)
			((<= 47 local6 77)
				(= local8 2)
			)
			((<= 78 local6 108)
				(= local8 3)
			)
			((<= 109 local6 139)
				(= local8 4)
			)
			((<= 140 local6 170)
				(= local8 5)
			)
			((<= 171 local6 201)
				(= local8 6)
			)
			((<= 202 local6 232)
				(= local8 7)
			)
			((<= 233 local6 263)
				(= local8 8)
			)
			((<= 264 local6 294)
				(= local8 9)
			)
			((<= 295 local6 325)
				(= local8 10)
			)
			((<= 326 local6 343)
				(= local8 11)
			)
		)
		(cond
			((<= (- local7 local6) -180)
				(-- local9)
			)
			((>= (- local7 local6) 180)
				(++ local9)
			)
		)
		(bigHand cel: local8)
		(littleHand cel: local9)
		(if (> local9 11)
			(= local9 0)
		)
		(if (< local9 0)
			(= local9 11)
		)
		(= local7 local6)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bigHand init:)
				(takeEvents init:)
				(SetCursor 151 54 191 87)
				(gTheIconBar disable: 1 2 0 3 6 8 9)
				(= local10 gTheCursor)
				((gTheIconBar at: 7) cursorView: myCursor)
				(gGame setCursor: myCursor)
			)
			(1
				(gTheIconBar enable: 1 2 0 3 6 8 9)
				((gTheIconBar at: 7) cursorView: local10)
				(gGame setCursor: local10)
				(SetCursor 0 0 319 155)
				(takeEvents dispose:)
				(self dispose:)
			)
		)
	)
)

(instance openTheDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 0)
				(gGame handsOff:)
				(gMessager say: 19 8 11 1 0 390) ; "!!!Blank msg"
				(gGkSound1 number: 393 setLoop: 1 play: self)
				(theKey cel: 0 setCycle: ForwardCounter 2 self)
			)
			(1)
			(2
				(gGkSound1 number: 310 setLoop: 1 play:)
				(if local0
					(SetFlag 206)
					(= local1 1)
					(cond
						((and (not (gEgo has: 12)) (not (gEgo has: 34))) ; ritLetter, ritPhoto
							(drawer
								view: 396
								loop: 2
								cel: 0
								init:
								setCycle: End self
							)
							(getTheItem init:)
						)
						((and (gEgo has: 34) (not (gEgo has: 12))) ; ritPhoto, ritLetter
							(drawer
								view: 3961
								loop: 4
								cel: 0
								init:
								setCycle: End self
							)
							(getTheItem init:)
						)
						(else
							(drawer
								view: 3961
								loop: 5
								cel: 0
								init:
								setCycle: End self
							)
						)
					)
					(if (not (IsFlag 207))
						(gMessager say: 19 8 11 2 self 390) ; "(ARCC)Grandaddy, you old fox!"
						(SetFlag 207)
					)
					(gEgo getPoints: 135 5)
				else
					(gMessager say: 19 8 12 2 self 390) ; "Nothing happens."
				)
			)
			(3
				(gGame handsOn:)
				(= local5 1)
				(self dispose:)
			)
		)
	)
)

(instance closeTheDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(drawer setCycle: Beg self)
				(getTheItem dispose:)
				(= local1 0)
			)
			(1
				(drawer dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global213
					(+
						(theDial cel:)
						(* 12 (bigHand cel:))
						(* 144 (littleHand cel:))
					)
				)
				(if local1
					(self setScript: closeTheDrawer self)
				else
					(self cue:)
				)
			)
			(1
				(gCurRoom newRoom: 390)
			)
		)
	)
)

(instance nothingHappens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGkSound1 number: 393 setLoop: 1 play:)
				(theKey cel: 0 setCycle: ForwardCounter 2 self)
			)
			(1
				(= cycles 15)
			)
			(2
				(gMessager say: 19 8 12 2 self 390) ; "Nothing happens."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theDial of Prop
	(properties
		noun 22
		modNum 390
		x 171
		y 62
		view 395
		signal 4096
	)

	(method (init)
		(super init:)
		(self cel: local14)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; Move
				(gCurRoom setScript: moveTheDial)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bigHand of Prop
	(properties
		noun 21
		modNum 390
		x 172
		y 81
		z 20
		view 396
		signal 16384
	)

	(method (init)
		(super init:)
		(self cel: local12)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; Move
				(gCurRoom setScript: moveTheBigHand)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance littleHand of Prop
	(properties
		noun 20
		modNum 390
		x 172
		y 61
		view 396
		loop 1
		signal 20480
	)

	(method (init)
		(super init:)
		(self cel: local13)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; Move
				(gCurRoom setScript: moveTheBigHand)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drawer of Prop
	(properties
		noun 23
		modNum 390
		x 123
		y 110
		view 396
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					(local1
						(gMessager say: noun theVerb 15 0 0 390) ; "A secret drawer has opened in the base of the clock."
					)
					((IsFlag 207)
						(gMessager say: noun theVerb 18 0 0 390) ; "The secret drawer is closed."
					)
					(else
						(gMessager say: noun theVerb 19 0 0 390) ; "There's an interesting design in the base of the clock."
					)
				)
			)
			(6 ; Open
				(cond
					(local1
						(self setScript: closeTheDrawer)
					)
					((IsFlag 207)
						(gMessager say: noun theVerb 18 0 0 390) ; "Gabriel can't open the secret drawer that way."
					)
					(else
						(gMessager say: noun theVerb 19 0 0 390) ; "The clock won't open that way."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theKey of Prop
	(properties
		noun 19
		modNum 390
		x 83
		y 89
		view 396
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if
					(and
						(== (littleHand cel:) 3)
						(== (bigHand cel:) 0)
						(== (theDial cel:) 2)
					)
					(= local0 1)
				else
					(= local0 0)
				)
				(if (and (not local1) local0)
					(gCurRoom setScript: openTheDrawer)
				else
					(self setScript: nothingHappens)
				)
			)
			(9 ; Move
				(if
					(and
						(== (littleHand cel:) 3)
						(== (bigHand cel:) 0)
						(== (theDial cel:) 2)
					)
					(= local0 1)
				else
					(= local0 0)
				)
				(if (and (not local1) local0)
					(gCurRoom setScript: openTheDrawer)
				else
					(self setScript: nothingHappens)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance clockFace of Feature
	(properties
		noun 25
		modNum 390
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 160 79 148 69 143 57 152 44 169 38 186 42 195 50 197 65 186 77 170 81
					yourself:
				)
		)
		(super init:)
	)
)

(instance leftExit of Feature
	(properties
		modNum 390
		nsTop 25
		nsRight 47
		nsBottom 145
	)

	(method (doVerb)
		(gCurRoom setScript: leaveRoom)
	)
)

(instance rightExit of Feature
	(properties
		modNum 390
		nsLeft 254
		nsTop 22
		nsRight 319
		nsBottom 147
	)

	(method (doVerb)
		(gCurRoom setScript: leaveRoom)
	)
)

(instance getTheItem of Feature
	(properties
		noun 28
		modNum 390
		y 200
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 203 107 233 119 172 122 130 111
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(cond
					((and (not (gEgo has: 12)) (not (gEgo has: 34))) ; ritLetter, ritPhoto
						(drawer view: 3961 loop: 4 cel: 4)
						(gEgo getPoints: -999 1)
						(gEgo get: 34) ; ritPhoto
						(gMessager say: 28 theVerb 0 0 0 390) ; "!!!Blank msg"
					)
					((and (gEgo has: 34) (not (gEgo has: 12))) ; ritPhoto, ritLetter
						(drawer view: 3961 loop: 5 cel: 4)
						(gEgo getPoints: -999 1 get: 12) ; ritLetter
						(gMessager say: 29 theVerb 0 0 0 390) ; "!!!Blank msg"
						(self dispose:)
					)
				)
			)
			(else
				(if (OneOf theVerb 7 9 6 8) ; Look, Move, Open, Operate
					(cond
						((and (not (gEgo has: 12)) (not (gEgo has: 34))) ; ritLetter, ritPhoto
							(gMessager say: 28 theVerb 0 0 0 390)
						)
						((and (gEgo has: 34) (not (gEgo has: 12))) ; ritPhoto, ritLetter
							(gMessager say: 29 theVerb 0 0 0 390)
						)
						(else
							(gMessager say: 23 theVerb 15 0 0 390)
						)
					)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance drawerFeature of Feature
	(properties
		noun 23
		modNum 390
		y 25
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 125 110 223 104 225 126 126 135
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 207)
					(gMessager say: noun theVerb 18 0 0 390) ; "The secret drawer is closed."
				else
					(gMessager say: noun theVerb 19 0 0 390) ; "There's an interesting design in the base of the clock."
				)
			)
			(6 ; Open
				(if (IsFlag 207)
					(gMessager say: noun theVerb 18 0 0 390) ; "Gabriel can't open the secret drawer that way."
				else
					(gMessager say: noun theVerb 19 0 0 390) ; "The clock won't open that way."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance takeEvents of Feature
	(properties
		modNum 390
		y 300
	)

	(method (handleEvent)
		(moveTheBigHand cue:)
		(return 1)
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 138 46 171 28 204 45 206 76 173 91 142 78
					yourself:
				)
		)
	)
)

(instance takeDialEvents of Feature
	(properties
		modNum 390
		y 300
	)

	(method (handleEvent)
		(moveTheDial cue:)
		(return 1)
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 91 116 33 167 5 228 36 226 88 175 110
					yourself:
				)
		)
	)
)

(instance myCursor of Cursor
	(properties
		view 397
	)
)

(instance myInsetExitCursor of Cursor
	(properties
		view 961
	)
)

