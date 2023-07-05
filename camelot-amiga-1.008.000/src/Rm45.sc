;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Gaza)
(use n128)
(use eRoom)
(use Interface)
(use Motion)
(use System)

(public
	Rm45 0
)

(local
	local0
	local1
)

(instance Rm45 of eRoom
	(properties
		picture 45
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
		(Load rsVIEW 60)
		(super init:)
		(proc0_13 65)
		(gAddToPics doit:)
		(self setRegions: 107) ; Gaza
		(SetFlag 82)
		(gEgo init:)
		(switch gPrevRoomNum
			(40
				(self enterRoom: 90 -5 90 60)
				(if (IsFlag 20)
					(self muleEnterRoom: 130 -5 130 45)
				)
				(if (== global189 6)
					(if global124
						(= local1 4)
					)
					((ScriptID 130 0) ; Jabir
						view: 392
						setLoop: 1
						cel: 0
						illegalBits: 0
						posn: 33 68
						init:
						setScript: (if (not global124) followMe else 0)
					)
					((ScriptID 130 1) posn: 33 68 hide:) ; jabirHead
					((ScriptID 130 2) ; jabirWindow
						brTop: 90
						brLeft: 110
						brBottom: 150
						brRight: 270
					)
				)
			)
			(else
				(self enterRoom: -10 65 45 65)
				(if (IsFlag 20)
					(self muleEnterRoom: -5 55 40 55)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
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
				((< (gEgo x:) 10)
					(if (== global189 6)
						(= global189 7)
					)
					(ClearFlag 82)
					(self leaveRoom: 44 -10 (gEgo y:))
				)
				((< (gEgo y:) 20)
					(if (== global189 6)
						(= global189 0)
					)
					(ClearFlag 82)
					(if global169
						(cond
							((not ((ScriptID 130 0) script:)) ; Jabir
								((ScriptID 130 0) setScript: whereYaGoing) ; Jabir
							)
							((!= ((ScriptID 130 0) script:) whereYaGoing) ; Jabir
								(self leaveRoom: 40 (gEgo x:) -5)
							)
						)
					else
						(self leaveRoom: 40 (gEgo x:) -5)
					)
				)
				((and (== local1 1) (< (gEgo x:) 60))
					(= local1 2)
					((ScriptID 130 0) setScript: Gone) ; Jabir
				)
			)
		)
		(if (and (== (gEgo onControl: 1) 2) (not local0))
			(= local0 1)
			(gEgo setScript: fall)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'talk/hamid[/!*]')
				(if global169
					(Talk 45 0) ; "We are very close to the pool where this water collects. Follow me."
				else
					(Print 45 1) ; "He is not here."
				)
			)
			((and global169 (Said 'draw/blade'))
				(= local1 3)
				(= global189 9)
				((ScriptID 130 0) setScript: (ScriptID 114 0)) ; Jabir, run
				(event claimed: 0)
			)
			((and global169 (or (Said 'talk,ask[/hamid]>') (Said 'tell[/me]>')))
				(cond
					(
						(or
							(Said '/terrain,water,spring')
							(Said '//terrain,water,spring')
						)
						(Talk 45 2) ; "This trickle of water in the wadi flows into a pool further down. That is where we wish to go."
					)
					(
						(or
							(Said '/wadi,canyon,oasis')
							(Said '//wadi,canyon,oasis')
						)
						(Talk 45 3) ; "There is a pool at the end of this wadi. Follow me."
					)
					(else
						(Talk 45 4) ; "We must not waste time with idle chatter, habib. You must come with me."
						(event claimed: 1)
					)
				)
			)
			(
				(or
					(Said 'ask/merlin[/advice]')
					(Said 'ask/advice[<merlin][/!*]')
					(Said 'talk/merlin[/!*]')
				)
				(Print 45 5) ; "Do not fall into this wadi. It looks treacherous."
			)
			((Said 'get,drink/water')
				(if global169
					(Talk 45 6) ; "Not here! Follow me to the pool."
				else
					(Print 45 7) ; "The side of the wadi is steep and unsafe. This is not a good place to try to reach the water, but it must flow down to an easier place."
				)
			)
			((Said 'climb,slide[/water,spring,pool,wadi]')
				(if global169
					(Talk 45 8) ; "No, no, that is trickier than you think. Follow me to where you can easily drink from this water."
				else
					(Print 45 9) ; "Do not try it! The ground may give way, or you may find yourself unable to climb out."
				)
			)
			((or (Said 'look<down') (Said 'look/dirt'))
				(Print 45 10) ; "The wadi drops off steeply. Do not fall into it."
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
							(Said '/terrain,water,spring')
							(Said '//terrain,water,spring')
						)
						(Print 45 11) ; "Water bubbles from the ground and flows down from this wadi. Be careful you do not fall into it. You might not be able to climb out again."
					)
					(
						(or
							(OnButton event 6 38 25 77)
							(OnButton event 6 100 31 111)
							(OnButton event 6 111 63 133)
							(OnButton event 6 133 78 189)
							(OnButton event 78 160 125 189)
							(OnButton event 149 165 165 189)
							(OnButton event 165 148 187 189)
							(OnButton event 187 136 200 189)
							(OnButton event 200 124 319 189)
							(OnButton event 273 96 319 124)
							(OnButton event 123 65 138 74)
							(OnButton event 147 29 190 44)
						)
						(proc107_2)
					)
					((or (Said '/crack') (Said '//crack'))
						(Print 45 12) ; "The fissures are not deep, and there is nothing in them."
					)
					(
						(or
							(Said '/siloam,pool,aquaduct,hezakiah,tunnel')
							(Said '//siloam,pool,aquaduct,hezakiah,tunnel')
						)
						(if (IsFlag 111)
							(Print 45 13) ; "You have seen the Pool of Siloam and Hezekiah's aqueduct. This stream must come from the same source."
						else
							(Print 45 14) ; "What odd things you babble about. Clearly, the heat is affecting your brain."
						)
					)
					(
						(or
							(Said '/wadi,canyon,oasis')
							(Said '//wadi,canyon,oasis')
						)
						(Print 45 15) ; "This seems to be what the Arabs call a wadi, but you are not in a safe place to reach the water. If you follow it, it should lead to more level ground."
					)
				)
			)
		)
	)
)

(instance fall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsFlag 20)
					(gMuleObj setMotion: 0)
				)
				(gEgo
					view: 60
					setLoop: 0
					setCel: 0
					posn: (+ (gEgo x:) 5) (+ (gEgo y:) 2)
				)
				(= cycles 2)
			)
			(1
				(gEgo setCel: 1 posn: (+ (gEgo x:) 3) (+ (gEgo y:) 1))
				(= cycles 2)
			)
			(2
				(gEgo setCel: 2 posn: (+ (gEgo x:) 9) (+ (gEgo y:) 3))
				(= cycles 2)
			)
			(3
				(gEgo setCel: 3 posn: (+ (gEgo x:) 9) (+ (gEgo y:) 15))
				(= cycles 2)
			)
			(4
				(gEgo posn: (+ (gEgo x:) 11) (+ (gEgo y:) 36))
				(= cycles 10)
			)
			(5
				(EgoDead 45 16) ; "You have managed to stumble off the crumbling edge and crack open your head upon a rock.          Wadi shame."
			)
		)
	)
)

(instance followMe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 20)
			)
			(1
				((ScriptID 130 0) setCycle: End self) ; Jabir
			)
			(2
				((ScriptID 130 1) show:) ; jabirHead
				(gTObj talkCue: self)
				(Talk 45 17) ; "You must follow me this way. There is a pool of fresh water over here."
			)
			(3
				((ScriptID 130 1) hide:) ; jabirHead
				((ScriptID 130 0) setCycle: Beg self) ; Jabir
			)
			(4
				((ScriptID 130 1) show:) ; jabirHead
				((ScriptID 130 0) setLoop: 0 cel: 2) ; Jabir
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
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo -5 60 self
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
				(Talk 45 18) ; "Where are you going? Follow me!"
			)
			(1
				(gCurRoom leaveRoom: 40 (gEgo x:) -5)
				(client setScript: 0)
			)
		)
	)
)

