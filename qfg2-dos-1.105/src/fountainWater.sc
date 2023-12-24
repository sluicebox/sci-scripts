;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 81)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TryToMoveTo)
(use Plaza)
(use Elemental)
(use Interface)
(use LoadMany)
(use Rev)
(use Avoid)
(use Motion)
(use Actor)
(use System)

(public
	fountainWater 0
)

(local
	[moveList 18] = [0 0 130 189 129 179 136 165 195 189 195 180 188 165 162 160 162 200]
	skinDown
	index
)

(procedure (FindWhere thePoint)
	(= index (* thePoint 2))
	(waterElemental newX: [moveList index] newY: [moveList (+ index 1)])
)

(procedure (ExcludeFountain theX)
	(if (> theX 159)
		(= theX (Max 230 theX))
	else
		(= theX (Min 80 theX))
	)
	(return theX)
)

(class FountainPlaza of Plaza
	(properties
		style 13
	)

	(method (init &tmp saveX)
		(if (== gPrevRoomNum south)
			(= bottomToX (= bottomFromX (ExcludeFountain (- 319 (gEgo x:)))))
		else
			(self style: 7)
		)
		(super init:)
		(InitAddToPics fountainSpout fountainBasin)
		(if (IsFlag 16) ; fShapeir
			(fountainWater init:)
		)
		(if (== gElementalState 7)
			(waterElemental cycleSpeed: 1 setCycle: Fwd init:)
		)
	)

	(method (setDoorPos door)
		(if (!= door 3)
			(super setDoorPos: door)
		else
			(= xOut (ExcludeFountain (- 319 (gEgo x:))))
			(= xIn xOut)
			(= yOut bottomFromY)
			(= yIn (- bottomToY 10))
		)
	)
)

(instance fountainBasin of PicView
	(properties
		x 161
		y 197
		noun '/basin,fount'
		description {the city fountain}
		view 310
		priority 14
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (IsFlag 16) ; fShapeir
				(HighPrint 81 0) ; "The crystal clear water of the fountain is a priceless treasure in a land such as this."
			else
				(HighPrint 81 1) ; "The cracked and dry fountain is a pitiful sight."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fountainSpout of PicView
	(properties
		x 160
		y 197
		z 9
		noun '/fount'
		description {the city fountain}
		view 310
		cel 1
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (< gCurRoomNum 380)
				(HighPrint 81 0) ; "The crystal clear water of the fountain is a priceless treasure in a land such as this."
			else
				(HighPrint 81 1) ; "The cracked and dry fountain is a pitiful sight."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fountainWater of Prop
	(properties
		x 160
		y 192
		noun '/water,splash'
		description {the splashing water}
		lookStr {The water splashes into the fountain in a most inviting way.}
		view 310
		loop 1
		signal 512
	)

	(method (init)
		(super init: &rest)
		(if (!= (gCSound number:) 310)
			(gCSound number: 310 loop: -1 playBed:)
		)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
		(self setCycle: Fwd)
	)

	(method (dispose)
		(if (not (OneOf gNewRoomNum 310 315)) ; FPN, FPS
			(gCSound fade:)
		)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp [str 100])
		(cond
			((Said 'drink')
				(if
					(or
						(gEgo inRect: 92 150 233 300)
						(gEgo inRect: 110 135 215 160)
					)
					(ClearFlag 3) ; fThirsty
					(ClearFlag 137) ; fDyingOfThirst
					(HighPrint 81 2) ; "The fountain water is cool and refreshing."
				else
					(NotClose)
				)
			)
			((Said 'get,get,fill/water,waterbag,(skin<water)')
				(cond
					((not (gEgo has: 37)) ; Waterskin
						(HighPrint 81 3) ; "You don't have a waterskin."
						(if (IsFlag 3) ; fThirsty
							(ClearFlag 3) ; fThirsty
							(ClearFlag 137) ; fDyingOfThirst
							(HighPrint 81 4) ; "But you do take advantage of the opportunity to quench your thirst."
						)
					)
					(
						(not
							(or
								(gEgo inRect: 92 150 233 300)
								(gEgo inRect: 110 135 215 160)
							)
						)
						(NotClose)
					)
					((== gDrinksLeft (* [gInvNum 37] 10)) ; Waterskin
						(if (== [gInvNum 37] 1) ; Waterskin
							(HighPrint 81 5) ; "Your waterskin is full of water."
						else
							(HighPrint 81 6) ; "Your waterskins are full of water."
						)
					)
					(else
						(ClearFlag 3) ; fThirsty
						(ClearFlag 137) ; fDyingOfThirst
						(= gDrinksLeft (* [gInvNum 37] 10)) ; Waterskin
						(HighPrint
							(Format ; "You fill your waterskin%c with cool, clear water from the fountain."
								@str
								81
								7
								(if (> [gInvNum 37] 1) 115 else 0) ; Waterskin
							)
						)
					)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance waterElemental of Elemental
	(properties
		x 160
		y 180
		noun '/elemental[<water]'
		description {the Water Elemental}
		lookStr {Watery tart!}
		view 346
		loop 1
		priority 14
		signal 18448
		wandering 1
		attackDist 35
		wanderList 8
	)

	(method (init)
		(super init: &rest)
		(LoadMany rsVIEW 47 342 346)
		(LoadMany rsSCRIPT 985)
		(self baseSetter: waterBase)
		(if (and (!= gElementalState 7) (== gDropObjRoom gCurRoom))
			(waterSkin
				x: (* (/ gDropObjPosn 100) 10)
				y: (* (mod gDropObjPosn 100) 10)
				init:
			)
		)
	)

	(method (attack)
		(gEgo hurtScript: getDrained)
		(super attack:)
	)

	(method (wander)
		(super wander:)
		(FindWhere wandering)
		(self setMotion: TryToMoveTo newX newY 250 self)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'drop,use,set,(put<down)/waterbag,water,(skin<water)')
				(if (== gElementalState 7)
					(if (gEgo has: 37) ; Waterskin
						(gEgo setScript: doSkin 0 1)
					else
						(DontHave)
					)
				else
					(event claimed: 0)
				)
			)
			((Said 'use/bellows,(elemental<air)')
				(if (gEgo has: 25) ; Bellows
					(gEgo setScript: useBellows)
				else
					(DontHave)
				)
			)
			((Said 'talk,talk/elemental,water')
				(HighPrint 81 8) ; "The Water Elemental cooly responds with a wave."
			)
			((Said 'drink,get,get,fill/water,waterbag,(skin<water)')
				(HighPrint 81 9) ; "Any adventurer who would try to get water from an Elemental-inhabited fountain must be wet behind the ears. That's no way to make a splash."
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((gEgo script:))
			(
				(and
					(or
						(gEgo inRect: 92 150 233 300)
						(gEgo inRect: 110 135 215 160)
					)
					wandering
				)
				(self
					following: 0
					wandering: 0
					setMotion: TryToMoveTo (gEgo x:) (gEgo y:) 50
					setAvoider: Avoid
				)
			)
			(
				(not
					(or
						(gEgo inRect: 92 150 233 300)
						(gEgo inRect: 110 135 215 160)
						wandering
					)
				)
				(self wandering: 1 cue:)
			)
		)
	)
)

(instance waterBase of Code
	(properties)

	(method (doit theActor &tmp theX)
		(= theX (theActor x:))
		(BaseSetter theActor)
		(theActor brLeft: (- theX 9) brRight: (+ theX 9))
	)
)

(instance windBag of Prop
	(properties
		noun '/wind,air'
		description {the wind bag}
		lookStr {It's a lot of hot air.}
		view 342
	)
)

(instance getDrained of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo x:) 160)
					(= register 1)
					(gEgo setHeading: 225 self)
				else
					(= register 0)
					(gEgo setHeading: 135 self)
				)
			)
			(1
				(if register
					(gEgo
						setLoop: (gEgo loop:)
						setCycle: Rev
						setMotion:
							MoveTo
							(+ (gEgo x:) 10)
							(- (gEgo y:) 10)
					)
					(waterElemental
						setMotion:
							TryToMoveTo
							(- (gEgo x:) 18)
							(+ (gEgo y:) 11)
							25
							self
					)
				else
					(gEgo
						setLoop: (gEgo loop:)
						setCycle: Rev
						setMotion:
							MoveTo
							(- (gEgo x:) 10)
							(- (gEgo y:) 10)
					)
					(waterElemental
						setMotion:
							TryToMoveTo
							(+ (gEgo x:) 18)
							(+ (gEgo y:) 11)
							25
							self
					)
				)
			)
			(2
				(waterElemental hide:)
				(gEgo
					view: 346
					setPri: 15
					setLoop: (+ register 6)
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(gEgo
					setLoop: (+ register 8)
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(4
				(gEgo
					setLoop: (+ register 10)
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(5
				(EgoDead 0 81 10 #title {You feel drained...} #icon 346 1 0) ; "For your information, "Go with the flow" is just an expression! Wave bye-bye, everyone..."
			)
		)
	)
)

(instance doSkin of HandsOffScript
	(properties)

	(method (changeState newState &tmp theX theY)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 165 145 self)
				(if (== register 1)
					(if (> (waterElemental x:) 160)
						(waterElemental wandering: 0 setMotion: MoveTo 185 200)
					else
						(waterElemental wandering: 0 setMotion: MoveTo 135 200)
					)
				)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo view: 47 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(if (== register 1)
					(waterSkin init:)
					(= skinDown 1)
					(= gDropObjRoom gCurRoom)
					(= theX (+ (waterSkin x:) 5))
					(= theY (+ (waterSkin y:) 5))
					(= gDropObjPosn (+ (* (/ theX 10) 100) (/ theY 10)))
					(gEgo use: 37 1) ; Waterskin
					(if (> gDrinksLeft (* [gInvNum 37] 10)) ; Waterskin
						(= gDrinksLeft (* [gInvNum 37] 10)) ; Waterskin
					)
				else
					(waterSkin dispose:)
					(= gDropObjRoom 0)
					(= skinDown 0)
					(gEgo get: 43) ; MagicWater
				)
				(gEgo setCycle: Beg self)
			)
			(4
				(if (== register 1)
					(EgoGait 0 0) ; walking
					(gEgo
						setLoop: -1
						setMotion: MoveTo 180 (- (gEgo y:) 15) self
					)
				else
					(if (== gElementalState 8)
						(Print 81 11) ; "You pick up the waterskin that now contains the essence of the Water Elemental."
					else
						(HighPrint 81 12) ; "You put the waterskin away."
					)
					(self changeState: 6)
				)
			)
			(5
				(Face gEgo waterSkin 0 self)
			)
			(6
				(if (== register 1)
					(waterElemental wandering: 1 cue:)
				)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance useBellows of HandsOffScript
	(properties)

	(method (changeState newState &tmp theX theY)
		(switch (= state newState)
			(0
				(cond
					((gEgo inRect: 160 0 300 150)
						(gEgo setMotion: MoveTo 240 175 self)
					)
					((gEgo inRect: 0 0 160 150)
						(gEgo setMotion: MoveTo 80 175 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(= register (gEgo x:))
				(cond
					(
						(or
							(gEgo inRect: 185 170 225 200)
							(gEgo inRect: 95 170 135 200)
						)
						(self cue:)
					)
					((> register 160)
						(gEgo setMotion: MoveTo 220 190 self)
					)
					(else
						(gEgo setMotion: MoveTo 100 190 self)
					)
				)
			)
			(2
				(if (> register 160)
					(gEgo setHeading: 315 self)
				else
					(gEgo setHeading: 45 self)
				)
			)
			(3
				(gEgo
					view: 342
					setLoop: (if (> register 160) 6 else 5)
					cycleSpeed: 1
					setCycle: Fwd
				)
				(if (> register 160)
					(= theX (- (gEgo x:) 19))
					(= theY (- (gEgo y:) 45))
				else
					(= theX (+ (gEgo x:) 19))
					(= theY (- (gEgo y:) 45))
				)
				(windBag
					posn: theX theY
					setLoop: (if (> register 160) 8 else 7)
					setCel: 0
					setPri: 15
					setCycle: End self
					init:
				)
				(waterElemental setScript: jumpIntoWaterskin)
			)
			(4
				(gEgo loop: 7)
				(NormalEgo)
				(windBag dispose:)
				(= cycles 1)
			)
			(5
				(if (> register 160)
					(gEgo setMotion: MoveTo 240 175 self)
				else
					(gEgo setMotion: MoveTo 80 175 self)
				)
			)
			(6
				(Face gEgo waterElemental)
				(self dispose:)
			)
		)
	)
)

(instance jumpIntoWaterskin of Script
	(properties)

	(method (changeState newState &tmp theX theY)
		(switch (= state newState)
			(0
				(= theX (+ (waterSkin x:) 2))
				(= theY (- (waterSkin y:) 6))
				(waterElemental
					following: 0
					wandering: 0
					illegalBits: 0
					setMotion: MoveTo theX theY self
				)
			)
			(1
				(if skinDown
					(waterElemental
						setLoop: 2
						setCel: 0
						cycleSpeed: 1
						setCycle: End self
					)
				else
					(self changeState: 4)
				)
			)
			(2
				(waterSkin setCel: 1)
				(waterElemental
					setLoop: 4
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(SolvePuzzle 623 20)
				(SkillUsed 14 100) ; honor
				(waterSkin setCel: 2)
				(++ gElementalState)
				(waterElemental dispose:)
			)
			(4
				(waterElemental setMotion: MoveTo 140 160 self)
			)
			(5
				(HighPrint 81 13) ; "Your efforts managed to blow the Water Elemental out of the fountain temporarily, but it quickly returned when you stopped."
				(waterElemental wandering: 1 cue:)
				(= cycles 1)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance waterSkin of Prop
	(properties
		x 156
		y 142
		noun '/waterbag,(skin<water)'
		description {the waterskin}
		lookStr {It's a waterskin.}
		view 346
		loop 12
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '(lockpick<up)/waterbag,(skin<water)')
				(self doVerb: 7)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(gEgo setScript: doSkin 0 0)
		)
	)
)

