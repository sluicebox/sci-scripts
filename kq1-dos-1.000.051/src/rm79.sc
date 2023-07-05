;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 79)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Feature)
(use LoadMany)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm79 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(Print 79 66) ; "You can't do that while you're invisible, Sir Graham."
)

(instance rm79 of Rm
	(properties
		picture 79
	)

	(method (dispose)
		(SetFlag 8)
		(super dispose: &rest)
	)

	(method (init)
		(self style: 6)
		(LoadMany rsSOUND 8 32)
		(LoadMany rsVIEW 181 180 279)
		(if (gEgo has: 7) ; Ceramic_Bowl
			(Load rsVIEW 35)
		)
		(if (or (and (IsFlag 113) (not (gEgo has: 17))) (gEgo has: 7)) ; Fiddle, Ceramic_Bowl
			(Load rsVIEW 1)
		)
		(super init:)
		(proc0_1)
		(gEgo posn: 116 160 loop: 3 init:)
		(cupboard init:)
		(fireplace1 init:)
		(fireplace2 init:)
		(fireplace3 init:)
		(fireplace4 init:)
		(nightstand init:)
		(table1 init:)
		(table2 init:)
		(table3 init:)
		(table4 init:)
		(table5 init:)
		(rug1 init:)
		(bed1 init:)
		(bed2 init:)
		(bed3 init:)
		(bed4 init:)
		(bed5 init:)
		(if (not (IsFlag 114))
			(fiddle init: stopUpd:)
		)
		(body ignoreActors: setPri: 8 init: priority: 8 stopUpd:)
		(tableStuff priority: 8)
		(head init: cycleSpeed: 1 stopUpd:)
		(gAddToPics add: tableStuff eachElementDo: #init doit:)
		(fire init: stopUpd:)
		(if (>= global101 1)
			(fire cycleSpeed: 1 setCycle: Fwd)
		)
		(wife init: stopUpd:)
		(if (not (IsFlag 1))
			(= local2 1)
			(gCurRoom setScript: welcome)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo onControl: 1) 16384)
				(self newRoom: 44)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event))
			((Said 'open,open,(look,look<in)/cabinet,cabinet')
				(Print 79 0 #at -1 130 #width 280 #mode 1) ; "If there was something of value in there, the woodcutter and his wife would not be starving to death."
			)
			((or (Said 'remove/ring') (Said 'get<off/ring'))
				(cond
					((not (gEgo has: 5)) ; Magic_Ring
						(proc0_6) ; "You don't have anything that fits that description in your inventory."
					)
					((not (IsFlag 17))
						(event claimed: 0)
					)
					(else
						(ClearFlag 1)
						(ClearFlag 17)
						(proc0_1)
						(gEgo startUpd:)
						(if (== local2 1)
							(Print 79 1 #at -1 130 #width 280 #mode 1) ; "The woodcutter is mildly impressed with your appearance, but he is too concerned with the plight of his poor wife to make idle chatter."
						else
							(Print 79 2 #at -1 130 #width 280 #mode 1) ; "The woodcutter is surprised by your sudden appearance, but quickly he recognizes you."
							(= local2 1)
							(gCurRoom setScript: welcome)
						)
					)
				)
			)
			((Said 'aid/man,woman,husband,husband,woman')
				(if (IsFlag 113)
					(Print 79 3 #at -1 130 #width 280 #mode 1) ; "You have already helped the woodcutter and his wife as much as you are able."
				else
					(Print 79 4 #at -1 130 #width 280 #mode 1) ; "That would be a very nice gesture. But how do you intend to do that?"
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room]')
						(cond
							((and (IsFlag 113) (== (body loop:) 4))
								(Print 79 5 #at -1 20 #width 280) ; "The woodcutter is feeding his wife the hearty stew. Thanks to your generosity, the woodcutter's wife will make a full recovery. They are both very happy...and very grateful to you."
							)
							((IsFlag 113)
								(Print 79 6 #at -1 20 #width 280) ; "The woodcutter has fed his wife the hearty stew. Thanks to your generosity, the woodcutter's wife will make a full recovery. They are both very happy...and very grateful to you."
							)
							(else
								(Print 79 7 #at -1 130 #width 280 #mode 1) ; "A woman is laying in bed, pale and still. Her husband is seated on the bed, holding her hand."
							)
						)
					)
					((Said 'building,room')
						(Print 79 8) ; "This house looks as shabby and tumbledown inside as it does outside, but it's surprisingly neat and tidy. The sagging bed fills most of the room, and a fire burns cheerfully in the old stone fireplace. A large wooden table and a smaller nightstand are nearby; above the nightstand is a small cabinet."
					)
					((or (Said '<on/endtable') (Said '<on/table<little'))
						(Print 79 9) ; "An earthenware pitcher sits on the nightstand."
					)
					((or (Said '<at/endtable') (Said '<at/table<little'))
						(Print 79 10) ; "The old nightstand is nothing more than a small table at the foot of the bed."
					)
				)
			)
			((Said 'open,open/endtable,(table<little)')
				(Print 79 11) ; "There are no drawers in this nightstand."
			)
			((Said 'get/endtable,(table<little)')
				(Print 79 12) ; "The nightstand won't be of any help to you on your quest."
			)
			((Said 'move,pull/endtable,(table<little)')
				(Print 79 13) ; "The woodcutter and his wife have gone to great pains to make their shabby home as neat and clean as possible."
			)
			((Said 'stand<on/endtable,(table<little)')
				(Print 79 14) ; "What are you going to do, dive onto the bed? Not with the woodcutter's wife in bed, you're not!"
			)
			((Said 'enter,(get,get,go<in)/bed')
				(Print 79 15) ; "The bed is already occupied. Neither the woodcutter nor his wife would look kindly upon your intrusion on their personal space."
			)
			((Said 'get,get/fiddle')
				(cond
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((gEgo has: 17) ; Fiddle
						(Print 79 16 #at -1 130 #width 280 #mode 1) ; "You've already accomplished that task."
					)
					((not (IsFlag 113))
						(Print 79 17 #at -1 130 #width 280 #mode 1) ; "You should not steal from these poor people, Sir Graham!"
					)
					((IsFlag 1)
						(localproc_0)
					)
					(
						(<=
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								(fiddle x:)
								(fiddle y:)
								60
							)
							50
						)
						(gCurRoom setScript: getFiddle)
					)
					(else
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
				)
			)
			((Said 'get,get/!*')
				(if (IsFlag 113)
					(Print 79 18 #at -1 20 #width 280) ; "The woodcutter offered you his fiddle, which is all he can spare. It would be unknightly to take anything else from these poor people."
				else
					(Print 79 17 #at -1 130 #width 280 #mode 1) ; "You should not steal from these poor people, Sir Graham!"
				)
			)
			((Said 'talk,talk/woman')
				(cond
					((and (IsFlag 113) (== (body loop:) 4))
						(Print 79 19 #at -1 130 #width 280 #mode 1) ; "The woodcutter's wife is too polite to speak with her mouth full!"
					)
					((IsFlag 113)
						(Print 79 20) ; "The woodcutter's wife is too fatigued to speak, but you can see in her eyes that she's very grateful...and happier than she's been in a long time."
					)
					(else
						(Print 79 21 #at -1 130 #width 280 #mode 1) ; "The woodcutter's poor wife appears to be near death."
					)
				)
			)
			((or (Said 'talk,talk/man,husband') (Said '/hello'))
				(cond
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((IsFlag 1)
						(Print 79 22 #at -1 130 #width 280 #mode 1) ; "The woodcutter is startled by the voice that appears to come from nowhere, but quickly returns to tending his wife."
					)
					((and (IsFlag 113) (not (gEgo has: 17))) ; Fiddle
						(Print 79 23 #at -1 20 #width 280) ; "WOODCUTTER: "Please, Sir Knight, take my fiddle as a small token of thanks.""
					)
					((IsFlag 113)
						(Print 79 24 #at -1 20 #width 280) ; "WOODCUTTER: "Thank you, Sir Knight!""
					)
					(else
						(Print 79 25 #at -1 130 #width 280 #mode 1) ; "The woodcutter, still holding his wife's hand and gazing at her pale face, does not seem to hear you."
					)
				)
			)
			((Said 'talk,talk/*')
				(Print 79 26 #at -1 130 #width 280 #mode 1) ; "It doesn't respond, but that shouldn't be surprising."
			)
			((Said 'talk,talk')
				(Print 79 27 #at -1 130 #width 280 #mode 1) ; "with whom do you wish to talk, Sir Graham?"
			)
			((Said 'give[/*]/woman')
				(Print 79 28) ; "The poor woman is too weak to even notice."
			)
			((Said 'give/soup')
				(cond
					((or (not (IsFlag 112)) (IsFlag 34))
						(Print 79 29 #at -1 130 #width 280 #mode 1) ; "What stew? There is no stew in your bowl."
					)
					((IsFlag 1)
						(localproc_0)
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((== (gEgo onControl: 1) 8192)
						(Print 79 30) ; "Move a little closer, Sir Graham."
					)
					((not (gEgo has: 7)) ; Ceramic_Bowl
						(proc0_6) ; "You don't have anything that fits that description in your inventory."
					)
					(else
						(gCurRoom setScript: fullBowl)
					)
				)
			)
			((Said 'give/bowl')
				(cond
					((IsFlag 1)
						(localproc_0)
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((== (gEgo onControl: 1) 8192)
						(Print 79 30) ; "Move a little closer, Sir Graham."
					)
					((not (gEgo has: 7)) ; Ceramic_Bowl
						(proc0_6) ; "You don't have anything that fits that description in your inventory."
					)
					((and (IsFlag 112) (not (IsFlag 34)))
						(gCurRoom setScript: fullBowl)
					)
					(else
						(gCurRoom setScript: emptyBowl)
					)
				)
			)
			((and (IsFlag 112) (not (IsFlag 34)) (Said 'eat,eat/soup'))
				(cond
					((IsFlag 1)
						(localproc_0)
					)
					((IsFlag 113)
						(Print 79 31 #at -1 20 #width 280) ; "You don't have the stew. You were kind enough to give it away for the woodcutter wife's speedy recover."
					)
					(else
						(Print 79 32 #at -1 20 #width 280) ; "It would be terribly cruel to eat in front of these poor, starving people. Your conscience prevents you from being so inconsiderate."
					)
				)
			)
			((and (Said 'give>') (= temp0 (gInventory firstTrue: #saidMe)))
				(= local0 (gInventory indexOf: temp0))
				(= local1 0)
				(cond
					((not (temp0 ownedBy: gEgo))
						(Print 79 33 #at -1 130 #width 280 #mode 1) ; "You don't have one of those to give."
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((== (gEgo onControl: 1) 8192)
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					((IsFlag 113)
						(Print 79 34 #at -1 20 #width 280) ; "You have already given the woodcutter a bowl filled with stew. To help him now, you must hurry and complete your mission."
					)
					(
						(switch local0
							(1
								(gGame changeScore: -8)
								(= local1 1)
								(gCurRoom setScript: acceptIt)
							)
							(2
								(ClearFlag 64)
								(gGame changeScore: -2)
								(gCurRoom setScript: acceptIt)
							)
							(11
								(gGame changeScore: -3)
								(= local1 1)
								(gCurRoom setScript: acceptIt)
							)
							(12
								(gGame changeScore: -6)
								(= local1 1)
								(gCurRoom setScript: acceptIt)
							)
							(13
								(gGame changeScore: -2)
								(gCurRoom setScript: acceptIt)
							)
							(14
								(gGame changeScore: -8)
								(= local1 1)
								(gCurRoom setScript: acceptIt)
							)
							(15
								(gGame changeScore: -6)
								(= local1 1)
								(gCurRoom setScript: acceptIt)
							)
							(16
								(gGame changeScore: -8)
								(= local1 1)
								(gCurRoom setScript: acceptIt)
							)
							(17
								(Print 79 35 #at -1 130 #width 280 #mode 1) ; "The woodcutter has already given the fiddle to you. It would be rude to return it."
							)
							(18
								(gGame changeScore: -3)
								(ClearFlag 66)
								(if (IsFlag 67)
									(gGame changeScore: -3)
									(= local1 1)
									(gCurRoom setScript: acceptIt)
								else
									(Print 79 36 #at -1 130 #width 280 #mode 1) ; "The woodcutter gratefully accepts the walnut, but is too weak to open it."
									(proc0_8 local0)
								)
							)
							(20
								(gGame changeScore: -4)
								(gCurRoom setScript: acceptIt)
							)
							(else
								(Print 79 37 #at -1 130 #width 280 #mode 1) ; "The woodcutter has little use for that."
							)
						))
					(else 0)
				)
			)
			((Said 'kill/husband,man,woman,woman')
				(Print 79 38) ; "You wouldn't want to hurt them."
			)
		)
	)
)

(instance wife of Prop
	(properties
		x 180
		y 116
		description {woodcutter's wife}
		view 181
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (Said 'look,look/woman,woman') (MousedOn self event 3))
				(cond
					((and (IsFlag 113) (== (body loop:) 4))
						(Print 79 39 #at -1 130 #width 280 #mode 1) ; "The woodcutter's wife is in the bed, sitting up and and eating hearty stew by the spoonful."
					)
					((IsFlag 113)
						(Print 79 40 #at -1 130 #width 280 #mode 1) ; "The woodcutter's wife is getting a bit of color back in her cheeks. With your help, she'll be making a full recovery."
					)
					(else
						(Print 79 41 #at -1 20 #width 280) ; "The woodcutter's wife lies in bed. Years of struggle and poverty have taken their toll on her; she looks much older than she really is."
					)
				)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance body of Prop
	(properties
		x 163
		y 139
		description {woodcutter}
		view 180
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(Print 79 42 #at -1 20 #width 280) ; "The woodcutter sits on the edge of the bed, next to his wife. Ever since the woods became too dangerous to venture into, he has not been able to earn a decent living."
			)
			((Said 'look,look/bowl')
				(if (or (and (== loop 0) (== cel 1)) (== loop 3) (== loop 4))
					(Print 79 43) ; "The woodcutter has the magic bowl you've given him; at the moment, it's filled with hot, savory stew."
				else
					(event claimed: 0)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance head of Prop
	(properties
		x 160
		y 101
		description {woodcutter}
		view 180
		loop 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(
				(or
					(Said 'look,look/man,husband,husband')
					(MousedOn self event 3)
				)
				(event claimed: 1)
				(Print 79 42 #at -1 20 #width 280) ; "The woodcutter sits on the edge of the bed, next to his wife. Ever since the woods became too dangerous to venture into, he has not been able to earn a decent living."
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance fiddle of View
	(properties
		x 178
		y 161
		z 15
		view 279
		loop 1
		cel 1
		priority 12
		signal 16
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (MousedOn self event 3) (Said 'look,look/fiddle'))
				(Print 79 44 #at -1 20 #width 280) ; "The woodcutter's most treasured possession, a fine old fiddle, lies on the table."
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance fire of Prop
	(properties
		x 248
		y 141
		noun '/fireplace,fire'
		view 279
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (Said 'look,look/fireplace,fire') (MousedOn self event 3))
				(Print 79 45 #at -1 20 #width 280) ; "A large fire burns merrily in the fireplace, providing some warmth in the drafty old cottage."
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance tableStuff of RPicView
	(properties
		x 70
		y 119
		noun '/pitcher'
		description {pitcher}
		view 279
		loop 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look,look/pitcher')
					(Said 'look,look/table[<little,little]')
				)
				(Print 79 46 #at -1 20 #width 280) ; "An old earthenware pitcher sits on the table."
				(event claimed: 1)
			)
			((Said 'look,look<in/pitcher')
				(Print 79 47) ; "It's empty."
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance ceramicBowl of Prop
	(properties
		x 163
		y 119
		z -15
		view 35
		loop 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((MousedOn self event 3)
				(Print 79 48 #at -1 130 #width 280 #mode 1) ; "A cracked old bowl sits beside the pitcher on the table."
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance welcome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(head setCycle: End self)
				(if (not (IsFlag 113))
					((ScriptID 0 23) number: 8 loop: -1 play:) ; backSound
				)
				(if (IsFlag 113)
					(wife loop: 1)
				)
			)
			(1
				(head loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(cond
					((IsFlag 113)
						(Print 79 49 #at -1 20 #width 280) ; "The woodcutter speaks with joy in his voice."
						(Print 79 50 #at -1 20 #width 280) ; "WOODCUTTER: "Sir Knight, bless you! Even now, my wife is recovering due to your kindness.""
					)
					((IsFlag 8)
						(Print 79 51 #at -1 20 #width 280) ; "The woodcutter speaks, his voice broken with sorrow."
						(Print 79 52 #at -1 20 #width 280) ; "WOODCUTTER: "Oh, Sir Knight, you have returned. But I fear that my wife grows weaker still for lack of food."
					)
					(else
						(Print 79 53 #at -1 20 #width 280) ; "The woodcutter speaks to you, his voice broken with sorrow."
						(Print 79 54 #at -1 20 #width 280) ; "WOODCUTTER: "We would welcome you to our home, Sir Knight, but we have had no food for so long, my beautiful wife cannot even rise from her bed. I fear she may die soon.""
					)
				)
				(head setCycle: Beg self)
			)
			(3
				(head loop: 1 cel: 3 setCycle: Beg self)
			)
			(4
				(head stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance emptyBowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 139 140 self
				)
			)
			(1
				(body hide: stopUpd:)
				(head hide: stopUpd:)
				(gEgo
					view: 35
					loop: 0
					cel: 0
					posn: 163 139
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(head loop: 2 cel: 0 show: setCycle: End self)
			)
			(3
				(Print 79 55 #at -1 130 #width 280 #mode 1) ; "WOODCUTTER: "Sir Knight, an empty bowl will not help us now.""
				(head setPri: 11 setCycle: Beg self)
			)
			(4
				(head hide: stopUpd:)
				(gEgo setCycle: Beg self)
			)
			(5
				(proc0_1)
				(gEgo posn: 139 140 loop: 0 stopUpd:)
				(head show: loop: 1 cel: 3 setCycle: Beg self)
				(body show:)
			)
			(6
				(head setPri: -1 stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fullBowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 23) stop:) ; backSound
				((ScriptID 0 21) number: 32 init: play:) ; gameSound
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 139 140 self
				)
			)
			(1
				(body hide: stopUpd:)
				(head hide: stopUpd:)
				(gEgo
					view: 35
					loop: 0
					cel: 0
					posn: 163 139
					cycleSpeed: 2
					setCycle: End self
				)
				(proc0_8 7)
			)
			(2
				(proc0_1)
				(gEgo posn: 139 140 loop: 0 stopUpd:)
				(body loop: 0 cel: 1 show:)
				(head show: loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(SetScore 113 3)
				(Print 79 56 #at -1 20 #width 280) ; "The woodcutter is overwhelmed with joy."
				(Print 79 57 #at -1 20 #width 280) ; "WOODCUTTER: "Thank you, thank you, Sir Knight! We shall never forget your kindness and generosity.""
				(head setPri: 11 setCycle: Beg self)
			)
			(4
				(head hide: stopUpd:)
				(wife loop: 1 forceUpd: stopUpd:)
				(body loop: 4 cel: 0 cycleSpeed: 2 setCycle: Fwd)
				(= cycles 62)
			)
			(5
				(body loop: 0 cel: 1 setCycle: 0)
				(head show: setCycle: End self)
			)
			(6
				(Print 79 58 #at -1 20 #width 280) ; "WOODCUTTER: "Please, take my fiddle as a small token of our thanks.""
				(head hide: stopUpd:)
				(body loop: 3 cycleSpeed: 2 setCycle: End self)
			)
			(7
				(= seconds 3)
			)
			(8
				(body loop: 4 setPri: 8 setCycle: Fwd)
				(HandsOn)
				(SetFlag 113)
				(self dispose:)
			)
		)
	)
)

(instance getFiddle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo loop: 2)
				(= cycles 2)
			)
			(1
				((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
				(SetScore 114 3)
				(gEgo get: 17) ; Fiddle
				(fiddle dispose:)
				(= cycles 8)
			)
			(2
				(proc0_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance acceptIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 139 140 self
				)
			)
			(1
				(proc0_15 gEgo body)
				(if local1
					(Print 79 59 #at -1 130 #width 280 #mode 1) ; "The woodcutter gratefully accepts the treasure."
				else
					(Print 79 60 #at -1 130 #width 280 #mode 1) ; "The woodcutter accepts your meager gift of food."
				)
				(head loop: 2 cel: 0 setCycle: End self)
				(proc0_8 local0)
			)
			(2
				(gEgo stopUpd:)
				(if local1
					(Print 79 61 #at -1 20 #width 280) ; "WOODCUTTER: "Thank you, Sir Knight, but I fear that only a gift of food will save my poor wife from starvation.""
				else
					(Print 79 62 #at -1 130 #width 280 #mode 1) ; "WOODCUTTER: "Thank you, Sir Knight. This will help... for a while.""
				)
				(head setPri: 11 setCycle: Beg self)
			)
			(3
				(proc0_1)
				(gEgo posn: 139 140 loop: 0)
				(head show: loop: 1 cel: 3 setCycle: Beg self)
				(body show: stopUpd:)
				(ceramicBowl dispose:)
			)
			(4
				(head setPri: -1 stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cupboard of NewFeature
	(properties
		x 68
		y 91
		noun '/cabinet,cabinet'
		nsTop 82
		nsLeft 55
		nsBottom 101
		nsRight 81
		description {cupboard}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There is a rickety old cupboard on the wall.}
	)
)

(instance fireplace1 of NewFeature
	(properties
		x 251
		y 46
		noun '/fireplace,chimney'
		nsTop 5
		nsLeft 241
		nsBottom 88
		nsRight 262
		description {chimney}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A large fire burns merrily in the fireplace, providing some warmth in the drafty old cottage.}
	)
)

(instance fireplace2 of NewFeature
	(properties
		x 251
		y 99
		noun '/fireplace,chimney'
		nsTop 88
		nsLeft 236
		nsBottom 110
		nsRight 266
		description {fireplace}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A large fire burns merrily in the fireplace, providing some warmth in the drafty old cottage.}
	)
)

(instance fireplace3 of NewFeature
	(properties
		x 234
		y 116
		noun '/fireplace,chimney'
		nsTop 98
		nsLeft 228
		nsBottom 135
		nsRight 241
		description {fireplace}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A large fire burns merrily in the fireplace, providing some warmth in the drafty old cottage.}
	)
)

(instance fireplace4 of NewFeature
	(properties
		x 266
		y 121
		noun '/fireplace,chimney'
		nsTop 102
		nsLeft 257
		nsBottom 141
		nsRight 275
		description {fireplace}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A large fire burns merrily in the fireplace, providing some warmth in the drafty old cottage.}
	)
)

(instance table1 of NewFeature
	(properties
		x 147
		y 144
		noun '/table[<big,kitchen]'
		nsTop 139
		nsLeft 143
		nsBottom 150
		nsRight 151
		description {table}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
	)

	(method (doLook)
		(if ((gInventory at: 17) ownedBy: gCurRoomNum) ; Fiddle
			(Print 79 63) ; "There is a sturdy old plank table here. The food it once held is long gone, but there appears to be a fiddle on the table."
		else
			(Print 79 64) ; "There is a sturdy old plank table here. The food it once held is long gone."
		)
	)
)

(instance table2 of NewFeature
	(properties
		x 158
		y 145
		noun '/table[<big,kitchen]'
		nsTop 138
		nsLeft 151
		nsBottom 153
		nsRight 165
		description {table}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
	)

	(method (doLook)
		(if ((gInventory at: 17) ownedBy: gCurRoomNum) ; Fiddle
			(Print 79 63) ; "There is a sturdy old plank table here. The food it once held is long gone, but there appears to be a fiddle on the table."
		else
			(Print 79 64) ; "There is a sturdy old plank table here. The food it once held is long gone."
		)
	)
)

(instance table3 of NewFeature
	(properties
		x 176
		y 144
		noun '/table[<big,kitchen]'
		nsTop 135
		nsLeft 165
		nsBottom 154
		nsRight 188
		description {table}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
	)

	(method (doLook)
		(if ((gInventory at: 17) ownedBy: gCurRoomNum) ; Fiddle
			(Print 79 63) ; "There is a sturdy old plank table here. The food it once held is long gone, but there appears to be a fiddle on the table."
		else
			(Print 79 64) ; "There is a sturdy old plank table here. The food it once held is long gone."
		)
	)
)

(instance table4 of NewFeature
	(properties
		x 197
		y 143
		noun '/table[<big,kitchen]'
		nsTop 136
		nsLeft 188
		nsBottom 150
		nsRight 206
		description {table}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
	)

	(method (doLook)
		(if ((gInventory at: 17) ownedBy: gCurRoomNum) ; Fiddle
			(Print 79 63) ; "There is a sturdy old plank table here. The food it once held is long gone, but there appears to be a fiddle on the table."
		else
			(Print 79 64) ; "There is a sturdy old plank table here. The food it once held is long gone."
		)
	)
)

(instance table5 of NewFeature
	(properties
		x 211
		y 144
		noun '/table[<big,kitchen]'
		nsTop 141
		nsLeft 206
		nsBottom 148
		nsRight 216
		description {table}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
	)

	(method (doLook)
		(if ((gInventory at: 17) ownedBy: gCurRoomNum) ; Fiddle
			(Print 79 63) ; "There is a sturdy old plank table here. The food it once held is long gone, but there appears to be a fiddle on the table."
		else
			(Print 79 64) ; "There is a sturdy old plank table here. The food it once held is long gone."
		)
	)
)

(instance rug1 of NewFeature
	(properties
		x 123
		y 148
		noun '/carpet,carpet'
		nsTop 138
		nsLeft 103
		nsBottom 158
		nsRight 143
		description {rug}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There is a small, threadbare carpet on the floor.}
	)
)

(instance bed1 of Feature
	(properties
		x 112
		y 117
		noun '/bed'
		nsTop 103
		nsLeft 94
		nsBottom 132
		nsRight 130
		description {bed}
		sightAngle 360
		closeRangeDist 320
		longRangeDist 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 79 65) ; "The woodcutter and his wife are on the bed."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bed2 of Feature
	(properties
		x 96
		y 94
		nsTop 87
		nsLeft 93
		nsBottom 102
		nsRight 99
		description {bed}
		sightAngle 360
		closeRangeDist 320
		longRangeDist 320
	)

	(method (doVerb theVerb)
		(bed1 doVerb: theVerb)
	)
)

(instance bed3 of Feature
	(properties
		x 173
		y 118
		nsTop 107
		nsLeft 131
		nsBottom 129
		nsRight 215
		description {bed}
		sightAngle 360
		closeRangeDist 320
		longRangeDist 320
	)

	(method (doVerb theVerb)
		(bed1 doVerb: theVerb)
	)
)

(instance bed4 of Feature
	(properties
		x 146
		y 133
		nsTop 129
		nsLeft 131
		nsBottom 137
		nsRight 162
		description {bed}
		sightAngle 360
		closeRangeDist 320
		longRangeDist 320
	)

	(method (doVerb theVerb)
		(bed1 doVerb: theVerb)
	)
)

(instance bed5 of Feature
	(properties
		x 194
		y 94
		nsTop 82
		nsLeft 172
		nsBottom 106
		nsRight 216
		description {bed}
		sightAngle 360
		closeRangeDist 320
		longRangeDist 320
	)

	(method (doVerb theVerb)
		(bed1 doVerb: theVerb)
	)
)

(instance nightstand of NewFeature
	(properties
		x 71
		y 123
		noun '/endtable,(table<little)'
		nsTop 113
		nsLeft 46
		nsBottom 134
		nsRight 96
		description {nightstand}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The old nightstand is nothing more than a small plain table at the foot of the bed.}
	)
)

