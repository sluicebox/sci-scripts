;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use n013)
(use n121)
(use Wat)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm120 0
	tree 1
	theStreet 2
	eastSide 3
	westSide 4
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 5] = [1120 41 1 1 0]
)

(procedure (localproc_0)
	(Wat travelSect: (Wat section:))
	(gCurRoom horizon: 30)
	(= local4 1)
	(switch (Wat whichChar:)
		(1
			(ScriptID 29) ; theMan
			(LoadMany rsVIEW 112 393 792 752 4 5 7 745)
			(LoadMany rsSCRIPT 969 930 951)
		)
		(3
			(ScriptID 8) ; theMan
			(LoadMany rsVIEW 113 393 792 752 4 5 7 745)
			(LoadMany rsSCRIPT 969 930 951)
		)
		(2
			(ScriptID 25) ; beg
			(LoadMany rsSCRIPT 969 930 951)
			(LoadMany rsVIEW 130 131 36 37 7 4)
		)
		(6
			(ScriptID 24) ; yeo
			(LoadMany rsVIEW 132 133)
			(Load rsSCRIPT 930)
		)
		(7
			(ScriptID 26) ; jew
			(LoadMany rsVIEW 134 30 135 7)
			(LoadMany rsSCRIPT 951 969)
		)
		(4
			(ScriptID 27) ; fMonk
			(LoadMany rsSCRIPT 969 930 951)
			(LoadMany rsVIEW 4 5 15 122 124 128 167 42)
		)
		(5
			(ScriptID 28) ; aMonk
			(Load rsSCRIPT 930)
			(LoadMany rsVIEW 129 58 147 168 4)
		)
		(8
			(ScriptID 10) ; fKnight
			(LoadMany rsVIEW 125 123 60 792)
			(ScriptID 20) ; Will
			(ScriptID 19) ; John
			(ScriptID 23) ; Tuck
			(LoadMany rsVIEW 151 152 160 161 154 155)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(if (OneOf (Wat whichChar:) 1 2 3 5 4 7 6)
		(= local1 0)
	)
	(switch (Wat whichChar:)
		(1
			(Wat travelSect: (Wat section:))
			((ScriptID 29 0) view: 752 posn: 205 65 setLoop: 1 setCel: 5 init:) ; theMan
			((ScriptID 29 1) posn: 197 73 setLoop: 3 setCel: 0 init:) ; theWoman
		)
		(2
			((ScriptID 25 0) posn: 205 70 loop: 2 cel: 5 init:) ; beg
		)
		(3
			((ScriptID 8 0) view: 752 posn: 207 66 setLoop: 1 setCel: 5 init:) ; theMan
			((ScriptID 8 1) posn: 205 74 setLoop: 4 setCel: 0 init:) ; poach
		)
		(5
			(if (== (Wat travelDir:) 1)
				((ScriptID 28 0) posn: 135 125 setLoop: 3 setCel: 0 init:) ; aMonk
			else
				((ScriptID 28 0) posn: 205 70 setLoop: 2 setCel: 0 init:) ; aMonk
			)
		)
		(4
			(if (== (Wat travelDir:) 1)
				((ScriptID 27 0) ; fMonk
					posn: 135 125
					setLoop: 6
					setCel: 0
					cycleSpeed: 60
					ignoreActors: 1
					init:
				)
			else
				((ScriptID 27 0) ; fMonk
					posn: 205 70
					setLoop: 4
					setCel: 0
					cycleSpeed: 60
					ignoreActors: 1
					init:
				)
			)
		)
		(7
			((ScriptID 26 0) ; jew
				view: 134
				ignoreActors: 1
				posn: 205 70
				loop: 4
				cel: 5
				init:
			)
		)
		(6
			((ScriptID 24 0) ; yeo
				view: 132
				ignoreActors: 1
				posn: 205 70
				loop: 0
				cel: 0
				init:
				setCycle: End self
			)
		)
	)
	(if (> (Wat weMeetAgain:) 1)
		(LoadMany rsVIEW 792 393)
		(= temp0
			(cond
				((OneOf (Wat section:) 1 2 5) 86)
				((OneOf (Wat section:) 3 4 6 7 8) 147)
				(else 297)
			)
		)
		(= temp1
			(cond
				((OneOf (Wat section:) 1 2 5) 44)
				((OneOf (Wat section:) 3 4 6 7 8) 39)
				(else 38)
			)
		)
		(switch (Wat whichChar:)
			(1
				((ScriptID 29 2) ; shooter
					posn: temp0 temp1
					setPri: (if (OneOf (Wat section:) 1 2 5) 1 else -1)
					init:
				)
			)
			(3
				((ScriptID 8 2) ; shootist
					posn: temp0 temp1
					setPri: (if (OneOf (Wat section:) 1 2 5) 1 else -1)
					init:
				)
			)
		)
	)
)

(instance rm120 of Rm
	(properties
		picture 120
		style 10
		horizon 20
		picAngle 60
		vanishingX 6720
		vanishingY -4000
	)

	(method (init &tmp temp0)
		(super init:)
		(proc121_0 1)
		(if (== gPrevRoomNum 220) ; forest
			(switch gEgoEdgeHit
				(3
					(= local3 1)
					(Wat section: (+ (Wat section:) 1) enterDir: 1)
				)
				(1
					(= local3 1)
					(Wat section: (- (Wat section:) 1) enterDir: 3)
				)
				(2
					(Wat enterDir: 4)
				)
				(4
					(Wat enterDir: 2)
				)
			)
		)
		(AddToFeatures eastSide westSide theStreet)
		(if (Wat script:)
			(switch (Wat travelDir:)
				(3
					(if (== gPrevRoomNum 100)
						(Wat enterDir: 3)
					)
					(if (>= (Wat section:) (Wat travelSect:))
						(localproc_0)
					)
				)
				(1
					(if (== gPrevRoomNum 100)
						(Wat enterDir: 1)
					)
					(if (<= (Wat section:) (Wat travelSect:))
						(localproc_0)
					)
				)
			)
		)
		(NormalEgo)
		(Load rsVIEW (+ (gEgo view:) 1))
		(if (and (IsFlag 38) (not (IsFlag 27)) (IsFlag 136))
			(Wat charObj: (ScriptID 10 0)) ; fKnight
			(gCurRoom setScript: (ScriptID 10 1)) ; fKnightEncounter
		else
			(= temp0 0)
			(if
				(and
					(Wat weMeetAgain:)
					(OneOf (Wat whichChar:) 1 3 2 5 4 7 6)
				)
				(= temp0 self)
			)
			(if
				(and
					(Wat weMeetAgain:)
					(or
						(and
							(>= (Wat section:) (Wat travelSect:))
							(== (Wat travelDir:) 3)
							(!= (Wat enterDir:) 1)
						)
						(and
							(<= (Wat section:) (Wat travelSect:))
							(== (Wat travelDir:) 1)
							(!= (Wat enterDir:) 3)
						)
					)
				)
				(localproc_1)
			)
			(gEgo setScript: walkIn temp0)
		)
		(if (or (!= (gRgnMusic number:) 490) (< (gRgnMusic vol:) 127))
			(gRgnMusic number: 905 play:)
		)
	)

	(method (doit)
		(cond
			((gEgo script:))
			((gEgo edgeHit:)
				(gEgo setScript: walkOut)
			)
			((and (not (Wat whichChar:)) (>= (gCurRoom horizon:) 30))
				(gCurRoom horizon: 20)
			)
			(
				(and
					(not (Wat offRoad:))
					(or (westSide onMe: gEgo) (eastSide onMe: gEgo))
				)
				(Wat offRoad: 1)
			)
			(
				(and
					(Wat offRoad:)
					(not (or (westSide onMe: gEgo) (eastSide onMe: gEgo)))
				)
				(Wat offRoad: 0)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (and (Wat whichChar:) (not (Wat script:)))
			(Wat setScript: (Wat theTimer:))
		)
		(super newRoom: newRoomNumber)
	)

	(method (notify)
		(gEgo actions: rm120Actions)
	)

	(method (dispose)
		(gEgo actions: 0)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(LoadMany 0 29 8)
		(super dispose:)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(switch (= state newState)
			(0
				(gEgo actions: rm120Actions)
				(if local4
					(= temp0 225)
					(= temp1 60)
					(= temp4 205)
					(= temp5 75)
					(= temp2 110)
					(= temp3 130)
					(= temp6 140)
					(= temp7 115)
				else
					(= temp0 286)
					(= temp1 -2)
					(= temp4 230)
					(= temp5 55)
					(= temp2 -14)
					(= temp3 237)
					(= temp6 40)
					(= temp7 183)
				)
				(if (and local2 (IsObject (Wat charObj:)))
					(= temp6 140)
					(= temp7 120)
					(= temp4 190)
					(= temp5 85)
				)
				(HandsOff)
				(switch (Wat enterDir:)
					(0
						(gEgo
							posn: 330 200
							init:
							setMotion: MoveTo 230 170 self
						)
					)
					(4
						(if (and (== (Wat section:) 9) (== (Wat enterDir:) 4))
							(gEgo
								posn: -15 145
								loop: 0
								init:
								setMotion: PolyPath 100 145 self
							)
						else
							(gEgo
								posn: -15 85
								loop: 0
								init:
								setMotion: PolyPath 39 85 self
							)
						)
					)
					(1
						(if local3
							(= local3 0)
							(gEgo
								posn: -15 28
								init:
								setMotion: MoveTo 168 51 self
							)
						else
							(gEgo
								posn: temp0 temp1
								loop: 5
								init:
								setMotion: MoveTo temp4 temp5 self
							)
						)
					)
					(2
						(gEgo
							posn: 330 177
							loop: 1
							init:
							setMotion: PolyPath 295 177 self
						)
					)
					(3
						(if local3
							(= local3 0)
							(gEgo
								posn: 330 200
								init:
								setMotion: MoveTo 230 170 self
							)
						else
							(gEgo
								loop: 6
								posn: temp2 temp3
								init:
								setMotion: MoveTo temp6 temp7 self
							)
						)
					)
				)
				(if local4
					(= local4 0)
					(switch (Wat whichChar:)
						(1
							(Wat charObj: (ScriptID 29 1)) ; theWoman
							(gCurRoom setScript: (ScriptID 29 3)) ; womanScript
						)
						(3
							(Wat charObj: (ScriptID 8 1)) ; poach
							(gCurRoom setScript: (ScriptID 8 3)) ; poachScript
						)
						(2
							(Wat charObj: (ScriptID 25 0)) ; beg
							(gCurRoom setScript: (ScriptID 25 1)) ; begScript
						)
						(6
							(Wat charObj: (ScriptID 24 0)) ; yeo
							(gCurRoom setScript: (ScriptID 24 1)) ; yeoScript
						)
						(7
							(Wat charObj: (ScriptID 26 0)) ; jew
							(gCurRoom setScript: (ScriptID 26 1)) ; jewScript
						)
						(4
							(Wat charObj: (ScriptID 27 0)) ; fMonk
							(gCurRoom setScript: (ScriptID 27 1)) ; monkScript
						)
						(5
							(Wat charObj: (ScriptID 28 0)) ; aMonk
							(gCurRoom setScript: (ScriptID 28 1)) ; monkScript
						)
					)
				)
				(if (and (IsFlag 38) (not (IsFlag 27)))
					((ScriptID 20) ; Will
						posn: 335 125
						init:
						setCycle: StopWalk 161
						setMotion: MoveTo 250 125
					)
				)
				(if (and (== gDay 11) (>= gRoomCount 20))
					(client setScript: toTheBattle)
				)
			)
			(1
				(NormalEgo)
				(if (and (IsFlag 38) (not (IsFlag 27)))
					(Wat charObj: (ScriptID 10 0)) ; fKnight
					(gCurRoom setScript: (ScriptID 10 1)) ; fKnightEncounter
					(= ticks 12)
				else
					(if (not (IsObject (Wat charObj:)))
						(HandsOn)
					)
					(self dispose:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register (gEgo edgeHit:))
				(Wat enterDir: 0)
				(switch register
					(2
						(gEgo
							setMotion:
								PolyPath
								(+ (gEgo x:) 15)
								(gEgo y:)
								self
						)
					)
					(3
						(gEgo
							setMotion:
								PolyPath
								(- (gEgo x:) 40)
								(+ (gEgo y:) 50)
								self
						)
						(if (and (== gDay 11) (IsFlag 64))
							(++ gRoomCount)
						)
					)
					(4
						(if (> (gEgo y:) 145)
							(gEgo
								setMotion:
									PolyPath
									(- (gEgo x:) 40)
									(+ (gEgo y:) 50)
									self
							)
							(= register 3)
						else
							(gEgo
								setMotion:
									PolyPath
									(- (gEgo x:) 15)
									(gEgo y:)
									self
							)
						)
					)
					(1
						(if (< (gEgo x:) 170)
							(= register 4)
							(gEgo
								setMotion: PolyPath -15 (+ (gEgo y:) 10) self
							)
						else
							(gEgo
								ignoreHorizon: 1
								setMotion: PolyPath (+ (gEgo x:) 40) -2 self
							)
							(if (and (== gDay 11) (IsFlag 64))
								(++ gRoomCount)
							)
						)
					)
				)
			)
			(1
				(if local5
					(= local5 0)
					((ScriptID 10 0) dispose: delete:) ; fKnight
					((ScriptID 10 4) dispose: delete:) ; theSword
					((ScriptID 10 2) dispose: delete:) ; horseBody
					((ScriptID 10 3) dispose: delete:) ; horseHead
				)
				(switch register
					(2
						(if
							(or
								(and (== gDay 12) (IsFlag 27))
								(and (== gDay 4) (IsFlag 48) (IsFlag 47))
							)
							(gCurRoom newRoom: 160)
						else
							(if
								(and
									(IsObject (Wat charObj:))
									(not (& ((Wat charObj:) signal:) $0020))
								)
								(SetFlag 70)
							)
							(if (== (Wat section:) 4)
								(if (Wat whichChar:)
									(Wat
										setScript: (Wat theTimer:)
										hurry: 1
										charObj: 0
										travelSect:
											(if (== (Wat travelDir:) 3)
												(+ (Wat travelSect:) 1)
											else
												(- (Wat travelSect:) 1)
											)
									)
								)
								(gCurRoom newRoom: 110)
							else
								(= global116 1)
								(gCurRoom newRoom: 220) ; forest
							)
						)
					)
					(4
						(if
							(or
								(and (== gDay 12) (IsFlag 27))
								(and (== gDay 4) (IsFlag 48) (IsFlag 47))
							)
							(gCurRoom newRoom: 160)
						else
							(if
								(and
									(IsObject (Wat charObj:))
									(not (& ((Wat charObj:) signal:) $0020))
								)
								(SetFlag 70)
							)
							(gCurRoom newRoom: 220) ; forest
						)
					)
					(1
						(cond
							((<= (Wat section:) 1)
								(if
									(or
										(and (== gDay 12) (IsFlag 27))
										(and
											(== gDay 4)
											(IsFlag 48)
											(IsFlag 47)
										)
									)
									(gCurRoom newRoom: 160)
								else
									(gCurRoom newRoom: 100)
								)
							)
							((and (== gDay 12) (gEgo has: 9)) ; message
								(gCurRoom newRoom: 160)
							)
							(else
								(if (IsObject (Wat charObj:))
									((Wat charObj:) dispose:)
									(Wat charObj: 0)
									(= local1 (Wat travelSect:))
									(= local2 (Wat whichChar:))
									(if (== (Wat travelDir:) 3)
										(Wat
											travelSect: (+ (Wat travelSect:) 1)
											setScript: (Wat theTimer:)
											hurry: 1
										)
									)
								)
								(if (OneOf gForestRoomNum 39 40 54 55 101 102)
									(-= gForestRoomNum 15)
								else
									(-= gForestRoomNum 16)
								)
								(gAddToPics eachElementDo: #dispose release:)
								((gCurRoom obstacles:)
									eachElementDo: #dispose
									release:
								)
								(= cycles 2)
							)
						)
						(Wat section: (- (Wat section:) 1))
					)
					(3
						(cond
							((>= (Wat section:) 9)
								(if
									(or
										(and (== gDay 12) (IsFlag 27))
										(and
											(== gDay 4)
											(IsFlag 48)
											(IsFlag 47)
										)
									)
									(gCurRoom newRoom: 160)
								else
									(gCurRoom newRoom: 100)
								)
							)
							((and (== gDay 12) (gEgo has: 9)) ; message
								(gCurRoom newRoom: 160)
							)
							(else
								(if (IsObject (Wat charObj:))
									((Wat charObj:) dispose:)
									(Wat charObj: 0)
									(= local1 (Wat travelSect:))
									(= local2 (Wat whichChar:))
									(if (== (Wat travelDir:) 1)
										(Wat
											travelSect: (- (Wat travelSect:) 1)
											setScript: (Wat theTimer:)
											hurry: 1
										)
									)
								)
								(if (OneOf gForestRoomNum 24 25 39 40 86 87)
									(+= gForestRoomNum 15)
								else
									(+= gForestRoomNum 16)
								)
								(gAddToPics eachElementDo: #dispose release:)
								((gCurRoom obstacles:)
									eachElementDo: #dispose
									release:
								)
								(= cycles 2)
							)
						)
						(Wat section: (+ (Wat section:) 1))
					)
				)
			)
			(2
				(if (== register 1)
					(Wat enterDir: 3)
				else
					(Wat enterDir: 1)
				)
				(if (OneOf register 1 3)
					(if
						(and
							(Wat weMeetAgain:)
							(or
								(and
									(>= (Wat section:) (Wat travelSect:))
									(== (Wat travelDir:) 3)
									(!= (Wat enterDir:) 1)
								)
								(and
									(<= (Wat section:) (Wat travelSect:))
									(== (Wat travelDir:) 1)
									(!= (Wat enterDir:) 3)
								)
							)
						)
						(localproc_1)
					)
					(if
						(and
							(== (Wat section:) 4)
							(IsFlag 27)
							(== gDay 12)
						)
						(= local5 1)
						((ScriptID 10 0) ; fKnight
							loop: 1
							cel: 5
							posn: 214 91
							z: 0
							init:
							stopUpd:
						)
						((ScriptID 10 4) posn: 125 55 cel: 2 init: stopUpd:) ; theSword
						((ScriptID 10 2) init:) ; horseBody
						((ScriptID 10 3) ; horseHead
							y: (- ((ScriptID 10 3) y:) 10) ; horseHead
							z: (- ((ScriptID 10 3) z:) 10) ; horseHead
							init:
						)
					)
					(gCurRoom drawPic: 120 (if (IsFlag 0) 10 else -32760))
					(proc121_0 1)
				)
				(= cycles 2)
			)
			(3
				(= temp0 0)
				(if
					(and
						(Wat weMeetAgain:)
						(or
							(and
								(>= (Wat section:) (Wat travelSect:))
								(== (Wat travelDir:) 3)
								(!= (Wat enterDir:) 1)
							)
							(and
								(<= (Wat section:) (Wat travelSect:))
								(== (Wat travelDir:) 1)
								(!= (Wat enterDir:) 3)
							)
						)
					)
					(switch local2
						(1
							(Wat charObj: (ScriptID 29 1)) ; theWoman
							(gCurRoom setScript: (ScriptID 29 3)) ; womanScript
						)
						(3
							(Wat charObj: (ScriptID 8 1)) ; poach
							(gCurRoom setScript: (ScriptID 8 3)) ; poachScript
						)
						(2
							(Wat charObj: (ScriptID 25 0)) ; beg
							(gCurRoom setScript: (ScriptID 25 1)) ; begScript
						)
						(5
							(Wat charObj: (ScriptID 28 0)) ; aMonk
							(gCurRoom setScript: (ScriptID 28 1)) ; monkScript
						)
						(4
							(Wat charObj: (ScriptID 27 0)) ; fMonk
							(gCurRoom setScript: (ScriptID 27 1)) ; monkScript
						)
						(7
							(Wat charObj: (ScriptID 26 0)) ; jew
							(gCurRoom setScript: (ScriptID 26 1)) ; jewScript
						)
						(6
							(Wat charObj: (ScriptID 24 0)) ; yeo
							(gCurRoom setScript: (ScriptID 24 1)) ; yeoScript
						)
					)
					(= temp0 gCurRoom)
				)
				(client setScript: walkIn temp0)
			)
		)
	)
)

(instance toTheBattle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 19) ; John
					posn: 335 125
					init:
					setCycle: StopWalk 152
					setMotion: MoveTo 250 125 self
				)
			)
			(1
				(Face (ScriptID 19) gEgo) ; John
				(Face gEgo (ScriptID 19)) ; John
				(= seconds 3)
			)
			(2
				(Converse 1 @local6 13 0 self) ; "I've been searching everywhere for you! We must get to the Overlook at once."
			)
			(3
				(= seconds 3)
			)
			(4
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803 9)
				(= ticks 100)
			)
			(5
				(Say 1120 43 self) ; "I barely had time to gather the men for an assault, but I had no time for planning. The result was bloody and disastrous."
			)
			(6
				(= global146 65)
				(gCurRoom newRoom: 176) ; robscrewed
			)
		)
	)
)

(instance theStreet of Feature
	(properties
		nsBottom 189
		nsRight 319
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0
			(cond
				((not (gEgo script:)) gEgo)
				((not (gCurRoom script:)) gCurRoom)
				(else gGame)
			)
		)
		(switch theVerb
			(2 ; Look
				(switch (Wat section:)
					(1
						(temp0 setScript: doubleMessage 1 0)
					)
					(2
						(temp0 setScript: doubleMessage 1 2)
					)
					(3
						(temp0 setScript: doubleMessage 1 4)
					)
					(4
						(temp0 setScript: doubleMessage 1 6)
					)
					(5
						(Say 1120 8 1) ; "This point is about mid-way between Nottingham to the south and the edge of my territory in Sherwood Forest to the north."
					)
					(6
						(temp0 setScript: doubleMessage 1 9)
					)
					(7
						(temp0 setScript: doubleMessage 1 11)
					)
					(8
						(temp0 setScript: doubleMessage 1 13)
					)
					(9
						(temp0 setScript: doubleMessage 1 15)
					)
				)
			)
			(10 ; Longbow
				(if (== (Wat qFight:) 4660)
					0
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance eastSide of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 150 189 319 18 319 189
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0
			(cond
				((not (gEgo script:)) gEgo)
				((not (gCurRoom script:)) gCurRoom)
				(else gGame)
			)
		)
		(if (== theVerb 2) ; Look
			(switch (Wat section:)
				(1
					(Say 1120 17 1) ; "East of here lie many thick banks of blackberry bushes."
				)
				(2
					(Say 1120 18 1) ; "The shooting glade is not far east of here."
				)
				(3
					(Say 1120 19 1) ; "East and slightly south of here is our hidden camp."
				)
				(4
					(temp0 setScript: doubleMessage 1 20)
				)
				(5
					(Say 1120 22 1) ; "There's a small grove of oaks immediately east of here."
				)
				(6
					(Say 1120 23 1) ; "The Widow's Cottage lies to the east."
				)
				(7
					(Say 1120 24 1) ; "East, within quick walking distance, is an Ash grove."
				)
				(8
					(Say 1120 25 1) ; "Somewhat east and south, near the river Trent, is a Willow grove, a tree sacred to women of mystic power."
				)
				(9
					(Say 1120 26 1) ; "Due east of here lies the sacred Willow Grove."
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance westSide of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:)) type: PTotalAccess init: 0 0 227 0 0 130 yourself:)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(switch (Wat section:)
				(1
					(Say 1120 27 1) ; "To the west, not far distant, is an Elder grove."
				)
				(2
					(Say 1120 28 1) ; "There's a rowan grove a long walk due west from this spot."
				)
				(3
					(Say 1120 29 1) ; "There's an ash grove not far to the west."
				)
				(4
					(Say 1120 30 1) ; "West a fair walk lies an Alder grove."
				)
				(5
					(Say 1120 31 1) ; "To the west lies the eldest Oak in all the forest, the Grandfather Oak of Sherwood."
				)
				(6
					(Say 1120 32 1) ; "West of here many young oaks grow, like courtiers to the great Grandfather Oak."
				)
				(7
					(Say 1120 33 1) ; "There's a grove of Hazel to the west."
				)
				(8
					(Say 1120 34 1) ; "Birches grow in a grove to the west."
				)
				(9
					(Say 1120 35 1) ; "It's difficult to travel west of here because of the thick blackberry bushes."
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance doubleMessage of TScript
	(properties)

	(method (cue)
		(if (not notKilled)
			(self dispose:)
			(gGame setCursor: 1 1)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say 1120 register self)
			)
			(1
				(Say 1120 (+ register 1) self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance tree of PicView
	(properties
		signal 4096
	)

	(method (doVerb theVerb)
		(cond
			((or (eastSide onMe: self) (> x 319) (> y 189))
				(eastSide doVerb: theVerb)
			)
			((or (westSide onMe: self) (< x 0))
				(westSide doVerb: theVerb)
			)
			(else
				(theStreet doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (gEgo onMe: event))
			(event claimed: 0)
			(gEgo handleEvent: event)
		else
			(super handleEvent: event)
		)
	)
)

(instance rm120Actions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(if (and (== theVerb 4) (== invItem 1)) ; Inventory, horn
				(if local0
					(= local0 0)
					(Say 1120 39) ; "Watling Street is too dangerous a place to wind my horn unless I have good cause."
				else
					(= local0 1)
					(Say 1120 40) ; "It isn't wise to wind my horn upon the road unless I truly have need of my men."
				)
				1
			)
		)
	)
)

