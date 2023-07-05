;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Gaza)
(use eRoom)
(use Interface)
(use Follow)
(use Motion)
(use System)

(public
	Rm36 0
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
)

(instance Rm36 of eRoom
	(properties
		picture 36
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
		(Load rsVIEW 136)
		(super init:)
		(self setRegions: 107) ; Gaza
		(= global112 2)
		(proc0_13 65)
		(gAddToPics doit:)
		(gEgo init:)
		(switch gPrevRoomNum
			(37
				(= local4 1)
				(= local6 1)
				(self enterRoom: 172 235 172 182)
				(if (IsFlag 20)
					(self muleEnterRoom: 245 230 245 178 3)
				)
			)
			(else
				(if (not (IsFlag 78))
					(= local5 1)
				)
				(gEgo setPri: 1 setLoop: 2 posn: 172 201)
				(if (not (IsFlag 112))
					(SetFlag 112)
					((ScriptID 130 0) ; Jabir
						view: 392
						posn: 102 165
						setLoop: 0
						cel: 0
						cycleSpeed: 1
						init:
					)
					((ScriptID 130 1) ignoreActors: 1 posn: 102 165) ; jabirHead
				)
				(self setScript: fromBoatWithMule)
				(gMuleObj
					setPri: 1
					illegalBits: 0
					ignoreActors: 1
					posn: 172 190
				)
			)
		)
	)

	(method (doit)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				((and global169 (not local1))
					(= local1 1)
					(if (== global189 1)
						(= local2 1)
						((ScriptID 130 0) setScript: (ScriptID 183 3)) ; Jabir, followMe
					else
						(= local3 1)
						((ScriptID 130 0) setScript: (ScriptID 183 1)) ; Jabir, hireMe
					)
				)
				((and local2 (not global169) (not local0))
					(= local0 1)
					(HandsOn)
				)
				((IsFlag 125)
					(ClearFlag 125)
					(= global125 2)
				)
				(local4
					(= local4 0)
					(Print 36 0) ; "You should not think of returning to Gaza, Arthur. If the mukhtar's men find you, it will mean your life."
					(= local5 1)
				)
				((> (gEgo y:) 185)
					(if (== gPrevRoomNum 35)
						(= global204 8000)
						(= global205 10000)
					)
					(if (IsFlag 20)
						(gMuleObj setMotion: Follow gEgo 40)
					)
					(self leaveRoom: 37 (gEgo x:) 235)
					(if local2
						(= global189 2)
					)
				)
				((and (== (gEgo onControl: 1) 2) (== (gEgo loop:) 3))
					(if (or (< global204 1000) (and (IsFlag 107) (IsFlag 20)))
						(= local5 1)
					)
					(self goingOut: 1 setScript: toBoat)
					(if (or global169 local2)
						(= global189 0)
					)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((and global169 (< global189 8) (Said 'draw/blade'))
				(= local7 1)
				(= global189 8)
				(if (gEgo inRect: 90 167 125 189)
					((ScriptID 130 0) setScript: (ScriptID 183 4)) ; Jabir, dodgeHim
				else
					((ScriptID 130 0) setScript: (ScriptID 114 0)) ; Jabir, run
				)
				(event claimed: 0)
			)
			((or (Said 'pay[/hamid]') (Said 'give,count[/coin][/hamid]'))
				(if (and global169 (< global189 8))
					((ScriptID 130 0) setScript: (ScriptID 183 2)) ; Jabir, payAttempt
				else
					(event claimed: 0)
				)
			)
			((Said 'no')
				(if local3
					(= local3 0)
					(Talk 36 1) ; "A pity. You are so young to die. Well, we may yet meet again, in case you change your mind."
				else
					(event claimed: 0)
				)
			)
			((Said 'call,yell/hazm,boy')
				(if (IsFlag 91)
					(Print 36 2) ; "He does not answer."
				else
					(Print 36 3) ; "He could never hear you from here."
				)
			)
			(
				(or
					(Said 'ask[/merlin][/advice]')
					(Said 'ask/advice[<merlin][/!*]')
					(Said 'talk/merlin[/!*]')
				)
				(if (IsFlag 106)
					(Print 36 4) ; "You should have returned directly to Jerusalem. There is no hope for you now."
				else
					(Print 36 5) ; "Gaza is unsafe. Jerusalem lies somewhere beyond the desert. Your choices are limited and filled with danger at every step. Go with caution."
				)
			)
			((and global169 (or (Said 'talk,ask[/hamid]>') (Said 'tell[/me]>')))
				(cond
					(
						(or
							(Said '/desert,gaza,port,city,terrain')
							(Said '//desert,gaza,port,city,terrain')
						)
						(Talk 36 6) ; "You have safely left Gaza behind, but the desert lies ahead. You will never cross it without my help."
					)
					(
						(or
							(Said
								'/mainmast,gangplank,sail,line,bow,stern,cargo,crew,captain,boat,ocean'
							)
							(Said
								'//mainmast,gangplank,sail,line,bow,stern,cargo,crew,captain,boat,ocean'
							)
						)
						(Talk 36 7) ; "I am a man of the desert, not of the sea."
					)
					(
						(or
							(Said '/water,spring,pool,spring,lake')
							(Said '//water,spring,pool,spring,lake')
						)
						(Talk 36 8) ; "Hire me, and I will lead you safely to water. Trust me in all things."
					)
					((Said '//hamid,yourself,himself')
						(Talk 36 9) ; "I urge you once more to hire me as your guide through the desert. Only I can show you where the hidden water lies."
					)
					((or (Said '/hazm,boy') (Said '//hazm,boy'))
						(Talk 36 10) ; "He is a useless pest."
					)
					(
						(or
							(Said '/scholar,alsirat,(sirat<al)')
							(Said '//scholar,alsirat,(sirat<al)')
						)
						(Talk 36 11) ; "He is an old fraud."
					)
					(
						(or
							(Said '/tower,turret,fort')
							(Said '//tower,turret,fort')
						)
						(Talk 36 12) ; "It is just an old tower."
					)
					(else
						(Talk 36 13) ; "If you must ask questions, you might at least hire me as your guide."
						(event claimed: 1)
					)
				)
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
							(Said '/desert,gaza,port,city,terrain')
							(Said '//desert,gaza,port,city,terrain')
						)
						(if (IsFlag 117)
							(Print 36 14) ; "I do not know what folly brought you back here to the hill above Gaza. I fear you are doomed."
						else
							(Print 36 15) ; "From this hard-earned height above Gaza you can see far across the sea and over the village. But ahead of you lies a searing and treacherous desert to cross."
						)
					)
					((or (Said '/hazm,boy') (Said '//hazm,boy'))
						(cond
							((IsFlag 117)
								(Print 36 16) ; "I do not think you will see Hazm ever again."
							)
							((IsFlag 91)
								(Print 36 17) ; "Undoubtedly he hurried back to his master, as instructed."
							)
							(else
								(Print 36 18) ; "There is a slim chance he might be on the dock where you left him."
							)
						)
					)
					(
						(or
							(Said '/scholar,alsirat,(sirat<al)')
							(Said '//scholar,alsirat,(sirat<al)')
						)
						(if (IsFlag 91)
							(Print 36 19) ; "Al-Sirat's enclosure is hidden somewhere in the hillside below. You would never find it again without Hazm."
						else
							(Print 36 20) ; "You had your chance when Hazm offered to take you to the scholar. Now it may be too late."
						)
					)
					(
						(or
							(Said
								'/mainmast,gangplank,sail,line,bow,stern,cargo,crew,captain'
							)
							(Said
								'//mainmast,gangplank,sail,line,bow,stern,cargo,crew,captain'
							)
						)
						(Print 36 21) ; "You can barely make out the ship, let alone any other detail, from this distance."
					)
					(
						(or
							(OnButton event 6 116 87 185)
							(OnButton event 87 134 154 155)
							(OnButton event 280 91 310 185)
							(OnButton event 239 109 280 152)
							(OnButton event 214 115 239 148)
							(OnButton event 196 128 214 148)
							(OnButton event 259 170 280 185)
						)
						(proc107_2)
					)
					(
						(or
							(Said '/boat')
							(Said '//boat')
							(OnButton event 136 68 152 84)
						)
						(if (IsFlag 117)
							(Print 36 22) ; "It may be the ship you came on still in port, or another ship entirely. It matters not."
						else
							(Print 36 23) ; "From this height above Gaza, the ship on which you spent so many weary weeks looks like a mere toy."
						)
					)
					(
						(or
							(Said '/tower,turret,fort')
							(Said '//tower,turret,fort')
							(OnButton event 102 64 110 72)
						)
						(Print 36 24) ; "You saw the stone tower when you disembarked. It looked abandoned."
					)
					(
						(or
							(Said '/shore,land')
							(Said '//shore,land')
							(OnButton event 68 64 111 72)
							(OnButton event 71 76 136 85)
							(OnButton event 74 86 160 119)
							(OnButton event 97 120 200 143)
						)
						(Print 36 25) ; "The town of Gaza occupies the shoreline."
					)
					((OnButton event 8 78 171 143)
						(Print 36 26) ; "From this hard-earned height above Gaza you can see far across the sea and over the village."
					)
					(
						(or
							(Said '/ocean')
							(Said '//ocean')
							(OnButton event 83 63 310 127)
						)
						(Print 36 27) ; "The sea looks lovely from here."
					)
					(
						(or
							(Said '/cloud,sky')
							(Said '//cloud,sky')
							(OnButton event 0 0 310 62)
						)
						(Print 36 28) ; "Aye, a most impressive looking bank of clouds."
					)
					((or (Said '/sun') (Said '//sun'))
						(Print 36 29) ; "You dare not look long at the glaring sun."
					)
					((or (Said '/cross') (Said '//cross'))
						(Print 36 30) ; "Cross? Ah, you refer to the mast and furled sail of the ship down at the dock."
					)
				)
			)
		)
	)
)

(instance toBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setPri: 1
					setLoop: 3
					setMotion: MoveTo (gEgo x:) 185 self
				)
			)
			(1
				(if local5
					(if (not local6)
						(Print 36 0) ; "You should not think of returning to Gaza, Arthur. If the mukhtar's men find you, it will mean your life."
						(= local6 1)
						(gEgo
							setLoop: 2
							setMotion: MoveTo (gEgo x:) 149 self
						)
					else
						(Print 36 31) ; "Why do you refuse to listen to good advice?"
						(= local6 0)
						(gEgo setMotion: MoveTo (gEgo x:) 205 self)
					)
				else
					(= global189 0)
					(gEgo setMotion: MoveTo (gEgo x:) 205 self)
				)
			)
			(2
				(if local5
					(if local6
						(gEgo
							setPri: -1
							setMotion: MoveTo (gEgo x:) 155 self
						)
					else
						(gRegMusic stop:)
						(gEgo setScript: (ScriptID 182 0)) ; redQueen
						(client setScript: 0)
					)
				else
					(gRegMusic stop:)
					(gEgo
						setLoop: -1
						setPri: -1
						setMotion: 0
						setCycle: Walk
						illegalBits: -32768
						cycleSpeed: 0
						moveSpeed: 0
						ignoreActors: 0
					)
					(gCurRoom newRoom: 35)
				)
			)
			(3
				(HandsOn)
				(gEgo illegalBits: -32768 ignoreActors: 0 setLoop: -1)
				(client goingOut: 0 setScript: 0)
			)
		)
	)
)

(instance fromBoatWithMule of Script
	(properties)

	(method (doit)
		(if (and (< (gMuleObj y:) 150) (== (gMuleObj priority:) 1))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 172 149 self)
			)
			(1
				(gEgo
					setLoop: -1
					setPri: -1
					setMotion: 0
					setCycle: Walk
					illegalBits: -32768
					cycleSpeed: 0
					moveSpeed: 0
					ignoreActors: 0
				)
				(gMuleObj setLoop: 2 setMotion: MoveTo 172 149)
				(gEgo setMotion: MoveTo 172 160 self)
			)
			(2
				(gEgo setMotion: MoveTo 235 170)
			)
			(3
				(gMuleObj setPri: -1 setMotion: MoveTo 172 160 self)
				(Face gEgo gMuleObj)
			)
			(4
				(gMuleObj
					setLoop: -1
					illegalBits: -32768
					ignoreActors: 0
					setMotion: MoveTo 150 161 self
				)
			)
			(5
				(gMuleObj setMotion: MoveTo 151 161 self)
			)
			(6
				(Face gMuleObj gEgo)
				(Rm36 comingIn: 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

