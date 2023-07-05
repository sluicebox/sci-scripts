;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Interface)
(use tahiti)
(use SoundSyncWave)
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
			(Print 3 22) ; "Oh, I hardly know you!"
		)
		(2
			(Print 3 23) ; "I don't think my boyfriend would like that!"
		)
		(3
			(Print 3 24) ; "She blushes and averts her gaze."
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
			)
		)
	)

	(method (newRoom newRoomNumber)
		(cond
			(local6)
			((and (== newRoomNumber south) local1)
				(if (lifesaverScript register:)
					(Print 3 0) ; "The poor girl couldn't hang on."
					(super newRoom: newRoomNumber &rest)
				else
					(gEgo setMotion: MoveTo (gEgo x:) 230 script)
					(= local6 1)
				)
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
		(LoadMany rsSCRIPT 301 355 354 368 357)
		(LoadMany rsVIEW 3 703 206 503 603 803 203 103 403)
		(LoadMany rsSOUND 38 39 40 41 53)
		(self setRegions: 301 300) ; Water, tahiti
		(gIceGlobalSound fade:)
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
		(gEgo init:)
		(self setScript: volleyScript)
	)

	(method (handleEvent event &tmp [temp0 35])
		(cond
			((super handleEvent: event))
			((Said 'look[<around,at][/room,beach]')
				(proc3_7 3 1) ; "This is where people play volleyball."
			)
		)
	)
)

(instance volleyScript of Script
	(properties)

	(method (init param1)
		(if (or (tahiti volley:) (== (gEgo view:) 206))
			(Animate (gCast elements:) 1)
			(= state start)
			(self dispose:)
		else
			(gCurRoom setFeatures: Net)
			(Man init:)
			(Girl init:)
			(Girl2 init:)
			(Ball init:)
			(Animate (gCast elements:) 1)
			(super init: param1 &rest)
		)
	)

	(method (dispose)
		(if (not (tahiti volley:))
			(tahiti volley: state)
		)
		(super dispose: &rest)
	)

	(method (changeState newState param2 &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(Ball illegalBits: 0 ignoreHorizon: 1 posn: 270 100)
				(= cycles 1)
			)
			(1
				(Man setScript: AngryManScript)
				(self setScript: (ScriptID 357 3) self) ; ReturnBallScript
			)
			(2
				(if param2
					(= temp1 (tahiti volley:))
					(-- temp1)
					(tahiti volley: temp1)
				else
					(Man setScript: 0)
					(self setScript: (ScriptID 355 0) self) ; playScript
				)
			)
			(3
				(= seconds 25)
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
				(proc3_7 3 2) ; "Oops! There goes the ball."
				(= local7 0)
				(= cycles 4)
			)
			(8
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
					setAvoider: Avoid
					setMotion: DPath 100 148 100 116 121 116 self
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
				(proc3_7 3 3) ; "You hear calls for help."
				(HandsOn)
				(gEgo setCycle: Walk viewer: local2)
				(= seconds 12)
			)
			(1
				(proc3_7 3 4) ; "The calls are getting fainter"
				(= seconds 8)
			)
			(2
				(proc3_7 3 5) ; "You hear: "gasp... gulp...""
				(= seconds 8)
			)
			(3
				(= register 1)
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
				(Print 3 6) ; "You can't do it from here."
			)
		)
	)
)

(instance AngryManScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(if (and (< 160 (gEgo x:)) (< (gEgo y:) 150))
					(proc3_7 3 7) ; ""Say would you return that ball." says one of the players."
					(= seconds 15)
				else
					(= seconds 1)
				)
			)
			(2
				(if (and (< 160 (gEgo x:)) (< (gEgo y:) 150))
					(proc3_7 3 8) ; "How about kicking us the ball."
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

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((not local7))
			((Said 'look[<at][/woman]')
				(proc3_7 3 9) ; "Isn't she cute!"
			)
			((Said 'kiss[/woman]')
				(localproc_0)
			)
			((Said 'talk/woman')
				(if local7
					(proc3_7 3 10) ; "In a mild state of confusion she says, "I just don't know how to thank you, sir.""
					(proc3_7 3 11) ; "Continuing she says, "I'm so grateful for your skills in performing cpr.""
					(proc3_7 3 12) ; "I'm a lucky lady you were around when I fell into my dilemma."
					(proc3_7 3 13) ; "In her excitement she says, "You will always be my hero.""
				else
					(proc3_7 3 14) ; "She can't talk now."
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
			((Said '[/ball][/ball]>')
				(cond
					((and (CantBeSeen self) (Said '/*'))
						(proc3_7 3 15) ; "You don't see any balls here."
						(event claimed: 1)
					)
					((IsOffScreen self)
						(proc3_7 3 16) ; "The ball is riding the waves."
						(event claimed: 1)
					)
					((Said 'look[<at]')
						(proc3_7 3 17) ; "It's a nice round volleyball."
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

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/woman]')
				(proc3_7 3 18) ; "The dark girl is lovely, but she seems very shy."
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

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/man]')
				(proc3_7 3 19) ; "Some life guard, he doesn't even know how to swim."
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
			((Said 'look[<at][/net]')
				(proc3_7 3 20) ; "A brand new volleyball net, probably belongs to one of the girls."
			)
		)
	)
)

(instance wave of SoundSyncWave ; UNUSED
	(properties
		y 157
		x 274
		view 703
		loop 1
		cycleSpeed 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/wave]')
				(proc3_7 3 21) ; "These are mild waves."
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

