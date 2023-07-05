;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room16 0
)

(synonyms
	(ignite lamp)
)

(local
	local0
	local1
	local2
)

(instance Room16 of Rm
	(properties
		picture 16
	)

	(method (init)
		(= south 22)
		(= west 15)
		(= east 17)
		(= north 37)
		(= horizon 115)
		(super init:)
		(if gDetailLevel
			(Lamp setCycle: Fwd init:)
			(Lamp2 setCycle: Fwd init:)
		else
			(Lamp addToPic:)
			(Lamp2 addToPic:)
		)
		(gAddToPics add: Knocker eachElementDo: #init doit:)
		(self setRegions: 206 setFeatures: Knocker Window1 Window2 Mat) ; houseOReg
		(LoadMany rsSOUND 43 44 128)
		(if (== gAct 7)
			(if (!= global203 500)
				(Note
					illegalBits: 0
					ignoreActors: 1
					ignoreHorizon: 1
					init:
					stopUpd:
				)
			)
			(Rover init: setScript: bark)
		)
		(Door cel: (if (== gPrevRoomNum 37) 3 else 0) init: stopUpd:)
		(if (== global102 1)
			(if (== gPrevRoomNum 15)
				(gEgo posn: 1 124)
			else
				(gEgo posn: 318 124)
			)
		)
		(= local2 (IsFirstTimeInRoom))
		(switch gPrevRoomNum
			(37
				(HandsOff)
				(gEgo posn: 145 121)
				(if (not local2)
					(self setScript: exit)
				)
			)
			(22
				(gEgo posn: 160 188)
			)
			(17
				(if global102
					(gEgo posn: 310 126)
				)
			)
		)
		(gEgo view: 0 illegalBits: -32766 init:)
	)

	(method (doit)
		(if local2
			(= local2 0)
			(Print 16 0) ; "You are standing in front of the old plantation house right by the front door."
			(if (== gPrevRoomNum 37)
				(self setScript: exit)
			)
		)
		(if (and (== gPrevRoomNum 37) (not local1) (== (Door cel:) 0))
			(= local1 1)
			(Door stopUpd:)
		)
		(if (< (gEgo y:) 140)
			(= global102 1)
		else
			(= global102 0)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0004)
				(not local0)
				(== (gEgo loop:) 3)
			)
			(= local0 1)
			(self setScript: myDoor)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 37)
			(gConMusic stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 16 0) ; "You are standing in front of the old plantation house right by the front door."
						)
						((Said '/stair')
							(Print 16 1) ; "Cracked stone steps lead up to the front door of the mansion."
						)
						((Said '/down')
							(if global102
								(Print 16 2) ; "You see the boards that make up the porch."
							else
								(event claimed: 0)
							)
						)
						((Said '/up')
							(Print 16 3) ; "You look upwards at the second-story gallery."
						)
					)
				)
				((Said 'drop/room')
					(= gDetailLevel 0)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance myDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(gEgo loop: 3)
				(Door cycleSpeed: 1 ignoreActors: 1 setCycle: End self)
				(myMusic number: 43 loop: 1 priority: 5 play:)
			)
			(1
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 50)
				)
			)
		)
	)
)

(instance bark of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 5) (== (Rover cel:) 0))
			(if (<= (DoSound sndCHECK_DRIVER) 3)
				(myBark number: 128)
			)
			(myBark loop: 1 play: self)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gConMusic stop:)
				(Rover loop: 3 cycleSpeed: 1 setCycle: Fwd)
				(= cycles 12)
			)
			(2
				(Rover loop: 5 cel: 0 setCycle: End self)
			)
			(3
				(Rover loop: 6 setCycle: Fwd)
				(= cycles 12)
			)
			(4
				(Rover loop: 5 cel: 1 setCycle: Beg self)
			)
			(5
				(Rover loop: 4 setCycle: End)
			)
			(6
				(Rover setCycle: Beg)
				(if (< (Random 1 100) 40)
					(= state 4)
				else
					(= state 1)
				)
				(= cycles 1)
			)
		)
	)
)

(instance blowAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global203 500)
				(Print 16 4) ; "Oh, no! A sudden gust of wind blows away the note."
				(Note
					setLoop: 4
					setStep: 5 5
					setCycle: Fwd
					setMotion: MoveTo 330 105 self
				)
			)
			(1
				(Note dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance exit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Door setCycle: Beg self)
				(myMusic number: 44 loop: 1 priority: 5 play:)
			)
			(1
				(Door stopUpd:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance Lamp of Prop
	(properties
		y 65
		x 116
		view 116
		loop 2
		priority 14
	)

	(method (handleEvent event)
		(cond
			((Said 'get/ignite')
				(Print 16 5) ; "You cannot remove them. They're firmly attached to the wall."
			)
			((or (MousedOn self event 3) (Said 'look/ignite'))
				(event claimed: 1)
				(Print 16 6) ; "The porch lights help to brighten this dreary house."
			)
		)
	)
)

(instance Lamp2 of Prop
	(properties
		y 65
		x 204
		view 116
		loop 2
		priority 14
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 16 6) ; "The porch lights help to brighten this dreary house."
		)
	)
)

(instance Door of Prop
	(properties
		y 116
		x 136
		view 116
		priority 8
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/door'))
			(event claimed: 1)
			(Print 16 7) ; "The front door of the old house is badly weathered."
		)
	)
)

(instance Note of Act
	(properties
		y 86
		x 172
		view 116
		loop 3
	)

	(method (handleEvent event)
		(if (!= global203 500)
			(cond
				((Said 'look/door,doorknocker')
					(Print 16 8) ; "What's this? A note has been attached to the doorknocker."
				)
				((Said 'get/letter')
					(Print 16 9) ; "Why don't you read it first?"
				)
				((or (Said 'read,look/letter') (MousedOn self event 3))
					(event claimed: 1)
					(if (gEgo inRect: 158 115 186 126)
						(Print 16 10) ; "You read the note. It says, "Meet me in the hedge garden.""
						(self setScript: blowAway)
					else
						(NotClose) ; "You're not close enough."
					)
				)
			)
		)
	)
)

(instance Rover of Act
	(properties
		y 120
		x 112
		view 520
		loop 4
	)

	(method (handleEvent event)
		(cond
			((Said 'pat,get,move/beauregard')
				(Print 16 11) ; "Beauregard doesn't look like he's in a good mood."
			)
			((Said 'feed/beauregard')
				(Print 16 12) ; "He doesn't seem very hungry right now."
			)
			(
				(or
					(Said 'give,feed,show/*[/beauregard]')
					(Said 'give,feed,show/*<beauregard')
				)
				(if (and global219 global224)
					(Print 16 12) ; "He doesn't seem very hungry right now."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said 'talk,calm/beauregard')
				(Print 16 13) ; "You try to calm the dog with soft words but it doesn't do any good."
			)
			((or (MousedOn self event 3) (Said '*/beauregard'))
				(event claimed: 1)
				(Print 16 14) ; "Beauregard seems agitated about something. Maybe you should investigate."
			)
		)
	)
)

(instance Knocker of RPicView
	(properties
		y 86
		x 172
		view 116
		loop 1
	)

	(method (handleEvent event)
		(cond
			((Said 'what/doorknocker<big')
				(Print 16 15) ; "Why, thank you, doctor."
			)
			(
				(or
					(Said 'bang/[<door,doorknocker]')
					(Said 'use/doorknocker[<door]')
				)
				(Print 16 16) ; "There's no need to knock. Just go into the house!"
			)
			((or (MousedOn self event 3) (Said 'look/doorknocker'))
				(event claimed: 1)
				(Print 16 17) ; "Those are a couple of ghoulish-looking doorknockers!"
			)
		)
	)
)

(instance myBark of Sound
	(properties
		number 32
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 36
		nsLeft 34
		nsBottom 113
		nsRight 66
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 36
		nsLeft 253
		nsBottom 113
		nsRight 285
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance Mat of RFeature
	(properties
		nsTop 120
		nsLeft 139
		nsBottom 124
		nsRight 178
	)

	(method (handleEvent event)
		(cond
			((Said 'move,get/doormat,(door<doormat)')
				(Print 16 18) ; "You wouldn't want to carry that old thing around!"
			)
			((Said 'lift,(look<below)/doormat,(door<doormat)')
				(Print 16 19) ; "There is nothing under the doormat."
			)
			((or (MousedOn self event 3) (Said 'look/doormat,(door<doormat)'))
				(event claimed: 1)
				(Print 16 20) ; "It's just an old doormat."
			)
		)
	)
)

(instance Wind of Sound ; UNUSED
	(properties)
)

(instance myMusic of Sound
	(properties)
)

