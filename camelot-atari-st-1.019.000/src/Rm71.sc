;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 71)
(include sci.sh)
(use Main)
(use MoveForward)
(use n128)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm71 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
)

(procedure (localproc_0 param1)
	(gTObj actor: param1 noWidth: 1 tWindow: thingWindow tLoop: 5 cSpeed: 0)
	(if param1
		(gTObj talkCue: self)
	)
	(Talk &rest)
)

(procedure (localproc_1)
	(switch local4
		(4
			(Print 71 52) ; "The sound of the Thing gnashing at your apple is truly revolting. And what a waste of the Seeress' gift!"
		)
		(8
			(= local2 0)
		)
		(5
			(Print 71 53) ; "The Thing devours the elixir, vial and all. That was truly a foolilsh move. It does the creature no good, but leaves you with no protection from rat bite."
		)
		(2
			(Print 71 54) ; "I cannot imagine what possessed you to do such a mindless thing."
		)
		(9
			(Print 71 55) ; "From the sound of the ghoul's gnashing teeth, I would say it enjoyed even that old bone. Imagine how much more he would enjoy your own, fresh bones."
		)
	)
	(gEgo put: local4 gCurRoomNum)
	(= local4 0)
	(gEgo illegalBits: -16128 setLoop: -1 setPri: -1)
	(HandsOn)
)

(procedure (localproc_2 param1)
	(= local4 param1)
	(gEgo setScript: lookGetGive)
)

(procedure (localproc_3 param1 param2)
	(= local4 param1)
	(= local5 param2)
	(gEgo setScript: throwIt)
)

(procedure (localproc_4 param1 param2)
	(cond
		((or (not global140) (not (gEgo has: global140)))
			(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
			(param2 claimed: 1)
		)
		((not (and local0 (IsItemAt 11))) ; mirror | golden_apple
			(Print 71 56) ; "The Thing in the sarcophagus wants nothing further to do with you, fortunately."
			(param2 claimed: 1)
		)
		(
			(not
				(or
					(& (gEgo onControl:) $1000)
					(& (gEgo onControl:) $0800)
					param1
				)
			)
			(NotClose) ; "Perhaps you should move closer."
			(param2 claimed: 1)
		)
		(else
			(return 0)
		)
	)
)

(instance leftDoor of Act
	(properties
		y 29
		x 27
		yStep 7
		view 171
		signal 16384
		illegalBits 0
	)
)

(instance frontDoor of Act
	(properties
		y 80
		x 142
		yStep 7
		view 171
		loop 1
		signal 16384
		illegalBits 0
	)
)

(instance rightDoor of Act
	(properties
		y 32
		x 252
		yStep 7
		view 171
		loop 2
		signal 16384
		illegalBits 0
	)
)

(instance stoneLid of Act
	(properties
		y 152
		x 171
		view 171
		loop 3
		priority 15
		signal 18448
	)

	(method (doit)
		(super doit:)
		(if (not xStep)
			(if (> (gSFX prevSignal:) 127)
				(= x (+ 171 (- (gSFX prevSignal:) 128)))
			)
			(if (== (gSFX prevSignal:) 170)
				(egoBonesIt cue:)
				(= xStep 3)
			)
		)
	)
)

(instance thingWindow of SysWindow
	(properties
		color 10
		back 8
		title {The Thing}
		brTop 24
		brLeft 50
		brBottom 80
		brRight 200
	)
)

(instance Rm71 of Rm
	(properties
		picture 71
	)

	(method (init)
		(Load rsVIEW 47)
		(super init:)
		(= global112 1)
		(self setRegions: 125) ; Catacombs
		(= local1 (gEgo has: 8)) ; boar_spear | grain | medallion
		(switch gPrevRoomNum
			(68
				(gEgo posn: 21 145 loop: 0 setMotion: MoveForward 30)
			)
			(72
				(gEgo posn: 142 138 loop: 2 setMotion: MoveForward 5)
			)
			(else
				(gEgo posn: 282 152 loop: 1 setMotion: MoveForward 35)
			)
		)
		(stoneLid init: stopUpd:)
		(if (IsFlag 171)
			(ClearFlag 171)
			(gCurRoom setScript: closeDoors)
		)
		(gAddToPics doit:)
		(gTObj init:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			((or global80 (IsFlag 172)) 0)
			((& (= temp0 (gEgo onControl:)) $0020)
				(gEgo setMotion: LeaveRoom 68 1 25)
			)
			((& temp0 $0010)
				(gEgo setMotion: LeaveRoom 72 3 5)
			)
			((& temp0 $0040)
				(gEgo setMotion: LeaveRoom 73 0 25)
			)
			((not (IsItemAt 11)) 0) ; mirror | golden_apple
			((and (& temp0 $0200) (== local0 0))
				(stoneLid setScript: egoBonesIt 0 4)
			)
			((and (& temp0 $1000) (== local1 0))
				(= local1 1)
				(Print 71 0) ; "Do not go too close, Arthur, I beg you! a ghoul is not to be trusted."
				(gEgo setMotion: 0)
			)
			((and (& temp0 $0800) (== local2 0) (== (gEgo script:) 0))
				(cond
					((gEgo has: 8) ; boar_spear | grain | medallion
						(theThing setScript: getScared)
					)
					((< (gEgo y:) 166)
						(gEgo setScript: egoBonesIt 0 1)
					)
					(else
						(gEgo setScript: egoBonesIt 0 0)
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((and local0 (Said 'ask[/thing,demon]/grail,galahad'))
				(Print 71 1) ; "You will learn nothing from this long-dead fiend in the sarcophagus."
			)
			(
				(or
					(Said 'look,read/carving,lid')
					(Said 'ask[/merlin]/carving,lid')
					(Said 'read/barrow')
				)
				(if
					(and
						(> (gEgo y:) 159)
						(<
							(- (stoneLid x:) 30)
							(gEgo x:)
							(+ (stoneLid x:) 85)
						)
					)
					(SetScore 282 1 1)
					(Print 71 2) ; "Below the pentacle are carved these words..."
					(Print 71 3) ; "Cursed is the priest who lies here. He betrayed the Goddess and stole her treasures. Sacred objects of gold he has stolen."
					(Print 71 4) ; "By the sign of the pentacle, he is imprisoned. The star of the Goddess rules him. Take heed, you who read these words of warning."
				else
					(Print 71 5) ; "The light is too dim to make out the inscription from here."
				)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(Said 'look<in,in[/barrow]')
							(OnButton event 95 141 250 182)
						)
						(cond
							((not local0)
								(Print 71 6) ; "The lid of the sarcophagus is closed."
							)
							((not (gEgo has: 8)) ; boar_spear | grain | medallion
								(Print 71 7) ; "You cannot look inside it from here and I do not advise getting closer."
							)
							(else
								(gEgo setScript: lookGetGive)
							)
						)
					)
					((Said 'look<below/barrow')
						(Print 71 8) ; "That is quite impossible. It is solid stone."
					)
					((Said 'look<above/barrow')
						(Print 71 9) ; "There is nothing upon the other side of the sarcophagus but a blank wall."
					)
					(
						(or
							(Said 'look[<!*][/room,catacomb]')
							(Said '//room,catacomb')
							(Said 'look<around')
							(Said 'look<at/room,catacomb')
						)
						(Print 71 10) ; "There are three doorways and colorful patterns upon the walls. There are no mummies or funeral urns here, only the one large, stone sarcophagus."
					)
					((Said 'look/thing,demon')
						(cond
							((not local0)
								(Print 71 11) ; "What ARE you babbling about?"
							)
							((not local2)
								(Print 71 12) ; "Nay, Arthur! Let your curiosity rest. Draw no closer, I beg you!"
							)
							(else
								(Print 71 13) ; "It crouches in the dark end of the sarcophagus, gibbering, grinding its hideous teeth and smelling of putrefaction, a vile and demented creature."
							)
						)
					)
					((Said '//thing,demon')
						(Print 71 14) ; "Whatever its origins, it is clearly evil and hungers for that which is still alive."
					)
					((or (Said '/barrow') (Said '//barrow'))
						(Print 71 15) ; "It is solid stone, carved with geometric designs on the sides. There is something different upon the lid, however."
					)
					((or (Said '/lid') (Said '//lid'))
						(if
							(and
								(> (gEgo y:) 160)
								(< (- (stoneLid x:) 68) (gEgo x:))
							)
							(Print 71 16) ; "There is a pentacle carved upon it and an inscription in Latin below that."
						else
							(Print 71 17) ; "The light is too dim to make it out from here."
						)
					)
					(
						(or
							(Said '/pentacle,star')
							(Said '//pentacle,star')
							(OnButton event 135 57 155 71)
						)
						(Print 71 18) ; "It is the five-pointed star or pentacle that is associated with the Goddess."
						(Print 71 19) ; "And because it is formed of one unbroken line, it is used to keep out harmful spirits. Or to lock them in."
					)
					((or (Said '/design') (Said '//design'))
						(Print 71 20) ; "There are many colourful geometric patterns painted upon the walls and doorways."
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 71 21) ; "One wall has geometric designs painted upon it and a pentacle over one door. The other three walls are barren."
					)
					((OnButton event 126 7 170 24)
						(Print 71 22) ; "It is...well, frankly, Arthur, I do not know what it is. I do not know EVERYTHING."
					)
					((or (Said '/beam,canter') (Said '//beam,canter'))
						(Print 71 23) ; "There are some support beams sticking out of the wall over one door."
					)
				)
			)
			((Said 'close/lid')
				(if local0
					(Print 71 24) ; "The lid is under the control of the Thing inside. I guarantee you could not move it."
				else
					(Print 71 25) ; "It IS shut."
				)
			)
			((and local0 (Said 'draw/blade')) 0)
			((Said 'open/lid,barrow')
				(if local0
					(Print 71 26) ; "It is already open."
				else
					(Print 71 27) ; "The stone lid is heavy and undoubtedly better left in place."
				)
			)
			(
				(and
					(Said 'give,throw>')
					(gEgo has: global140)
					(not (IsItemAt 11)) ; mirror | golden_apple
				)
				(Print 71 28) ; "The thing in the sarcophagus wants nothing further to do with you, fortunately."
				(event claimed: 1)
			)
			((and (gEgo has: 8) (Said 'use,show,hold,read/medal')) ; boar_spear | grain | medallion
				(Print 71 29) ; "Merely possessing the medallion is protection enough. The fiend will know it is there."
			)
			((Said 'get/thing,demon')
				(Print 71 30) ; "It is more likely to get you, were you to attempt such folly."
			)
			((and (not local0) (Said 'reach<in,in,in/barrow'))
				(Print 71 31) ; "The sarcophagus is closed."
			)
			(
				(or
					(Said 'get,rob/apple[<golden,dinar]')
					(Said 'reach<in,in,in/barrow')
				)
				(cond
					((and local0 (gEgo has: 8) (IsItemAt 11)) ; boar_spear | grain | medallion, mirror | golden_apple
						(= local3 1)
						(gEgo setScript: lookGetGive)
					)
					((not (gEgo has: 8)) ; boar_spear | grain | medallion
						(Print 71 32) ; "If what you seek is in the sarcophagus, it is guarded by the Thing."
					)
					((not (IsItemAt 11)) ; mirror | golden_apple
						(Print 71 33) ; "There was but one and you took it."
					)
					((not local0)
						(Print 71 11) ; "What ARE you babbling about?"
					)
				)
			)
			((Said 'get/lid,barrow')
				(Print 71 34) ; "Impractical, not to mention impossible."
			)
			((Said 'kill,attack,annihilate/thing,demon')
				(Print 71 35) ; "You cannot kill that which is already dead."
			)
		)
	)
)

(instance theThing of Act
	(properties
		view 47
	)

	(method (init)
		(super init:)
		(self setPri: 14 ignoreActors: 1 illegalBits: 0)
		(= local15 1)
	)

	(method (doit)
		(super doit:)
		(if local14
			(if (and (> (- (self y:) local7) 152) (< (self y:) 160))
				(self y: 152)
			else
				(self y: (- (self y:) local7))
				(if (> local7 -12)
					(-= local7 local8)
				else
					(= local7 -12)
				)
			)
			(if (> (self y:) 160)
				(= local7 0)
			)
		)
		(if (and local15 (== (gSFX prevSignal:) 170))
			(self setScript: egoBonesIt 0 2)
			(ClearFlag 288)
			(= local15 0)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(Said 'greet')
					(Said 'talk[/thing,demon,demon,creature]')
					(Said 'ask/thing,demon,creature,creature')
				)
				(if local0
					(if (not local2)
						(localproc_0 0 71 36 71 37) ; "Yes, come closer. I will show you my golden treasure. Do not be afraid."
					else
						(localproc_0 0 71 38) ; "Sssssst! Begone! The accursed Goddess protects you. Begone!"
					)
				)
			)
			((Said 'give>')
				(if (not (localproc_4 0 event))
					(cond
						((Said '/medal')
							(if (not local6)
								(= local6 1)
								(Print 71 39) ; "Your source of protection? Are you mad!?"
							else
								(Print 71 40) ; "How could I have raised you to be such a fool?"
								(localproc_2 8)
							)
						)
						((Said '/apple,elixer,grail,lodestone,bone')
							(localproc_2 global140)
						)
					)
				)
			)
			((Said 'throw>')
				(if (not (localproc_4 (& (gEgo onControl:) $0200) event))
					(event claimed: 1)
					(switch global140
						(8
							(if (not local6)
								(= local6 1)
								(Print 71 39) ; "Your source of protection? Are you mad!?"
							else
								(Print 71 40) ; "How could I have raised you to be such a fool?"
								(localproc_3 8 8)
							)
						)
						(4
							(localproc_3 4 3)
						)
						(5
							(localproc_3 5 7)
						)
						(2
							(localproc_3 2 5)
						)
						(9
							(localproc_3 9 4)
						)
						(else
							(event claimed: 0)
						)
					)
				)
			)
			((and (Said 'get>') (IsItemAt global140))
				(event claimed: 1)
				(switch global140
					(2
						(if (gEgo has: 8) ; boar_spear | grain | medallion
							(= local3 2)
							(gEgo setScript: lookGetGive)
						else
							(Print 71 41) ; "Arthur, do not tempt fate by trifling with this ghoul."
						)
					)
					(9
						(Print 71 42) ; "There is nothing left to get."
					)
					(5
						(Print 71 43) ; "The Thing drank it then ate the glass vial."
					)
					(4
						(Print 71 42) ; "There is nothing left to get."
					)
					(8
						(if (not local16)
							(= local16 1)
							(Print 71 44) ; "Without the medallion around your neck, you are no longer protected from the Thing. You were a fool to part with it."
						else
							(= local3 2)
							(gEgo setScript: lookGetGive)
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance getScared of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global109 6)
				(= local2 1)
				(theThing
					startUpd:
					setCycle: Fwd
					posn: 133 174
					setLoop: 5
					setMotion: MoveTo 133 156 self
				)
			)
			(1
				(localproc_0 theThing 71 45) ; "Screeeeeaaaagh! The accursed pentacle!"
			)
			(2
				(theThing setLoop: 4 setCycle: End self)
			)
			(3
				(theThing stopUpd:)
				(= global109 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookGetGive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (or local3 local4)
					(= global109 6)
				)
				(= local1 1)
				(gEgo illegalBits: 0)
				(cond
					((< (gEgo y:) 166)
						(gEgo setMotion: MoveTo 135 165 self)
					)
					((> (gEgo x:) 200)
						(gEgo setMotion: MoveTo 264 165 self)
					)
					(else
						(gEgo setMotion: MoveTo 94 165 self)
					)
				)
			)
			(1
				(if (!= (gEgo x:) 135)
					(gEgo setMotion: MoveTo 135 165 self)
				else
					(self cue:)
				)
			)
			(2
				(gEgo illegalBits: -16128 setLoop: 2)
				(cond
					((and (not local2) (gEgo has: 8)) ; boar_spear | grain | medallion
						(self setScript: getScared self)
					)
					((not local2)
						(gEgo setScript: egoBonesIt 0 1)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(if (or local3 local4)
					(self cue:)
				else
					(Print 71 46) ; "The Thing has retreated from the warding spell of the medallion. There is a glint of gold at this end of the sarcophagus."
					(Print 71 47) ; "I believe....aye, it is a golden apple."
					(gEgo setLoop: -1 setPri: -1)
					(HandsOn)
					(self dispose:)
				)
			)
			(5
				(gEgo
					setPri: 14
					posn: 138 147
					setLoop: 1
					view: 44
					cel: 0
					setCycle: End self
				)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo setPri: -1 view: 0 posn: 135 165 setLoop: 2)
				(= cycles 2)
			)
			(8
				(if local4
					(self cue:)
				else
					(if (!= local3 2)
						(Print 71 48) ; "An apple of solid gold! I wonder how often the fiend has used it as a lure."
						(SetScore 0 0 5)
						(gEgo get: 11) ; mirror | golden_apple
						(theThing dispose:)
						(stoneLid setScript: egoBonesIt 0 5)
					else
						(Print 71 49) ; "Hang onto it this time, Arthur."
						(gEgo get: 2) ; lodestone
						(HandsOn)
					)
					(gEgo illegalBits: -16128 setLoop: -1 setPri: -1)
					(= local3 0)
					(= global109 0)
					(self dispose:)
				)
			)
			(9
				(= global109 0)
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance throwIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global109 6)
				(theThing startUpd: xStep: 12 yStep: 12)
				(if (& (gEgo onControl:) $0200)
					(= local7 30)
					(= local8 6)
				else
					(= local7 20)
					(= local8 4)
				)
				(gEgo cel: 0 view: 44)
				(if (< (gEgo x:) 127)
					(gEgo setLoop: 0)
					(theThing posn: (+ (gEgo x:) 10) (- (gEgo y:) 28))
				else
					(gEgo setLoop: 9)
					(theThing posn: (- (gEgo x:) 12) (- (gEgo y:) 29))
				)
				(gEgo setCycle: CT 4 1 self)
			)
			(1
				(gEgo cel: 5)
				(theThing
					view: 44
					setLoop: local5
					setCycle: Fwd
					setMotion: MoveTo 130 190
				)
				(= local14 1)
				(= cycles 2)
			)
			(2
				(if (== (gEgo loop:) 0)
					(gEgo setLoop: 0)
				else
					(gEgo setLoop: 2)
				)
				(gEgo view: 0)
				(theThing setMotion: MoveTo 130 190 self)
			)
			(3
				(= local14 0)
				(theThing
					view: 47
					xStep: 1
					yStep: 1
					loop: 4
					setLoop: -1
					setCycle: 0
					cel: 3
					posn: 133 152
					stopUpd:
				)
				(= global109 0)
				(localproc_1)
				(gEgo setCycle: Walk setLoop: -1)
				(self dispose:)
			)
		)
	)
)

(instance egoBonesIt of Script
	(properties)

	(method (init)
		(super init: &rest)
		(switch register
			(2
				(self changeState: 4)
			)
			(1
				(= local9 130)
				(= local11 165)
				(= local13 0)
				(= local10 130)
				(= local12 148)
				(self changeState: 1)
			)
			(0
				(= local9 95)
				(= local11 170)
				(= local13 2)
				(= local10 99)
				(= local12 154)
				(self changeState: 1)
			)
			(4
				(= local9 213)
				(= local13 256)
				(self changeState: 9)
			)
			(5
				(= local9 171)
				(= local13 0)
				(self changeState: 9)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 3) (== (gSFX prevSignal:) -1))
			(= global109 0)
			(EgoDead 71 50) ; "Alas, curiosity killed the King. Even the worms will go hungry by the time the ghoul is finished with you."
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(= global109 6)
				(gEgo
					setLoop: -1
					setPri: -1
					illegalBits: 0
					setMotion: MoveTo local9 local11 self
				)
			)
			(2
				(gSFX priority: 10 number: 72 loop: 1 play:)
				(gEgo
					view: 47
					setLoop: (+ local13 global124)
					setPri: 14
					posn: local10 local12
					cycleSpeed: 1
					cel: 0
					setCycle: End self
				)
			)
			(3
				(stoneLid startUpd: xStep: 3 setMotion: MoveTo 171 152)
			)
			(4
				(HandsOff)
				(= global109 6)
				(theThing
					view: 47
					setLoop: 5
					setCycle: Fwd
					posn: 133 174
					setMotion: MoveTo 133 152 self
				)
			)
			(5
				(= seconds 2)
			)
			(6
				(localproc_0 theThing 71 51) ; "I smell warm blood and live flesh. Come closer. I have golden treasure. Come closer and see."
			)
			(7
				(HandsOn)
				(theThing setLoop: 4 setCycle: End self)
			)
			(8
				(theThing stopUpd:)
				(= global109 0)
				(self dispose:)
			)
			(9
				(HandsOff)
				(if local13
					(gSFX priority: 10 number: 71 loop: 1 play:)
					(SetFlag 288)
				)
				(stoneLid xStep: (if local13 0 else 3) startUpd:)
				(if local0
					(stoneLid setMotion: MoveTo local9 152 self)
				)
				(stoneLid setMotion: MoveTo local9 152 self)
				(= local0 (not local0))
			)
			(10
				(gEgo illegalBits: (| $c000 local13) setLoop: -1 setPri: -1)
				(HandsOn)
				(client setMotion: 0 stopUpd:)
				(if local13
					(theThing init:)
				else
					(theThing dispose:)
				)
				(self dispose:)
			)
		)
	)
)

(instance closeDoors of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (not global80))
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo illegalBits: -2)
				(leftDoor
					setLoop: 0
					setPri: 0
					init:
					setMotion: MoveTo (leftDoor x:) 86
				)
				(frontDoor
					setLoop: 1
					setPri: 0
					init:
					setMotion: MoveTo (frontDoor x:) 134 self
				)
				(rightDoor
					setLoop: 2
					setPri: 0
					init:
					setMotion: MoveTo (rightDoor x:) 92
				)
				(gSFX number: (proc0_20 84) loop: 1 play:)
			)
			(2
				(gSFX stop: number: (proc0_20 87) loop: 1 play:)
				(client setScript: 0)
			)
		)
	)
)

