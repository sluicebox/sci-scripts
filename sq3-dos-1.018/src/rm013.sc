;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Interface)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm013 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm013 of Rm
	(properties
		picture 13
		style 0
		horizon 10
	)

	(method (init &tmp [temp0 50])
		(HandsOn)
		(Load rsSCRIPT 991)
		(= local3 991)
		(Load rsVIEW 17)
		(Load rsVIEW 26)
		(Load rsVIEW 752)
		(Load rsVIEW 852)
		(Load rsVIEW 10)
		(Load rsVIEW 289)
		(if (== global135 3)
			(Load rsVIEW 260)
			(Load rsVIEW 261)
		else
			(Load rsVIEW 22)
			(Load rsVIEW 23)
		)
		(Load rsSOUND 35)
		(Load rsSOUND 45)
		(Load rsSOUND 52)
		(Load rsSOUND 53)
		(if (not global160)
			(= global160 226)
		)
		(if (!= gPrevRoomNum 12)
			(= global132 3)
		)
		(super init:)
		(bot init:)
		(HandsOn)
		(gEgo setStep: -1 1)
		(if (== global132 3)
			(gEgo
				view: 0
				posn: 304 111
				setStep: 3
				setPri: 9
				init:
				setScript: railWalkScript
			)
			(grabber
				loop: (if (== global135 3) 1 else 0)
				setStep: 3 1
				posn: global160 104
				init:
				stopUpd:
			)
		else
			(gEgo setScript: grabScript)
		)
	)

	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(if
					(and
						(not gHandsOff)
						(== (User controls:) 1)
						(!= global132 6)
					)
					(gEgo
						setMotion:
							MoveTo
							(cond
								((< (event x:) 30) -30)
								((> (event x:) 295) 330)
								(else
									(event x:)
								)
							)
							(gEgo y:)
					)
					(event claimed: 1)
				)
			)
			(evSAID
				(if (Said 'look>')
					(cond
						((Said '/android')
							(Print 13 0) ; "It's not a model you've seen before. The droid appears to be dedicated to this work station. It seems harmless enough."
						)
						((Said '/comp,console,(device<monitoring)')
							(Print 13 1) ; "It is similar to the one you are currently viewing. The only difference is that you can't read what it says."
						)
						((Said '/device,grabber,console[<control]')
							(if (or (== global132 4) (== global132 5))
								(Print 13 2) ; "Your view of the grabber from here reveals a Forward/Reverse control stick (currently grasped), and a button marked CLAW."
							else
								(Print 13 3) ; "A grabber hangs beneath a rail. There is a seat for a driver. There is a claw underneath that looks capable of grabbing things."
							)
						)
						((Said '/motivator,artifact')
							(if (== global135 3)
								(if (or (== global132 4) (== global132 5))
									(Print 13 4) ; "Your viewing angle doesn't allow that."
								else
									(Print 13 5) ; "It's hanging peacefully under the grabber."
								)
							else
								(Print 13 6) ; "Your not able to make it out here."
							)
						)
						((Said 'look/throttle,control,stick')
							(if (or (== global132 4) (== global132 5))
								(Print 13 7) ; "You are grasping the control stick in your hand."
							else
								(Print 13 8) ; "It looks like your standard directional control."
							)
						)
						((Said '/claw[<grabber]')
							(if (== global132 6)
								(Print 13 9) ; "The claw looks very much like something which would bear the name 'claw'. A set of opposing appendages is designed to grip an object by applying pressure from about its circumference in the direction of its center."
							else
								(Print 13 4) ; "Your viewing angle doesn't allow that."
							)
						)
						((Said '/chair[<grabber,device]')
							(if (or (== global132 4) (== global132 5))
								(Print 13 10) ; "You seem to be covering all available seat surface area making viewing impossible."
							else
								(Print 13 11) ; "It looks like something that would cradle your posterior nicely."
							)
						)
						((Said '/system,pedestal,bin')
							(if global133
								(Print 13 12) ; "On the south side of the room is a chute. A platform extends from its edge."
							else
								(Print 13 13) ; "On the south side of the room is a chute which leads to who-knows-where. A platform extends from its edge."
							)
						)
						((Said '/banister,banister')
							(Print 13 14) ; "The rail is supported by beams hanging from the ceiling. The grabber hangs below it."
						)
						((Said 'look/partition')
							(Print 13 15) ; "The walls are made of metal and very strong composite materials commonly used in spacecraft."
						)
						((Said '[<at,around,in][/area,!*]')
							(if (or (== global132 4) (== global132 5))
								(Print 13 16) ; "In this room the rail makes a U-turn. There is a chute at the bottom. In the middle are panels of monitoring devices being tended to by a droid."
							else
								(Print 13 17) ; "In this room the rail makes a U-turn. There is a machine here which hangs under the rail. There is a chute at the bottom. In the middle are panels of monitoring devices being tended to by a droid."
							)
						)
						((Said '/lamp<grabber,device,safety')
							(if (or (== global132 4) (== global132 5))
								(Print 13 18) ; "The safety light on top of the grabber indicates that it is currently in use."
							else
								(Print 13 19) ; "There is a safety light on top of the grabber. It is currently dark."
							)
						)
						(
							(or
								(Said '[<down]/dirt,deck')
								(Said '<down[/dirt,deck]')
							)
							(Print 13 20) ; "More metal decking."
						)
						(
							(or
								(Said '[<up,above]/ceiling')
								(Said '<up,above[/ceiling]')
							)
							(Print 13 21) ; "The ceiling looks closer from up here. It looks no more spectacular, however."
						)
					)
				)
				(if (Said 'yell,talk/android')
					(Print 13 22) ; "It apparently isn't designed to process input from you."
				)
				(if (Said 'hit,kill/android')
					(Print 13 23) ; "You are not equipped to mar this metal moron, nor do you need to."
				)
				(if
					(or
						(Said 'climb[<up][/grabber,device]')
						(Said 'climb/banister,banister<up<to')
						(Said 'climb<up,on/banister,banister')
					)
					(Print 13 24) ; "You aren't able to do that."
				)
				(if (Said 'enter,(go<in,in)/system')
					(Print 13 25) ; "Go there yourself."
				)
				(if
					(or
						(Said 'enter,board[/device,grabber,chair]')
						(Said 'get<on,in,onto,down/[device,grabber,chair]')
						(Said
							'climb[<on,in,onto,in,down][/device,grabber,chair]'
						)
					)
					(cond
						((or (== global132 5) (== global132 4))
							(Print 13 26) ; "Think again."
						)
						((gEgo inRect: global160 110 (+ global160 40) 116)
							(gEgo setScript: ontoGrabScript)
						)
						((== global132 6)
							(gEgo setScript: grabScript)
						)
						(else
							(Print 13 27) ; "Not from here."
						)
					)
				)
				(if
					(or
						(Said
							'pull,press,use,manipulate,go[<forward,backward,back][/stick,throttle,control,knob]'
						)
						(Said
							'start,manipulate,drive[<forward,backward,back]/grabber,device'
						)
					)
					(Print 13 28) ; "Just move as you've been moving."
				)
				(if
					(Said
						'disembark,(stand[<up]),(climb,get<off,out)[/grabber,device,claw,!*]'
					)
					(if (or (== global132 5) (== global132 4))
						(cond
							((gEgo mover:)
								(Print 13 29) ; "You must bring the grabber to a complete stop before doing that."
							)
							((gEgo inRect: 126 103 154 107)
								(gEgo setScript: platformScript)
							)
							(else
								(Print 13 30) ; "You're not in a satisfactory location for performing that act."
							)
						)
					else
						(Print 13 31) ; "You're not on it."
					)
				)
			)
			($0040 ; direction
				(if (or gHandsOff (and (!= global132 4) (!= global132 5)))
					(return)
				)
				(switch (event message:)
					(JOY_UP
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_DOWN
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_UPLEFT
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_UPRIGHT
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_DOWNRIGHT
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_DOWNLEFT
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= local0 3)
			(if (== newRoomNumber 15)
				(gLongSong fade:)
			)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit)
		(if
			(and
				(not local2)
				(or
					(gEgo inRect: 35 103 260 105)
					(gEgo inRect: 143 74 237 78)
					(== global132 6)
				)
			)
			(= local2 15)
		)
		(if
			(and
				(> local2 2)
				(not (gEgo inRect: 35 103 260 105))
				(not (gEgo inRect: 143 74 237 78))
				(!= global132 6)
			)
			(= local2 0)
		)
		(if (and (> local2 2) global219)
			(-- local2)
		)
		(if (and (== (bot script:) botPanelScript) (== local2 2))
			(= local2 1)
			(cond
				((or (gEgo inRect: 35 103 260 105) (== global132 6))
					(bot setScript: frontZapScript)
				)
				((gEgo inRect: 143 74 237 78)
					(bot setScript: backZapScript)
				)
				(else
					(= local2 0)
				)
			)
		)
		(super doit:)
	)
)

(instance botPanelScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bot setLoop: 0 cel: 0 cycleSpeed: 4 setCycle: End self)
			)
			(1
				(bot cel: 0)
				(= seconds (Random 7 12))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance frontZapScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bot cycleSpeed: 0 setCycle: End self)
			)
			(1
				(= cycles 15)
			)
			(2
				(bot setLoop: 1 cel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(3
				(bot setLoop: 3 setCycle: Walk setMotion: MoveTo 165 127 self)
			)
			(4
				(bot
					cel: 255
					loop:
						(cond
							((== global132 6) 3)
							((< (gEgo x:) (- (bot x:) 20)) 1)
							((> (gEgo x:) (+ (bot x:) 45)) 2)
							(else 3)
						)
					setCycle: Beg self
				)
			)
			(5
				(= seconds 3)
			)
			(6
				(if
					(and
						(== local2 1)
						(or
							(gEgo inRect: 35 103 260 105)
							(and (== global132 6) (== (gEgo view:) 0))
						)
					)
					(bot
						cel: 0
						loop:
							(cond
								((== global132 6) 7)
								((< (gEgo x:) (- (bot x:) 20)) 4)
								((> (gEgo x:) (+ (bot x:) 45)) 5)
								(else 7)
							)
						setCycle: End self
					)
					(zotSound play:)
				else
					(bot cel: 0 setCycle: End self)
				)
			)
			(7
				(if (> (bot loop:) 2)
					(if
						(and
							(== local0 0)
							(or
								(gEgo inRect: 35 103 260 105)
								(== global132 6)
							)
						)
						(= local0 3)
						(HandsOff)
						(if (== global132 4)
							(grabber
								view: 752
								loop: (if (== global135 3) 1 else 0)
								posn: (gEgo x:) (gEgo y:)
								setMotion: 0
								init:
							)
						)
						(gEgo hide:)
						(zot
							x:
								(if (!= global132 6)
									(+ (gEgo x:) 11)
								else
									(gEgo x:)
								)
							y:
								(if (!= global132 6)
									(+ (gEgo y:) 45)
								else
									(- (gEgo y:) 6)
								)
							init:
						)
					)
					(= cycles 15)
					(ShakeScreen 5)
				else
					(= cycles 2)
				)
			)
			(8
				(if (gCast contains: zot)
					(zot dispose:)
					(RedrawCast)
					(gEgo dispose:)
					(Print 13 32) ; "You really bit the beam, Buckwheat. And there's that lack of regard for organics in action again. I guess they never heard of the warning shot concept around here. Anyway, you're dead."
					(EgoDead 901 0 10 14)
				else
					(bot
						setLoop: 3
						setCycle: Walk
						setMotion: MoveTo 165 109 self
					)
				)
			)
			(9
				(bot setLoop: 1 cel: 255 setCycle: Beg self)
			)
			(10
				(= local2 0)
				(bot setScript: botPanelScript)
			)
		)
	)
)

(instance backZapScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bot cycleSpeed: 0 setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(bot setLoop: 9 cel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(3
				(bot setLoop: 8 setCycle: Walk setMotion: MoveTo 192 100 self)
			)
			(4
				(= seconds 3)
			)
			(5
				(if (and (== local2 1) (gEgo inRect: 143 74 237 78))
					(HandsOff)
					(bot cel: 0 setCycle: End self)
					(zotSound play:)
				else
					(bot setCycle: Walk setMotion: MoveTo 165 109 self)
				)
			)
			(6
				(if (< (bot y:) 105)
					(grabber
						view: 752
						posn: (gEgo x:) (gEgo y:)
						setLoop: (if (== global135 3) 3 else 2)
						init:
						setPri: (gEgo priority:)
						setMotion: 0
					)
					(gEgo hide:)
					(zot posn: (+ (gEgo x:) 7) (+ (gEgo y:) 24) init:)
					(ShakeScreen 5)
					(= cycles 15)
				else
					(bot setLoop: 9 cel: 255 setCycle: Beg self)
				)
			)
			(7
				(if (gCast contains: zot)
					(zot dispose:)
					(RedrawCast)
					(gEgo dispose:)
					(Print 13 32) ; "You really bit the beam, Buckwheat. And there's that lack of regard for organics in action again. I guess they never heard of the warning shot concept around here. Anyway, you're dead."
					(EgoDead 901 0 10 14)
				else
					(bot setLoop: 0 cel: 0 setScript: botPanelScript)
					(= local2 0)
				)
			)
		)
	)
)

(instance railWalkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1)
			)
			(1
				(gEgo
					view: 17
					setLoop: (gEgo loop:)
					cel: 0
					x:
						(if (< (gEgo x:) 22)
							22
						else
							(gEgo x:)
						)
					setMotion: 0
					illegalBits: 0
					setCycle: End self
				)
			)
			(2
				(gEgo
					setPri: (if (< (gEgo y:) 113) 8 else 9)
					setStep: 3 20
					setMotion: MoveTo (gEgo x:) 220 self
				)
				(gLongSong number: 45 loop: 1 play:)
			)
			(3
				(= local4 (Print 13 33 #dispose)) ; "You stepped off the rail! You're dead again. Way to go. Haven't we taught you anything?"
				(= seconds 5)
			)
			(4
				(cls)
				(EgoDead 901 0 0 1)
			)
		)
	)

	(method (doit)
		(cond
			((and (== (gEgo view:) 0) (!= (gEgo onControl: 1) 16384))
				(self changeState: 1)
				(HandsOff)
				(= global100 1)
			)
			((> (gEgo x:) 316)
				(gEgo setMotion: 0)
				(gCurRoom newRoom: 12)
			)
		)
		(super doit:)
	)
)

(instance ontoGrabScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global100 1)
				(HandsOff)
				(if (== global132 3)
					(gEgo
						view: 289
						posn: (+ global160 7) (gEgo y:)
						cel: 0
						setMotion: 0
						cycleSpeed: 2
						setCycle: End self
					)
				else
					(self changeState: 2)
				)
			)
			(1
				(= cycles 5)
			)
			(2
				(grabber dispose:)
				(HandsOn)
				(gEgo setScript: grabScript)
				(= global100 0)
			)
		)
	)
)

(instance grabScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global132 5)
					(gEgo
						view: (if (== global135 3) 261 else 23)
						setPri: 7
						posn: 242 76
						setStep: 2 1
						init:
						setMotion: MoveTo -40 76
					)
					(User prevDir: 7)
				else
					(gEgo setStep: 3 1 setPri: 9 y: 104)
					(if (== global132 4)
						(gEgo
							x: 313
							init:
							setMotion: MoveTo -40 (gEgo y:)
						)
						(User prevDir: 7)
					else
						(gEgo
							view: (if (== global135 3) 260 else 22)
							loop: 0
							cel: 0
						)
						(if (== global132 6)
							(gEgo x: (grabber x:))
							(grabber dispose:)
						else
							(gEgo x: global160)
						)
						(= global132 4)
					)
				)
				(gEgo setCycle: Fwd)
				(= cycles 2)
			)
			(1
				(if (< (gEgo x:) 230)
					(Print 13 34) ; "Plopping into the seat, you grasp the forward/backward control of the grabber."
				)
			)
			(2
				(HandsOff)
				(User canControl: 0 canInput: 1)
				(gEgo
					view: 26
					setPri: 7
					setLoop: (if (!= global135 3) 2 else 5)
					illegalBits: 0
					posn: -9 102
					setStep: 1 2
					setMotion: MoveTo -9 96 self
				)
			)
			(3
				(gEgo
					setLoop: (if (!= global135 3) 1 else 4)
					posn: -6 94
					setStep: 5 1
					setMotion: MoveTo 59 81 self
				)
			)
			(4
				(gEgo
					view: (if (== global135 3) 261 else 23)
					setPri: -1
					setLoop: -1
					loop: 0
					setStep: 2 1
					posn: 132 76
					illegalBits: $8000
				)
				(= seconds 2)
			)
			(5
				(gEgo setMotion: MoveTo 321 76)
				(= global100 0)
				(HandsOn)
				(= global132 5)
				(User prevDir: 3)
			)
			(6
				(HandsOff)
				(User canControl: 0 canInput: 1)
				(= seconds 2)
			)
			(7
				(gEgo
					view: 26
					setLoop: (if (!= global135 3) 0 else 3)
					setStep: 5 1
					posn: 59 81
					setMotion: MoveTo -6 94 self
				)
			)
			(8
				(gEgo
					setLoop: (if (!= global135 3) 2 else 5)
					posn: -9 96
					setStep: 1 2
					setMotion: MoveTo -9 102 self
				)
			)
			(9
				(gEgo
					view: (if (== global135 3) 260 else 22)
					setLoop: -1
					loop: 0
					setPri: 9
					setStep: 3 1
					illegalBits: $8000
					posn: -8 104
					setMotion: MoveTo 322 104
				)
				(HandsOn)
				(= global132 4)
				(= global100 0)
				(User prevDir: 3)
			)
		)
	)

	(method (doit)
		(if (not gHandsOff)
			(cond
				((not (gEgo mover:))
					(cond
						((and (== global132 4) (!= (gEgo loop:) 0))
							(gEgo loop: 0)
						)
						((and (== global132 5) (!= (gEgo loop:) 1))
							(gEgo loop: 1)
						)
					)
					(if (== (gLongSong state:) 3)
						(gLongSong stop:)
					)
				)
				((== global132 4)
					(cond
						(
							(and
								(== (gEgo loop:) 0)
								(or
									(!= (gLongSong number:) 52)
									(!= (gLongSong state:) 3)
								)
							)
							(gLongSong stop: number: 52 play:)
						)
						(
							(and
								(== (gEgo loop:) 1)
								(or
									(!= (gLongSong number:) 53)
									(!= (gLongSong state:) 3)
								)
							)
							(gLongSong stop: number: 53 play:)
						)
					)
				)
				((== global132 5)
					(cond
						(
							(and
								(== (gEgo loop:) 1)
								(or
									(!= (gLongSong number:) 52)
									(!= (gLongSong state:) 3)
								)
							)
							(gLongSong stop: number: 52 play:)
						)
						(
							(and
								(== (gEgo loop:) 0)
								(or
									(!= (gLongSong number:) 53)
									(!= (gLongSong state:) 3)
								)
							)
							(gLongSong stop: number: 53 play:)
						)
					)
				)
			)
		)
		(if (not global100)
			(if (== global132 4)
				(if (< (gEgo x:) -8)
					(= global100 1)
					(HandsOff)
					(self changeState: 2)
				)
				(if (> (gEgo x:) 316)
					(gEgo setMotion: 0)
					(gCurRoom newRoom: 12)
				)
			)
			(if (== global132 5)
				(if (< (gEgo x:) 132)
					(= global100 1)
					(HandsOff)
					(self changeState: 6)
				)
				(if (> (gEgo x:) 255)
					(gEgo setMotion: 0)
					(gCurRoom newRoom: 12)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp [temp0 100])
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) global100 (event claimed:))
			(return)
		)
		(if
			(or
				(Said 'lower/claw[<grabber]')
				(Said 'use,press,press/claw,button')
			)
			(Print 13 35) ; "The button is programmed not to work in this area."
		)
	)
)

(instance platformScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global160 (gEgo x:))
				(grabber x: (gEgo x:) y: (gEgo y:) init:)
				(= global160 (gEgo x:))
				(gEgo
					view: 0
					loop: 2
					posn: 154 152
					setPri: 14
					cycleSpeed: 0
					setMotion: 0
					setCycle: Walk
					setStep: 3 2
				)
				(= global132 6)
			)
			(1
				(HandsOff)
				(gEgo
					view: 17
					setLoop: (gEgo loop:)
					cel: 0
					illegalBits: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(2
				(if (!= local0 3)
					(= local0 1)
					(gEgo setCycle: 0)
					(if (gEgo inRect: 99 168 190 172)
						(gEgo setStep: 3 20 setMotion: MoveTo 148 229 self)
					else
						(gEgo
							setPri: 9
							setStep: 5 20
							setMotion: MoveTo (gEgo x:) 230 self
						)
						(self state: 4)
					)
					(gLongSong number: 45 loop: 1 play:)
				)
			)
			(3
				(gEgo hide:)
				(Timer setCycle: self 2)
			)
			(4
				(if (not global133)
					(gGame changeScore: 5)
				)
				(gCurRoom newRoom: 15)
			)
			(5
				(Print 13 36) ; "We haven't seen footwork like that since Gerald Ford! Unfortunately, your fall causes you to make contact with the non-moving deck below. The resulting impact forces the cancellation of your subscription to life."
				(EgoDead 901 0 0 1)
			)
		)
	)

	(method (doit)
		(if global100
			(return)
		)
		(super doit:)
		(if (or (== (gEgo onControl: 0) 5) (gEgo inRect: 99 168 190 172))
			(self changeState: 1)
			(= global100 1)
		)
	)
)

(instance grabber of Act
	(properties
		view 752
	)

	(method (init)
		(super init:)
		(self setStep: 3 1 setPri: 9 ignoreActors: 1)
	)
)

(instance bot of Act
	(properties
		view 10
	)

	(method (init)
		(super init:)
		(self
			cel: 0
			loop: 0
			posn: 165 109
			setPri: 8
			illegalBits: 0
			ignoreActors: 1
			setScript: botPanelScript
		)
	)
)

(instance zot of View
	(properties
		view 10
	)

	(method (init)
		(super init:)
		(self loop: 6 ignoreActors: 1 setPri: 15)
	)
)

(instance zotSound of Sound
	(properties
		number 35
		priority 1
	)
)

