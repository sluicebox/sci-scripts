;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 73)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room73 0
)

(synonyms
	(lil person woman)
	(shower bath)
	(room bathroom)
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance Room73 of Rm
	(properties
		picture 73
	)

	(method (init)
		(= south 43)
		(super init:)
		(LoadMany rsVIEW 17 19 21 40 41 641 905)
		(LoadMany rsSOUND 26 76)
		(Load rsSCRIPT 985)
		(gAddToPics
			add: sink toilet bathtub basket settie
			eachElementDo: #init
			doit:
		)
		(self
			setFeatures:
				basket
				sink
				toilet
				bathtub
				Cabinet
				settie
				Window1
				Mirror
		)
		(towel setPri: 9 init: stopUpd:)
		(rope setPri: 13 init: stopUpd:)
		(if (== global203 1)
			(if (> [gCycleTimers 4] 1)
				(LoadMany rsVIEW 500 505 905)
				(LoadMany rsMESSAGE 243 226)
				(= [global377 5] 226)
				(|= global208 $0020)
				(Lilian
					setAvoider: ((Avoid new:) offScreenOK: 1)
					init:
					setScript: perfume
				)
			else
				(= global125 1)
			)
		)
		(if
			(and
				(>= gAct 6)
				(not (& gCorpseFlags $0020)) ; Clarence
				(not (& gCorpseFlags $0040)) ; Lillian
			)
			(cond
				((== global106 73)
					(self setRegions: 278) ; Dclar
					(= local3 1)
				)
				((not (== global106 41))
					(switch (Random 1 2)
						(1
							(self setRegions: 278) ; Dclar
							(= local3 1)
						)
						(2
							(= global106 41)
						)
					)
				)
			)
		)
		(gEgo view: 0 posn: 178 188 observeControl: 16384 init:)
		(if global153
			(gEgo
				view: 40
				loop: 0
				cel: 0
				illegalBits: 0
				posn: 261 168
				setScript: wash
			)
		)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 73 0) ; "A modern bathroom has been installed in this old house."
			(= local2 1)
		)
		(cond
			((< (gEgo x:) 130)
				(= vertAngle 20)
			)
			((< (gEgo x:) 190)
				(= vertAngle 0)
			)
			(else
				(= vertAngle 160)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(HandsOff)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(if (>= gAct 5)
				(cond
					(
						(or
							(Said 'read,look/bottle,label/monocle')
							(Said '(read,look)<use<monocle/bottle,label')
						)
						(if (gEgo has: 1) ; monocle
							(if (< (gEgo distanceTo: basket) 30)
								(SetFlag 5)
								(= local4 1)
								(self setScript: pickUp)
							else
								(NotClose) ; "You're not close enough."
							)
						else
							(DontHave) ; "You don't have it."
						)
					)
					((Said '/bottle>')
						(cond
							((Said 'read')
								(Print 73 1) ; "You notice some very small writing at the bottom of the label on the empty sleeping powder bottle. You can't quite read it, though."
							)
							((Said 'open,(look<in)')
								(Print 73 2) ; "The sleeping powder bottle is empty."
							)
							((Said 'look')
								(if (< (gEgo distanceTo: basket) 20)
									(if (>= gAct 5)
										(Print 73 3) ; "A small, empty bottle has been thrown into the wastebasket."
									else
										(Print 73 4) ; "Currently, it is empty."
									)
								else
									(NotClose) ; "You're not close enough."
								)
							)
							((Said 'get')
								(if (< (gEgo distanceTo: basket) 30)
									(self setScript: pickUp)
								else
									(NotClose) ; "You're not close enough."
								)
							)
						)
					)
					((Said 'read,look/label,print')
						(Print 73 1) ; "You notice some very small writing at the bottom of the label on the empty sleeping powder bottle. You can't quite read it, though."
					)
					((Said 'get,look,detach/powder')
						(Print 73 2) ; "The sleeping powder bottle is empty."
					)
				)
			)
			(if (event claimed:)
				(return)
			)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 73 0) ; "A modern bathroom has been installed in this old house."
						)
						((Said '/curtain<shower')
							(Print 73 5) ; "The shower curtain is draped over the bathtub."
						)
						((Said '/soap')
							(Print 73 6) ; "You see a small sliver of soap."
						)
						((Said '/chair,bench')
							(Print 73 7) ; "You notice a lovely seat under the large windows."
						)
						((Said '/door')
							(Print 73 8) ; "That's the bathroom door."
						)
					)
				)
				((Said 'get/mirror')
					(Print 73 9) ; "The mirror is firmly attached to the wall."
				)
				((Said 'get/soap')
					(Print 73 10) ; "You don't need any soap...unless you're washing your hands."
				)
				((Said 'get,(get<in)/shower,shower')
					(cond
						((gCast contains: Lilian)
							(Print 73 11) ; "Why don't you wait until Lillian is gone."
						)
						(local3
							(Print 73 12) ; "What a morbid thought!"
						)
						((== gAct 7)
							(Print 73 13) ; "You have no time to do that now."
						)
						(else
							(Print 73 14) ; "Yes, you DO feel a bit grimy. Perhaps a shower will make you feel better."
							(self setScript: shower)
						)
					)
				)
				((Said 'flush,pull/chain,toilet')
					(if (gEgo inRect: 230 160 281 170)
						(Print 73 15) ; "Okay."
						(= local1 1)
						(self setScript: flushing)
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'scrub/face')
					(Print 73 16) ; "Your face isn't dirty."
				)
				(
					(or
						(Said 'rotate<on/water')
						(Said 'scrub/give')
						(Said 'scrub[<!*]')
					)
					(cond
						((gEgo inRect: 61 121 121 151)
							(if (gCast contains: Lilian)
								(Print 73 17) ; "You should wait your turn."
							else
								(Print 73 15) ; "Okay."
								(self setScript: wash)
							)
						)
						((gEgo inRect: 197 127 264 154)
							(if (gCast contains: Lilian)
								(Print 73 11) ; "Why don't you wait until Lillian is gone."
							else
								(Print 73 14) ; "Yes, you DO feel a bit grimy. Perhaps a shower will make you feel better."
								(self setScript: shower)
							)
						)
						(else
							(NotClose) ; "You're not close enough."
						)
					)
				)
				((or (Said 'drink') (Said 'drink/water[<sink,shower]'))
					(Print 73 18) ; "You're not thirsty."
				)
				((Said 'sit,go,use/room,toilet')
					(if (gCast contains: Lilian)
						(Print 73 19) ; "Please! Lillian doesn't want to watch you!"
					else
						(gEgo loop: 2)
						(Print 73 20) ; "Excuse us."
						(= global153 1)
						(gCurRoom newRoom: 43)
					)
				)
			)
		)
	)
)

(instance perfume of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lilian loop: 7 cel: 0 cycleSpeed: 1 setCycle: Fwd)
				(mySound number: 76 loop: 1 play:)
				(= cycles 2)
			)
			(1
				(if local2
					(= global213 6)
					(Say 1 73 21) ; "Hi, Laura. I'm feeling better now. That ride through the bayou had me plumb frazzled. If you need to freshen up, too, I'll be done in just a bit."
				)
				(= cycles 20)
			)
			(2
				(towel hide:)
				(mySound stop:)
				(Lilian loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(Lilian loop: 8 cel: 0 setCycle: End self)
			)
			(4
				(Lilian loop: 9 setCycle: Fwd)
				(= cycles 30)
			)
			(5
				(Lilian loop: 8 cel: (- (NumCels Lilian) 1) setCycle: Beg self)
			)
			(6
				(Lilian loop: 6 cel: 0 setCycle: End self)
			)
			(7
				(Lilian loop: 6 setCycle: Beg self)
			)
			(8
				(Lilian loop: 5 cel: 0 setCycle: End self)
			)
			(9
				(towel show:)
				(Lilian view: 505 loop: 0 cel: 0 setCycle: End self)
			)
			(10
				(Lilian loop: 1 cel: 0 setCycle: Fwd)
				(= cycles 30)
			)
			(11
				(Lilian loop: 2 cel: 0 setCycle: End self)
			)
			(12
				(Lilian loop: 3 cel: 0 setCycle: Fwd)
				(= cycles 30)
			)
			(13
				(Lilian loop: 0 cel: 3 setCycle: Beg self)
			)
			(14
				(HandsOff)
				(Lilian view: 500 setCycle: Walk cycleSpeed: 0)
				(if (gEgo inRect: 140 130 160 140)
					(Lilian setMotion: MoveTo 147 160 self)
				else
					(Lilian setMotion: MoveTo 147 (Lilian y:) self)
				)
			)
			(15
				(Lilian setMotion: MoveTo 147 240 self)
			)
			(16
				(HandsOn)
				(++ global203)
				(= [gCycleTimers 4] 1)
				(Lilian dispose:)
				(= global125 1)
				(client setScript: 0)
			)
		)
	)
)

(instance shower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 205 148 self
				)
			)
			(1
				(gEgo view: 19 loop: 0 setCycle: End self)
			)
			(2
				(gEgo loop: 1 setCycle: End self)
			)
			(3
				(gEgo loop: 2 setCycle: End self)
			)
			(4
				(bra setCycle: End init:)
				(gEgo view: 21 loop: 0 setCycle: End self)
			)
			(5
				(gCurRoom newRoom: 215) ; showerReg
				(client setScript: 0)
			)
		)
	)
)

(instance flushing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 261 165 self)
			)
			(1
				(if (not local1)
					(= global153 1)
					(gEgo setScript: wash)
					(client setScript: 0)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo view: 40 loop: 2 setCycle: End self)
			)
			(3
				(rope hide:)
				(mySound number: 26 loop: 1 play:)
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(rope show:)
				(gEgo loop: 2 cel: 2 setCycle: Beg self)
			)
			(6
				(gEgo
					view: 0
					loop: 0
					setCycle: Walk
					posn: (- (gEgo x:) 2) (gEgo y:)
					illegalBits: -32768
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance wash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if global153
					(gEgo view: 40 loop: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(if global153
					(rope hide:)
					(mySound number: 26 loop: 1 play:)
					(gEgo loop: 1 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(if global153
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(3
				(if global153
					(rope show:)
					(gEgo loop: 0 cel: 2 setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(4
				(gEgo
					view: 0
					setCycle: Walk
					setAvoider: (Avoid new:)
					ignoreControl: 16384
					setMotion: MoveTo 100 134 self
				)
			)
			(5
				(gEgo setPri: 11 view: 41 loop: 5 setCycle: Fwd)
				(mySound number: 76 loop: -1 play:)
				(= seconds 5)
			)
			(6
				(mySound stop:)
				(towel hide:)
				(gEgo setPri: -1 loop: 0 cel: 0 setCycle: End self)
			)
			(7
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(8
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(9
				(gEgo loop: 3 cel: 0 setCycle: Beg self)
			)
			(10
				(gEgo
					loop: 2
					cel: (- (NumCels gEgo) 1)
					setCycle: Beg self
				)
			)
			(11
				(gEgo loop: 4 cel: 0 setCycle: End self)
			)
			(12
				(gEgo loop: 4 setCycle: Beg self)
			)
			(13
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(14
				(towel show:)
				(gEgo
					view: 0
					illegalBits: -32768
					observeControl: 16384
					setAvoider: 0
					setCycle: Walk
				)
				(HandsOn)
				(= global153 0)
				(client setScript: 0)
			)
		)
	)
)

(instance pickUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 116 128 self)
			)
			(1
				(gEgo
					view: 17
					cel: 0
					loop: 3
					setMotion: 0
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(if local4
					(= local4 0)
					(Print 73 22 #icon 641 0 0) ; "You read the small print of the sleeping powder bottle through the monocle. It says "Can be fatal if taken in too large a dose." Oh, oh!"
				else
					(Print 73 23) ; "After retrieving the small bottle from the wastebasket you read its label."
					(Print 73 24) ; "It says, "Dr. Milliken's Miracle-Sleep Powder... with Dr. Milliken's, you can be sure your dreams will be `sweet' tonight!""
					(Print 73 25) ; "Upon further inspection of the label you notice some very small print at the bottom. Though you try to read the small print, you can't quite make it out."
					(Print 73 26) ; "Giving up, you put the bottle back in the wastebasket."
				)
				(= cycles 2)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(HandsOn)
				(gEgo view: 0 loop: 3 setCycle: Walk)
				(client setScript: 0)
			)
		)
	)
)

(instance sink of RPicView
	(properties
		y 141
		x 81
		view 173
		priority 9
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((Said 'look<in/sink')
				(Print 73 27) ; "There is nothing in the sink."
			)
			((or (MousedOn self event 3) (Said 'look/sink'))
				(event claimed: 1)
				(Print 73 28) ; "It's a basic pedestal sink."
			)
		)
	)
)

(instance toilet of RPicView
	(properties
		y 174
		x 271
		view 173
		cel 2
		priority 13
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/toilet')
				(Print 73 29) ; "You don't want to do that!"
			)
			((or (MousedOn self event 3) (Said 'look/toilet'))
				(event claimed: 1)
				(Print 73 30) ; "It does the job required of it."
			)
		)
	)
)

(instance bathtub of RPicView
	(properties
		y 151
		x 241
		view 173
		cel 1
		priority 10
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((Said 'look<in/shower')
				(if local3
					(Print 73 31) ; "Clarence is lying in the bathtub... dead!"
				else
					(Print 73 32) ; "The bathtub is empty."
				)
			)
			((or (MousedOn self event 3) (Said 'look/shower'))
				(event claimed: 1)
				(if local3
					(Print 73 31) ; "Clarence is lying in the bathtub... dead!"
				else
					(Print 73 33) ; "The claw-footed bathtub has a shower attached to it."
				)
			)
		)
	)
)

(instance settie of RPicView
	(properties
		y 125
		x 161
		view 173
		cel 3
		priority 9
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/bench')
				(Print 73 34) ; "The seat doesn't open."
			)
			((or (MousedOn self event 3) (Said 'look/chair,bench'))
				(event claimed: 1)
				(Print 73 7) ; "You notice a lovely seat under the large windows."
			)
		)
	)
)

(instance basket of RPicView
	(properties
		y 122
		x 117
		view 173
		cel 6
	)

	(method (handleEvent event)
		(cond
			((Said 'get/(basket[<wastepaper,garbage]),(can[<garbage])')
				(Print 73 35) ; "You can't get that."
			)
			((Said 'look<in/(basket[<wastepaper,garbage]),(can[<garbage])')
				(if (< (gEgo distanceTo: basket) 20)
					(if (>= gAct 5)
						(Print 73 3) ; "A small, empty bottle has been thrown into the wastebasket."
					else
						(Print 73 4) ; "Currently, it is empty."
					)
				else
					(NotClose) ; "You're not close enough."
				)
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/(basket[<wastepaper,garbage]),(can[<garbage])')
				)
				(event claimed: 1)
				(Print 73 36) ; "You see a wastepaper basket near the sink."
			)
		)
	)
)

(instance bra of Prop
	(properties
		y 148
		x 210
		view 19
		loop 3
	)
)

(instance towel of Prop
	(properties
		y 95
		x 91
		view 173
		cel 4
	)

	(method (handleEvent event)
		(cond
			((Said 'get/towel,(cloth<scrub)')
				(Print 73 37) ; "You don't need a towel...unless you're washing your hands."
			)
			((or (MousedOn self event 3) (Said 'look/towel,(cloth<scrub)'))
				(event claimed: 1)
				(Print 73 38) ; "A small hand towel hangs over the sink."
			)
		)
	)
)

(instance rope of Prop
	(properties
		y 134
		x 269
		view 173
		cel 5
	)
)

(instance Lilian of Act
	(properties
		y 134
		x 97
		view 505
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/lil'))
				(if (not (& global207 $0020))
					(|= global207 $0020)
					(= global213 6)
					(Say 0 73 39) ; "Your friend Lillian Prune, is a rebellious flapper. Like you, she is twenty years old, but unlike you, she has been known to hang out in speakeasies, smoke, and run around with several young men. She is assertive and out-going, to the point of obnoxiousness, but underneath it all you believe her to be a lonely, insecure girl."
				else
					(Print 73 40) ; "Your friend is freshening up in the bathroom."
				)
				(event claimed: 1)
			)
			((Said 'talk,ask,tell')
				(Print 73 41) ; "Lillian seems intent upon tidying up. She's not listening to you."
			)
			((Said 'show,give,get,kill,kiss,embrace,flirt>')
				(Room73 setScript: (ScriptID 243 0)) ; atsgl
				((Room73 script:) handleEvent: event)
			)
		)
	)
)

(instance Cabinet of RFeature
	(properties
		nsTop 95
		nsLeft 51
		nsBottom 152
		nsRight 67
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/armoire[<medicine,linen]')
				(Print 73 42) ; "There is nothing you need inside the linen cabinet."
			)
			((Said 'look<behind/armoire[<medicine,linen]')
				(Print 73 43) ; "There is nothihng there."
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/armoire[<medicine,linen]')
				)
				(event claimed: 1)
				(Print 73 44) ; "That's a linen cabinet."
			)
		)
	)
)

(instance Mirror of RFeature
	(properties
		nsTop 68
		nsLeft 68
		nsBottom 94
		nsRight 84
	)

	(method (handleEvent event)
		(cond
			((or (Said 'look<in/mirror') (Said 'look/reflection'))
				(if (< (gEgo distanceTo: sink) 40)
					(= global213 12)
					(Say 0 73 45) ; "You gaze into the mirror and appraise your appearance. A bit disheveled, perhaps, but not bad...considering the circumstances."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said 'look<(behind,below)/mirror')
				(Print 73 46) ; "There is nothing of interest behind the mirror."
			)
			((or (MousedOn self event 3) (Said 'look/mirror'))
				(event claimed: 1)
				(Print 73 47) ; "You see a dusty, old mirror hanging on the wall."
			)
		)
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 43
		nsLeft 98
		nsBottom 97
		nsRight 224
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance mySound of Sound
	(properties)
)

