;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Interface)
(use tahiti)
(use n821)
(use LoadMany)
(use DPath)
(use Chase)
(use Grooper)
(use Sight)
(use Avoid)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	volleyRm 0
	Man 1
	Girl 2
	Ball 3
	Net 4
	joinGameScript 5
	Girl2 6
	proc3_7 7
	proc3_8 8
)

(local
	local0
	local1
	local2
	[local3 2]
	local5
	local6
	local7
)

(procedure (proc3_7 &tmp [temp0 4] [temp4 100])
	(proc0_3)
	(Format @temp4 &rest)
	(TextSize @[temp0 0] @temp4 gUserFont 0)
	(Print @temp4 #at -1 12 #width (if (> [temp0 2] 24) 300 else 0) #mode 1)
)

(procedure (proc3_8 param1 &tmp [temp0 4] [temp4 100])
	(proc0_3)
	(Format @temp4 &rest)
	(TextSize @[temp0 0] @temp4 gUserFont 0)
	(Print
		@temp4
		#at
		-1
		12
		#width
		(if (> [temp0 2] 24) 300 else 0)
		#mode
		1
		#dispose
		#time
		param1
	)
)

(procedure (localproc_0)
	(switch (Random 1 3)
		(1
			(Print 3 30) ; "Oh, I hardly know you!"
		)
		(2
			(Print 3 31) ; "I don't think my boyfriend would like that!"
		)
		(3
			(Print 3 32) ; "She blushes and averts her gaze."
		)
	)
)

(instance volleyRm of Rm
	(properties
		picture 3
		east 2
		south 8
		west 4
		picAngle 70
	)

	(method (doit)
		(super doit: &rest)
		(if local5
			(= local5 0)
			(gEgo setScript: (ScriptID 368) volleyScript) ; cprEndScript
		)
	)

	(method (notify param1 param2)
		(-- argc)
		(return
			(switch param1
				(0
					(if argc
						(= local1 param2)
					else
						local1
					)
				)
				(1
					(if argc
						(= local0 param2)
					else
						local0
					)
				)
				(2
					(= local5 1)
				)
				(3
					(if argc
						(= local7 param2)
					else
						local7
					)
				)
				(4
					(gEgo
						view: 200
						setLoop: -1
						setCycle: Walk
						loop: 0
						viewer: local2
					)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(cond
			(local6)
			((and (== newRoomNumber south) local1)
				(if (lifesaverScript register:)
					(super newRoom: newRoomNumber &rest)
				else
					(HandsOff)
					(lifesaverScript register: 1)
					(gEgo setMotion: MoveTo (gEgo x:) 230 script)
					(= local6 1)
				)
			)
			(local1
				(EgoDead 918 0 0 3 0) ; "For your heartless attitude."
			)
			(else
				(super newRoom: newRoomNumber &rest)
			)
		)
	)

	(method (init)
		(super init:)
		DPath
		Avoid
		Chase
		Jump
		(LoadMany rsSCRIPT 301 355 354 368)
		(LoadMany rsVIEW 3 206 503 603 803 203 103 403)
		(LoadMany rsSOUND 38 39 40 41 53)
		(self setRegions: 301 300) ; Water, tahiti
		(gIceGlobalSound stop:)
		(= local2 (gEgo viewer:))
		(switch gPrevRoomNum
			(south)
			(west
				(gEgo
					loop: 0
					posn:
						10
						(switch (gEgo view:)
							(217 180)
							(216 155)
							(215 130)
							(214 125)
							(else 110)
						)
				)
			)
			(else
				(gEgo
					posn:
						300
						(switch (gEgo view:)
							(217 180)
							(216 140)
							(215 120)
							(214 115)
							(else 100)
						)
					heading: 270
				)
				(DirLoop gEgo 270)
			)
		)
		(HandsOn)
		(gAddToPics add: Net doit:)
		(self setFeatures: Net)
		(gEgo init:)
		(self setScript: volleyScript)
	)

	(method (handleEvent event &tmp [temp0 35])
		(cond
			((super handleEvent: event))
			((Said 'look[<around,at][/room,beach]')
				(if (tahiti volley:)
					(proc3_7 3 1) ; "This is where people play volleyball."
				else
					(proc3_7 3 2) ; "You think to yourself... "How about this, a volleyball game.""
				)
			)
		)
	)
)

(instance volleyScript of Script
	(properties)

	(method (init param1)
		(if (or (< 7 (tahiti volley:)) (== (gEgo view:) 206))
			(Animate (gCast elements:) 1)
			(= state start)
			(self dispose:)
		else
			(Man init:)
			(Girl init:)
			(Girl2 init:)
			(Ball init:)
			(Animate (gCast elements:) 1)
			(super init: param1 &rest)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (Random 0 1)
					(Ball
						illegalBits: 0
						ignoreHorizon: 1
						posn: 151 66
						setPri: (+ (Girl priority:) 1)
						setMotion: JumpTo (Girl nsRight:) (Girl nsTop:) self
					)
					(self setScript: (ScriptID 355 0) self Man) ; playScript
				else
					(Ball
						illegalBits: 0
						ignoreHorizon: 1
						posn: 172 71
						setPri: (+ (Man priority:) 1)
						setMotion: JumpTo (Man nsLeft:) (Man nsTop:) self
					)
					(self setScript: (ScriptID 355 0) self Girl) ; playScript
				)
			)
			(1
				(if (not (tahiti volley:))
					(proc3_8 4 3 3) ; "Glad ya joined in" she says..."Two against one is making me tired."
				)
				(gGame changeScore: 1)
				(tahiti volley: (+ (tahiti volley:) 1))
				(= seconds 5)
			)
			(2
				(if local0
					(gGame changeScore: 1)
					(tahiti volley: (+ (tahiti volley:) 1))
					(= seconds 5)
				)
			)
			(3
				(if (and local0 (< 7 (tahiti volley:)))
					(= cycles 2)
				else
					(self changeState: 2)
				)
			)
			(4
				(soundSplash init:)
				(script caller: self)
			)
			(5)
			(6
				(soundSplash number: (proc0_5 53) play:)
				(splash init: posn: (Ball x:) (Ball y:) setCycle: End)
				(Ball setMotion: JumpTo (+ (Ball x:) 40) 260 self)
			)
			(7
				(proc3_7 3 4) ; "Oops! There goes the ball."
				(= local7 0)
				(= cycles 4)
			)
			(8
				(DisposeScript 355)
				(= local1 1)
				(HandsOff)
				(splash dispose:)
				(Girl
					heading: 180
					view: 203
					setAvoider: Avoid 1
					setCycle: Walk
					setMotion: Chase Ball 10 self
				)
				(gEgo setCycle: Walk)
			)
			(9
				(HandsOn)
				(gEgo setScript: lifesaverScript)
				(= seconds 1)
			)
			(10)
			(11
				(gEgo setScript: (ScriptID 354)) ; cprScript
			)
			(12
				(= local6 0)
				(= local1 0)
				(gEgo setCycle: Walk viewer: local2 setLoop: Grooper)
			)
		)
	)
)

(instance joinGameScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(User canControl: 0)
				(= local0 0)
				(gEgo
					setLoop: -1
					setAvoider: Avoid
					setMotion: DPath 100 116 121 116 self
				)
			)
			(1
				(gEgo
					setAvoider: 0
					viewer: 0
					view: 3
					setLoop: 1
					setCel: 0
					heading: 90
				)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance lifesaverScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc3_7 3 5) ; "You hear calls for help."
				(HandsOn)
				(gEgo setCycle: Walk viewer: local2)
				(= seconds 12)
			)
			(1
				(proc3_7 3 6) ; "The calls are getting fainter."
				(= seconds 8)
			)
			(2
				(proc3_7 3 7) ; "You hear: "gasp... gulp...""
				(= seconds 8)
			)
			(3
				(if (not register)
					(lifesaverScript register: 1)
					(Print 3 8) ; "The poor girl couldn't hang on."
					(gGame changeScore: -10)
					(= local1 0)
				)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(if (or (== state 2) (!= gCurRoomNum gNewRoomNum)) 1)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'save,help')
				(Print 3 9) ; "You can't do it from here."
			)
		)
	)
)

(instance AngryManScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(if (and (< 160 (gEgo x:)) (< (gEgo y:) 150))
					(proc3_7 3 10) ; ""Say, would you return that ball," asks one of the players."
					(= seconds 15)
				else
					(= seconds 1)
				)
			)
			(2
				(if (and (< 160 (gEgo x:)) (< (gEgo y:) 150))
					(proc3_7 3 11) ; "How about kicking us the ball?"
					(self init:)
				else
					(self changeState: 1)
				)
			)
		)
	)
)

(instance GirlViewer of Code
	(properties)

	(method (doit)
		(if (!= (Girl onControl: 1) 1)
			(Girl view: 103)
		)
		(Girl
			setLoop:
				(switch (Girl view:)
					(3 3)
					(103
						(switch (Girl onControl: 1)
							(512 3)
							(1024 3)
							(2048 2)
							(4096 1)
							(1 0)
							(else
								(Girl loop:)
							)
						)
					)
					(203 -1)
				)
		)
	)
)

(instance Girl of Act
	(properties
		y 121
		x 135
		heading 90
		view 3
		loop 3
	)

	(method (init)
		(super init: &rest)
		(= viewer GirlViewer)
	)

	(method (canBeHere)
		(return 1)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/woman]')
				(proc3_7 3 12) ; "Isn't she cute!"
			)
			((Said 'kiss[/woman]')
				(localproc_0)
			)
			((not local7))
			((Said 'talk/woman')
				(if local7
					(proc3_7 3 13) ; "In a mild state of confusion she says, "I just feel so stupid and embarrassed!""
					(proc3_7 3 14) ; "She stammers her thanks, "I'm so grateful for your skills in performing cpr.""
					(proc3_7 3 15) ; "I feel kinda sick, I'm going home."
				else
					(proc3_7 3 16) ; "She can't talk now."
				)
			)
		)
	)
)

(instance Ball of Act
	(properties
		view 3
		loop 7
	)

	(method (init)
		(self setLoop: loop)
		(super init:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event &rest))
			((or (Said '/ball>') (Said '//ball>'))
				(cond
					((and (CantBeSeen self) (Said '/*'))
						(proc3_7 3 17) ; "You don't see any balls here."
						(event claimed: 1)
					)
					((IsOffScreen self)
						(proc3_7 3 18) ; "The ball is riding the waves."
						(event claimed: 1)
					)
					((Said 'look[<at]')
						(proc3_7 3 19) ; "It's a nice round volleyball."
					)
				)
			)
		)
	)
)

(instance Girl2 of Act
	(properties
		y 117
		x 174
		view 3
		loop 4
	)

	(method (canBeHere)
		(return 1)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/woman]')
				(proc3_7 3 20) ; "The dark girl is lovely, but she seems very shy."
			)
			((Said 'talk/woman')
				(if local0
					(if local1
						(proc3_8 4 3 21) ; ""I can't swim a stroke." she says"
					else
						(proc3_8 4 3 22) ; "The girl next to you replies, "Let's play now-later we can talk.""
					)
				else
					(proc3_8 4 3 23) ; "One of the girls says, "Would you like to play?""
				)
			)
			((Said 'help,get,save/woman')
				(if local1
					(proc3_8 4 3 24) ; "Go ahead and do it."
				else
					(event claimed: 0)
				)
			)
			((Said 'kiss[/woman]')
				(localproc_0)
			)
		)
	)
)

(instance Man of Act
	(properties
		y 122
		x 188
		view 3
		loop 5
	)

	(method (canBeHere)
		(return 1)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/man]')
				(proc3_7 3 25) ; "Some lifeguard, he doesn't even know how to swim."
			)
			((Said 'talk/man')
				(cond
					(local1
						(proc3_8 4 3 26) ; ""I don't know how to swim," he sputters"
					)
					(local0
						(proc3_8 4 3 27) ; ""The sun feels good, doesn't it," he replies"
					)
					(else
						(proc3_8 4 3 28) ; ""Why don't you join us," he invites"
					)
				)
			)
		)
	)
)

(instance Net of PV
	(properties
		y 125
		x 153
		view 3
		loop 6
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]/net')
				(proc3_7 3 29) ; "A brand new volleyball net, probably belongs to one of the girls."
			)
		)
	)
)

(instance soundSplash of Sound
	(properties
		number 53
		priority 1
	)
)

(instance splash of Prop
	(properties
		view 503
		loop 4
	)
)

