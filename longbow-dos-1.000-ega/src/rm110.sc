;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use n013)
(use Wat)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use System)

(public
	rm110 0
)

(local
	local0
	local1
	[local2 6] = [1110 26 1 1 1 0]
	[local8 4] = [1110 29 1 0]
	[local12 4] = [1110 30 1 0]
	[local16 5] = [1110 31 2 1 0]
)

(instance rm110 of Rm
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1110 13) ; "How green and beautiful Sherwood Forest is, stretching beyond the end of sight."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		(= gForestRoomNum 71)
		(if (and (== gDay 11) (IsFlag 64) (>= gRoomCount 20))
			(self picture: 803 style 7)
		else
			(self picture: 110 style 10)
		)
		(super init:)
		(if (and (== gDay 11) (IsFlag 64) (>= gRoomCount 20))
			(Say 1110 33) ; "I arrived at the Overlook too late! The treasure train had arrived and my men had no choice but to attack without leadership. All was chaos!"
			(= global146 65)
			(gCurRoom newRoom: 176) ; robscrewed
		else
			(Wat section: 4)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 147 170 188 171 184 183 166 183
						yourself:
					)
			)
			(if (== gDisguiseNum 0) ; outlaw
				(switch gDay
					(1
						(cond
							((not (IsFlag 137)) 0)
							((not (IsFlag 44))
								(LoadMany rsVIEW 110 755)
								(self setScript: waitForEncounter 0 1)
							)
						)
					)
					(3
						(if (not (IsFlag 49))
							(Load rsVIEW 55)
							(self setScript: waitForEncounter 0 2)
						)
					)
					(4
						(if (not (IsFlag 47))
							(LoadMany rsVIEW 110 755)
							(self setScript: waitForEncounter 0 3)
						)
					)
					(5
						(cond
							((not (IsFlag 111)))
							((not (IsFlag 50))
								(SetFlag 50)
								(LoadMany rsVIEW 106 25)
								(= local0 1)
								(self setScript: (ScriptID 18 3)) ; day5
							)
							(
								(and
									(not (IsFlag 147))
									(not (IsFlag 55))
									(not (Wat script:))
								)
								(if (< (Random 0 100) 50)
									(if (< (Random 0 100) 50)
										(Load rsVIEW 25)
										(self setScript: (ScriptID 18 4)) ; day6A
									else
										(Load rsVIEW 106)
										(self setScript: (ScriptID 18 5)) ; day6B
									)
								else
									(self
										setScript:
											waitForMonk
											0
											(if (< (Random 0 100) 50) 5 else 4)
									)
								)
							)
						)
					)
					(6
						(cond
							((Wat script:))
							((IsFlag 25)
								(if (not (IsFlag 147))
									(if (< (Random 0 100) 50)
										(Load rsVIEW 106)
										(self setScript: (ScriptID 18 5)) ; day6B
									else
										(self setScript: waitForMonk 0 4)
									)
								)
							)
							((not (IsFlag 55))
								(if (< (Random 0 100) 50)
									(Load rsVIEW 25)
									(self setScript: (ScriptID 18 4)) ; day6A
								else
									(self setScript: waitForMonk 0 5)
								)
							)
						)
					)
					(8
						(if (not (IsFlag 135))
							(Load rsVIEW 53)
							(self setScript: waitForEncounter 0 6)
						)
					)
					(9
						(if (and (IsFlag 36) (not (IsFlag 28)))
							(Load rsVIEW 72)
							(self setScript: waitForEncounter 0 7)
						)
					)
					(11
						(LoadMany rsVIEW 160 161 162)
						(ScriptID 20) ; Will
						(HandsOff)
						((ScriptID 20) ; Will
							view: 160
							loop: 0
							cel: 2
							posn: 75 150
							actions: willActions
							init:
						)
					)
					(12
						(if (and (IsFlag 38) (not (IsFlag 27)))
							(SetFlag 136)
							(self setScript: (ScriptID 18 8)) ; day12
						)
					)
				)
			)
			(AddToFeatures street ridge)
			(NormalEgo)
			(gEgo actions: egoActions)
			(switch gPrevRoomNum
				(220 ; forest
					(if (== gEgoEdgeHit 4)
						(= global116 0)
					else
						(= global116 1)
					)
					(gEgo setScript: fromTheForest)
				)
				(120
					(gEgo setScript: fromTheStreet)
				)
				(100
					(if (> gDay 1)
						(SetFlag 137)
					)
					(gEgo setScript: fromTheForest)
				)
				(else
					(gEgo posn: 120 155 loop: 6 init:)
					(SetFlag 137)
				)
			)
			(if (or (!= (gRgnMusic number:) 905) (< (gRgnMusic vol:) 127))
				(gRgnMusic number: 905 play:)
			)
		)
	)

	(method (doit)
		(cond
			((gEgo script:))
			((& (gEgo onControl: 1) $0002)
				(if (and (== gDay 5) (gEgo mover:) local0)
					(Wat qFight: ((gEgo mover:) x:))
				)
				(gEgo setScript: takeTheLowRoad)
			)
			((gEgo edgeHit:)
				(gEgo setScript: offScreen)
			)
		)
		(super doit:)
	)
)

(instance ridge of Feature
	(properties
		lookStr 12 ; "From here I can spy safely upon Watling Street."
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 0 145 319 64 319 91 199 123 184 119 163 127 157 137 127 146 169 160 319 177 319 189 0 189
				yourself:
			)
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance street of Feature
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if
					(or
						(and
							(gCurRoom script:)
							(!= (gCurRoom script:) waitForEncounter)
							(!= (gCurRoom script:) waitForMonk)
						)
						(Wat script:)
					)
					(Say 1110 15) ; "I've seen all I need to see. It is time to act."
				else
					(Say 1110 14) ; "There is no one on Watling Street now."
				)
			)
			(3 ; Do
				(HandsOff)
				(gEgo setMotion: PolyPath (gEgo x:) 50)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 76 123 319 67 319 94 125 146 74 144
				yourself:
			)
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance takeTheLowRoad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo
					setPri: 11
					setLoop: 3
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 55) self
				)
			)
			(2
				(if (== (Wat travelSect:) 4)
					(Wat
						enterDir:
							(switch (Wat travelDir:)
								(1 1)
								(3 3)
								(else 2)
							)
					)
				else
					(Wat enterDir: 2)
				)
				(if
					(and
						(== gDay 4)
						(IsFlag 48)
						(or (IsFlag 153) (IsFlag 174))
					)
					(gCurRoom newRoom: 160)
				else
					(gCurRoom newRoom: 120)
				)
			)
		)
	)
)

(instance offScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch (gEgo edgeHit:)
					(EDGE_RIGHT
						(= global116 1)
						(gEgo
							setMotion:
								PolyPath
								(+ (gEgo x:) 15)
								(gEgo y:)
								self
						)
					)
					(EDGE_LEFT
						(= global116 0)
						(gEgo
							setMotion:
								PolyPath
								(- (gEgo x:) 15)
								(gEgo y:)
								self
						)
					)
					(else
						(= global116 1)
						(gEgo
							setMotion:
								PolyPath
								(gEgo x:)
								(+ (gEgo y:) 55)
								self
						)
					)
				)
			)
			(1
				(cond
					(
						(and
							(== gDay 4)
							(IsFlag 48)
							(or (IsFlag 153) (IsFlag 174))
						)
						(gCurRoom newRoom: 160)
					)
					((== (gEgo edgeHit:) EDGE_LEFT)
						(switch (Wat travelDir:)
							(0
								(Wat enterDir: 2)
							)
							(1
								(Wat enterDir: 1)
							)
							(3
								(Wat enterDir: 3)
							)
						)
						(gCurRoom newRoom: 120)
					)
					(
						(and
							(== gDay 1)
							(IsFlag 46)
							(IsFlag 45)
							(IsFlag 44)
						)
						(gCurRoom newRoom: 160)
					)
					(else
						(gEgo edgeHit: EDGE_RIGHT)
						(gCurRoom newRoom: 220) ; forest
					)
				)
			)
		)
	)
)

(instance fromTheForest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 46 233 init: setMotion: PolyPath 107 150 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(cond
					((and (== gDay 1) (not (IsFlag 137)))
						(self setScript: (ScriptID 18 9) self) ; setup
					)
					((== gDay 11)
						(client setScript: day11Script)
					)
					((and (IsFlag 38) (not (IsFlag 27)))
						(client setScript: seeKnight)
					)
					(else
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(3
				(gCurRoom setScript: waitForEncounter 0 1)
				(self dispose:)
			)
		)
	)
)

(instance fromTheStreet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgoHead setPri: 11)
				(gEgo
					posn: 119 195
					init:
					setPri: 11
					setLoop: 2
					setMotion: MoveTo 119 143 self
				)
			)
			(1
				(gEgoHead setPri: -1)
				(gEgo setPri: -1 setMotion: MoveTo (gEgo x:) 160 self)
			)
			(2
				(gEgo setLoop: -1 setHeading: 45 self)
			)
			(3
				(cond
					((and (== gDay 1) (not (IsFlag 137)))
						(self setScript: (ScriptID 18 9) self) ; setup
					)
					((== gDay 11)
						(client setScript: day11Script)
					)
					((and (IsFlag 38) (not (IsFlag 27)))
						(client setScript: seeKnight)
					)
					(else
						(if (IsFlag 70)
							(ClearFlag 70)
							(Say 1110 3) ; "For one of my reputation for daring, wit and cunning, that was a dazzling display of indecision."
						)
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(4
				(gCurRoom setScript: waitForEncounter 0 1)
				(self dispose:)
			)
		)
	)
)

(instance waitForEncounter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 20))
			)
			(1
				(if (not (gEgo script:))
					(client
						setScript:
							(switch register
								(1
									(SetFlag 44)
									(ScriptID 18 0) ; day1
								)
								(2
									(SetFlag 49)
									(ScriptID 18 1) ; day3
								)
								(3
									(SetFlag 47)
									(ScriptID 18 2) ; day4
								)
								(6
									(SetFlag 135)
									(ScriptID 18 6) ; day8
								)
								(7
									(SetFlag 28)
									(ScriptID 18 7) ; day9
								)
							)
					)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance waitForMonk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 20))
			)
			(1
				(if (not (gEgo script:))
					(switch register
						(4
							(Load rsVIEW 106)
							(client setScript: (ScriptID 18 5)) ; day6B
						)
						(5
							(Load rsVIEW 25)
							(client setScript: (ScriptID 18 4)) ; day6A
						)
					)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance blewHornDay11 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(1
				(= ticks 12)
			)
			(2
				(Converse 2 @local16 1 0 14 1 self) ; "The men are on alert. They'll be here as quickly as they can manage."
			)
			(3
				(gCurRoom newRoom: 171) ; strat
			)
		)
	)
)

(instance day11Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 30)
			)
			(1
				(if (IsFlag 64)
					(Converse 1 @local8 14 0 self) ; "They haven't reached here yet, Robin, but it won't be long."
				else
					(= gRoomCount 0)
					(SetFlag 64)
					(Converse 1 @local2 14 0 self) ; "No sign of them from here yet, but they'll reach the Overlook before the day is out."
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance seeKnight of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 12)
			)
			(1
				(Say 1110 4 self) ; "It's good I have such trusted men."
			)
			(2
				(Say 1110 5 self) ; "While I eluded the Sheriff's men, they've found the Queen's Knight and hold him for me upon Watling Street."
			)
			(3
				(Say 1110 6 self) ; "I'll join them at once."
			)
			(4
				(gEgo setScript: takeTheLowRoad)
				(self dispose:)
			)
		)
	)
)

(instance egoActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(and
				(== theVerb 4) ; Inventory
				(== invItem 1) ; horn
				(cond
					((== gDay 11)
						(gCurRoom setScript: blewHornDay11)
						1
					)
					(
						(OneOf
							(gCurRoom script:)
							0
							waitForEncounter
							waitForMonk
						)
						1
						(if local1
							(= local1 0)
							(Say 1110 8) ; "If I wind my horn now, it will alarm anyone within miles upon Watling Street."
						else
							(= local1 1)
							(Say 1110 7) ; "Winding my horn here would destroy my advantage of secrecy."
						)
					)
					(else
						1
						(switch (Wat whichChar:)
							(9
								(Say 1110 9) ; "Yonder monks will not tarry in these parts if they hear my horn being winded."
							)
							(1
								(Say 1110 10) ; "The Sheriff's man will double his pace if I alarm him with my horn."
							)
							(3
								(Say 1110 10) ; "The Sheriff's man will double his pace if I alarm him with my horn."
							)
							(else
								(Say 1110 11) ; "I'll never catch up to yonder traveller if I'm so foolish as to wind my horn now."
							)
						)
					)
				)
			)
		)
	)
)

(instance willActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Talk
			1
			(Converse 1 @local12 14 0) ; "We're all waiting for word from you."
		)
	)
)

