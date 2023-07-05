;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room45 0
)

(synonyms
	(luggage case bag)
	(toy bear)
	(drawer chest dresser)
	(armoire armoire closet)
	(ethel person woman)
	(room bedroom nursery)
)

(local
	local0
	local1
	local2
)

(instance Room45 of Rm
	(properties
		picture 45
	)

	(method (init)
		(= west 44)
		(super init:)
		(gAddToPics
			add:
				suit1
				bed
				lamp1
				lamp2
				wardrobe
				chest
				chair
				endtable
				bear
				dollhouse
				sofa
				shelf1
				shelf2
			eachElementDo: #init
			doit:
		)
		(self
			setFeatures:
				suit1
				lamp1
				lamp2
				bed
				chair
				endtable
				wardrobe
				sofa
				bear
				dollhouse
				shelf1
				shelf2
				chest
		)
		(switch gAct
			(0
				(if (== [gCycleTimers 4] 0)
					(= [gCycleTimers 4] 1800)
				)
				(if (== gEthelState 0)
					(LoadMany rsMESSAGE 243 221)
					(LoadMany rsVIEW 325 903)
					(= global208 8)
					(= [global377 3] 221)
					(Ethel
						ignoreActors: 1
						cycleSpeed: 1
						init:
						setScript: ethelActions
					)
					(eHead
						ignoreActors: 1
						cycleSpeed: 1
						setPri: 6
						cycleSpeed: 1
						init:
					)
					(Mouth ignoreActors: 1 cycleSpeed: 1 setPri: 6 init: hide:)
				)
			)
		)
		(gEgo view: 0 posn: 1 124 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 45 0) ; "It looks as if this might have been a nursery at one time. Now it has been converted into a makeshift guest room with Ethel as its current guest."
		)
		(if (and (> (gEgo x:) 126) (< (gEgo y:) 104))
			(gEgo setPri: 4)
		else
			(gEgo setPri: -1)
		)
		(if (< (gEgo x:) 60)
			(= vertAngle 0)
		else
			(= vertAngle 137)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== [gCycleTimers 4] 1)
			(= global125 1)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(if
				(and
					global208
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
				(if (event claimed:)
					(return 1)
				)
			)
			(cond
				((Said 'look[<around,at][/room]')
					(Print 45 0) ; "It looks as if this might have been a nursery at one time. Now it has been converted into a makeshift guest room with Ethel as its current guest."
				)
				((Said 'look/blind,curtain')
					(Print 45 1) ; "Broken shutters mar the elegant French windows."
				)
				((Said 'close,open/blind,curtain')
					(CantDo) ; "You can't do that."
				)
			)
		)
	)
)

(instance ethelActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== [gCycleTimers 4] 1) (== local2 0))
			(= local2 1)
			(= global203 2)
			(= state 7)
			(= seconds 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Ethel cel: 0 loop: 0 setCycle: End self)
			)
			(1
				(Mouth show: setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(Mouth hide:)
				(Ethel setCycle: Beg self)
			)
			(3
				(if (< (Random 1 100) 60)
					(= state -1)
				)
				(= seconds (Random 6 12))
			)
			(4
				(eHead loop: (Random 1 2) setCycle: End)
				(= seconds (Random 6 12))
			)
			(5
				(eHead setCycle: Beg)
				(= seconds (Random 6 12))
			)
			(6
				(Ethel loop: 4 cel: 0 setCycle: End)
				(= seconds (Random 6 12))
			)
			(7
				(Ethel loop: 4 cel: 0 setCycle: Beg)
				(= state -1)
				(= seconds (Random 6 12))
			)
			(8
				(eHead dispose:)
				(Mouth dispose:)
				(Ethel
					view: 325
					setLoop: 0
					ignoreActors: 0
					cycleSpeed: 0
					setCycle: Fwd
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setMotion: MoveTo -10 124 self
				)
			)
			(9
				(++ gEthelState)
				(= global208 0)
				(Ethel setAvoider: 0 dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance lamp1 of RPicView
	(properties
		y 54
		x 231
		view 145
		priority 2
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance lamp2 of RPicView
	(properties
		y 67
		x 259
		view 145
		priority 3
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance wardrobe of RPicView
	(properties
		y 93
		x 207
		view 145
		cel 2
		priority 3
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((Said 'move/armoire,dollhouse')
				(Print 45 2) ; "It's much too heavy."
			)
			((Said '(look<in),open/armoire,(door<armoire)')
				(Print 45 3) ; "The armoire is empty."
			)
			((or (MousedOn self event 3) (Said 'look/armoire'))
				(Print 45 4) ; "There is an antique armoire against the back wall."
				(event claimed: 1)
			)
		)
	)
)

(instance chest of RPicView
	(properties
		y 89
		x 27
		view 145
		cel 3
		priority 5
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look[<at]/drawer'))
			(Print 45 5) ; "You notice an old dresser in the corner."
			(event claimed: 1)
		)
	)
)

(instance bed of RPicView
	(properties
		y 105
		x 125
		view 145
		cel 1
		priority 5
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {bed})
		)
	)
)

(instance chair of RPicView
	(properties
		y 101
		x 65
		view 145
		cel 5
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance endtable of RPicView
	(properties
		y 89
		x 87
		view 145
		cel 4
		priority 5
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance bear of RPicView
	(properties
		y 168
		x 291
		view 145
		cel 7
		priority 12
	)

	(method (handleEvent event)
		(cond
			((Said 'get/toy,animal')
				(Print 45 6) ; "Some of these old toys are fragile. Better leave them alone."
			)
			((Said 'play')
				(Print 45 7) ; "You really have better things to do, Laura!"
			)
			((or (MousedOn self event 3) (Said 'look/toy,animal'))
				(Print 45 8) ; "There are some old toys left over from many years ago."
				(event claimed: 1)
			)
		)
	)
)

(instance dollhouse of RPicView
	(properties
		y 137
		x 256
		view 145
		cel 6
		priority 10
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((Said 'look<in/dollhouse,(cabin<doll)')
				(Print 45 9) ; "The old dollhouse is empty."
			)
			((or (MousedOn self event 3) (Said 'look/(cabin<doll),dollhouse'))
				(Print 45 10) ; "It's a wonderful old dollhouse. But you'd better leave it alone."
				(event claimed: 1)
			)
		)
	)
)

(instance sofa of RPicView
	(properties
		y 167
		x 160
		view 145
		cel 9
		priority 12
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {couch})
		)
	)
)

(instance shelf1 of RPicView
	(properties
		y 167
		x 89
		view 145
		cel 10
		priority 12
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/shelf'))
			(Print 45 11) ; "You see several old toys on the dusty shelves."
			(event claimed: 1)
		)
	)
)

(instance shelf2 of RPicView
	(properties
		y 167
		x 233
		view 145
		cel 8
		priority 12
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(Print 45 11) ; "You see several old toys on the dusty shelves."
			(event claimed: 1)
		)
	)
)

(instance suit1 of RPicView
	(properties
		y 111
		x 131
		view 145
		cel 11
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/luggage')
				(Print 45 12) ; "It's locked."
			)
			((Said 'get/luggage')
				(Print 45 13) ; "You'd look silly carrying around a suitcase!"
			)
			((or (MousedOn self event 3) (Said 'look/luggage'))
				(Print 45 14) ; "You notice a suitcase next to the bed. It must belong to Ethel."
				(event claimed: 1)
			)
		)
	)
)

(instance Ethel of Act
	(properties
		y 100
		x 68
		view 327
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
			((Said 'look<in/drink,glass')
				(Print 45 15) ; "Ethel seems to be drinking a strong alcoholic drink."
			)
			((Said 'look/drink,glass,give,handkerchief')
				(Print 45 16) ; "Ethel holds a drink and a white hanky in her hand."
			)
			((Said 'get>')
				(cond
					((Said '/drink,glass')
						(Print 45 17) ; "That's Ethel's drink."
					)
					((Said '/handkerchief')
						(Print 45 18) ; "It's hers!"
					)
				)
			)
			((and (MousedOn self event 3) (not (& global207 $0008)))
				(event claimed: 1)
				(DoLook {ethel})
			)
			(
				(and
					(& global207 $0008)
					(or (MousedOn self event 3) (Said 'look/ethel'))
				)
				(event claimed: 1)
				(Print 45 19) ; "Ethel is relaxing in her room after a long day."
			)
			((Said 'talk/ethel')
				(= global213 4)
				(switch local1
					(0
						(Say 1 45 20) ; "Where is Lillian, Laura? I'd like to speak with her."
						(= global213 12)
						(Say 1 45 21) ; "She went to freshen up in the bathroom. She'll be right back."
					)
					(1
						(Say 1 45 22) ; "Why don't you go find Lillian?"
					)
					(else
						(Say 1 45 23) ; "Run along, Laura."
					)
				)
				(++ local1)
			)
		)
	)
)

(instance eHead of Prop
	(properties
		y 64
		x 65
		view 327
		loop 1
	)
)

(instance Mouth of Prop
	(properties
		y 57
		x 66
		view 327
		loop 3
	)
)

