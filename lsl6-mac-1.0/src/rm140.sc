;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use LarryRoom)
(use n098)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm140 0
)

(local
	local0 = -1
	local1
	local2 = 60
	[local3 2] = [1 -1]
	local5
	local6
	local7
	local8
	local9
	local10 = -1
)

(procedure (localproc_0 param1 param2 param3 &tmp [temp0 20])
	(monitorL setCycle: 0)
	(monitorR setCycle: 0)
	(switch param1
		(87
			(switch param2
				(95
					(monitorL
						view: 154
						setLoop: 4
						cel: 0
						cycleSpeed: 10
						setCycle: End
					)
					(monitorR
						view: 154
						setLoop: 4
						cel: 0
						cycleSpeed: 10
						setCycle: End param3
					)
				)
				(93
					(monitorL view: 154 setLoop: 4 cel: 0)
					(monitorR view: 154 setLoop: 4 cel: 0)
				)
				(else
					(monitorL view: 154 setLoop: 4 cel: 14)
					(monitorR view: 154 setLoop: 4 cel: 14)
				)
			)
		)
		(85
			(monitorL
				view: 153
				setLoop: 6
				cel: 0
				cycleSpeed: 18
				setCycle: End param3
			)
			(monitorR view: 153 setLoop: 6 cel: 0 cycleSpeed: 18 setCycle: End)
		)
		(84
			(monitorL
				view: 153
				setLoop: 5
				cel: 0
				cycleSpeed: 8
				setCycle: End param3
			)
			(monitorR view: 153 setLoop: 5 cel: 0 cycleSpeed: 8 setCycle: End)
		)
		(88
			(monitorL view: 145 setLoop: 3 cel: 3)
			(monitorR view: 145 setLoop: 3 cel: 3)
		)
		(90
			(monitorL view: 145 setLoop: 3 cel: 0)
			(monitorR view: 145 setLoop: 3 cel: 0)
		)
		(91
			(monitorL view: 145 setLoop: 3 cel: 1)
			(monitorR view: 145 setLoop: 3 cel: 1)
		)
		(92
			(monitorL view: 145 setLoop: 3 cel: 2)
			(monitorR view: 145 setLoop: 3 cel: 2)
			(UnLoad 128 153)
		)
		(86
			(if (== param2 93)
				(monitorL view: 152 setLoop: 2 cel: 0)
				(monitorR view: 152 setLoop: 2 cel: 0)
			else
				(monitorL view: 152 setLoop: 2 cycleSpeed: 6 setCycle: Fwd)
				(monitorR view: 152 setLoop: 2 cycleSpeed: 6 setCycle: Fwd)
			)
		)
		(89
			(switch param2
				(94
					(monitorL
						view: 151
						setLoop: 0
						cel: 0
						cycleSpeed: 6
						setCycle: Fwd
						startUpd:
					)
					(monitorR
						view: 151
						setLoop: 0
						cel: 0
						cycleSpeed: 6
						setCycle: Fwd
						startUpd:
					)
				)
				(96
					(monitorL view: 151 setLoop: 1 cel: 0)
					(monitorR view: 151 setLoop: 1 cel: 0)
				)
				(93
					(monitorL view: 151 setLoop: 0 cel: 0)
					(monitorR view: 151 setLoop: 0 cel: 0)
				)
			)
		)
		(else
			(monitorL view: 145 setLoop: 7 cel: 0)
			(monitorR view: 145 setLoop: 7 cel: 0)
		)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 100)) (>= temp0 60) ((-- temp0))
		(Palette palSET_INTENSITY 0 255 temp0)
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 local2)) (<= temp0 100) ((++ temp0))
		(Palette palSET_INTENSITY 0 255 temp0)
	)
)

(procedure (localproc_3 param1)
	(switch param1
		(97
			(applauseSign setCycle: Fwd)
			(applause setLoop: -1 play:)
		)
		(98
			(applause fade: 0 10 10 1)
			(applauseSign cel: 0 setCycle: 0)
			(applauseSign stopUpd:)
		)
	)
)

(class cObj of Obj
	(properties)
)

(instance rm140 of LarryRoom
	(properties
		picture 140
		style 9
		horizon 0
		autoLoad 0
		noControls 1
	)

	(method (init)
		(gGame setCursor: 999 1)
		(super init: &rest)
		(Palette palSET_INTENSITY 0 255 local2)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(self setScript: cartoonScr)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or
					(& (event type:) evMOUSEBUTTON)
					(and (== (event message:) KEY_RETURN) (& (event type:) evKEYBOARD))
				)
			)
			(event claimed: 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(proc98_0)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(= local0 newRoomNumber)
		(gCast eachElementDo: #hide)
		(SetPort 0)
		(SetPort 0 0 190 320 10 0)
		(DrawPic 98 6)
		(roomTimer setReal: self 2)
		(= gTextSpeed 9)
	)

	(method (cue)
		(Palette palSET_INTENSITY 0 255 100)
		(roomTimer dispose: delete:)
		(super newRoom: local0)
	)
)

(instance roomTimer of Timer
	(properties)
)

(instance biff of Actor
	(properties
		x -18
		y 131
		view 144
		cel 6
		signal 18432
		cycleSpeed 4
		moveSpeed 4
	)
)

(instance rockHard of Prop
	(properties
		x 118
		y 112
		view 140
		loop 1
		cel 3
		priority 2
		signal 18448
	)
)

(instance girl1 of Prop
	(properties
		x 200
		y 108
		view 140
		loop 1
		priority 2
		signal 18448
	)
)

(instance girl2 of Prop
	(properties
		x 217
		y 110
		view 140
		loop 1
		cel 1
		priority 2
		signal 18448
	)
)

(instance girl3 of Prop
	(properties
		x 233
		y 112
		view 140
		loop 1
		cel 2
		priority 2
		signal 18448
	)
)

(instance monitorL of Prop
	(properties
		x 281
		y 13
		view 145
		loop 7
		priority 10
		signal 18448
	)
)

(instance monitorR of Prop
	(properties
		x 19
		y 13
		view 145
		loop 7
		priority 10
		signal 18448
	)
)

(instance waveLeft of Prop
	(properties
		x 120
		y 40
		view 142
		loop 1
		cel 4
		priority 1
		signal 18448
		cycleSpeed 15
	)
)

(instance waveRight of Prop
	(properties
		x 195
		y 40
		view 142
		cel 7
		priority 1
		signal 18448
		cycleSpeed 15
	)
)

(instance applauseSign of Prop
	(properties
		x 204
		y 8
		view 149
		cel 1
	)
)

(instance sfx of Sound
	(properties
		flags 1
	)
)

(instance applause of Sound
	(properties
		number 141
	)
)

(instance cartoonScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(applauseSign init: cel: 0 stopUpd:)
				(shalo init: setCycle: Walk setMotion: MoveTo 67 124 self)
				(rockHard init: setScript: (fidgetScr new:) 0 3)
				(girl1 init: setScript: (fidgetScr new:) 0 0)
				(girl2 init: setScript: (fidgetScr new:) 0 1)
				(girl3 init: setScript: (fidgetScr new:) 0 2)
				(monitorL init: stopUpd:)
				(monitorR init: stopUpd:)
				(gEgo
					init:
					view: 140
					setLoop: 1
					cel: 4
					x: 88
					y: 114
					setPri: 2
					stopUpd:
				)
			)
			(1
				(shalo setLoop: 3 cel: 0 stopUpd:)
				(= ticks 30)
			)
			(2
				(= gTextSpeed 18)
				(gMessager say: 0 0 1 1 3 self) ; "...and don't worry about thinking up answers while we're taping."
			)
			(3
				(shalo setLoop: 2 cel: 3)
				(= ticks 30)
			)
			(4
				(shalo cel: 1)
				(= ticks 30)
			)
			(5
				(shalo
					setLoop: 1
					setCycle: Fwd
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 52 125 self
				)
			)
			(6
				(shalo cue:)
				(gMessager say: 0 0 1 4 6 self) ; "But, wait, Ms. Shalo! I didn't give you any answers earlier. I haven't gone out with these women. In fact, I've never even seen them before!"
			)
			(7
				(= seconds 6)
			)
			(8
				((ScriptID 1823 33) color: 15 y: 25 talkWidth: 300) ; Voice_Over_Announcer
				(= gTextSpeed 99)
				(gMessager say: 0 0 1 7) ; "(CHEAP PA SYSTEM DIRECTOR VOICE OVER) Places, people, places! Lights! Playback! In 5... 4... 3..."
				(localproc_2)
				(= register 0)
				(= ticks 240)
			)
			(9
				(UnLoad 128 146)
				(if (not register)
					(= register 1)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(gGlobalSound1 number: 140 loop: -1 play: 80 fade: 127 10 10 0)
					(waveLeft init: setCycle: Fwd)
					(waveRight init: setCycle: Fwd)
				)
				(= ticks 30)
			)
			(10
				(SetPort 0)
				(SetPort 0 0 190 320 10 0)
				(= cycles 2)
			)
			(11
				(biff init: setLoop: 0 view: 98 cel: 0 x: -15 y: 130)
				(localproc_3 97)
				(localproc_0 87 93)
				((ScriptID 1823 33) color: 22 talkWidth: 300) ; Voice_Over_Announcer
				(= gTextSpeed 18)
				(gMessager say: 0 0 1 8 self) ; "(VOICE OVER ANNOUNCER) Live! From somewhere near Hollywood, California! It's the latest and greatest in embarrassment television: (WHINNY)"
			)
			(12
				(sfx number: 1144 loop: 1 play:)
				((ScriptID 1823 33) talkWidth: -2) ; Voice_Over_Announcer
				(= gTextSpeed 99)
				(gMessager say: 0 0 1 9) ; "STALLIONS!"
				(= ticks 90)
			)
			(13
				(localproc_0 87 95 self)
			)
			(14
				(= seconds 4)
			)
			(15
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= ticks 30)
			)
			(16
				(localproc_0 90)
				((ScriptID 1823 33) talkWidth: 300) ; Voice_Over_Announcer
				(= gTextSpeed 18)
				(gMessager say: 0 0 1 10) ; "Today featuring three hot young Fillies from the Mensa chapter of downtown Pasadena!"
				(= ticks 90)
			)
			(17
				(localproc_0 91)
				(= ticks 90)
			)
			(18
				(localproc_0 92)
				(= ticks 90)
			)
			(19
				(localproc_0 88)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= ticks 30)
			)
			(20
				(gMessager say: 0 0 1 11) ; "And also featuring two of the hung-est Stallions we could pry away from Venice Beach!"
				(= ticks 120)
			)
			(21
				(localproc_0 89 93)
				(= ticks 90)
			)
			(22
				(localproc_0 87)
				(= ticks 30)
			)
			(23
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= ticks 30)
			)
			(24
				(= gTextSpeed 18)
				(gMessager say: 0 0 1 12 self) ; "And now, let's all give a big whinny for the star of our show: (NEIGH) (WHINNY) (SNICKER)"
			)
			(25
				(sfx number: 1144 loop: 1 play:)
				((ScriptID 1823 33) talkWidth: -2) ; Voice_Over_Announcer
				(gMessager say: 0 0 1 13) ; "BIFF STIFF!"
				(biff
					view: 144
					setLoop: 0
					cel: 0
					setCycle: Walk
					cycleSpeed: 2
					moveSpeed: 2
					setMotion: MoveTo 35 135 self
				)
			)
			(26
				(biff setMotion: MoveTo 52 125 self)
			)
			(27
				(biff setMotion: MoveTo 158 109 self)
			)
			(28
				(biff view: 150 setLoop: 3 cel: 2)
				(= ticks 30)
			)
			(29
				(biff setLoop: 3 cycleSpeed: 6 setCycle: Fwd)
				(= seconds 3)
			)
			(30
				(biff setLoop: 4 cel: 0 setCycle: 0)
				(= ticks 30)
			)
			(31
				(localproc_3 98)
				(gGlobalSound1 fade: 100 10 10 0)
				(biff cycleSpeed: 12 setCycle: End self)
			)
			(32
				(= seconds 2)
			)
			(33
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(biff cycleSpeed: 12 setCycle: Beg self)
			)
			(34
				(localproc_0 86 93)
				(biff view: 147 cel: 0)
				(= ticks 120)
			)
			(35
				(localproc_0 86 94)
				(= gTextSpeed 18)
				(gMessager say: 0 0 1 14 self) ; "Welcome back, everybody. Let's meet our contestants."
				(= ticks 180)
			)
			(36
				(localproc_0 89 93)
			)
			(37
				(= gTextSpeed 18)
				(gMessager say: 0 0 1 15 self) ; "Stallion number two is a professional body builder and part-time out-of-work concrete form dismantler who credits his physical success to HerbaByte. Let's hear it for LARRY LAFFER!"
				(= ticks 180)
			)
			(38
				(localproc_3 97)
			)
			(39
				(localproc_0 88)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= ticks 30)
			)
			(40
				(= gTextSpeed 18)
				(gMessager say: 0 0 1 16 self) ; "Stallion number one is also a professional body builder and an apprentice condom sizer who guarantees that, around him, women come first! Really slam 'em together for ROCK HARD!"
			)
			(41
				(localproc_3 98)
				(localproc_0 86 94)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= ticks 30)
			)
			(42
				(= gTextSpeed 18)
				(gMessager say: 0 0 1 17 18 self) ; "(COMING DOWN IN INTENSITY) As you regular fans know, both of these Stallions recently had a dream date with each of our three lovely Fillies."
			)
			(43
				(localproc_3 97)
				(gMessager say: 0 0 1 19 self) ; "OOPS, I'm sorry! I meant "heavy BREATHING!" HA, HA, HA!"
			)
			(44
				(= ticks 30)
			)
			(45
				(gMessager say: 0 0 1 20 self) ; "And now, let's meet our three little Fillies!"
			)
			(46
				(localproc_0 90)
				(= gTextSpeed 18)
				(gMessager say: 0 0 2 1 self) ; "Filly number one is a nuclear chemist specializing in zero gravity liquid-fueled propulsion systems who has a mainframe computer right in her very own home. Yes, that's right: she really IS a rocket scientist! How about some animal noises for DR. SHARLA MANE!"
				(= ticks 180)
			)
			(47)
			(48
				(localproc_0 91)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= ticks 30)
			)
			(49
				(= gTextSpeed 18)
				(gMessager say: 0 0 2 2 self) ; "Filly number two also hails from Pasadena where she leads a think tank specializing in international economics, monetary systems, and currency stabilization. Get it off for DR. SHARLA O'HARA!"
				(= ticks 180)
			)
			(50)
			(51
				(localproc_0 92)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= ticks 30)
			)
			(52
				(= gTextSpeed 18)
				(gMessager say: 0 0 2 3 self) ; "And finally, Filly number three is one hunk of prime horseflesh: with PhDs in marine biology, sub-atomic nuclear physics, and film studies, a woman who expects more from her man than just intelligent conversation! Hoot it up a while for DR. SHARLA TANN!"
				(= ticks 180)
			)
			(53)
			(54
				(localproc_3 98)
				(localproc_0 86 93)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= ticks 30)
			)
			(55
				(biff view: 150 setLoop: 5 cel: 0 setCycle: End self)
			)
			(56
				(biff view: 148 cel: 0 stopUpd:)
				(UnLoad 128 150)
				(localproc_0 86 94)
				(= gTextSpeed 18)
				(gMessager say: 0 0 2 4 self) ; "I'm sure you all know the rules, so let's get right to the game: Larry, you're first."
			)
			(57
				(localproc_0 89 96)
				(= ticks 90)
			)
			(58
				(localproc_0 89 94)
				(= ticks 30)
			)
			(59
				(= gTextSpeed 18)
				(gMessager say: 0 0 2 5 self) ; "Me? Uh, I dunno. I'm not really prepared..."
			)
			(60
				(localproc_0 89 93)
				(= ticks 90)
			)
			(61
				(localproc_0 89 94)
				(gMessager say: 0 0 2 6 self) ; "Oh, what the hell! I'll take Greek Mythology for $500, Alex!"
			)
			(62
				(localproc_0 89 96)
				(= gTextSpeed 27)
				(gMessager say: 0 0 2 7) ; "That's about all of this we need to see, isn't it? Let's fast forward..."
				(self setScript: ffScr self)
			)
			(63
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= ticks 30)
			)
			(64
				(localproc_0 86 94)
				(= gTextSpeed 18)
				(gMessager say: 0 0 2 8 self) ; "...and we're back with our contestants. Larry, what now?"
			)
			(65
				(localproc_0 89 94)
				(gMessager say: 0 0 2 9 self) ; "Uh, could I buy a vowel, Pat?"
			)
			(66
				(localproc_0 89 93)
				(gMessager say: 0 0 2 10) ; "YIKES! This is not going well! Let's cut to the chase..."
				(self setScript: ffScr self)
			)
			(67
				(localproc_3 97)
				(localproc_0 86 94)
				(gMessager say: 0 0 2 11 self) ; "And the winner of today's show: ROCK HARD!"
			)
			(68
				(= gTextSpeed 18)
				(localproc_0 86 94)
				(gMessager say: 0 0 2 12 self) ; "Rock and Sharla win an all-expense paid cruise down the lovely Mexican Riviera, with stops at Tijuana and Juarez!"
			)
			(69
				(localproc_0 85 95 self)
			)
			(70
				(= ticks 90)
			)
			(71
				(localproc_0 89 93)
				(gMessager say: 0 0 2 13 self) ; "And our second prize goes to Larry Laffer: immediately after the show you'll travel by studio limo to the exclusive health spa and resort, "La Costa Lotta," where you'll spend a wonderful two (some-expense-paid) weeks!"
			)
			(72
				(localproc_0 84 95 self)
			)
			(73
				(= ticks 90)
			)
			(74
				(localproc_0 86 94)
				(gMessager say: 0 0 2 14 self) ; "Thanks for watching, folks! And be sure to tune in again tomorrow for another episode of... (WHINNY)"
			)
			(75
				(gGlobalSound1 fade: 127 10 5 0)
				(localproc_0 87)
				(sfx number: 1144 loop: 1 play:)
				((ScriptID 1144 24) x: -1 talkWidth: 100 textX: 100) ; Biff_Stiff
				(gMessager say: 0 0 2 15 self) ; "STALLIONS!"
			)
			(76
				(= seconds 8)
			)
			(77
				(waveLeft dispose:)
				(waveRight dispose:)
				(UnLoad 128 142)
				(gGlobalSound1 fade:)
				(localproc_3 98)
				(localproc_0 0)
				(localproc_1)
				(= seconds 5)
			)
			(78
				(shalo
					init:
					view: 146
					setLoop: 0
					cel: 0
					x: -15
					y: 130
					setCycle: Walk
					cycleSpeed: 4
					moveSpeed: 4
					setMotion: MoveTo 35 135 self
				)
			)
			(79
				(shalo setMotion: MoveTo 52 125 self)
			)
			(80
				(shalo setMotion: MoveTo 135 117 self)
			)
			(81
				(shalo setLoop: 4 cel: 0)
				(= ticks 60)
			)
			(82
				(shalo cel: 1)
				(= ticks 30)
			)
			(83
				(gMessager say: 0 0 2 16 self) ; "Rock, Honey, here's your tickets for the cruise. I'm afraid Sharla won't be going with you; she opted for the cash payoff instead. But you won't be lonely; I'll be waiting for you in your cabin!"
			)
			(84
				((ScriptID 1823 33) ; Voice_Over_Announcer
					name: {Rock Hard}
					color: 82
					back: 205
					talkWidth: -2
				)
				(gMessager say: 0 0 2 17 self) ; "(DISINTERESTED) Whatever."
			)
			(85
				(shalo cel: 0)
				(= ticks 30)
			)
			(86
				(shalo setLoop: 1 setCycle: Walk setMotion: MoveTo 102 124 self)
			)
			(87
				(shalo setLoop: 2 cel: 3)
				(= ticks 30)
			)
			(88
				(gMessager say: 0 0 2 18 self) ; "You come with me, Doofus!"
			)
			(89
				(= local1 0)
				(shalo setLoop: 1 setCycle: Walk setMotion: MoveTo 52 125 shalo)
				(= ticks 60)
			)
			(90
				(gEgo view: 900 setLoop: 8 cel: 2)
				(= ticks 60)
			)
			(91
				(gMessager say: 0 0 2 19 self) ; "That's Laffer!"
			)
			(92
				(= seconds 3)
			)
			(93
				(gEgo
					cycleSpeed: 6
					moveSpeed: 6
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 52 125 self
				)
			)
			(94
				(gEgo setMotion: MoveTo 35 135 self)
			)
			(95
				(gEgo setMotion: MoveTo -15 130 self)
			)
			(96
				(gMessager say: 0 0 2 20 self) ; "Here's your limo, Lasser. Enjoy the ride!"
			)
			(97
				(gCast eachElementDo: #dispose)
				(DrawPic 98 6)
				(= cycles 2)
			)
			(98
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 4)
			)
			(99
				(UnLoad 128 149)
				(UnLoad 128 148)
				(UnLoad 128 147)
				(UnLoad 128 140)
				(UnLoad 128 145)
				(UnLoad 128 152)
				(UnLoad 128 144)
				(UnLoad 128 141)
				(UnLoad 128 154)
				(UnLoad 128 142)
				(UnLoad 128 146)
				(UnLoad 128 151)
				(gMessager say: 0 0 2 21 23 self) ; "Wow! What a cherry '73 Pacer!!"
			)
			(100
				(= seconds 5)
			)
			(101
				(gCurRoom newRoom: 800)
			)
		)
	)
)

(instance shalo of Actor
	(properties
		x 47
		y 124
		view 146
		signal 18432
		cycleSpeed 4
		moveSpeed 4
	)

	(method (cue)
		(super cue:)
		(switch (++ local1)
			(1
				(self cycleSpeed: 4 moveSpeed: 4 setMotion: MoveTo 35 135 self)
			)
			(2
				(self setMotion: MoveTo -15 130 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance fidgetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: 140 setLoop: 1 cel: register)
				(= seconds (Random 5 20))
			)
			(1
				(= ticks 30)
			)
			(2
				(client view: 141 setLoop: register cel: 0 setCycle: End self)
			)
			(3
				(= ticks 90)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance ffScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= local5 (View new:))
					view: 143
					name: {scanLine1}
					setLoop: 0
					cel: 0
					x: 0
					y: 24
					priority: 13
					signal: 18448
					init:
					hide:
				)
				((= local6 (View new:))
					view: 143
					name: {scanLine2}
					setLoop: 1
					cel: 0
					x: 0
					y: 73
					priority: 13
					signal: 18448
					init:
					hide:
				)
				((= local7 (View new:))
					view: 143
					name: {scanLine3}
					setLoop: 2
					cel: 0
					x: 0
					y: 116
					priority: 13
					signal: 18448
					init:
					hide:
				)
				((= local8 (Prop new:))
					view: 143
					name: {ffHand}
					setLoop: 3
					cel: 0
					x: 154
					y: 140
					priority: 14
					signal: 18448
					init:
					setCycle: End self
				)
			)
			(1
				(gGlobalSound1 number: 145 loop: -1 play: 80)
				(waveLeft cycleSpeed: 0)
				(waveRight cycleSpeed: 0)
				(= register 0)
				(= local9 60)
				(= cycles 2)
			)
			(2
				(switch (Random 0 30)
					(1
						(localproc_0 87)
					)
					(2
						(localproc_0 89 93)
					)
					(3
						(localproc_0 89 96)
					)
					(4
						(localproc_0 86 93)
					)
					(5
						(localproc_0 90)
					)
					(6
						(localproc_0 91)
					)
					(7
						(localproc_0 92)
					)
					(8
						(localproc_0 88)
					)
				)
				(switch (++ register)
					(1
						(local7 hide:)
						(local5 show:)
					)
					(2
						(local5 hide:)
						(local6 show:)
					)
					(3
						(local6 hide:)
						(local7 show:)
						(= register 0)
					)
				)
				(if (-- local9)
					(-- state)
					(= cycles 1)
				else
					(local8 cycleSpeed: 12 setCycle: CT 6 -1 self)
				)
			)
			(3
				(waveLeft cycleSpeed: 15)
				(waveRight cycleSpeed: 15)
				(local5 dispose:)
				(local6 dispose:)
				(local7 dispose:)
				(= ticks 10)
			)
			(4
				(local8 cycleSpeed: 6 setCycle: Beg self)
			)
			(5
				(gGlobalSound1 number: 140 loop: -1 play: 80)
				(local8 dispose:)
				(UnLoad 128 143)
				(self dispose:)
			)
		)
	)
)

