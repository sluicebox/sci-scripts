;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Gaza)
(use eRoom)
(use Interface)
(use Motion)
(use System)

(public
	Rm37 0
)

(local
	local0
	local1
)

(instance Rm37 of eRoom
	(properties
		picture 37
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
		(self setRegions: 107) ; Gaza
		(proc0_13 65)
		(gAddToPics doit:)
		(gEgo init:)
		(switch gPrevRoomNum
			(38
				(self enterRoom: 320 120 290 120)
				(if (IsFlag 20)
					(gMuleObj loop: 1)
					(self muleEnterRoom: 330 140 280 120)
				)
			)
			(else
				(self enterRoom: 193 235 193 182)
				(if (== global189 2)
					(if global124
						(= local1 4)
					)
					((ScriptID 130 0) ; Jabir
						view: 392
						posn: 232 126
						setLoop: 3
						cel: 0
						cycleSpeed: 1
						init:
					)
					((ScriptID 130 1) ; jabirHead
						ignoreActors: 1
						posn: 232 126
						setLoop: 9
						cel: 0
						setCycle: End
					)
				)
				(if (IsFlag 20)
					(gMuleObj loop: 3)
					(self muleEnterRoom: 220 230 220 180)
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
				posn: 55 190
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
					((ScriptID 130 0) setScript: followMe) ; Jabir
				)
				((> (gEgo x:) 310)
					(if (== global189 2)
						(= global189 3)
					)
					(self leaveRoom: 38 320 (gEgo y:))
				)
				((> (gEgo y:) 185)
					(if (< global189 9)
						(= global189 0)
					)
					(if global169
						(cond
							((not ((ScriptID 130 0) script:)) ; Jabir
								((ScriptID 130 0) setScript: whereYaGoing) ; Jabir
							)
							((!= ((ScriptID 130 0) script:) whereYaGoing) ; Jabir
								(self leaveRoom: 36 (gEgo x:) 235)
							)
						)
					else
						(self leaveRoom: 36 (gEgo x:) 235)
					)
				)
				(
					(and
						(== local1 1)
						(or
							(< (gEgo distanceTo: (ScriptID 130 0)) 40) ; Jabir
							(and (< (gEgo y:) 176) (> (gEgo x:) 250))
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
			((and global169 (< global189 8) (Said 'draw/blade'))
				(= local0 1)
				((ScriptID 130 0) setScript: (ScriptID 114 0)) ; Jabir, run
				(= local1 3)
				(= global189 8)
				(event claimed: 0)
			)
			((and global169 (or (Said 'talk,ask[/hamid]>') (Said 'tell[/me]>')))
				(cond
					(
						(or
							(Said '/desert,gaza,terrain,canyon')
							(Said '//desert,gaza,terrain,canyon')
						)
						(Talk 37 0) ; "From here you can go either into the desert or back the way you came."
					)
					((or (Said '/cliff,mesa') (Said '//cliff,mesa'))
						(Talk 37 1) ; "Follow me and I will lead you free of the cliffs."
					)
					(else
						(Talk 37 2) ; "In this heat, you must waste no breath upon idle chatter."
						(event claimed: 1)
					)
				)
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
							(Said '/desert,gaza,terrain,canyon')
							(Said '//desert,gaza,terrain,canyon')
						)
						(if (IsFlag 106)
							(Print 37 3) ; "Arthur, Arthur, why are you here?. You should be back in Jerusalem by now."
						else
							(Print 37 4) ; "This area is enclosed by cliffs. There are but two openings...back to the ridge overlooking Gaza or into the desert."
						)
					)
					((OnButton event 178 114 200 129)
						(proc107_2)
					)
					(
						(or
							(Said '/cliff,mesa')
							(Said '//cliff,mesa')
							(OnButton event 0 0 309 108)
							(OnButton event 265 126 309 181)
							(OnButton event 0 108 42 188)
						)
						(Print 37 5) ; "The cliffs are formidably high."
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
				(HandsOff)
				((ScriptID 130 1) setCycle: Beg) ; jabirHead
				((ScriptID 130 0) setCycle: End self) ; Jabir
			)
			(1
				((ScriptID 130 1) setLoop: 7) ; jabirHead
				(gTObj talkCue: self)
				(Talk 37 6) ; "This way, habib. Follow me."
			)
			(2
				(HandsOn)
				((ScriptID 130 0) setCycle: Beg) ; Jabir
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
					setMotion: MoveTo 325 136 self
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
				(Talk 37 7) ; "Where are you going? Follow me!"
			)
			(1
				(gCurRoom leaveRoom: 36 (gEgo x:) 235)
				(client setScript: 0)
			)
		)
	)
)

