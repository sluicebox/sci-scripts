;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room46 0
)

(synonyms
	(luggage case bag)
	(drawer dresser)
	(painting blaze)
	(room bedroom)
)

(local
	local0
	local1
	local2
)

(instance myMusic of Sound
	(properties)
)

(instance Room46 of Rm
	(properties
		picture 46
	)

	(method (init)
		(= east 47)
		(super init:)
		(gAddToPics
			add: suit1 suit2 horse bed1 bed2 chest table2 sofa
			eachElementDo: #init
			doit:
		)
		(self setFeatures: suit1 suit2 horse table2 bed1 bed2 sofa chest)
		(table
			cel:
				(switch gAct
					(1 9)
					(else 8)
				)
			setPri: 6
			init:
			stopUpd:
		)
		(if (== gGertieRoomState 2)
			(table cel: 8)
		)
		(if (and (== gAct 1) (!= gGertieRoomState 2))
			(plant setPri: 6 init: stopUpd:)
		)
		(if gDetailLevel
			(lamp1 setPri: 6 setCycle: Fwd init:)
			(lamp2 setPri: 6 setCycle: Fwd init:)
		else
			(lamp1 setPri: 6 init: stopUpd:)
			(lamp2 setPri: 6 init: stopUpd:)
		)
		(Bwindow ignoreActors: 1 setPri: 7 init: stopUpd:)
		(panel setLoop: 1 setCel: 11 illegalBits: 0 setPri: 4 init: stopUpd:)
		(LoadMany rsSOUND 74 75)
		(switch gAct
			(0
				(if (& gSpyFlags $0002)
					(self setRegions: 224) ; sleeping
					(= local0 1)
				)
				(= gGertieRoomState 0)
			)
			(1
				(if (< gGertieRoomState 2)
					(= local1 1)
					(Bwindow
						view: 246
						setPri: 9
						loop: 2
						cel: 0
						posn: 37 127
						cycleSpeed: 2
						ignoreActors: 0
						setCycle: Fwd
					)
					(Twindow
						cycleSpeed: 2
						cel: (- (NumCels Bwindow) 2)
						setCycle: Fwd
						init:
					)
					(myMusic number: 12 loop: -1 play:)
				)
			)
		)
		(if (!= gPrevRoomNum 49)
			(gEgo view: 0 illegalBits: -32764 posn: 304 101 init:)
		else
			(gEgo
				view: 0
				illegalBits: -32768
				setPri: 2
				loop: 2
				posn: 152 79
				init:
			)
			(if (== local0 0)
				(gEgo posn: 152 79)
				(self setScript: enterPanel)
			)
		)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 46 0) ; "This is a cozy guest room which Gloria and Gertie are sharing."
		)
		(if (and (== gAct 1) (== gGertieRoomState 0))
			(Printf 46 1 46 2) ; "Did something happen in here?! %s"
			(Print 46 3) ; "Is that cigar smoke you smell?"
			(= gGertieRoomState 1)
			(= local2 1)
		)
		(if
			(or
				(gEgo inRect: 60 80 116 104)
				(gEgo inRect: 178 82 213 105)
			)
			(gEgo setPri: 5)
		else
			(gEgo setPri: -1)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look,find/gertie,body')
					(if (== gAct 0)
						(event claimed: 0)
					else
						(Print 46 4) ; "She's not around here!"
					)
				)
				((Said '/panel,(door<hidden)>')
					(cond
						((and (& global175 $0040) (Said 'open,move'))
							(if (not local0)
								(if (& (gEgo onControl: 0) $0010)
									(HandsOff)
									(self setScript: exiting)
								else
									(NotClose) ; "You're not close enough."
								)
							else
								(Print 46 5) ; "You better not while others are in the room."
							)
						)
						((Said 'look')
							(if (& global175 $0040)
								(Print 46 6) ; "Even though you know where it is, you can't see it."
							else
								(Print 46 7) ; "You don't see one."
							)
						)
					)
				)
				((Said 'look[<around,at][/room]')
					(if (and (== gAct 1) local1)
						(Printf 46 1 46 2) ; "Did something happen in here?! %s"
						(Print 46 3) ; "Is that cigar smoke you smell?"
					else
						(Print 46 0) ; "This is a cozy guest room which Gloria and Gertie are sharing."
					)
				)
				((Said 'smell/smoke,butt')
					(if (and (== gAct 1) local2)
						(Print 46 8) ; "The distinctive odor of cigar smoke permeates the air."
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance enterPanel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global204 1)
				(panel setMotion: MoveTo 180 84 self)
				(myMusic number: 74 loop: 1 play:)
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 15) self
				)
			)
			(2
				(gEgo setPri: -1 illegalBits: -32764)
				(panel setMotion: MoveTo 155 84 self)
				(myMusic number: 75 loop: 1 play:)
			)
			(3
				(HandsOn)
				(Print 46 9) ; "The secret panel closes behind you and leaves no trace!"
				(= global204 0)
				(client setScript: 0)
			)
		)
	)
)

(instance exiting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global204 1)
				(panel setMotion: MoveTo 180 84 self)
				(myMusic number: 74 loop: 1 play:)
			)
			(1
				(if (gEgo inRect: 150 87 154 90)
					(= cycles 1)
				else
					(gEgo illegalBits: -32768 setMotion: MoveTo 152 85 self)
				)
			)
			(2
				(gEgo illegalBits: -32768 setMotion: MoveTo 154 79 self)
			)
			(3
				(gEgo setPri: 2)
				(panel setMotion: MoveTo 155 84 self)
				(myMusic number: 75 loop: 1 play:)
			)
			(4
				(HandsOn)
				(= global204 0)
				(gCurRoom newRoom: 49)
				(client setScript: 0)
			)
		)
	)
)

(instance closeWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 75 120 self)
			)
			(1
				(gEgo loop: 1)
				(Twindow hide:)
				(Bwindow
					posn: 37 127
					loop: 0
					cel: 3
					setPri: 7
					setCycle: Beg self
				)
			)
			(2
				(myMusic stop:)
				(Bwindow ignoreActors: 1 setPri: 7 stopUpd:)
				(= local1 0)
				(= gGertieRoomState 3)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance horse of RPicView
	(properties
		y 53
		x 183
		view 146
		priority 5
	)

	(method (handleEvent event)
		(cond
			((Said 'look<behind,below/painting')
				(Print 46 10) ; "There is only the wall behind the picture."
			)
			((Said 'get/painting')
				(Print 46 11) ; "The picture is firmly attached to the wall."
			)
			((Said 'open/painting')
				(Print 46 12) ; "It doesn't open."
			)
			((Said 'look/eye,(painting<eye)')
				(Print 46 13) ; "The eyes of the horse have a strange, vacant stare."
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/painting')
					(Said 'look/painting/painting')
				)
				(event claimed: 1)
				(Print 46 14) ; "You notice a portrait of a magnificent palomino on the wall. Could it be the Colonel's horse in better days? Funny, the horse seems to have a strange, vacant stare."
			)
		)
	)
)

(instance bed1 of RPicView
	(properties
		y 106
		x 110
		view 146
		cel 4
		priority 6
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 46 15) ; "The beds are old and lumpy. Oh, well. You're not going to be doing much sleeping tonight, anyway."
		)
	)
)

(instance chest of RPicView
	(properties
		y 93
		x 182
		view 146
		cel 1
		priority 5
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look[<!*]/drawer'))
			(event claimed: 1)
			(Print 46 16) ; "Between the beds, you notice an old dresser."
		)
	)
)

(instance bed2 of RPicView
	(properties
		y 107
		x 215
		view 146
		cel 5
		priority 6
		signal 16384
	)

	(method (handleEvent event)
		(if (and (not local0) (MousedOn self event 3))
			(event claimed: 1)
			(DoLook {bed})
		)
	)
)

(instance table2 of RPicView
	(properties
		y 94
		x 256
		view 146
		cel 2
		priority 5
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance sofa of RPicView
	(properties
		y 157
		x 133
		view 146
		cel 7
		priority 11
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {couch})
		)
	)
)

(instance suit1 of RPicView
	(properties
		y 119
		x 211
		view 146
		cel 3
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/luggage')
				(Print 46 17) ; "They're locked."
			)
			((Said 'get/luggage')
				(Print 46 18) ; "You'd look silly carrying a suitcase around with you."
			)
			((or (MousedOn self event 3) (Said 'look/luggage'))
				(event claimed: 1)
				(Print 46 19) ; "You notice several suitcases in the room. They must belong to Gloria and Gertie."
			)
		)
	)
)

(instance suit2 of RPicView
	(properties
		y 86
		x 106
		view 146
		cel 6
		priority 7
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 46 19) ; "You notice several suitcases in the room. They must belong to Gloria and Gertie."
		)
	)
)

(instance Twindow of Prop
	(properties
		y 37
		x 60
		view 246
		loop 1
	)
)

(instance Bwindow of Prop
	(properties
		y 127
		x 37
		view 246
	)

	(method (handleEvent event)
		(cond
			((Said 'look/curtain')
				(if local1
					(Print 46 20) ; "The heavy drapes flap with the wind coming in through the open window."
				else
					(event claimed: 0)
				)
			)
			((Said '(go,climb,hop)<out/window')
				(if local1
					(Print 46 21) ; "What? Are you crazy?!"
				else
					(Print 46 22) ; "The window isn't open."
				)
			)
			((Said 'open/window')
				(if local1
					(Print 46 23) ; "It's open."
				else
					(Print 46 24) ; "There is no need to open the window."
				)
			)
			((Said 'close/window')
				(if local1
					(if (& (gEgo onControl: 0) $0008)
						(self setScript: closeWindow)
					else
						(NotClose) ; "You're not close enough."
					)
				else
					(Print 46 25) ; "It's closed."
				)
			)
			(
				(or
					(Said 'look[<down]/dirt')
					(Said 'look<(down,out)')
					(Said 'look<(out,through)/window')
				)
				(if local1
					(if (& (gEgo onControl: 0) $0008)
						(Print 46 26) ; "Curiously, you peer through the open window into the darkness outside. Looking downward you think you see something, but can't make out any details."
					else
						(NotClose) ; "You're not close enough."
					)
				else
					(event claimed: 0)
				)
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(if local1
					(Print 46 27) ; "Who could have opened the window...and why?"
				else
					(DoLook {window})
				)
			)
			((Said 'look/window')
				(if local1
					(Print 46 27) ; "Who could have opened the window...and why?"
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 45
		x 120
		view 148
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance lamp2 of Prop
	(properties
		y 46
		x 250
		view 148
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance panel of Act
	(properties
		y 84
		x 155
		view 146
	)
)

(instance table of Prop
	(properties
		y 111
		x 72
		view 146
	)

	(method (handleEvent event)
		(cond
			((and (== gAct 1) (!= gGertieRoomState 2))
				(cond
					((or (Said 'look/dirt') (Said 'look<down'))
						(Print 46 28) ; "A small table has been knocked over spilling a potted plant on the floor."
					)
					((Said 'get,straighten/nightstand,foliage')
						(Print 46 29) ; "Don't worry about it. Fifi will get it."
					)
					(
						(or
							(Said 'look/nightstand,foliage')
							(MousedOn self event 3)
						)
						(Print 46 30) ; "It appears that a small table has been knocked over, with the potted plant it supported lying crumpled on the floor."
						(event claimed: 1)
					)
				)
			)
			((or (Said 'look/foliage') (MousedOn self event 3))
				(Print 46 31) ; "A potted plant graces the top of the small table."
			)
		)
	)
)

(instance plant of Prop
	(properties
		y 109
		x 99
		view 146
		cel 10
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/foliage'))
			(event claimed: 1)
			(Print 46 32) ; "The crumpled plant lies on the floor next to a small table that has been knocked over."
		)
	)
)

