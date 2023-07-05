;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 750)
(include sci.sh)
(use Main)
(use SQRoom)
(use Styler)
(use Plane)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm750 0
)

(local
	local0 = 1
	local1
	local2
	local3
)

(procedure (localproc_0)
	(buttonUp cel: 0)
	(buttonStop cel: 1)
	(buttonDown cel: 0)
	(UpdateScreenItem buttonUp)
	(UpdateScreenItem buttonStop)
	(UpdateScreenItem buttonDown)
)

(procedure (localproc_1)
	(buttonUp cel: 3)
	(buttonStop cel: 3)
	(buttonDown cel: 3)
	(UpdateScreenItem buttonUp)
	(UpdateScreenItem buttonStop)
	(UpdateScreenItem buttonDown)
)

(instance rm750 of SQRoom
	(properties
		noun 1
		picture 750
	)

	(method (init)
		(super init:)
		(gGame handsOff:)
		(if (== gPrevRoomNum 760)
			(plane setRect: 0 64876 319 138)
			(elevator posn: 78 770 init:)
		else
			(plane setRect: 0 0 319 798)
			(elevator posn: 78 -20 init:)
		)
		(UpdatePlane plane)
		(motorControl init:)
		(pleasureOne init:)
		(pleasureTwo init:)
		(pleasureThree init:)
		(coughControl init:)
		(choiceOfMen init:)
		(coughControlFeature init:)
		(self buildPic:)
		((= local1 (Plane new:))
			init:
			posn: 275 10
			addCast: (= local2 (Cast new:))
			setBitmap: 7501 0 0
			priority: (+ (GetHighPlanePri) 1)
		)
		(buttonUp init: local2)
		(buttonStop init: local2)
		(buttonDown init: local2)
		(UpdatePlane local1)
		(if (!= gPrevRoomNum 760)
			(gGSound1 number: 750 flags: 1 loop: -1 play:)
		)
		(self setScript: sEnterRoom)
	)

	(method (buildPic)
		(AddPicAt plane 751 0 139)
		(AddPicAt plane 752 0 278)
		(AddPicAt plane 753 0 417)
		(AddPicAt plane 754 0 556)
		(AddPicAt plane 755 0 695)
	)

	(method (handleEvent event)
		(event localize: local1)
		(if (local2 handleEvent: event)
			(event claimed: 1)
			(return 1)
		else
			(event globalize:)
			(super handleEvent: event)
		)
	)

	(method (dispose)
		((gCurRoom plane:) setRect: 0 0 319 138)
		(if (!= gNewRoomNum 760)
			(gGSound1 fade:)
			(gGSound2 fade:)
		)
		(super dispose:)
	)
)

(instance scrollCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 ((gCurRoom plane:) left:))
		(= temp2 ((gCurRoom plane:) top:))
		(= temp3 ((gCurRoom plane:) right:))
		(= temp4 ((gCurRoom plane:) bottom:))
		(= temp0 2)
		(if
			(and
				(> (+ (elevator y:) temp2) 111)
				(> temp4 138)
				(elevator mover:)
				(> (elevator y:) ((elevator mover:) yLast:))
			)
			((gCurRoom plane:)
				setRect: temp1 (- temp2 temp0) temp3 (- (+ temp2 798) temp0)
			)
			(UpdatePlane (gCurRoom plane:))
		)
		(if
			(and
				(< (+ (elevator y:) temp2) 109)
				(< temp2 0)
				(elevator mover:)
				(< (elevator y:) ((elevator mover:) yLast:))
			)
			((gCurRoom plane:)
				setRect: temp1 (+ temp2 temp0) temp3 (+ temp2 798 temp0)
			)
			(UpdatePlane (gCurRoom plane:))
		)
	)
)

(instance sPokeTheBitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(elevator setMotion: MoveTo 78 449 self)
			)
			(2
				(elevator loop: 1)
				(pokeIt
					cel: 0
					posn: (- (elevator x:) 11) (elevator y:)
					init:
					setCycle: CT 13 1 self
				)
			)
			(3
				(gGSound2 loop: 0 number: 752 play:)
				(ShakePlane gThePlane 2 12 2)
				(pokeIt setCycle: End self)
			)
			(4
				(pokeIt dispose:)
				(elevator loop: 0)
				(gGame points: 3 518)
				(= cycles 5)
			)
			(5
				(SetFlag 201)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(if (== gPrevRoomNum 760)
					(elevator
						code: scrollCode
						setSpeed: 3
						setMotion: MoveTo 78 670 self
					)
				else
					(gGSound2 number: 493 play: setVol: 100)
					(elevator
						code: scrollCode
						setSpeed: 3
						setMotion: MoveTo 78 110 self
					)
				)
			)
			(2
				(gGSound2 stop:)
				(= local0 0)
				(elevator setSpeed: 0)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2) disable: 0)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance elevator of Actor
	(properties
		x 72
		y 80
		priority 1
		fixPriority 1
		view 750
		signal 28705
	)

	(method (doit)
		(super doit:)
		(cond
			(local0)
			((>= (self y:) 671)
				(= local0 1)
				(localproc_1)
				(gGame handsOff:)
				(elevator setSpeed: 3)
			)
			((<= (self y:) 109)
				(= local0 1)
				(localproc_1)
				(gGame handsOff:)
				(elevator setSpeed: 3)
			)
		)
	)

	(method (cue)
		(local1 dispose:)
		(if (< y 110)
			(gCurRoom newRoom: 740)
		else
			(gCurRoom newRoom: 760)
		)
	)
)

(instance pokeIt of Prop
	(properties
		priority 1
		fixPriority 1
		view 752
	)
)

(instance buttonUp of View
	(properties
		noun 2
		x 6
		y 5
		view 7501
		loop 1
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local3 1)
				(self cel: 1)
				(buttonStop cel: 0)
				(buttonDown cel: 0)
				(UpdateScreenItem buttonUp)
				(UpdateScreenItem buttonStop)
				(UpdateScreenItem buttonDown)
				(elevator setMotion: MoveTo 78 -20 elevator)
				(gGSound2 number: 493 play: setVol: 100)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buttonStop of View
	(properties
		noun 4
		x 6
		y 15
		view 7501
		loop 2
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local3 0)
				(buttonUp cel: 0)
				(self cel: 1)
				(buttonDown cel: 0)
				(UpdateScreenItem buttonUp)
				(UpdateScreenItem buttonStop)
				(UpdateScreenItem buttonDown)
				(elevator setMotion: 0)
				(gGSound2 stop:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buttonDown of View
	(properties
		noun 3
		x 6
		y 26
		view 7501
		loop 3
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local3 1)
				(buttonUp cel: 0)
				(buttonStop cel: 0)
				(self cel: 1)
				(UpdateScreenItem buttonUp)
				(UpdateScreenItem buttonStop)
				(UpdateScreenItem buttonDown)
				(elevator setMotion: MoveTo 78 770 elevator)
				(gGSound2 number: 493 play: setVol: 100)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance motorControl of View
	(properties
		noun 9
		x 134
		y 158
		view 753
	)
)

(instance pleasureOne of View
	(properties
		noun 7
		x 26
		y 252
		view 753
		loop 4
	)
)

(instance pleasureTwo of View
	(properties
		noun 7
		x 127
		y 285
		view 753
		loop 1
	)
)

(instance pleasureThree of View
	(properties
		noun 7
		x 25
		y 302
		view 753
		loop 4
		cel 1
	)
)

(instance coughControl of View
	(properties
		noun 8
		x 136
		y 456
		view 753
		loop 2
	)
)

(instance choiceOfMen of View
	(properties
		noun 10
		x 13
		y 558
		view 753
		loop 3
	)
)

(instance coughControlFeature of Feature
	(properties
		noun 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 35 375 65 371 82 367 99 360 125 382 124 393 109 409 89 414 89 418 100 422 124 436 126 447 110 462 74 466 66 466 44 460 31 449 29 433 42 423 40 411 30 396 26 389 27 382
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(140 ; Paperclip
				(if (not local3)
					(gCurRoom setScript: sPokeTheBitch)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance elevatorControls of Feature ; UNUSED
	(properties
		noun 5
		y 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 0 34 0 34 40 0 40 yourself:)
		)
		(super init: &rest)
	)

	(method (doit)
		(cond
			(
				(and
					(gUser canInput:)
					(self onMe: (gUser curEvent:))
					(!= gTheCursor gNormalCursor)
				)
				(gGame setCursor: gNormalCursor 1)
			)
			(
				(and
					(gUser canInput:)
					(not (self onMe: (gUser curEvent:)))
					(!= gTheCursor ((gTheIconBar curIcon:) getCursor:))
				)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
			)
		)
	)
)

(instance localSound of Sound ; UNUSED
	(properties)
)

