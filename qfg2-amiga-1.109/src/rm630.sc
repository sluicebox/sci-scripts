;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 630)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use Stage)
(use TargActor)
(use Full)
(use Interface)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm630 0
)

(local
	beastFed
	beastWatered
	beastPotioned
	beastCondition
	safeX
	safeY
	spellNum
	lookedInEyes
	hairAdded
	timerCounter
	hurtCounter
	[tmpStr 100]
	[cageFeatPts 16] = [165 144 206 158 273 133 272 82 254 61 217 49 188 60 164 82]
	[cagePolyPts 12] = [147 142 222 119 279 133 286 144 219 166 193 164]
)

(instance rm630 of Stage
	(properties
		picture 660
		style 8
		north 665
		east 665
		south 665
		west 665
		picAngle 75
		topFromX 80
		topToX 80
		rightFromY 160
		rightToY 160
		leftFromY 150
		leftToY 150
	)

	(method (init)
		(LoadMany rsVIEW 15 47 630 632 633 12 637)
		(SolvePuzzle 645 5)
		(= gNow (+ (* gDay 100) gTimeODay))
		(= beastWatered (> gBeastCare 1))
		(= beastFed (mod gBeastCare 2))
		(cond
			((IsFlag 42)) ; fAlScurvaFreed
			((or (not gCageLastHere) (< (- gNow gCageLastHere) 90))
				(= beastCondition 1)
			)
			((or beastFed beastWatered)
				(= beastCondition 2)
			)
			(else
				(= beastCondition 3)
			)
		)
		(if (== gRoomExitDir 3)
			(= inOut 3)
		)
		(= gSpellChecker gAllChecker)
		(gEgo init:)
		(super init:)
		(if gNight
			(gCurRoom overlay: 659 8)
			(InitAddToPics stellar1 stellar2)
		)
		(self setRegions: 660) ; desertReg
		(gDirectionHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(cageDoor init:)
		(InitAddToPics cageFront cageBack cagePieceLeft cagePieceRight)
		(cond
			((== beastCondition 3)
				(InitAddToPics deadBeast)
			)
			((IsFlag 42)) ; fAlScurvaFreed
			(else
				(beastBody init:)
				(beastHead init: setScript: beastWakesUp)
			)
		)
		(InitFeatures cageFeat)
		(theCage points: @cageFeatPts size: 8)
		(cageBase points: @cagePolyPts size: 6)
		(self addObstacle: cageBase)
		(if (== inOut 3)
			(gEgo posn: 45 76 setScript: (ScriptID 660 2) self) ; duneIn
		)
	)

	(method (cue)
		(super cue:)
		(if (and (== gEgoGait 3) (or (== beastCondition 1) (== beastCondition 2))) ; riding
			(self setScript: saurusBalks 0 gRoomExitDir)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((gEgo script:))
			((gEgo edgeHit:)
				(= gRoomExitDir (gEgo edgeHit:))
			)
			((& (gEgo onControl:) $0004)
				(gEgo setScript: (ScriptID 660 3)) ; duneOut
			)
			((& (gEgo onControl:) $1000)
				(if
					(and
						(gEgo inRect: 170 142 265 162)
						(not (cageDoor script:))
					)
					(gEgo setPri: 13)
				else
					(gEgo setPri: -1)
				)
				(if
					(and
						(or (== beastCondition 1) (== beastCondition 2))
						(not (cageDoor script:))
					)
					(self setScript: beastLunges)
				)
			)
			(else
				(= safeX (gEgo x:))
				(= safeY (gEgo y:))
				(if
					(and
						(gEgo inRect: 170 142 265 162)
						(not (cageDoor script:))
					)
					(gEgo setPri: 13)
				else
					(gEgo setPri: -1)
				)
			)
		)
	)

	(method (dispose)
		(if (== gRoomExitDir 3)
			(gEgo x: (- 320 (gEgo x:)))
		)
		(if (or (== beastCondition 1) (== beastCondition 2))
			(if (and (not beastFed) (not beastWatered))
				(HighPrint 630 0) ; "You hear a strangled cry of protest from the beast. When you look back at it, it seems to say, "Water, I must have water"."
			)
			(= gBeastCare (+ (* beastWatered 2) beastFed))
			(= gCageLastHere gNow)
		)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look,look>')
				(cond
					((Said 'search,look,look[<at,around][/room,area][/!*]')
						(if (== beastCondition 3)
							(HighPrint 630 1) ; "You see the carcass of the beast in its iron prison."
						else
							(HighPrint 630 2) ; "You see a strange creature trapped in a cage in the middle of the desert. The head resembles a cobra, the body looks like that of a panther, and its tail is like a scorpion. You find it difficult to believe that such a combination could exist in nature.  It looks half-starved and its eyes have a touch of madness in them."
						)
					)
					((Said '/eye')
						(if (== beastCondition 3)
							(HighPrint 630 3) ; "It stares at you with a cold, dead, gaze, much like your last blind date."
						else
							(HighPrint 630 4) ; "As you look into the eyes of the creature, you hear in your mind, "Come closer, much closer. Come closer and free me, release me. Open the cage and free me. Open the cage and trust me."
							(= lookedInEyes 1)
						)
					)
				)
			)
			(
				(or
					(and
						(== (event type:) $0040) ; direction
						(OneOf (event message:) JOY_UPLEFT JOY_UP JOY_UPRIGHT JOY_RIGHT JOY_DOWNRIGHT)
					)
					(and
						(== (event type:) evMOUSEBUTTON)
						(not (event modifiers:))
						(or
							(> (event x:) (gEgo x:))
							(< (event y:) (gEgo y:))
						)
					)
				)
				(if (== gEgoGait 3) ; riding
					(event claimed: 1)
					(HighPrint 630 5) ; "Your saurus isn't thrilled at the prospect of getting any closer to that cage."
				)
			)
			((== gEgoGait 3)) ; riding
			((IsFlag 42)) ; fAlScurvaFreed
			((Said 'attack,kill/creature,beast,animal,monster')
				(if (== beastCondition 3)
					(HighPrint 630 6) ; "It's dead enough already, thank you."
				else
					(HighPrint 630 7) ; "You can't fight a caged beast. Your sword is hampered by the bars of the cage, and if you get too near, the beast could easily strike you with its tail."
				)
			)
			((or (Said 'feed') (Said 'give/food'))
				(cond
					((== beastCondition 3)
						(HighPrint 630 8) ; "Well, OK, but it probably won't help at this point."
					)
					((not (gEgo inRect: 125 143 232 178))
						(HighPrint 630 9) ; "You should move closer to the front of the cage."
					)
					((gEgo has: 3) ; Food
						(self setScript: beastEats 0 0)
					)
					(else
						(HighPrint 630 10) ; "You have nothing to feed the beast."
					)
				)
			)
			((or (Said 'water') (Said 'give/water'))
				(cond
					((== beastCondition 3)
						(HighPrint 630 11) ; "You can water the beast until you're blue in the face, but it'll never grow again."
					)
					((not (gEgo inRect: 125 143 232 178))
						(HighPrint 630 9) ; "You should move closer to the front of the cage."
					)
					((> gDrinksLeft 0)
						(self setScript: beastEats 0 1)
					)
					(else
						(HighPrint 630 12) ; "You have no water to give the beast."
					)
				)
			)
			((Said 'get,get/hair,fur')
				(cond
					((== beastCondition 3)
						(HighPrint 630 13) ; "Whaddya want a bunch of dead fur fer?"
					)
					(
						(not
							(and
								(gTimers contains: beastTimer)
								(> (beastTimer seconds:) 0)
							)
						)
						(HighPrint 630 14) ; "You don't dare get any hair as long as the beast is staring at you."
					)
					((gEgo has: 21) ; DispelPotion
						(self setScript: getFur)
					)
					(else
						(HighPrint 630 15) ; "Whaddya want a bunch of fur fer?"
					)
				)
			)
			((or (Said 'use,give,feed/potion') (Said 'use,give,feed//potion'))
				(cond
					((== beastCondition 3)
						(HighPrint 630 16) ; "By the dead-pan expression on the beast's face, you get the impression he doesn't want any, thank you all the same."
					)
					((not (gEgo inRect: 125 143 232 178))
						(HighPrint 630 9) ; "You should move closer to the front of the cage."
					)
					((gEgo has: 21) ; DispelPotion
						(self setScript: usePotion)
					)
					(else
						(DontHave)
					)
				)
			)
		)
	)
)

(instance getFur of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: -1 setMotion: PolyPath 247 121 self)
			)
			(1
				(gEgo
					view: 47
					setLoop: 2
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(beastHead hide:)
				(beastBody view: 633 setLoop: 1 setCel: 0 setCycle: CT 1 1 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(beastBody cycleSpeed: 1 setCycle: End self)
			)
			(5
				(beastBody view: 632 setLoop: 3)
				(beastHead setLoop: 8 setCycle: 0 show:)
				(NormalEgo)
				(beastTimer dispose:)
				(= cycles 1)
			)
			(6
				(gEgo setMotion: PolyPath safeX safeY self)
			)
			(7
				(HighPrint 630 17) ; "You get some hair from the beast and mix it into the dispel potion."
				(= hairAdded 1)
				(self dispose:)
			)
		)
	)
)

(instance usePotion of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: beastEats self 2)
			)
			(1
				(= cycles 15)
			)
			(2
				(if (not hairAdded)
					(= beastWatered 1)
					(HighPrint 630 18) ; "The potion doesn't seem to work, but the beast seems overjoyed with the liquid anyway."
					(client setScript: beastDoneEating)
				else
					(SolvePuzzle 643 15)
					(SkillUsed 14 50) ; honor
					(TrySkill 14 100) ; honor
					(= beastPotioned 1)
					(beastTimer dispose:)
					(beastHead dispose:)
					(beastBody
						view: 633
						setLoop: 1
						setCel: 0
						setCycle: CT 1 1 self
					)
				)
			)
			(3
				(= cycles 12)
			)
			(4
				(beastBody cycleSpeed: 3 setCycle: End self)
			)
			(5
				(beastHead dispose:)
				(beastBody
					view: 632
					setLoop: 4
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(6
				(beastBody dispose:)
				(alScurva init:)
				(= cycles 1)
			)
			(7
				(alScurva
					setLoop: 0
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 182 146 self
				)
			)
			(8
				(alScurva x: (- (alScurva x:) 5) setLoop: 1)
				(gestureTimer setCycle: gestureTimer 3)
				(Say alScurva self 630 19) ; "I know not who you are, or why you saved me, but you are a fool if you expect to be rewarded for it. I am Al Scurva, an apprentice Sorcerer."
			)
			(9
				(Say alScurva self 630 20) ; "My former master, Ad Avis, transformed me into that monster and left me to die. He will be most displeased that I am still alive."
			)
			(10
				(Say alScurva self 630 21) ; "Do not think he will be unaware of your interference. He will be watching you from now on."
			)
			(11
				(Say alScurva self 630 22) ; "I will give you this warning: Do not go near Ad Avis unless you have some spell of protection or are very quick."
			)
			(12
				(Say alScurva self 630 23) ; "If he manages to throw a spell at you, you will either be his willing servant or else be transformed into a creature most resembling your soul."
			)
			(13
				(Say alScurva self 630 24) ; "There is some major ritual magic he has planned for when the moon arises between the Scorpion's claws and the Dragon's teeth. If he succeeds in this it would be best not to be in this land. I certainly will not be."
			)
			(14
				(Say alScurva self 630 25) ; "Just remember, Ad Avis awaits you in Raseir."
			)
			(15
				(gestureTimer dispose:)
				(alScurva setLoop: 8 setCel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(16
				(alScurva setLoop: 7 setCel: 0 setCycle: End self)
				(SetFlag 42) ; fAlScurvaFreed
				(= beastCondition 0)
			)
			(17
				(= cycles 8)
			)
			(18
				(alScurvaMouth init: setCycle: Fwd)
				(cond
					((and beastFed beastWatered)
						(Say alScurva self 630 26) ; "Oh, yeah, thanks for the food and water."
					)
					(beastFed
						(Say alScurva self 630 27) ; "Oh, yeah, thanks for the food."
					)
					(else
						(Say alScurva self 630 28) ; "Oh, yeah, thanks for the water."
					)
				)
			)
			(19
				(alScurva dispose:)
				(alScurvaMouth dispose:)
				(self dispose:)
			)
		)
	)
)

(instance beastEats of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< register 3)
					(self changeState: 2)
				else
					(beastHead setLoop: 6 setCel: 0 setCycle: End self)
				)
			)
			(1
				(beastHead setLoop: 5 cycleSpeed: 1 setCycle: Fwd)
				(self changeState: 8)
			)
			(2
				(HandsOff)
				(gEgo setMotion: MoveTo 170 155 self)
			)
			(3
				(SolvePuzzle 644 5)
				(TrySkill 14 100) ; honor
				(switch register
					(0
						(gEgo use: 3 1) ; Food
					)
					(1
						(-- gDrinksLeft)
					)
					(2
						(gEgo use: 21 1) ; DispelPotion
					)
				)
				(gEgo
					view: 47
					setLoop: 0
					setCel: 0
					setPri: 15
					setCycle: End self
				)
			)
			(4
				(= cycles 4)
			)
			(5
				(gEgo setCycle: Beg self)
				(if
					(not
						(and
							(gTimers contains: beastTimer)
							(> (beastTimer seconds:) 0)
						)
					)
					(beastHead setLoop: 6 setCel: 0 setCycle: End)
				)
			)
			(6
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 160 165 self
				)
				(if
					(not
						(and
							(gTimers contains: beastTimer)
							(> (beastTimer seconds:) 0)
						)
					)
					(beastHead setLoop: 5 cycleSpeed: 1 setCycle: Fwd)
					(StartTimer beastTimer 15)
				)
			)
			(7
				(NormalEgo)
				(gEgo setHeading: 45 self)
			)
			(8
				(HandsOn)
				(switch register
					(0
						(= beastFed 1)
						(HighPrint
							(Format ; "The beast quickly swallows the dried meat and fruit%s"
								@tmpStr
								630
								29
								(if beastWatered
									{.}
								else
									{, gagging a bit from lack of water.}
								)
							)
						)
					)
					(1
						(= beastWatered 1)
						(HighPrint
							(Format ; "The beast greedily laps up the water%s"
								@tmpStr
								630
								30
								(if beastFed
									{.}
								else
									{ while watching you with a hungry expression.}
								)
							)
						)
					)
					(2
						(HighPrint 630 31) ; "The beast laps greedily at the potion."
					)
				)
				(SkillUsed 14 25) ; honor
				(= cycles 1)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance beastDoneEating of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(beastHead setCycle: End self)
			)
			(1
				(beastHead setLoop: 6 setCel: 3 setCycle: Beg self)
			)
			(2
				(beastHead setLoop: 8 setCel: 0)
				(if
					(and
						(gTimers contains: beastTimer)
						(> (beastTimer seconds:) 0)
					)
					(beastTimer dispose:)
				)
				(self dispose:)
			)
		)
	)
)

(instance beastWakesUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(beastHead setLoop: 7 setCel: 0)
				(= cycles 12)
			)
			(1
				(beastHead setCycle: End self)
			)
			(2
				(beastHead setLoop: 8 setCel: 0)
				(= cycles 3)
			)
			(3
				(if (== beastCondition 2)
					(HighPrint 630 32) ; "The beast looks a little weaker now, but still watches your every move with its cold stare."
				)
				(self dispose:)
			)
		)
	)
)

(instance beastLunges of HandsOffScript
	(properties)

	(method (changeState newState &tmp theLoop theHeading)
		(switch (= state newState)
			(0
				(= register (* 2 (> (beastHead cel:) 3)))
				(if (< (gEgo x:) 207)
					(beastHead hide:)
					(beastBody setLoop: 2 setCycle: End self)
				else
					(beastHead setLoop: 9 setCel: register setCycle: End self)
				)
			)
			(1
				(cond
					((< (gEgo x:) 174)
						(= theLoop 3)
					)
					((> (gEgo x:) 235)
						(= theLoop 4)
					)
					(else
						(= theLoop 5)
					)
				)
				(gEgo view: 633 setLoop: theLoop setCel: 0 setCycle: End)
				(if (< (gEgo x:) 207)
					(beastBody cycleSpeed: 2 setCycle: Beg self)
				else
					(beastHead cycleSpeed: 1 setCycle: CT register -1 self)
				)
			)
			(2
				(cond
					((< (gEgo x:) 174)
						(= theHeading 45)
						(= theLoop 6)
					)
					((> (gEgo x:) 235)
						(= theHeading 335)
						(= theLoop 7)
					)
					(else
						(= theHeading 0)
						(= theLoop 3)
					)
				)
				(gEgo posn: safeX safeY loop: theLoop)
				(NormalEgo)
				(if (< (gEgo x:) 207)
					(beastBody setLoop: 3 cycleSpeed: 0)
					(beastHead show:)
				else
					(beastHead setLoop: 8)
				)
				(= cycles 1)
			)
			(3
				(if
					(and
						(gTimers contains: beastTimer)
						(> (beastTimer seconds:) 0)
					)
					(gCurRoom setScript: beastEats 0 3)
				)
				(self dispose:)
			)
		)
	)
)

(instance openDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register 0)
					(gEgo setMotion: MoveTo 170 150 self)
				else
					(self cue:)
				)
			)
			(1
				(if (or (== beastCondition 3) (IsFlag 42)) ; fAlScurvaFreed
					(Print 630 33) ; "The cage door is stuck fast."
					(self changeState: 5)
				else
					(gEgo setHeading: 90)
					(cageDoor setCycle: End self)
				)
			)
			(2
				(gEgo setMotion: MoveTo 180 152 self)
			)
			(3
				(beastBody dispose:)
				(beastHead dispose:)
				(self cue:)
			)
			(4
				(gEgo
					view: 633
					setLoop: 0
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(5
				(cond
					((or (== beastCondition 3) (IsFlag 42)) ; fAlScurvaFreed
						(self dispose:)
					)
					(lookedInEyes
						(EgoDead 0 630 34 #icon 632 0 0) ; "Trusting soul, weren't you? A starving monster dying of thirst in the desert is not the most honorable of gentlemen. Things aren't always as they seem, and there definitely seemed to be more to this thing."
					)
					(else
						(EgoDead 0 630 35 #icon 632 0 0) ; "Freeing a creature like this does not seem to have been a wise decision. Perhaps the fact that the beast is obviously starving and dying of thirst had something to do with its ill-temper."
					)
				)
			)
		)
	)
)

(instance saurusBalks of HandsOffScript
	(properties)

	(method (changeState newState &tmp eX)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(gEgo
					view: 15
					setLoop: (> (gEgo x:) (cageFront x:))
					setCel: 0
					cycleSpeed: 1
					setCycle: CT 2 1
				)
				(= cycles 6)
			)
			(2
				(gEgo setCycle: CT 0 -1 self)
			)
			(3
				(gEgo view: 12 setLoop: -1 cycleSpeed: 0 setCycle: Walk)
				(= cycles 1)
			)
			(4
				(cond
					((or (== gRoomExitDir 2) (< (gEgo x:) 160))
						(gEgo setMotion: MoveTo 40 180 self)
					)
					((== register 4)
						(gEgo
							setMotion:
								MoveTo
								(+ (gEgo x:) 50)
								(gEgo y:)
								self
						)
					)
					(else
						(gEgo
							setMotion:
								MoveTo
								(gEgo x:)
								(+ (gEgo y:) 50)
								self
						)
					)
				)
			)
			(5
				(gEgo setHeading: 270 self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance beastHurts of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: beastHead)
					(beastHead hide:)
				)
				(beastBody setLoop: 1 setCycle: Full 1 self)
			)
			(1
				(if (gCast contains: beastHead)
					(beastHead show:)
				)
				(beastBody setLoop: 3)
				(if (> (++ hurtCounter) 2)
					(HighPrint 630 36) ; "The beast feels pain, no doubt, but its enchantment seems to prevent it from being killed by anything you are able to do."
				else
					(HighPrint 630 37) ; "The beast reacts in pain and fury."
				)
				(self dispose:)
			)
		)
	)
)

(instance beastBody of TargActor
	(properties
		x 225
		y 135
		noun '/beast,creature,animal,monster'
		description {the beast}
		view 632
		loop 3
		priority 9
		signal 16
	)

	(method (hurtMe)
		(self setScript: beastHurts)
		(return 1)
	)

	(method (detectMe)
		(HighPrint 630 38) ; "There is a strong enchantment on the beast and upon the cage."
		(return 1)
	)

	(method (calmMe)
		(HighPrint 630 39) ; "The beast seems at peace for a moment, but not for long."
		(return 1)
	)

	(method (dazzleMe)
		(HighPrint 630 40) ; "The beast only reacts with a few quick blinks."
		(return 1)
	)

	(method (fetchMe)
		(HighPrint 630 41) ; "The beast is much too large to fetch, and you can't control the spell well enough to get only some fur."
		(return 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(HighPrint 630 42) ; "A closer look at the monster shows that it is fierce indeed, although obviously weakened by lack of food and water. It will not survive much longer."
			(HighPrint 630 43) ; "Its eyes catch yours, and you can't seem to look away. Huge eyes, burning eyes that see your very soul."
			(HighPrint 630 44) ; "You seem to hear in your mind the words, "Come closer, much closer. Come closer and release me, free me. Come closer and trust me. Look into my eyes and trust me.""
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== loop 1) (== cel 1))
			(= z (- 2 z))
		)
	)
)

(instance deadBeast of PicView
	(properties
		x 235
		y 134
		noun '/beast,animal,monster,creature,body'
		description {the dead beast}
		lookStr {You see an ex-beast.__As you stare at it, you seem to hear a voice in your mind, saying "I'm dead.__Go away.___Trust me, I'm dead.__Aaaaahhhhhhh".}
		view 633
		loop 2
		cel 10
		priority 11
		signal 16
	)
)

(instance beastHead of TargActor
	(properties
		x 208
		y 125
		noun '/beast,creature,animal,monster'
		description {beast}
		view 632
		loop 8
		priority 10
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(beastBody doVerb: 1)
		)
	)

	(method (hurtMe)
		(self setScript: beastHurts)
		(return 1)
	)

	(method (doit &tmp theAngle)
		(= theAngle (GetAngle x y (gEgo x:) (gEgo y:)))
		(cond
			(script)
			((gCurRoom script:))
			((and (gTimers contains: beastTimer) (> (beastTimer seconds:) 0)))
			((< theAngle 153)
				(= cel 5)
			)
			((< theAngle 170)
				(= cel 4)
			)
			((< theAngle 186)
				(= cel 3)
			)
			((< theAngle 207)
				(= cel 2)
			)
			((< theAngle 233)
				(= cel 1)
			)
			(else
				(= cel 0)
			)
		)
		(super doit:)
	)
)

(instance alScurva of Talker
	(properties
		x 225
		y 135
		view 637
		priority 9
		signal 16
		cycleSpeed 2
		tLoop -1
		talkSpeed 1
		myName '//al,al,man,apprentice'
		title {Al Scurva:}
		color 11
		back 1
	)
)

(instance alScurvaMouth of Prop
	(properties
		x 180
		y 115
		view 637
		loop 2
		priority 10
		signal 16
		cycleSpeed 1
	)
)

(instance gestureTimer of Timer
	(properties)

	(method (cue)
		(cond
			((alScurva cel:)
				(alScurva setCycle: Beg)
			)
			((> (Random 1 10) 5)
				(alScurva setLoop: (Random 3 6) setCel: 0 setCycle: Full 1)
			)
			(else
				(alScurva setLoop: (Random 3 6) setCel: 0 setCycle: End)
			)
		)
		(self setCycle: self (Random 3 5))
	)
)

(instance cageFront of PicView
	(properties
		x 218
		y 158
		view 630
		priority 11
		signal 16400
	)

	(method (onMe)
		(return 0)
	)
)

(instance cageBack of PicView
	(properties
		x 216
		y 156
		view 630
		cel 1
		priority 9
		signal 16400
	)

	(method (onMe)
		(return 0)
	)
)

(instance cagePieceLeft of PicView
	(properties
		x 172
		y 151
		view 630
		cel 2
		signal 16384
	)

	(method (onMe)
		(return 0)
	)
)

(instance cagePieceRight of PicView
	(properties
		x 264
		y 137
		view 630
		cel 3
		priority 10
		signal 16400
	)

	(method (onMe)
		(return 0)
	)
)

(instance cageDoor of TargActor
	(properties
		x 207
		y 157
		noun '/door,bar'
		description {the cage door}
		view 630
		loop 1
		priority 12
		signal 16400
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(HighPrint 630 45) ; "There are no signs of footprints around the cage. The door to the cage is fastened shut, but there is no lock."
			)
			(2
				(if (gEgo inRect: 125 143 232 178)
					(gCurRoom setScript: openDoor 0 0)
				else
					(HighPrint 630 9) ; "You should move closer to the front of the cage."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (openMe &tmp rmn)
		(if (< (gEgo x:) 207)
			(self setScript: openDoor 0 1)
			(= rmn 1)
		else
			(HighPrint 630 46) ; "The magic on the cage door seems to be impervious to your spell from this angle. You might try casting the spell from in front of the cage (if you dare!)"
			(= rmn 0)
		)
		(return rmn)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'unlock,lockpick/door,lock')
				(self doVerb: 1)
			)
			((Said 'free/creature,beast,animal,monster')
				(if (== beastCondition 3)
					(HighPrint 630 47) ; "Its death has freed it."
				else
					(HighPrint 630 48) ; "The cage door is unlocked."
				)
			)
		)
	)
)

(instance cageFeat of Feature
	(properties
		noun '/birdcage'
		description 'the&birdcage'
	)

	(method (onMe theObj)
		(return (AvoidPath (theObj x:) (theObj y:) theCage))
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1)
				(HighPrint 630 49) ; "The cage is made of wrought iron. When the sun is on it, that metal must be scorching. There is no sign of food or water in the cage and the creature must have been in the cage for at least a couple of days."
				(HighPrint 630 45) ; "There are no signs of footprints around the cage. The door to the cage is fastened shut, but there is no lock."
			)
			((== theVerb 2)
				(cageDoor doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beastTimer of Timer
	(properties)

	(method (cue)
		(switch (++ timerCounter)
			(1
				(HighPrint 630 50) ; "He's wolfing that down pretty good, for a snake!"
				(StartTimer self 15)
			)
			(else
				(gCurRoom setScript: beastDoneEating)
			)
		)
	)
)

(instance theCage of Polygon
	(properties
		type PTotalAccess
	)
)

(instance cageBase of Polygon
	(properties
		type PBarredAccess
	)
)

(instance stellar1 of PicView
	(properties
		x 273
		y 65
		noun '/hand,(star,constellation<hand)'
		description {the Dark Hand constellation}
		lookStr {The stars here appear to form a Dark Hand.}
		view 660
		loop 2
		cel 2
		priority 0
		signal 24592
	)
)

(instance stellar2 of PicView
	(properties
		x 67
		y 43
		noun '/star,constellation<saurii'
		description {the Saurus constellation}
		lookStr {This constellation is said to resemble a Saurus.}
		view 660
		loop 2
		cel 3
		priority 0
		signal 24592
	)
)

