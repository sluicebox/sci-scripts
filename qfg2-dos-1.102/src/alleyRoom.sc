;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 704)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use battleSound)
(use TargActor)
(use Full)
(use TryToMoveTo)
(use StateMachine)
(use Interface)
(use AFeat)
(use MoveFwd)
(use Approach)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	alleyRoom 0
)

(local
	[townspeopleViews 3] = [357 358 359]
	wasScrolling
	seenNoDamageMsg
	earthElemDead
	earthElemHeading
	saveIllegalBits
	[angles 2] = [1 2]
	[attacks 2] = [1 1]
	[witArrowLoops 8] = [3 4 0 7 2 6 1 5]
	volumeLevel = 30
	HornCounter
)

(procedure (EgoEndCombat)
	(if (gCast contains: (ScriptID 32 0)) ; warrior
		((ScriptID 32 0) endCombat: dispose:) ; warrior
		(NormalEgo)
		(gEgo
			observeControl: saveIllegalBits
			posn: ((ScriptID 32 0) x:) ((ScriptID 32 0) y:) ; warrior, warrior
			init:
		)
	)
)

(instance alleyRoom of AlleyRoom
	(properties)

	(method (init)
		(LoadMany rsVIEW 345 80 81 810 811 715 709 357 358 359)
		(LoadMany rsSCRIPT 31 30 32 24)
		(gCSound number: 700 loop: -1 playBed:)
		(detectee init:)
		(super init: &rest)
		(= wasScrolling 1)
	)

	(method (dispose)
		(if (IsObject earthElemSM)
			(earthElemSM dispose:)
		)
		(gCSound fade:)
		(super dispose: &rest)
	)

	(method (notify theSignal)
		(if (== theSignal 59)
			(EgoEndCombat)
			(self turnAround:)
			(return 1)
		)
	)

	(method (doit &tmp theOdds)
		(super doit:)
		(if isScrolling
			(= wasScrolling 1)
			(return)
		)
		(if
			(and
				wasScrolling
				(not (gGame script:))
				(< gElementalState 6)
				(or
					(and
						(== gDay 12)
						(>= gYEgo 20)
						(<= (Random 1 100) 40)
					)
					(and
						(== gDay 13)
						(or
							(and
								(>= gYEgo 20)
								(<= (= theOdds (Random 1 100)) 65)
							)
							(and (< gYEgo 20) (<= (Random 1 100) 30))
						)
					)
				)
			)
			(gGame setScript: earthElemSM)
			(return)
		)
		(if (not isScrolling)
			(= wasScrolling 0)
		)
	)

	(method (newAlley)
		(= wasScrolling 1)
		(earthElemSM cue: 6)
		(super newAlley: &rest)
	)

	(method (crossIntersection)
		(if (and (not (IsFlag 144)) (== gDay 3) (<= 0 gTimeODay 4))
			(gGame setScript: harpoCrosses)
		else
			(super crossIntersection:)
		)
	)

	(method (makeCrosser guy &tmp aView aPalette aDsc aNoun aLookStr)
		(if (Random 0 1)
			(= aView [townspeopleViews (Random 0 2)])
			(= aPalette (Random 1 3))
			(= aDsc {the townsperson})
			(= aNoun '/man,woman')
			(= aLookStr {The townsperson looks nondescript.})
		else
			(= aView 294)
			(= aPalette 0)
			(= aDsc {the guard})
			(= aNoun '/man,guard')
			(= aLookStr {The guard looks official.})
		)
		(guy
			view: aView
			palette: aPalette
			description: aDsc
			noun: aNoun
			lookStr: aLookStr
		)
	)

	(method (handleEvent event)
		(if (Said 'listen')
			(HighPrint 704 0) ; "You hear the sounds of people coming and going and living their lives."
		else
			(super handleEvent: event)
		)
	)
)

(instance earthElem of Monster
	(properties
		noun '/earth,dirt,monster,elemental[<earth]'
		description {the earth elemental}
		view 345
		cel 2
		cycleSpeed 3
		moveSpeed 3
		strength 200
		intell 50
		agil 50
		vit 100
		luck 50
		weap 150
		magic 100
		armorValue 8
		weapValue 10
		barX 260
		battleMusic 52
		endMusic 53
	)

	(method (init)
		(if (not (IsFlag 109))
			(= gMonsterHealth 0)
			(SetFlag 109)
		else
			(= health gEarthElemHealth)
			(= stamina gEarthElemStamina)
			(= gMonsterHealth health)
		)
		(super init:)
	)

	(method (calmMe)
		(earthElemSM cue: 4)
		(return 1)
	)

	(method (dazzleMe)
		(self calmMe:)
	)

	(method (detectMe)
		(if (not earthElemDead)
			(HighPrint 704 1) ; "The mass of rock radiates strong magic."
		)
	)

	(method (hurtMe amt byWhat)
		(cond
			((OneOf (byWhat type:) 52 25)
				(super hurtMe: (* amt 2) byWhat)
				(if (and health (== (byWhat type:) 25))
					(earthElemSM cue: 1)
				)
			)
			((== (byWhat type:) 3)
				(self die:)
			)
			((not seenNoDamageMsg)
				(HighPrint 704 2) ; "Your attack has no effect on the stone of the Earth Elemental."
				(= seenNoDamageMsg 1)
			)
		)
	)

	(method (die)
		(super die:)
		(= earthElemDead 1)
		(earthElemSM cue: 2)
	)

	(method (handleEvent event)
		(if
			(and
				(Said 'search>')
				(Said '/earth,dirt,monster,elemental[<earth]')
			)
			(self doVerb: 7)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(cond
					((gEgo has: 52) ; MagicEarth
						(HighPrint 704 3) ; "You have enough elemental dirt."
					)
					(earthElemDead
						(gEgo setScript: getDirt)
					)
					(else
						(HighPrint 704 4) ; "You can't be serious. It is too big and dangerous right now."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(= gEarthElemHealth health)
		(= gEarthElemStamina stamina)
	)
)

(instance getDirt of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (earthElem x:) (earthElem y:) self)
			)
			(1
				(gEgo view: 47 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(if (gEgo has: 38) ; ClothBag
					(HighPrint 704 5) ; "You carefully put the elemental away in the cloth bag."
					(gEgo use: 38) ; ClothBag
					(gEgo get: 52) ; MagicEarth
					(++ gElementalState)
					(SolvePuzzle 655 20)
					(SkillUsed 14 100) ; honor
				else
					(HighPrint 704 6) ; "The elemental earth keeps slipping through your hands, and you have nothing suitable to put it in."
				)
				(= cycles 5)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 0 setCycle: StopWalk 4 setHeading: 0)
				(self dispose:)
			)
		)
	)
)

(instance earthElemDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client
					view: 345
					y: (Max (client y:) 106)
					setLoop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End self
					setMotion: 0
				)
			)
			(1
				(EgoEndCombat)
				(client setPri: 0 ignoreActors:)
				(HandsOn 1)
				(self dispose:)
			)
		)
	)
)

(instance earthElemHitByFlame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(earthElem
					view: 345
					setLoop: 3
					cel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(1
				(earthElem setCycle: Beg self)
			)
			(2
				(HandsOn 1)
				(self dispose:)
			)
		)
	)
)

(instance earthElemSM of StateMachine
	(properties)

	(method (handleEvent event)
		(if (and (Said 'attack>') (< state 3))
			(earthElem setScript: earthElemCombat)
			(self changeState: 3)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)

	(method (doState theSignal)
		(if (== theSignal 6)
			(earthElem dispose:)
			(= gSpellChecker gAllChecker)
			(self dispose:)
		)
		(switch state
			(0
				(HandsOff)
				(= gSpellChecker earthElemSpellChecker)
				(earthElem posn: 155 94)
				(gEgo setLoop: 3 setMotion: MoveTo (gEgo x:) 176)
				(Print 704 7 #at -1 180 #dispose) ; "You hear a rumbling at the end of the alley..."
				(earthElem
					view: 345
					loop: 4
					cel: 0
					setCycle: End self
					priority: 5
					signal: 16
					barMessage: 0
					initCombat:
					hurtScript: 0
					deathScript: 0
					show:
				)
				(= cueState 1)
			)
			(1
				(HandsOn 1)
				(cls)
				(gEgo setLoop: -1)
				(earthElem
					view: 345
					setLoop: 5
					cel: 0
					setCycle: SyncWalk
					setMotion: Approach gEgo 5
				)
				(self changeState: 2)
			)
			(2
				(cond
					(
						(or
							(< (earthElem distanceTo: gEgo) 15)
							(< (- (gEgo y:) (earthElem y:)) 10)
						)
						(earthElem setScript: earthElemCombat)
						(self changeState: 3)
					)
					((== theSignal 1)
						(= cueState 1)
						(self setScript: earthElemHitByFlame self)
					)
					((== theSignal 2)
						(self changeState: 4)
					)
					((== theSignal 4)
						(= cueState 1)
						(= seconds 10)
						(earthElem setMotion: 0)
					)
				)
			)
			(3
				(cond
					((== theSignal 2)
						(self changeState: 4)
					)
					((== theSignal 3)
						(HandsOff)
						(EgoEndCombat)
						(earthElem
							endCombat:
							view: 345
							loop: 4
							cel: 9
							setCycle: Beg self
						)
						(= cueState 8)
					)
				)
			)
			(8
				(HandsOn 1)
				(earthElem dispose:)
				(self dispose:)
			)
			(4
				(= cueState 5)
				(earthElem health: 50 stamina: 50 setScript: earthElemDies self)
				((ScriptID 31 0) stop: dispose:) ; battleSound
				(gMiscSound
					number: (earthElem endMusic:)
					priority: 6
					loop: 0
					play:
				)
				(= gSpellChecker gAllChecker)
			)
			(5
				(if (IsObject earthElem)
					(earthElem addToPic:)
				)
				(self dispose:)
			)
		)
	)
)

(instance earthElemSpellChecker of Code
	(properties)

	(method (doit aSpell)
		(if (OneOf aSpell 28 6)
			(HighPrint 704 8) ; "That wouldn't help you now."
			(return 0)
		else
			(return 1)
		)
	)
)

(instance earthElemCombat of Script
	(properties)

	(method (changeState newState &tmp opp theLoop)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setScript: 0)
				(Print 704 9 #at -1 20 #dispose) ; "You quickly move into position in preparation for combat."
				(gEgo
					setMotion: TryToMoveTo 138 (+ (earthElem y:) 10) 10 self
				)
				(client setMotion: 0)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(cls)
				(HandsOn 1)
				(client
					view: 345
					loop: 0
					cel: 0
					opponent: (ScriptID 32 0) ; warrior
					barMessage: {"Rocky"}
					drawStatus:
				)
				(= saveIllegalBits (gEgo illegalBits:))
				(gEgo dispose:)
				((ScriptID 32 0) ; warrior
					posn: (gEgo x:) (gEgo y:)
					opponent: earthElem
					barX: (- ((ScriptID 32 0) barX:) 5) ; warrior
					initCombat:
				)
				(= seconds 3)
			)
			(3
				(= theLoop (Random 0 1))
				(client
					action: [attacks theLoop]
					attDirection: [angles theLoop]
					setLoop: theLoop
					cel: 0
				)
				(= cycles (Random 5 15))
			)
			(4
				(client setCycle: End self)
			)
			(5
				(= opp (client opponent:))
				(if (and (== (client action:) 1) (client tryAttack: opp 0))
					(client doDamage: opp)
				)
				(= cycles 2)
			)
			(6
				(client setCycle: Beg self)
			)
			(7
				(if (== gDay 12)
					(earthElemSM cue: 3)
				else
					(client action: 0 setLoop: 0)
					(self changeState: 3)
				)
			)
		)
	)
)

(instance harpoCrosses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(harpo posn: 107 80 init:)
				(SetFlag 144)
				(gCurRoom isMoving: 0)
				(gEgo setMotion: 0)
			)
			(2
				(HighPrint 704 10) ; "The strange noise seems to be coming closer..."
				(harpo setHeading: 90 setCycle: Walk setMotion: MoveFwd 84 self)
				(gCurRoom nextTee: 0)
			)
			(3
				(harpo cel: 0)
				(Honk_Honk changeState: 0)
				0
			)
			(4
				(harpo dispose:)
				(self dispose:)
			)
		)
	)
)

(instance harpo of Actor
	(properties
		noun '/harpo,man,woman,girl'
		description {the funny-lookin' dude}
		lookStr {That strange man bears a striking resemblance to some of the other odd characters you've met around this city.}
		view 715
		signal 16384
		illegalBits 0
	)

	(method (init)
		(super init:)
		(gCast delete: self)
		(gCast addToFront: self)
		(self setScript: Honk_Honk)
	)
)

(instance Honk_Honk of Script
	(properties
		name {Honk-Honk}
	)

	(method (init)
		(super init: &rest)
		(self doit:)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== (harpo view:) 715)
				(OneOf (harpo cel:) 2 4)
				(== ((harpo cycler:) cycleCnt:) 0)
			)
			(gSpareSound number: 36 loop: 1 priority: 5 vol: 127 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSpareSound number: 36 loop: 1 priority: 5 vol: volumeLevel play:)
				(= cycles 2)
			)
			(1
				(gSpareSound number: 36 loop: 1 priority: 5 play:)
				(= cycles 8)
			)
			(2
				(if (>= (++ HornCounter) 4)
					(-= volumeLevel 30)
				else
					(+= volumeLevel 30)
				)
				(cond
					((== HornCounter 3)
						(harpoCrosses cue:)
					)
					((== HornCounter 7)
						(harpoCrosses cue:)
					)
					(else
						(self changeState: 0)
					)
				)
			)
		)
	)
)

(instance detectee of TargActor
	(properties
		x 160
		y 38
		view 709
		priority 5
		signal 16
	)

	(method (init)
		(super init: &rest)
		(self hide:)
	)

	(method (onMe)
		(return 0)
	)

	(method (detectMe &tmp dX dY dir)
		(SolvePuzzle 693 7 1)
		(if (and (== gYEgo 36) (<= 38 gXEgo 42))
			(= dir 0)
		else
			(= dX (- gXEgo 40))
			(= dY (- gYEgo 40))
			(cond
				((< (* (Abs dY) 3) (Abs dX))
					(if (< dX 0)
						(= dir 2)
					else
						(= dir 6)
					)
				)
				((> (Abs dY) (* 3 (Abs dX)))
					(= dir 0)
				)
				((< dX 0)
					(= dir 1)
				)
				(else
					(= dir 7)
				)
			)
		)
		(if (< (-= dir (* 2 (- (gCurRoom facingHeading:) 1))) 0)
			(+= dir 8)
		)
		(HandsOff)
		(self loop: [witArrowLoops dir] show: setCycle: Full 10 self)
		(return 1)
	)

	(method (cue)
		(self hide:)
		(HandsOn)
	)
)

