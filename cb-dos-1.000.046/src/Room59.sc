;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 59)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room59 0
)

(synonyms
	(get detach)
)

(local
	local0
	local1
)

(instance Room59 of Rm
	(properties
		picture 59
	)

	(method (init)
		(super init:)
		(gAddToPics
			add:
				stove
				dresser
				mirror
				portrait
				shelf
				herb1
				herb2
				table
				herb3
				chair1
				chair2
				pillow
			eachElementDo: #init
			doit:
		)
		(Load rsSCRIPT 985)
		(Load rsVIEW 2)
		(if (== ((gInventory at: 17) owner:) 59) ; carrot
			(carrot setPri: 8 init: stopUpd:)
		)
		(self
			setFeatures:
				chair2
				table
				chair1
				stove
				dresser
				mirror
				portrait
				shelf
				herb1
				herb2
				herb3
				pillow
				Window1
				Window2
				Rug
				Bed
		)
		(if gDetailLevel
			(boil loop: 7 setPri: 8 setCycle: Fwd init:)
			(fire setPri: 9 setCycle: Fwd init:)
		else
			(fire setPri: 9 init: stopUpd:)
			(boil loop: 7 setPri: 8 init: stopUpd:)
		)
		(= global373 boil)
		(if (and (>= gAct 2) (<= gAct 5))
			(self setRegions: 262) ; celihome
		)
		(LoadMany rsMESSAGE 243)
		(Load rsVIEW 901)
		(= global208 2)
		(switch gAct
			(2
				(LoadMany rsMESSAGE 283)
				(= [global377 1] 283)
			)
			(3
				(LoadMany rsMESSAGE 283)
				(= [global377 1] 283)
			)
			(4
				(LoadMany rsMESSAGE 299)
				(= [global377 1] 299)
			)
		)
		(if (== gAct 5)
			(|= gMustDos $0001)
		)
		(gEgo view: 0 posn: 115 160 init:)
		(HandsOn)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 59 0) ; "Celie's place looks quite cozy and comfortable. She's managed to make a home out of a little old shack."
		)
		(if (& (gEgo onControl: 0) $0002)
			(gCurRoom newRoom: 6)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(= global108 1)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(if
				(and
					global208
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(DisposeScript 990)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
				(if (event claimed:)
					(return)
				)
			)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 59 0) ; "Celie's place looks quite cozy and comfortable. She's managed to make a home out of a little old shack."
						)
						((Said '/painting')
							(Print 59 1) ; "That's a nice picture."
						)
						((Said '/wall')
							(Print 59 2) ; "There is nothing special on the walls."
						)
						((Said '/curtain')
							(Print 59 3) ; "Tattered curtains frame the small windows."
						)
						((or (Said '/ceiling') (Said '<up'))
							(Print 59 4) ; "You look up at the ceiling but see nothing of interest."
						)
						((or (Said '/dirt') (Said '<down'))
							(Print 59 5) ; "There is nothing of interest on the floor."
						)
					)
				)
				((Said 'get/painting')
					(Print 59 6) ; "You don't want to take Celie's picture."
				)
				((or (Said 'get/gumbo') (Said 'eat[/gumbo,food]'))
					(Print 59 7) ; "You're not hungry for gumbo, even though it smells so good."
				)
				((Said 'sit[/down,*]')
					(if (gEgo inRect: 180 145 222 185)
						(if (not local0)
							(= local0 1)
							(HandsOff)
							(gEgo setScript: sitDown)
						else
							(Print 59 8) ; "You are sitting already."
						)
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'stand[/up,*]')
					(if local0
						(= local0 0)
						(HandsOff)
						(gEgo setScript: standUp)
					else
						(Print 59 9) ; "You are standing already."
					)
				)
				(
					(or
						(Said 'go/bed,sleep')
						(Said 'sleep')
						(Said 'lay<down')
						(Said 'lay/bed<down')
					)
					(Print 59 10) ; "That's Celie's bed, not yours."
				)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 202 165 self
				)
			)
			(1
				(gEgo view: 2 setPri: 13 loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(User canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setAvoider: 0 setPri: -1 setCycle: Beg self)
			)
			(1
				(gEgo view: 0 loop: 3 setCycle: Walk)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance stove of RPicView
	(properties
		y 127
		x 212
		view 159
		priority 8
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/oven'))
				(event claimed: 1)
				(Print 59 11) ; "A small fire burns in the wood stove, warming the place. A pot of good-smelling gumbo simmers atop it."
			)
			((Said 'look/log,oak')
				(Print 59 12) ; "A pile of wood waits by the wood stove."
			)
		)
	)
)

(instance dresser of RPicView
	(properties
		y 152
		x 57
		view 159
		loop 1
		priority 11
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((Said '(look<in),search,open/dresser,drawer')
				(Print 59 13) ; "There is nothing of interest in the dresser."
			)
			((or (MousedOn self event 3) (Said 'look/dresser'))
				(event claimed: 1)
				(Print 59 14) ; "A small dresser rests in the corner."
			)
		)
	)
)

(instance pillow of RPicView
	(properties
		y 102
		x 160
		view 159
		loop 2
		priority 6
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((Said 'look<below/pillow')
				(Print 59 15) ; "There is nothing under the pillows."
			)
			((or (MousedOn self event 3) (Said 'look/pillow'))
				(event claimed: 1)
				(Print 59 16) ; "A couple of pillows lie on the bed."
			)
		)
	)
)

(instance mirror of RPicView
	(properties
		y 106
		x 49
		view 159
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(cond
			((Said 'get/mirror')
				(Print 59 17) ; "You don't need a mirror."
			)
			((or (Said 'look<in/mirror') (Said 'look/reflection'))
				(if (< (gEgo distanceTo: mirror) 50)
					(= global213 12)
					(Say 0 59 18) ; "You gaze into the mirror and appraise your appearance. A bit disheveled, perhaps, but not bad...considering the circumstances."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look/mirror'))
				(event claimed: 1)
				(Print 59 19) ; "A small mirror hangs on the wall above the dresser."
			)
		)
	)
)

(instance portrait of RPicView
	(properties
		y 99
		x 79
		view 159
		loop 1
		cel 2
	)
)

(instance shelf of RPicView
	(properties
		y 96
		x 255
		view 159
		loop 4
	)

	(method (handleEvent event)
		(cond
			((Said 'get/bottle')
				(Print 59 20) ; "There's nothing you need in any of the jars."
			)
			((Said 'look/bottle')
				(Print 59 21) ; "There are some strange concoctions in those jars!"
			)
			((or (MousedOn self event 3) (Said 'look/shelf'))
				(event claimed: 1)
				(Print 59 22) ; "Various odd-looking jars fill the shelves."
			)
		)
	)
)

(instance herb1 of RPicView
	(properties
		y 100
		x 231
		view 159
		loop 2
		cel 3
	)
)

(instance herb2 of RPicView
	(properties
		y 104
		x 247
		view 159
		loop 2
		cel 4
	)
)

(instance herb3 of RPicView
	(properties
		y 107
		x 268
		view 159
		loop 2
		cel 5
	)
)

(instance table of RPicView
	(properties
		y 137
		x 257
		view 159
		loop 1
		cel 3
		priority 8
		signal 16384
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/nightstand'))
			(event claimed: 1)
			(if (== ((gInventory at: 17) owner:) 59) ; carrot
				(Print 59 23) ; "A single carrot on the kitchen table captures your attention."
			else
				(Print 59 24) ; "There is nothing that interests you on either one of the tables."
			)
		)
	)
)

(instance chair1 of RPicView
	(properties
		y 140
		x 224
		view 159
		cel 2
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 59 25) ; "There are two old chairs near the dining table."
		)
	)
)

(instance chair2 of RPicView
	(properties
		y 172
		x 194
		view 159
		cel 1
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/chair'))
			(event claimed: 1)
			(Print 59 25) ; "There are two old chairs near the dining table."
		)
	)
)

(instance fire of Prop
	(properties
		y 111
		x 206
		view 159
		loop 3
	)
)

(instance carrot of Prop
	(properties
		y 105
		x 242
		view 159
		loop 2
		cel 6
	)

	(method (handleEvent event)
		(cond
			((Said 'ask[/celie]/carrot<for')
				(= global213 2)
				(Say 1 59 26) ; "Go on. You kin have it if'n you want it."
				(++ local1)
			)
			((Said 'get/carrot')
				(if (< (gEgo distanceTo: carrot) 40)
					(if (not local1)
						(Print 59 27) ; "Before taking the carrot, you look at Celie for permission. She nods her approval. With that, you take the juicy-looking carrot for yourself."
					else
						(Ok) ; "Okay."
					)
					(carrot dispose:)
					(= global182 1)
					(gEgo get: 17) ; carrot
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look/carrot'))
				(event claimed: 1)
				(Print 59 23) ; "A single carrot on the kitchen table captures your attention."
			)
		)
	)
)

(instance boil of Prop
	(properties
		y 94
		x 205
		view 159
		loop 7
	)

	(method (handleEvent event)
		(cond
			((Said 'get/caldron,gumbo')
				(Print 59 7) ; "You're not hungry for gumbo, even though it smells so good."
			)
			((Said 'get/caldron')
				(Print 59 7) ; "You're not hungry for gumbo, even though it smells so good."
			)
			((or (MousedOn self event 3) (Said 'look/caldron,pan,gumbo'))
				(event claimed: 1)
				(Print 59 28) ; "The gumbo in the pot atop the stove fills the cabin with a wonderful odor."
			)
		)
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 58
		nsLeft 99
		nsBottom 85
		nsRight 133
	)

	(method (handleEvent event)
		(cond
			((Said 'open/window')
				(Print 59 29) ; "The windows don't open. Why not try a door?"
			)
			((Said 'break/window')
				(Print 59 30) ; "There's no reason to do that. If you wish to leave the house, use a door."
			)
			((Said 'look<(out,through)/window')
				(Print 59 31) ; "As it's dark outside, it's difficult to see out the windows."
			)
			((or (MousedOn self event 3) (Said 'look/window'))
				(event claimed: 1)
				(Print 59 32) ; "Tattered curtains cover the windows."
			)
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 49
		nsLeft 15
		nsBottom 81
		nsRight 190
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 59 32) ; "Tattered curtains cover the windows."
		)
	)
)

(instance Rug of RFeature
	(properties
		nsTop 147
		nsLeft 109
		nsBottom 162
		nsRight 160
	)

	(method (handleEvent event)
		(cond
			((Said 'move,(look<below)/carpet')
				(Print 59 33) ; "There is only the floor under the rugs."
			)
			((or (MousedOn self event 3) (Said 'look/carpet'))
				(event claimed: 1)
				(Print 59 34) ; "Two rag rugs lie on the wooden floor."
			)
		)
	)
)

(instance Bed of RFeature
	(properties
		nsTop 106
		nsLeft 96
		nsBottom 132
		nsRight 148
	)

	(method (handleEvent event)
		(cond
			((Said 'look<below/bed')
				(Print 59 35) ; "Only the floorboards are under the bed."
			)
			((or (MousedOn self event 3) (Said 'look/bed'))
				(event claimed: 1)
				(Print 59 36) ; "An old quilt covers Celie's small bed."
			)
		)
	)
)

