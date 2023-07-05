;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 605)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	moatRg 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance moatRg of Rgn
	(properties)

	(method (init)
		(LoadMany rsVIEW 14 107 108)
		(Load rsSOUND 14)
		(if (>= global101 1)
			(LoadMany rsVIEW 80 75 76 81)
			(if (IsFlag 2)
				(LoadMany rsVIEW 163 164)
			)
		)
		(self keep: 0)
		(super init:)
		(monsterHead1
			setPri: 4
			init:
			hide:
			setChecks: 1 8
			shiftClick: 1
			setScript: monsterLeftRight
		)
		(monsterTail1 setPri: 4 init: hide: setChecks: 1 8 shiftClick: 1)
		(moatMonster
			setPri: 4
			init:
			hide:
			setChecks: 1 8
			shiftClick: 1
			setScript: monsterLookScript
		)
		(if (>= global101 1)
			(egoReflect init:)
			(goatReflect init:)
		)
	)

	(method (doit)
		(if (!= (= local0 (gEgo onControl: 1)) local1)
			(= local1 local0)
			(switch local0
				(16
					(egoReflect dispose:)
					(moatMonster setScript: 0)
					(gEgo setScript: drownFrontScript)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room]')
						(Print 605 0) ; "You are standing outside King Edward's castle, which is surrounded by a serpent-filled moat."
					)
					((Said '/castle')
						(Print 605 1) ; "King Edward the Benevolent, the mighty ruler of Daventry, lives in this castle."
					)
					((Said '/moat')
						(Print 605 2) ; "You never know what sort of fierce sea creatures lie just beneath the surface of the moat."
					)
					((Said '/water')
						(Print 605 3) ; "It's your typical moat water: murky and smelly."
					)
					((Said '/ivy,vine')
						(Print 605 4) ; "Tendrils of ivy cling to the massive walls of the castle."
					)
				)
			)
			((Said 'get,get,get,pick/ivy,vine')
				(Print 605 5) ; "It's the king's ivy. Leave it alone."
			)
			((Said 'pet,ride,capture/serpent,animal,animal')
				(Print 605 6) ; "What! Are you crazy?"
			)
			((Said 'hit,kill,shoot/serpent,animal,animal')
				(Print 605 7) ; "But they help to guard the castle! You should let these creatures do their job in peace."
			)
			((Said 'climb,climb[<in,in]/serpent,animal,animal')
				(Print 605 8) ; "You'd end up inside the serpent. And what would happen to Daventry then?"
			)
			((Said 'drink,get,get/water,drink')
				(if (and (gEgo has: 8) (IsFlag 9)) ; Empty_Water_Bucket
					(event claimed: 0)
				else
					(Print 605 9) ; "Who knows what danger lurks beneath the surface of the murky water."
				)
			)
			((Said 'smell,smell[/moat,brook,water]')
				(Print 605 10) ; "The odor of the murky water is almost unbearable."
			)
			((Said 'dive[<in,on,in][/moat]')
				(Print 605 11) ; "You wouldn't want to dive in the serpent-filled moat."
			)
			((Said 'climb,climb')
				(Print 605 12) ; "The guards do not appreciate people climbing their castle."
			)
			((or (Said 'go/swim') (Said 'swim') (Said 'enter,go/moat'))
				(Print 605 13) ; "Go ahead. But it's not recommended."
			)
			((Said 'steal,pick,get,get/animal,serpent')
				(Print 605 14) ; "You'll want to leave those horrible creatures alone."
			)
			((Said 'talk,talk/animal,serpent')
				(Print 605 15) ; "These serpents would rather eat you than to talk to you."
			)
			((or (Said 'get,get/water') (Said 'fill/bucket'))
				(cond
					((IsFlag 9)
						(Print 605 16) ; "You already have water."
					)
					((not (gEgo has: 8)) ; Empty_Water_Bucket
						(Print 605 17) ; "You don't have a bucket."
					)
					((& (gEgo onControl: 1) $0200)
						(Print 605 18) ; "You fill the bucket with the murky water from the moat."
						(UpdateWaterBucket 1)
					)
					(else
						(Print 605 19) ; "You need to get closer to the water."
					)
				)
			)
		)
	)
)

(instance drownFrontScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 14
					yStep: 5
					setLoop: 1
					setCel: 0
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 25) self
				)
			)
			(1
				((ScriptID 0 21) number: 14 init: play:) ; gameSound
				(gEgo setCycle: End self)
			)
			(2
				(if (IsFlag 1)
					(Print 605 20) ; "As you fall, the magic ring slips from your finger."
					(gGame changeScore: -3)
				)
				((ScriptID 0 21) number: 96 loop: -1 play:) ; gameSound
				(gEgo setLoop: 0 cycleSpeed: 0 setCycle: Fwd)
				(= cycles 20)
			)
			(3
				(gEgo setCycle: CT 5 1 self)
			)
			(4
				(if (< (gEgo x:) 160)
					(moatMonster view: 108 x: (- (gEgo x:) 18) setLoop: 1)
				else
					(moatMonster x: (+ (gEgo x:) 18) setLoop: 0)
				)
				(gEgo setCycle: End)
				(moatMonster
					y: (+ (gEgo y:) 2)
					view: 107
					cycleSpeed: 1
					setCycle: End self
					show:
				)
			)
			(5
				(gEgo hide:)
				(moatMonster setLoop: (+ 2 (< (gEgo x:) 160)) setCycle: Fwd)
				(= cycles 40)
			)
			(6
				(moatMonster
					setLoop: (+ 4 (< (gEgo x:) 160))
					setCycle: End self
				)
			)
			(7
				(moatMonster hide:)
				(= cycles 30)
			)
			(8
				((ScriptID 0 21) number: 50 loop: 1 play: self) ; gameSound
				(moatMonster
					show:
					view: 108
					setLoop: (+ 5 (> (gEgo x:) 160))
					setCel: 0
					setCycle: End
				)
				(= cycles 30)
			)
			(9
				(moatMonster setCycle: Beg)
			)
			(10
				(moatMonster dispose:)
				(EgoDead {The moat monsters appreciate your good taste.})
				(HandsOn)
			)
		)
	)
)

(instance monsterLeftRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 (Random 0 1))
				(switch gCurRoomNum
					(1
						(monsterHead1 x: (Random 60 260))
					)
					(2
						(monsterHead1 x: (Random 120 260))
					)
					(83
						(monsterHead1 x: (Random 60 200))
					)
				)
				(if (== gCurRoomNum 1)
					(monsterHead1 y: (Random 148 168))
				else
					(monsterHead1 y: (Random 169 186))
				)
				(= cycles
					(Random (/ 100 (+ global101 1)) (/ 600 (+ global101 1)))
				)
			)
			(1
				(TempSound number: 97 loop: 1 play:)
				(monsterHead1
					show:
					setLoop: local3
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(monsterTail1
					x: (monsterHead1 x:)
					y: (monsterHead1 y:)
					cycleSpeed: 1
				)
				(monsterHead1
					setLoop: (+ local3 2)
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(TempSound number: 97 loop: 1 play:)
				(monsterHead1
					x: (+ (monsterHead1 x:) (- (* local3 120) 60))
					setLoop: local3
					setCel: 0
					setCycle: End
				)
				(monsterTail1
					show:
					setLoop: (+ local3 2)
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(monsterHead1 setLoop: (+ local3 2) setCel: 0 setCycle: Fwd)
				(monsterTail1
					setLoop: (+ local3 4)
					setCel: 0
					setCycle: End self
				)
			)
			(5
				(monsterHead1 hide:)
				(monsterTail1
					x: (monsterHead1 x:)
					setLoop: (+ local3 2)
					setCel: 0
					setCycle: End self
				)
			)
			(6
				(monsterTail1
					setLoop: (+ local3 4)
					setCel: 0
					setCycle: End self
				)
			)
			(7
				(monsterTail1 setCel: 0 hide:)
				(= cycles 1)
			)
			(8
				(self init:)
			)
		)
	)
)

(instance monsterLookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles
					(Random (/ 100 (+ global101 1)) (/ 600 (+ global101 1)))
				)
			)
			(1
				(if (== gCurRoomNum 1)
					(moatMonster y: (Random 148 168))
				else
					(moatMonster y: (Random 169 186))
				)
				(moatMonster
					x: (Random 50 270)
					show:
					setLoop: 2
					setCel: 0
					cycleSpeed: (Random 1 2)
					setCycle: End self
				)
			)
			(2
				(= local2 (Random 0 1))
				(moatMonster setLoop: local2 setCel: 0 setCycle: End self)
			)
			(3
				(if (= local4 (Random 0 1))
					(moatMonster setLoop: (+ local2 3) setCel: 0 setCycle: End)
					(= cycles (Random 40 60))
				else
					(self cue:)
				)
			)
			(4
				(moatMonster setCycle: Beg self)
			)
			(5
				(if local4
					(moatMonster
						setLoop: local2
						setCel: (moatMonster lastCel:)
						setCycle: Beg self
					)
				else
					(self cue:)
				)
			)
			(6
				(moatMonster
					setLoop: 2
					setCel: (moatMonster lastCel:)
					setCycle: Beg self
				)
			)
			(7
				(moatMonster hide:)
				(= cycles 2)
			)
			(8
				(moatMonster stopUpd:)
				(self init:)
			)
		)
	)
)

(instance monsterHead1 of Prop
	(properties
		x 45
		y 145
		description {moat monster}
		view 107
		loop 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/serpent,animal,animal')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 605 21) ; "These scaly, slimy serpents cruise the moat searching for unwary trespassers."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance monsterTail1 of Prop
	(properties
		x 45
		y 145
		description {monster's tail}
		view 107
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 605 21) ; "These scaly, slimy serpents cruise the moat searching for unwary trespassers."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance moatMonster of Prop
	(properties
		description {moat monster}
		view 108
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/serpent,animal,animal')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 605 21) ; "These scaly, slimy serpents cruise the moat searching for unwary trespassers."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance TempSound of Sound
	(properties
		priority 3
	)
)

(instance goatReflect of View
	(properties
		description {reflection}
		view 163
		priority 1
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 2)
			(self
				loop: (gGoat loop:)
				x: (gGoat x:)
				y: (+ (gGoat y:) 20)
				cel: (gGoat cel:)
			)
		)
	)

	(method (doit)
		(if (and (>= global101 1) (IsFlag 2))
			(if (== (gGoat view:) 165)
				(self view: 163)
			else
				(self view: 164)
			)
			(self
				loop: (gGoat loop:)
				x: (gGoat x:)
				cel: (gGoat cel:)
				y: (+ (gGoat y:) 20)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 605 22) ; "You can see the goat's reflection on the dirty moat water."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoReflect of View
	(properties
		description {reflection}
		sightAngle 90
		closeRangeDist 500
		longRangeDist 500
		view 80
		priority 1
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (>= global101 1)
			(self
				loop: (gEgo loop:)
				x: (gEgo x:)
				cel: (gEgo cel:)
				y: (+ (gEgo y:) 20)
			)
			(if (IsFlag 1)
				(egoReflect hide:)
			)
		)
	)

	(method (doit)
		(if (>= global101 1)
			(if (IsFlag 1)
				(self hide:)
			else
				(self show:)
			)
			(self
				view:
					(switch (gEgo view:)
						(0 80)
						(2 81)
						((if (IsFlag 0) 23 else 16) 76)
						((if (IsFlag 0) 17 else 15) 75)
					)
				loop: (gEgo loop:)
				cel: (gEgo cel:)
				x: (gEgo x:)
				y: (+ (gEgo y:) 20)
			)
		)
		(super doit: &rest)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/reflection')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 605 23) ; "You can see your reflection on the dirty moat water."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

