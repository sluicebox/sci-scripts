;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use Gaza)
(use eRoom)
(use Interface)
(use Motion)
(use System)

(public
	Rm38 0
)

(local
	local0
	local1
	local2
)

(instance Rm38 of eRoom
	(properties
		picture 38
	)

	(method (init)
		(Load rsPIC 112)
		(self
			style:
				(switch global103
					(0 100)
					(1 15)
					(2 17)
				)
		)
		(super init:)
		(proc0_13 65)
		(gAddToPics doit:)
		(self setRegions: 107) ; Gaza
		(gEgo init:)
		(switch gPrevRoomNum
			(55
				(self comingIn: 0)
				(ClearFlag 98)
				(gEgo loop: 0 posn: 160 160 setScript: beenABadBoy)
			)
			(46
				(self enterRoom: 240 -5 240 60)
				(if (IsFlag 20)
					(gMuleObj loop: 2)
					(self muleEnterRoom: 210 0 210 75)
				)
			)
			(42
				(self enterRoom: 185 235 185 182)
				(if (IsFlag 20)
					(gMuleObj loop: 3)
					(self muleEnterRoom: 160 230 160 180)
				)
			)
			(39
				(self enterRoom: 320 120 290 120)
				(if (IsFlag 20)
					(gMuleObj loop: 1)
					(self muleEnterRoom: 325 130 280 130)
				)
			)
			(else
				(if (== global189 3)
					(if global124
						(= local1 4)
					)
					((ScriptID 130 0) ; Jabir
						view: 389
						posn: 127 170
						init:
						setCycle: Walk
						setScript: (if (not global124) followMe else 0)
					)
					((ScriptID 130 1) ignoreActors: 1 posn: 155 175 hide:) ; jabirHead
				)
				(self enterRoom: -10 120 50 120)
				(if (IsFlag 20)
					(gMuleObj loop: 0)
					(self muleEnterRoom: -5 105 65 105)
				)
			)
		)
		(if (== global189 9)
			(= local1 3)
			((ScriptID 130 0) ; Jabir
				view: 399
				setLoop: 0
				setCel: 5
				setStep: 2 1
				illegalBits: 0
				posn: 65 80
				init:
			)
		)
	)

	(method (doit)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				((and global169 (== local1 4))
					(= global189 8)
					(= local1 3)
					(SetFlag 126)
					((ScriptID 130 0) setScript: (ScriptID 114 0)) ; Jabir, run
				)
				((and global169 (< local1 1))
					(= local1 1)
					(HandsOff)
				)
				((> (gEgo x:) 310)
					(if (== global189 3)
						(= global189 0)
					)
					(if global169
						(cond
							((not ((ScriptID 130 0) script:)) ; Jabir
								(= local0 39)
								((ScriptID 130 0) setScript: whereYaGoing) ; Jabir
							)
							((not local0)
								(self leaveRoom: 39 320 (gEgo y:))
							)
						)
					else
						(self leaveRoom: 39 320 (gEgo y:))
					)
				)
				((< (gEgo x:) 10)
					(if (== global189 3)
						(= global189 0)
					)
					(if global169
						(cond
							((not ((ScriptID 130 0) script:)) ; Jabir
								(= local0 37)
								((ScriptID 130 0) setScript: whereYaGoing) ; Jabir
							)
							((not local0)
								(self leaveRoom: 37 -10 (gEgo y:))
							)
						)
					else
						(self leaveRoom: 37 -10 (gEgo y:))
					)
				)
				((> (gEgo y:) 185)
					(if (== global189 3)
						(= global189 4)
					)
					(self leaveRoom: 42 (gEgo x:) 235)
				)
				((< (gEgo y:) 40)
					(if (== global189 3)
						(= global189 0)
					)
					(if global169
						(cond
							((not ((ScriptID 130 0) script:)) ; Jabir
								(= local0 46)
								((ScriptID 130 0) setScript: whereYaGoing) ; Jabir
							)
							((not local0)
								(self leaveRoom: 46 (gEgo x:) -5)
							)
						)
					else
						(self leaveRoom: 46 (gEgo x:) -5)
					)
				)
				(
					(and
						(== local1 1)
						(or
							(< (gEgo distanceTo: (ScriptID 130 0)) 40) ; Jabir
							(> (gEgo y:) ((ScriptID 130 0) y:)) ; Jabir
						)
					)
					(= local1 2)
					((ScriptID 130 0) setScript: Gone) ; Jabir
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((and global169 (< global189 8) (Said 'draw/blade'))
				(= local2 1)
				(= local1 3)
				(= global189 8)
				((ScriptID 130 0) setScript: (ScriptID 114 0)) ; Jabir, run
				(event claimed: 0)
			)
			(
				(and
					global169
					(or (Said 'talk,ask[/hamid][/*]') (Said 'tell[/me][/*]'))
				)
				(Talk 38 0) ; "In this heat, you must waste no breath upon idle chatter."
				(event claimed: 1)
			)
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
			((Said 'get,move,lift/column,ruin')
				(Print 38 1) ; "It is too deeply buried."
			)
			((or (Said 'read/column,ruin,lettering') (Said 'look/lettering'))
				(Print 38 2) ; "The markings on the ancient pillar have been obliterated with the passage of time."
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
							(Said '/desert,gaza,terrain')
							(Said '//desert,gaza,terrain')
						)
						(Print 38 3) ; "Your way is blocked upon one side by cliffs. The rest upon all sides is desert."
					)
					(
						(or
							(Said '/cliff,mesa')
							(Said '//cliff,mesa')
							(OnButton event 0 0 160 80)
							(OnButton event 0 0 70 180)
						)
						(Print 38 4) ; "The high cliffs continue to one side of you."
					)
					(
						(or
							(OnButton event 125 120 152 139)
							(OnButton event 200 118 213 128)
							(OnButton event 236 143 255 150)
						)
						(proc107_2)
					)
					(
						(or
							(Said '/column,ruin')
							(Said '//column,ruin')
							(OnButton event 251 81 303 105)
						)
						(Print 38 5) ; "It appears to be a chunk of very ancient pillar, partially buried."
					)
				)
			)
		)
	)
)

(instance beenABadBoy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 5)
			)
			(1
				(Print 38 6) ; "Now that you have trudged far from the city walls, what have you to show for it? Nothing. You are lost in the blistering desert without water once again."
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance followMe of Script
	(properties)

	(method (doit)
		(if (and (== state 2) (not (gCurRoom comingIn:)))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 130 0) setMotion: MoveTo 155 175 self) ; Jabir
			)
			(1
				((ScriptID 130 0) ; Jabir
					view: 392
					setLoop: 8
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				((ScriptID 130 1) show:) ; jabirHead
				((ScriptID 130 0) setLoop: 0 setCycle: End) ; Jabir
			)
			(3
				((ScriptID 130 1) hide:) ; jabirHead
				(gTObj talkCue: self)
				(Talk 38 7) ; "Good, you are here. But stay close behind me or you may get lost."
				((ScriptID 130 0) setLoop: 1 setCycle: CT 4 1) ; Jabir
			)
			(4
				((ScriptID 130 0) setCycle: Beg self) ; Jabir
			)
			(5
				(gTObj talkCue: self)
				(Talk 38 8) ; "This way, habib. We must go directly to the water."
				((ScriptID 130 1) show:) ; jabirHead
				((ScriptID 130 0) setLoop: 3 setCycle: End) ; Jabir
			)
			(6
				((ScriptID 130 0) setCycle: Beg self) ; Jabir
			)
			(7
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance Gone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 130 1) hide:) ; jabirHead
				((ScriptID 130 0) ; Jabir
					view: 389
					setLoop: -1
					cycleSpeed: 0
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 168 235 self
				)
			)
			(1
				(= local1 3)
				((ScriptID 130 0) dispose:) ; Jabir
			)
		)
	)
)

(instance whereYaGoing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(gTObj talkCue: self)
				(Talk 38 9) ; "Where are you going? Follow me!"
			)
			(1
				(switch local0
					(37
						(gCurRoom leaveRoom: 37 -10 (gEgo y:))
					)
					(39
						(gCurRoom leaveRoom: 39 320 (gEgo y:))
					)
					(46
						(gCurRoom leaveRoom: 46 (gEgo x:) -5)
					)
				)
				(client setScript: 0)
			)
		)
	)
)

