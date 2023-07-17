;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 740)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use n666)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use DPath)
(use Timer)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm740 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13 = -1
	local14
)

(instance rm740 of SQRoom
	(properties
		noun 1
	)

	(method (init)
		(Load 140 745 273 741 746) ; WAVE
		(Load rsSOUND 744)
		(Load rsVIEW 7480 7481 7482 7483 7484 7485 7486 7487 7488 7490 7493)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 725 0 871 22 958 39 958 37 887 22 823 12
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 4 13 0 19 81 5 118 0 62 1
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 900 97 902 106 887 110 844 110 813 106 793 103 776 102 768 116 711 108 679 103 651 104 612 111 479 111 479 114 550 114 572 114 619 114 653 106 682 105 770 118 778 105 793 105 819 110 837 111 888 111 905 107 903 98 923 89 950 90 951 88 923 87
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 376 119 359 112 327 111 294 105 244 105 228 93 187 85 186 87 181 95 174 95 160 114 71 114 71 115 162 115 168 108 196 115 214 128 230 117 274 117 291 107 324 113 358 114 377 122 378 120
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 174 97 171 106 198 113 214 125 228 115 272 115 286 107 280 107 258 107 244 107 226 95 188 87 182 97
					yourself:
				)
		)
		(super init:)
		(cond
			((== gPrevRoomNum 610)
				(elevator
					init:
					loop: 0
					x: 72
					y: 132
					approachVerbs: 4 ; Do
					setScaler: Scaler 100 70 90 87
				)
				((gCurRoom plane:) setRect: 64897 0 319 138)
				(UpdatePlane plane)
				(self setScript: sShuttleLands)
			)
			((== gPrevRoomNum 490)
				(elevator
					init:
					loop: 0
					x: 72
					y: 132
					approachVerbs: 4 ; Do
					setScaler: Scaler 100 70 90 87
				)
				((gCurRoom plane:) setRect: 64897 0 319 138)
				(UpdatePlane plane)
				(shuttle init:)
				(self setScript: sShuttleTakesOff)
			)
			((== gPrevRoomNum 750)
				((gCurRoom plane:) setRect: 0 0 959 138)
				(UpdatePlane plane)
				(elevator loop: 1 x: 72 y: 132 approachVerbs: 4) ; Do
				(gEgo setScaler: Scaler 100 38 102 87)
				(self setScript: sEnterFrom750)
				(shuttle init:)
			)
			((== gPrevRoomNum 480)
				((gCurRoom plane:) setRect: 64897 0 319 138)
				(UpdatePlane plane)
				(gEgo setScaler: Scaler 100 70 90 87 setScript: sWalkIn)
				(shuttle init:)
				(elevator
					init:
					loop: 0
					x: 72
					y: 132
					approachVerbs: 4 ; Do
					setScaler: Scaler 100 70 90 87
				)
			)
			(else
				(elevator
					init:
					loop: 0
					x: 72
					y: 132
					approachVerbs: 4 ; Do
					setScaler: Scaler 100 70 90 87
				)
				((gCurRoom plane:) setRect: 64897 0 319 138)
				(UpdatePlane plane)
				(self setScript: sShuttleLands)
			)
		)
		(if (IsFlag 131)
			(rippedSkull cel: 5 init:)
			(rippedSkullFront init:)
		)
		(if (IsFlag 127)
			(leftNanite posn: 25 112 view: 7496 loop: 0 cel: 0 init:)
		else
			(leftNanite init: setScript: sLeftNanite)
		)
		(if (not (IsFlag 127))
			(leftNaniteHead init:)
			(leftNaniteArm init:)
			(rightNanite init: setScript: sRightNanite)
			(rightNaniteArm init:)
			(deathTrap init:)
		)
		(exitToShuttle init: gTheExitCursor approachVerbs: 5) ; Exit
		(skull init: approachVerbs: 135 4) ; Finger_Nail, Do
		(leftTop init:)
		(leftEdge init:)
		(rightEdge init:)
		(meninges init:)
		(brainLeft init:)
		(brainRight init:)
		(mineShaft init:)
		(light init:)
		(gGSound1 number: 740 loop: -1 play:)
		(gWalkHandler addToFront: self)
		(self buildPic:)
	)

	(method (buildPic)
		(AddPicAt plane 742 0 0)
		(AddPicAt plane 741 320 0)
		(AddPicAt plane 740 639 0)
	)

	(method (handleEvent event)
		(cond
			((and (or local7 local8) (not (gEgo script:)))
				(gEgo setScript: sRogerClammers)
				(event claimed: 1)
				(return 1)
			)
			(
				(and
					(skull onMe: event)
					(IsFlag 125)
					(& (event type:) evMOVE)
					(IsFlag 131)
					(not (gEgo script:))
				)
				(gEgo setScript: sApproachOpening)
				(event claimed: 1)
				(return 1)
			)
			(
				(and
					(> gMouseY 97)
					(not (IsFlag 125))
					(& (event type:) evMOVE)
					(IsFlag 131)
					(not (gEgo script:))
				)
				(gEgo setScript: sApproachOpening)
				(event claimed: 1)
				(return 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(
				(and
					(not (IsFlag 127))
					(deathTrap onMe: gEgo)
					(not (gEgo script:))
					(not local0)
					(not local9)
				)
				(if (> (gEgo y:) 100)
					(= local5 1)
					(= local6 0)
					(gEgo setScript: sScroller)
				else
					(= local6 1)
					(= local5 0)
					(gEgo setScript: sScroller)
				)
			)
			(
				(and
					(not (IsFlag 127))
					(< (gEgo x:) 245)
					(== (gEgo loop:) 1)
					(not (gEgo script:))
					(< ((gCurRoom plane:) left:) -5)
					(not local9)
				)
				(gEgo setScript: sScrollScreen)
			)
		)
		(cond
			(
				(and
					(rightEdge onMe: gEgo)
					(not (gEgo script:))
					(not local7)
					(or (== (gEgo view:) 902) (== (gEgo view:) 910))
					(== (gEgo loop:) 1)
				)
				(= local7 1)
				(self setScript: sFallsInChasm)
			)
			(
				(and
					(leftEdge onMe: gEgo)
					(not (gEgo script:))
					(not local8)
					(or (== (gEgo view:) 902) (== (gEgo view:) 910))
					(== (gEgo loop:) 0)
				)
				(= local8 1)
				(self setScript: sFallsInChasm)
			)
		)
	)

	(method (dispose)
		((gCurRoom plane:) setRect: 0 0 319 138)
		(gEgo setScale: 0)
		(if (gWalkHandler contains: self)
			(gWalkHandler delete: self)
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
		(= temp0 (gEgo xStep:))
		(if
			(and
				(> (+ (gEgo x:) temp1) 220)
				(> temp3 325)
				(gEgo mover:)
				(> (gEgo x:) ((gEgo mover:) xLast:))
			)
			((gCurRoom plane:)
				setRect: (- temp1 temp0) temp2 (- temp3 temp0) temp4
			)
			(UpdatePlane (gCurRoom plane:))
		)
		(if
			(and
				(< (+ (gEgo x:) temp1) 100)
				(< temp1 -5)
				(gEgo mover:)
				(< (gEgo x:) ((gEgo mover:) xLast:))
			)
			((gCurRoom plane:)
				setRect: (+ temp1 temp0) temp2 (+ temp3 temp0) temp4
			)
			(UpdatePlane (gCurRoom plane:))
		)
	)
)

(instance sScrollScreen of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(= temp0 ((gCurRoom plane:) left:))
				(= temp1 ((gCurRoom plane:) top:))
				(= temp2 ((gCurRoom plane:) right:))
				(= temp3 ((gCurRoom plane:) bottom:))
				(= temp4 5)
				(if (< temp0 -5)
					((gCurRoom plane:)
						setRect: (+ temp0 temp4) temp1 (+ temp2 temp4) temp3
					)
					(UpdatePlane (gCurRoom plane:))
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 1010 30 normalize: init:)
				(= cycles 3)
			)
			(1
				(gEgo code: scrollCode setMotion: MoveTo 882 24 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sApproachOpening of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 125)
					(gEgo setMotion: PolyPath 880 110 self)
				else
					(gEgo setMotion: PolyPath 901 28 self)
				)
			)
			(1
				(= next sRogerClimbs)
				(self dispose:)
			)
		)
	)
)

(instance sExitToShuttle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 125)
					(gEgo
						posn: 873 109
						view: 744
						loop: 0
						cel: 0
						cycleSpeed: 9
						setCycle: CT 14 1 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if (IsFlag 125)
					(ClearFlag 125)
					(gEgo
						posn: 901 28
						setScaler: Scaler 100 70 90 87
						normalize: 6
					)
				)
				(= cycles 1)
				(gGame handsOn:)
			)
			(2
				(gEgo setMotion: PolyPath 950 28 self)
			)
			(3
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 1010 28 self)
			)
			(4
				(= gShuttleRoomNum 740)
				(gCurRoom newRoom: 480)
				(self dispose:)
			)
		)
	)
)

(instance sShuttleTakesOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 273) ; WAVE
				(= cycles 3)
			)
			(1
				(sound1 number: 273 loop: -1 play:)
				(shuttle init: posn: 944 20 setMotion: DPath 930 -1 self)
			)
			(2
				(sound1 fade:)
				(= ticks 240)
			)
			(3
				(gCurRoom newRoom: 610)
				(self dispose:)
			)
		)
	)
)

(instance sShuttleLands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 273) ; WAVE
				(= cycles 3)
			)
			(1
				(sound1 number: 273 loop: -1 play:)
				(shuttle init: posn: 930 -1 setMotion: DPath 944 20 self)
			)
			(2
				(sound1 fade:)
				(= ticks 240)
			)
			(3
				(= gShuttleRoomNum 740)
				(gCurRoom newRoom: 490)
				(self dispose:)
			)
		)
	)
)

(instance sFallsInChasm of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 142))
					(gMessager say: 9 2 11 0 self) ; "Yikes, how am I supposed to jump across this one?"
				else
					(= cycles 1)
				)
			)
			(1
				(if (not (IsFlag 142))
					(SetFlag 142)
					(= local7 0)
					(= local8 0)
					(gGame handsOn:)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(2
				(= local9 1)
				(cond
					(local7
						(gEgo normalize: setMotion: PolyPath 665 112 self)
					)
					(local8
						(gEgo normalize: setMotion: PolyPath 164 110 self)
					)
				)
			)
			(3
				(cond
					(local7
						(gEgo
							posn: 445 109
							view: 745
							loop: 0
							cycleSpeed: 12
							setCycle: CT 10 1 self
						)
					)
					(local8
						(gEgo
							posn: 385 108
							view: 745
							setLoop: 1 1
							setCel: 0 1
							cycleSpeed: 12
							setCycle: CT 10 1 self
						)
					)
				)
			)
			(4
				(cond
					((IsFlag 202)
						(cond
							(local7
								(gEgo setCel: 11 setCycle: End)
							)
							(local8
								(gEgo setCel: 11 setCycle: End)
							)
						)
					)
					(local7
						(gEgo setCel: 11 setCycle: End self)
					)
					(local8
						(gEgo setCel: 11 setCycle: End self)
					)
				)
				(= cycles 1)
			)
			(5
				(if (IsFlag 202)
					(cond
						(local7
							(if (< ((gCurRoom plane:) left:) -250)
								(= temp0 ((gCurRoom plane:) left:))
								(= temp1 ((gCurRoom plane:) top:))
								(= temp2 ((gCurRoom plane:) right:))
								(= temp3 ((gCurRoom plane:) bottom:))
								(= temp4 5)
								((gCurRoom plane:)
									setRect:
										(+ temp0 5)
										temp1
										(+ temp2 temp4)
										temp3
								)
								(UpdatePlane (gCurRoom plane:))
								(-- state)
							)
						)
						((and local8 (> ((gCurRoom plane:) right:) 719))
							(= temp0 ((gCurRoom plane:) left:))
							(= temp1 ((gCurRoom plane:) top:))
							(= temp2 ((gCurRoom plane:) right:))
							(= temp3 ((gCurRoom plane:) bottom:))
							(= temp4 5)
							((gCurRoom plane:)
								setRect: (- temp0 5) temp1 (- temp2 temp4) temp3
							)
							(UpdatePlane (gCurRoom plane:))
							(-- state)
						)
					)
					(= cycles 1)
				else
					((gCurRoom plane:) setRect: -320 0 639 138)
					(UpdatePlane (gCurRoom plane:))
				)
			)
			(6
				(cond
					(local7
						(gEgo
							posn: 358 115
							view: 746
							setLoop: 0 1
							setCel: 0 1
							setCycle: End self
						)
					)
					(local8
						(gEgo
							posn: 477 108
							view: 746
							setLoop: 1 1
							setCel: 0 1
							setCycle: End self
						)
					)
				)
			)
			(7
				(= local9 0)
				(fallTimer setReal: fallTimer 10)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					(local7
						(gEgo
							posn: 350 110
							view: 747
							loop: 0
							cel: 0
							cycleSpeed: 12
							setCycle: End self
						)
					)
					(local8
						(gEgo
							posn: 477 108
							view: 747
							setLoop: 1 1
							setCel: 0 1
							cycleSpeed: 12
							setCycle: End self
						)
					)
				)
			)
			(1
				(EgoDead 28 self) ; "And you were so close, too."
			)
			(2
				(cond
					(local7
						(gEgo posn: 521 111 normalize: 1)
					)
					(local8
						(gEgo posn: 354 114 normalize: 0)
					)
				)
				(= local10 0)
				(= local7 0)
				(= local8 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerClammers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(++ local10)
				(fallTimer dispose:)
				(cond
					(local7
						(gEgo
							posn: 358 115
							view: 746
							cel: 0
							loop: 0
							cycleSpeed: 12
							setCycle: End self
						)
					)
					(local8
						(gEgo
							posn: 477 108
							view: 746
							setCel: 0 1
							setLoop: 1 1
							cycleSpeed: 12
							setCycle: End self
						)
					)
				)
			)
			(1
				(if (> local10 2)
					(cond
						(local7
							(gEgo
								posn: 358 115
								view: 746
								cel: 0
								loop: 2
								setCycle: End self
							)
						)
						(local8
							(gEgo
								posn: 477 108
								view: 746
								cel: 0
								loop: 3
								setCycle: End self
							)
						)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(if (> local10 2)
					(cond
						(local7
							(gEgo posn: 354 114 normalize: 1)
						)
						(local8
							(gEgo posn: 494 114 normalize: 0)
						)
					)
					(= cycles 3)
				else
					(fallTimer setReal: fallTimer 10)
					(= cycles 1)
				)
			)
			(3
				(if (and (> local10 2) local7 (not (IsFlag 140)))
					(gMessager say: 9 2 9 0 self) ; "Man, that was close!"
					(SetFlag 140)
				else
					(= cycles 1)
				)
				(gGame points: 3 493)
			)
			(4
				(if (> local10 2)
					(= local10 0)
					(= local7 0)
					(= local8 0)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWalkTopLeft of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 63 7 normalize:)
				((gCurRoom plane:) setRect: 0 0 959 138)
				(UpdatePlane (gCurRoom plane:))
				(self dispose:)
			)
		)
	)
)

(instance sWalkTopRight of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 755 4 normalize:)
				((gCurRoom plane:) setRect: 64897 0 319 138)
				(UpdatePlane (gCurRoom plane:))
				(self dispose:)
			)
		)
	)
)

(instance sRogerCutsThru of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 905 29
					view: 742
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: CT 4 1 self
				)
			)
			(1
				(sound1 number: 745 loop: -1 play:)
				(gMessager say: 3 88 1 0 self) ; "You slice away with the nail and, amazingly enough, manage to cut a slice in the barrier!"
				(gEgo posn: 905 29 cel: 5 setCycle: End self)
			)
			(2
				(gEgo loop: 1 setCycle: Fwd)
				(rippedSkull init: cel: 0 setCycle: CT 1 1)
				(= ticks 120)
			)
			(3
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(gEgo loop: 3 setCycle: Fwd)
				(rippedSkull cel: 1 setCycle: CT 3 1)
				(= ticks 60)
			)
			(5
				(gEgo loop: 4 cel: 0 setCycle: End self)
			)
			(6
				(sound1 stop:)
				(gEgo loop: 5 setCycle: Fwd)
				(rippedSkull cel: 3 setCycle: CT 5 1)
				(rippedSkullFront init:)
				(= ticks 60)
			)
			(7
				(gEgo loop: 6 cel: 0 setCycle: End self)
			)
			(8
				(gGame points: 3 491)
				(SetFlag 131)
				(= next sRogerClimbs)
				(self dispose:)
			)
		)
	)
)

(instance sRogerClimbs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 125)
					(gEgo
						posn: 873 109
						view: 744
						loop: 0
						cel: 0
						cycleSpeed: 9
						setCycle: CT 14 1 self
					)
				else
					(gEgo
						posn: 878 115
						view: 743
						loop: 0
						cel: 0
						cycleSpeed: 9
						setCycle: End self
					)
				)
			)
			(1
				(if (IsFlag 125)
					(ClearFlag 125)
					(gEgo
						posn: 901 28
						setScaler: Scaler 100 70 90 87
						normalize: 6
					)
				else
					(SetFlag 125)
					(gEgo
						posn: 880 110
						setScaler: Scaler 100 38 102 87
						normalize: 1
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sScroller of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local3 (Random 0 1))
				(= cycles 1)
			)
			(1
				(if (>= ((gCurRoom plane:) left:) -5)
					(cond
						(local5
							(= local5 0)
							(= next sRogerShotFront)
						)
						(local6
							(= local6 0)
							(= next sRogerShotSide)
						)
					)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(2
				(if (IsFlag 202)
					(= temp4 5)
					(= temp0 ((gCurRoom plane:) left:))
					(= temp1 ((gCurRoom plane:) top:))
					(= temp2 ((gCurRoom plane:) right:))
					(= temp3 ((gCurRoom plane:) bottom:))
					(if (< temp0 -5)
						((gCurRoom plane:)
							setRect: (+ temp0 temp4) temp1 (+ temp2 temp4) temp3
						)
						(UpdatePlane (gCurRoom plane:))
						(-- state)
					)
				else
					((gCurRoom plane:) setRect: 64897 0 319 138)
					(UpdatePlane (gCurRoom plane:))
				)
				(= cycles 1)
			)
			(3
				(= local0 1)
				(ShootTimer setReal: ShootTimer 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeftNanite of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 1)
				(leftNaniteHead view: 748 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(leftNaniteHead view: 748 loop: 1 cel: 0 setCycle: Beg self)
			)
			(2
				(= local2 0)
				(self changeState: 5)
			)
			(3
				(= local2 1)
				(leftNaniteArm view: 748 loop: 2 cel: 0 setCycle: End)
				(= cycles 1)
			)
			(4
				(= local2 0)
				(self changeState: 5)
			)
			(5
				(= ticks (Random 15 100))
			)
			(6
				(self changeState: (Random 0 5))
			)
		)
	)
)

(instance sRightNanite of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(rightNaniteArm view: 748 loop: 4 cel: 0 setCycle: End self)
			)
			(1
				(= local1 0)
				(= ticks (Random 120 360))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sRogerShotFront of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((== local3 0)
				(if (and (not local1) (== state 0))
					(= local1 0)
					(rightNanite setScript: 0)
					(= ticks 1)
				)
			)
			((and (not local2) (== state 0))
				(= local2 0)
				(leftNanite setScript: 0)
				(= ticks 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270)
			)
			(1
				(if (== local3 0)
					(rightNaniteArm hide:)
					(rightNanite
						view: 7485
						loop: 0
						cel: 0
						setCycle: CT 3 1 self
					)
				else
					(leftNaniteArm hide:)
					(leftNaniteHead hide:)
					(leftNanite
						view: 7482
						loop: 0
						cel: 0
						setCycle: CT 10 1 self
					)
				)
			)
			(2
				(sound1 number: 746 loop: 0 play:)
				(if (== local3 0)
					(rightNaniteArm hide:)
					(rightNanite view: 7485 loop: 0 cel: 4 setCycle: End self)
				else
					(leftNaniteArm hide:)
					(leftNaniteHead hide:)
					(leftNanite view: 7482 loop: 0 cel: 11 setCycle: End self)
				)
			)
			(3
				(gEgo
					view: 7486
					loop: 0
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(4
				(EgoDead 16 self) ; "So close and yet so far away. How embarrassing to get wasted by the Laurel and Hardy of nanites."
			)
			(5
				(gEgo posn: 250 107 normalize: 1)
				(if (== local3 0)
					(rightNaniteArm show:)
					(rightNanite view: 748 loop: 3)
					(rightNanite setScript: sRightNanite)
				else
					(leftNaniteArm show:)
					(leftNaniteHead show:)
					(leftNanite setScript: sLeftNanite)
					(leftNanite view: 748 loop: 0)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerShotSide of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((== local3 0)
				(if (and (not local1) (== state 0))
					(= local1 0)
					(rightNanite setScript: 0)
					(= ticks 1)
				)
			)
			((and (not local2) (== state 0))
				(= local2 0)
				(leftNanite setScript: 0)
				(= ticks 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((gCurRoom plane:) setRect: 0 0 959 138)
				(UpdatePlane (gCurRoom plane:))
				(gEgo setHeading: 270)
			)
			(1
				(if (== local3 0)
					(rightNaniteArm hide:)
					(rightNanite
						view: 7484
						loop: 0
						cel: 0
						setCycle: CT 6 1 self
					)
				else
					(leftNaniteArm hide:)
					(leftNaniteHead hide:)
					(leftNanite view: 7481 loop: 0 cel: 0 setCycle: CT 7 1 self)
				)
			)
			(2
				(sound1 number: 746 loop: 0 play:)
				(if (== local3 0)
					(rightNaniteArm hide:)
					(rightNanite view: 7484 loop: 0 cel: 7 setCycle: End self)
				else
					(leftNaniteArm hide:)
					(leftNaniteHead hide:)
					(leftNanite view: 7481 loop: 0 cel: 8 setCycle: End self)
				)
			)
			(3
				(gEgo
					view: 7487
					loop: 0
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(4
				(EgoDead 16 self) ; "So close and yet so far away. How embarrassing to get wasted by the Laurel and Hardy of nanites."
			)
			(5
				(gEgo posn: 250 107 normalize: 1)
				(if (== local3 0)
					(rightNaniteArm show:)
					(rightNanite view: 748 loop: 3)
					(rightNanite setScript: sRightNanite)
				else
					(leftNaniteArm show:)
					(leftNaniteHead show:)
					(leftNanite setScript: sLeftNanite)
					(leftNanite view: 748 loop: 0)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRNanKillBehind of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not local1) (== state 0))
			(= local1 0)
			(rightNanite setScript: 0)
			(= ticks 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 247)
			)
			(1
				(gEgo
					view: 749
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: CT 6 1 self
				)
			)
			(2
				(stone init: posn: 181 33 setMotion: myJumpTo 104 42 self)
				(gEgo cel: 7 setCycle: End)
			)
			(3
				(sound1 number: 741 loop: 0 play:)
				(stone dispose:)
				(rightNaniteArm hide:)
				(rightNanite view: 7493 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(rightNanite view: 7483 loop: 0 cel: 0 setCycle: CT 9 1 self)
			)
			(5
				(sound1 number: 746 loop: 0 play:)
				(rightNanite cel: 10 setCycle: End)
				(gEgo
					view: 7488
					loop: 0
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(6
				(EgoDead 16 self) ; "So close and yet so far away. How embarrassing to get wasted by the Laurel and Hardy of nanites."
			)
			(7
				(gEgo normalize: 5)
				(rightNaniteArm show:)
				(rightNanite view: 748 loop: 3 setScript: sRightNanite)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRightWarnLeft of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not local1) (== state 0))
			(rightNanite setScript: 0)
			(= ticks 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 247)
			)
			(1
				(gEgo
					view: 749
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: CT 6 1 self
				)
			)
			(2
				(stone init: posn: 181 33 setMotion: myJumpTo 104 42 self)
				(gEgo cel: 7 setCycle: End)
			)
			(3
				(stone dispose:)
				(sound1 number: 741 loop: 0 play:)
				(rightNaniteArm hide:)
				(rightNanite view: 7493 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(rightNanite view: 7494 loop: 0 cel: 0 setCycle: End self)
			)
			(5
				(cond
					((== local12 1)
						(if (and (== local11 1) (== local13 1))
							(gMessager say: 7 139 4 0 self) ; "You chuck another gallstone -- this time at the other robot who also thinks the other one did it."
						else
							(gMessager say: 7 139 3 0 self) ; "You chuck a gallstone at one of the robots -- causing it to think the other one did it."
						)
					)
					((and (== local12 2) (== local11 1) (== local13 1))
						(gMessager say: 7 139 4 0 self) ; "You chuck another gallstone -- this time at the other robot who also thinks the other one did it."
					)
					(else
						(gMessager say: 7 1 5 0 self) ; MISSING MESSAGE
					)
				)
			)
			(6
				(rightNanite setCycle: Beg self)
			)
			(7
				(gEgo normalize: 5)
				(rightNaniteArm show:)
				(rightNanite view: 748 loop: 3 setScript: sRightNanite)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLNanKillBehind of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not local2) (== state 0))
			(leftNanite setScript: 0)
			(= ticks 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 7480 7488)
				(gEgo setHeading: 247)
			)
			(1
				(gEgo
					view: 749
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: CT 6 1 self
				)
			)
			(2
				(stone init: posn: 181 33 setMotion: myJumpTo 33 52 self)
				(gEgo cel: 7 setCycle: End)
			)
			(3
				(sound1 number: 741 loop: 0 play:)
				(stone dispose:)
				(leftNaniteArm hide:)
				(leftNaniteHead hide:)
				(leftNanite view: 7490 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(leftNanite view: 7480 loop: 0 cel: 0 setCycle: CT 9 1 self)
			)
			(5
				(sound1 number: 746 loop: 0 play:)
				(leftNanite cel: 10 setCycle: End)
				(gEgo
					view: 7488
					loop: 0
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(6
				(EgoDead 16 self) ; "So close and yet so far away. How embarrassing to get wasted by the Laurel and Hardy of nanites."
			)
			(7
				(gEgo normalize: 5)
				(leftNaniteArm show:)
				(leftNaniteHead show:)
				(leftNanite view: 748 loop: 0 setScript: sLeftNanite)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeftWarnRight of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not local2) (== state 0))
			(= local2 0)
			(leftNanite setScript: 0)
			(= ticks 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 749 7490 7492)
				(gEgo setHeading: 247)
			)
			(1
				(gEgo
					view: 749
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: CT 6 1 self
				)
			)
			(2
				(stone init: posn: 181 33 setMotion: myJumpTo 33 52 self)
				(gEgo cel: 7 setCycle: End)
			)
			(3
				(sound1 number: 741 loop: 0 play:)
				(stone dispose:)
				(leftNaniteArm hide:)
				(leftNaniteHead hide:)
				(leftNanite view: 7490 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(leftNanite view: 7492 loop: 0 cel: 0 setCycle: End self)
			)
			(5
				(cond
					((== local11 1)
						(if (and (== local12 1) (== local13 0))
							(gMessager say: 7 139 4 0 self) ; "You chuck another gallstone -- this time at the other robot who also thinks the other one did it."
						else
							(gMessager say: 7 139 3 0 self) ; "You chuck a gallstone at one of the robots -- causing it to think the other one did it."
						)
					)
					((and (== local11 2) (== local12 1) (== local13 0))
						(gMessager say: 7 139 4 0 self) ; "You chuck another gallstone -- this time at the other robot who also thinks the other one did it."
					)
					(else
						(gMessager say: 7 1 5 0 self) ; MISSING MESSAGE
					)
				)
			)
			(6
				(leftNanite setCycle: Beg self)
			)
			(7
				(gEgo normalize: 5)
				(leftNaniteArm show:)
				(leftNaniteHead show:)
				(leftNanite view: 748 loop: 0 setScript: sLeftNanite)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFight of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not local1) (not local2) (== state 0) (not local4))
			(rightNanite setScript: 0)
			(leftNanite setScript: 0)
			(= local4 1)
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 247)
			)
			(1
				(gEgo
					view: 749
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: CT 6 1 self
				)
			)
			(2
				(cond
					(local11
						(stone
							posn: 181 33
							init:
							setMotion: myJumpTo 33 52 self
						)
					)
					(local12
						(stone
							posn: 181 33
							init:
							setMotion: myJumpTo 104 42 self
						)
					)
				)
				(gEgo cel: 7 setCycle: End)
			)
			(3
				(sound1 number: 741 loop: 0 play:)
				(stone dispose:)
				(rightNaniteArm dispose:)
				(rightNanite view: 7495 loop: 0 cel: 0 setCycle: End self)
				(leftNaniteArm dispose:)
				(leftNaniteHead dispose:)
				(leftNanite view: 7492 loop: 0 cel: 0 setCycle: End self)
			)
			(4)
			(5
				(rightNanite dispose:)
				(leftNanite dispose:)
				(= gAutoRobot
					((WalkieTalkie new:)
						x: -109
						y: -43
						priority: 90
						holdOnLastCel: 1
						disposeWhenDone: 0
						init: 0 748 self
						start:
						yourself:
					)
				)
			)
			(6
				(= gAutoRobot
					((WalkieTalkie new:)
						x: -109
						y: -43
						priority: 90
						holdOnLastCel: 1
						init: 0 7480 self
						start:
						yourself:
					)
				)
			)
			(7
				(SetFlag 127)
				(gGame points: 5 492)
				(gMessager say: 7 0 6 0 self) ; "That was quite effective! That was very impressive, Roger. I'll bet that's not something you hear every decade."
				(WalkieTalkie killRobot:)
				(leftNanite posn: 20 110 view: 7496 loop: 0 cel: 0 init:)
				(gEgo normalize: 1)
				(deathTrap dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExit750 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 493)
				(gEgo setMotion: MoveTo 78 114 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(elevAndEgo init:)
				(elevator hide:)
				(gEgo hide:)
				(= cycles 1)
			)
			(3
				(gGSound2 number: 493 loop: -1 play: setVol: 100)
				(elevAndEgo setSpeed: 3 setMotion: MoveTo 78 220 self)
			)
			(4
				(gGSound2 fade:)
				(gCurRoom newRoom: 750)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFrom750 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 125)
				(gEgo posn: 78 114 normalize: 2)
				(elevAndEgo posn: 78 220 init:)
				(Load rsSOUND 493)
				(= cycles 3)
			)
			(1
				(gGSound2 number: 493 loop: -1 play: setVol: 100)
				(elevAndEgo setSpeed: 3 setMotion: MoveTo 78 114 self)
				(Load rsVIEW 749 7490 7492)
				(Load rsVIEW 749 7490 7492)
				(Load rsVIEW 749 7490 7492)
				(Load rsVIEW 749 7490 7492)
			)
			(2
				(gGSound2 stop:)
				(elevator init:)
				(elevAndEgo dispose:)
				(gEgo init: setMotion: MoveTo 77 115 self)
			)
			(3
				(gEgo normalize: 2)
				(= local7 0)
				(= local8 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance myJumpTo of JumpTo
	(properties
		gx -25
		gy 1
		xStep 10
		yStep 3
	)
)

(instance elevAndEgo of Actor
	(properties
		x 78
		y 114
		view 7489
	)
)

(instance stone of Actor
	(properties
		view 749
		loop 1
	)
)

(instance shuttle of Actor
	(properties
		noun 8
		x 944
		y 20
		view 7400
		signal 20513
	)

	(method (init)
		(self ignoreActors: 1)
		(super init:)
	)
)

(instance elevator of Actor
	(properties
		noun 10
		sightAngle 180
		approachX 77
		approachY 115
		x 73
		y 137
		priority 95
		fixPriority 1
		view 740
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 125)
					(gCurRoom setScript: sExit750)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rippedSkull of Prop
	(properties
		noun 3
		x 899
		y 25
		view 742
		loop 7
		signal 20513
		cycleSpeed 1
	)

	(method (doit)
		(super doit:)
		(if (IsFlag 125)
			(self approachX: 868 approachY 110)
		else
			(self approachX: 878 approachY 115)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 3 1 8) ; MISSING MESSAGE
			)
			(4 ; Do
				(gEgo setScript: sRogerClimbs)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rippedSkullFront of Prop
	(properties
		noun 3
		x 899
		y 25
		view 742
		loop 8
		signal 20513
		cycleSpeed 1
	)

	(method (init)
		(self setPri: 120)
		(super init:)
	)
)

(instance leftNanite of Prop
	(properties
		noun 7
		sightAngle 280
		x 28
		y 105
		view 748
		signal 20513
	)

	(method (init)
		(if (IsFlag 127)
			(self setPri: 20)
		else
			(self setPri: 90)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(139 ; Gallstone
				(if (not (IsFlag 127))
					(if (and (< (gEgo x:) 204) (< (gEgo y:) 91))
						(cond
							((== (++ local11) 1)
								(if (== local12 0)
									(= local13 1)
								)
								(gEgo setScript: sLeftWarnRight)
							)
							((== local11 2)
								(if
									(or
										(== local12 0)
										(and (== local12 1) (== local13 0))
									)
									(= local11 0)
									(gEgo setScript: sLNanKillBehind)
								else
									(= local11 1)
									(gCurRoom setScript: sFight)
								)
								(= local12 0)
							)
						)
					else
						(gMessager say: 7 139 12) ; "I don't think I can hit them from here."
					)
				)
			)
			(1 ; Look
				(cond
					((IsFlag 127)
						(gMessager say: 7 1 7) ; "The self-deactivated nanites now pose no threat."
					)
					((IsFlag 173)
						(gMessager say: 7 1) ; "Nanites are there and they look real pissy."
					)
					(else
						(SetFlag 173)
						(gMessager say: 7 1 3) ; "Holy Captain's Log, Batman! There are a few more of those nanites here. How am I gonna handle this one?"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftNaniteHead of Prop
	(properties
		noun 7
		sightAngle 280
		x 28
		y 105
		view 748
		loop 1
		signal 20513
	)

	(method (init)
		(self setPri: 90)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(139 ; Gallstone
				(if (and (< (gEgo x:) 204) (< (gEgo y:) 91))
					(cond
						((== (++ local11) 1)
							(if (== local12 0)
								(= local13 1)
							)
							(gEgo setScript: sLeftWarnRight)
						)
						((== local11 2)
							(if
								(or
									(== local12 0)
									(and (== local12 1) (== local13 0))
								)
								(= local11 0)
								(gEgo setScript: sLNanKillBehind)
							else
								(= local11 1)
								(gCurRoom setScript: sFight)
							)
							(= local12 0)
						)
					)
				else
					(gMessager say: 7 139 12) ; "I don't think I can hit them from here."
				)
			)
			(1 ; Look
				(cond
					((IsFlag 127)
						(gMessager say: 7 1 7) ; "The self-deactivated nanites now pose no threat."
					)
					((IsFlag 173)
						(gMessager say: 7 1) ; "Nanites are there and they look real pissy."
					)
					(else
						(SetFlag 173)
						(gMessager say: 7 1 3) ; "Holy Captain's Log, Batman! There are a few more of those nanites here. How am I gonna handle this one?"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftNaniteArm of Prop
	(properties
		noun 7
		sightAngle 280
		x 28
		y 105
		view 748
		loop 2
		signal 20513
	)

	(method (init)
		(self setPri: 90)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(139 ; Gallstone
				(if (and (< (gEgo x:) 204) (< (gEgo y:) 91))
					(cond
						((== (++ local11) 1)
							(if (== local12 0)
								(= local13 1)
							)
							(gEgo setScript: sLeftWarnRight)
						)
						((== local11 2)
							(if
								(or
									(== local12 0)
									(and (== local12 1) (== local13 0))
								)
								(= local11 0)
								(gEgo setScript: sLNanKillBehind)
							else
								(= local11 1)
								(gCurRoom setScript: sFight)
							)
							(= local12 0)
						)
					)
				else
					(gMessager say: 7 139 12) ; "I don't think I can hit them from here."
				)
			)
			(1 ; Look
				(cond
					((IsFlag 127)
						(gMessager say: 7 1 7) ; "The self-deactivated nanites now pose no threat."
					)
					((IsFlag 173)
						(gMessager say: 7 1) ; "Nanites are there and they look real pissy."
					)
					(else
						(SetFlag 173)
						(gMessager say: 7 1 3) ; "Holy Captain's Log, Batman! There are a few more of those nanites here. How am I gonna handle this one?"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightNanite of Prop
	(properties
		noun 7
		sightAngle 280
		x 105
		y 105
		view 748
		loop 3
		signal 20513
	)

	(method (init)
		(self setPri: 90)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(139 ; Gallstone
				(if (and (< (gEgo x:) 204) (< (gEgo y:) 91))
					(cond
						((== (++ local12) 1)
							(if (== local11 0)
								(= local13 0)
							)
							(gEgo setScript: sRightWarnLeft)
						)
						((== local12 2)
							(if
								(or
									(== local11 0)
									(and (== local11 1) (== local13 1))
								)
								(= local12 0)
								(gEgo setScript: sRNanKillBehind)
							else
								(= local12 1)
								(gCurRoom setScript: sFight)
							)
							(= local11 0)
						)
					)
				else
					(gMessager say: 7 139 12) ; "I don't think I can hit them from here."
				)
			)
			(1 ; Look
				(cond
					((IsFlag 127)
						(gMessager say: 7 1 7) ; "The self-deactivated nanites now pose no threat."
					)
					((IsFlag 173)
						(gMessager say: 7 1) ; "Nanites are there and they look real pissy."
					)
					(else
						(SetFlag 173)
						(gMessager say: 7 1 3) ; "Holy Captain's Log, Batman! There are a few more of those nanites here. How am I gonna handle this one?"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightNaniteArm of Prop
	(properties
		noun 7
		sightAngle 280
		x 105
		y 105
		view 748
		loop 4
		signal 20513
	)

	(method (init)
		(self setPri: 90)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(139 ; Gallstone
				(if (and (< (gEgo x:) 204) (< (gEgo y:) 91))
					(cond
						((== (++ local12) 1)
							(if (== local11 0)
								(= local13 0)
							)
							(gEgo setScript: sRightWarnLeft)
						)
						((== local12 2)
							(if
								(or
									(== local11 0)
									(and (== local11 1) (== local13 1))
								)
								(= local12 0)
								(gEgo setScript: sRNanKillBehind)
							else
								(= local12 1)
								(gCurRoom setScript: sFight)
							)
							(= local11 0)
						)
					)
				else
					(gMessager say: 7 139 12) ; "I don't think I can hit them from here."
				)
			)
			(1 ; Look
				(cond
					((IsFlag 127)
						(gMessager say: 7 1 7) ; "The self-deactivated nanites now pose no threat."
					)
					((IsFlag 173)
						(gMessager say: 7 1) ; "Nanites are there and they look real pissy."
					)
					(else
						(SetFlag 173)
						(gMessager say: 7 1 3) ; "Holy Captain's Log, Batman! There are a few more of those nanites here. How am I gonna handle this one?"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightEdge of Feature
	(properties
		noun 4
		sightAngle 40
		x 470
		y 116
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 511 90 472 93 450 108 450 113 444 120 439 127 436 135 435 138 503 138 501 126 497 120 492 105
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local8
					(gEgo setScript: sRogerClammers)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftEdge of Feature
	(properties
		noun 5
		x 367
		y 115
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 378 112 370 99 348 90 358 106 352 115 351 138 388 138 388 127
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local7
					(gEgo setScript: sRogerClammers)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance skull of Feature
	(properties
		noun 3
		sightAngle 365
		approachX 880
		approachY 110
		x 867
		y 38
		z 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 777 10 847 20 907 29 958 40 958 47 888 35 816 22 777 14
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(135 ; Finger_Nail
				(if (not (IsFlag 131))
					(gEgo setScript: sRogerCutsThru)
				)
			)
			(4 ; Do
				(if (IsFlag 131)
					(gEgo setScript: sRogerClimbs)
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

(instance deathTrap of Feature
	(properties
		noun 4
		sightAngle 40
		x 185
		y 109
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 192 98 193 106 210 112 212 120 197 129 181 128 150 139 167 117 177 110 172 102 152 87 166 92 177 93
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftTop of Feature
	(properties
		noun 3
		sightAngle 40
		x 65
		y 12
	)

	(method (init)
		(self
			setPolygon: ((Polygon new:) type: PTotalAccess init: 3 2 1 24 129 1 yourself:)
		)
		(super init: &rest)
	)
)

(instance meninges of Feature
	(properties
		noun 3
		sightAngle 40
		x 786
		y 54
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 360 1 139 0 4 27 7 80 105 79 213 82 247 93 309 80 373 94 393 135 431 137 454 93 507 82 580 90 627 81 662 85 752 107 768 98 813 101 846 90 875 93 937 80 933 48 730 10 667 1
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance brainRight of Feature
	(properties
		noun 4
		sightAngle 40
		x 798
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 958 87 923 85 894 92 879 101 876 100 866 97 848 93 830 100 802 104 769 100 756 110 728 105 702 97 681 92 653 96 642 89 606 89 578 103 570 96 547 89 514 90 494 105 507 138 638 138 672 137 696 137 747 137 757 137 958 137
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance brainLeft of Feature
	(properties
		noun 5
		sightAngle 40
		x 257
		y 110
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 170 89 194 96 195 103 213 110 214 120 199 131 181 130 159 138 348 138 350 113 356 106 344 89 288 84 247 101 234 91 186 83 173 85
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance mineShaft of Feature
	(properties
		noun 11
		sightAngle 40
		x 72
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 44 114 64 114 65 107 78 107 81 112 105 113 99 130 100 139 52 138 49 127 40 115
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance light of Feature
	(properties
		noun 12
		sightAngle 40
		x 144
		y 93
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 143 69 142 77 139 77 140 98 142 98 142 116 145 118 150 116 148 98 149 75 147 71
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exitToShuttle of ExitFeature
	(properties
		noun 8
		sightAngle 40
		approachX 880
		approachY 28
		x 919
		y 17
		nextRoom 490
		message 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 953 5 921 5 885 16 886 20 911 27 953 30
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if (IsFlag 125)
			(= approachY 110)
		else
			(= approachY 28)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Exit
				(gEgo setScript: sExitToShuttle)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ShootTimer of Timer
	(properties)

	(method (doit)
		(super doit:)
		(if (and (< (gEgo x:) 150) (not (gEgo script:)))
			(gEgo setScript: sRogerShotFront)
		)
	)

	(method (cue)
		(= local0 0)
		(cond
			((and local5 (deathTrap onMe: gEgo))
				(gEgo setScript: sRogerShotFront)
			)
			((and local6 (deathTrap onMe: gEgo))
				(gEgo setScript: sRogerShotSide)
			)
		)
	)
)

(instance fallTimer of Timer
	(properties)

	(method (cue)
		(gEgo setScript: sRogerFalls)
	)
)

(instance sound1 of Sound
	(properties
		flags 1
	)
)

