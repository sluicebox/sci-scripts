;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use Gaza)
(use eRoom)
(use Interface)
(use Motion)
(use System)

(public
	Rm42 0
)

(local
	local0
	local1
	local2
)

(instance Rm42 of eRoom
	(properties
		picture 42
	)

	(method (init)
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
			(43
				(self enterRoom: 223 235 223 182)
				(if (IsFlag 20)
					(self muleEnterRoom: 190 220 190 175)
				)
			)
			(44
				(self enterRoom: 320 115 290 115)
				(if (IsFlag 20)
					(self muleEnterRoom: 320 125 285 125)
				)
			)
			(else
				(if (== global189 4)
					(if global124
						(= local2 4)
					)
					((ScriptID 130 0) ; Jabir
						view: 389
						posn: 221 73
						init:
						setCycle: Walk
						setScript: (if (not global124) followMe else 0)
					)
					((ScriptID 130 1) ignoreActors: 1 posn: 264 80 hide:) ; jabirHead
				)
				(self enterRoom: 175 -5 175 60)
				(if (IsFlag 20)
					(self muleEnterRoom: 195 -5 195 50)
				)
			)
		)
		(if (== global189 9)
			(= local2 3)
			((ScriptID 130 0) ; Jabir
				view: 399
				setLoop: 0
				setCel: 5
				setStep: 2 1
				illegalBits: 0
				posn: 40 80
				init:
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				((and global169 (== local2 4))
					(= global189 8)
					(= local2 3)
					(SetFlag 126)
					((ScriptID 130 0) setScript: (ScriptID 114 0)) ; Jabir, run
				)
				((and global169 (< local2 1) (not (gEgo script:)))
					(= local2 1)
					(HandsOff)
				)
				((> (gEgo x:) 310)
					(if (== global189 4)
						(= global189 5)
					)
					(if global169
						(cond
							((not ((ScriptID 130 0) script:)) ; Jabir
								(= local0 44)
								((ScriptID 130 0) setScript: whereYaGoing) ; Jabir
							)
							((not local0)
								(self leaveRoom: 44 320 (gEgo y:))
							)
						)
					else
						(self leaveRoom: 44 320 (gEgo y:))
					)
				)
				((> (gEgo y:) 185)
					(if (== global189 4)
						(= global189 0)
					)
					(if global169
						(cond
							((not ((ScriptID 130 0) script:)) ; Jabir
								(= local0 43)
								((ScriptID 130 0) setScript: whereYaGoing) ; Jabir
							)
							((not local0)
								(self leaveRoom: 43 (gEgo x:) 235)
							)
						)
					else
						(self leaveRoom: 43 (gEgo x:) 235)
					)
				)
				((< (gEgo y:) 22)
					(if (== global189 4)
						(= global189 0)
					)
					(if global169
						(cond
							((not ((ScriptID 130 0) script:)) ; Jabir
								(= local0 38)
								((ScriptID 130 0) setScript: whereYaGoing) ; Jabir
							)
							((not local0)
								(self leaveRoom: 38 (gEgo x:) -5)
							)
						)
					else
						(self leaveRoom: 38 (gEgo x:) -5)
					)
				)
				(
					(and
						(== local2 1)
						(or
							(< (gEgo distanceTo: (ScriptID 130 0)) 40) ; Jabir
							(and (> (gEgo x:) 220) (> (gEgo y:) 55))
						)
					)
					(= local2 2)
					((ScriptID 130 0) setScript: Gone) ; Jabir
				)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((and global169 (< global189 8) (Said 'draw/blade'))
				(= local1 1)
				(= local2 3)
				(= global189 8)
				((ScriptID 130 0) setScript: (ScriptID 114 0)) ; Jabir, run
				(event claimed: 0)
			)
			(
				(and
					global169
					(or (Said 'talk,ask[/hamid][/*]') (Said 'tell[/me][/*]'))
				)
				(Talk 42 0) ; "In this heat, you must waste no breath upon idle chatter."
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
						(Print 42 1) ; "Upon one side are tall cliffs. Upon the other side, open desert."
					)
					(
						(or
							(Said '/cliff,mesa')
							(Said '//cliff,mesa')
							(OnButton event 0 0 90 189)
						)
						(Print 42 2) ; "Tall cliffs block you on one side."
					)
					(
						(or
							(OnButton event 127 13 160 22)
							(OnButton event 230 23 270 33)
							(OnButton event 211 33 306 55)
							(OnButton event 281 128 319 189)
							(OnButton event 117 133 140 147)
						)
						(proc107_2)
					)
				)
			)
		)
	)
)

(instance followMe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 130 0) setMotion: MoveTo 264 80 self) ; Jabir
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
				((ScriptID 130 0) setLoop: 0 setCycle: End self) ; Jabir
			)
			(3
				((ScriptID 130 1) hide:) ; jabirHead
				(gTObj talkCue: self)
				(Talk 42 3) ; "Come, the water is not much farther."
				((ScriptID 130 0) setLoop: 1 setCycle: CT 4 1) ; Jabir
			)
			(4
				((ScriptID 130 0) setCycle: Beg self) ; Jabir
			)
			(5
				(gTObj talkCue: self)
				(Talk 42 4) ; "This way, habib. Follow me."
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
					setMotion: MoveTo 320 80 self
				)
			)
			(1
				(= local2 3)
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
				(Talk 42 5) ; "Where are you going? Follow me!"
			)
			(1
				(switch local0
					(38
						(gCurRoom leaveRoom: 38 (gEgo x:) -5)
					)
					(43
						(gCurRoom leaveRoom: 43 (gEgo x:) 235)
					)
					(44
						(gCurRoom leaveRoom: 44 320 (gEgo y:))
					)
				)
				(client setScript: 0)
			)
		)
	)
)

