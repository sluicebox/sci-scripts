;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use fileScr)
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
	[local0 6] = [154 153 145 152 151 149]
	local6
	local7
	local8 = 60
	[local9 2] = [1 -1]
	local11
	local12
	local13
	local14
	local15
	local16 = -1
)

(procedure (localproc_0 param1 param2 param3)
	(monitorL setCycle: 0)
	(monitorR setCycle: 0)
	(switch param1
		(86
			(switch param2
				(94
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
				(92
					(monitorL view: 154 setLoop: 4 cel: 0)
					(monitorR view: 154 setLoop: 4 cel: 0)
				)
				(98
					(monitorL view: 154 setLoop: 3 cel: 0)
					(monitorR view: 154 setLoop: 3 cel: 0)
				)
				(99
					(monitorL view: 154 setLoop: 3 cel: 1)
					(monitorR view: 154 setLoop: 3 cel: 1)
				)
				(else
					(monitorL view: 154 setLoop: 4 cel: 14)
					(monitorR view: 154 setLoop: 4 cel: 14)
				)
			)
		)
		(84
			(monitorL
				view: 153
				setLoop: 6
				cel: 0
				cycleSpeed: 18
				setCycle: End param3
			)
			(monitorR view: 153 setLoop: 6 cel: 0 cycleSpeed: 18 setCycle: End)
		)
		(83
			(monitorL
				view: 153
				setLoop: 5
				cel: 0
				cycleSpeed: 8
				setCycle: End param3
			)
			(monitorR view: 153 setLoop: 5 cel: 0 cycleSpeed: 8 setCycle: End)
		)
		(87
			(monitorL view: 145 setLoop: 3 cel: 3)
			(monitorR view: 145 setLoop: 3 cel: 3)
		)
		(89
			(monitorL view: 145 setLoop: 3 cel: 0)
			(monitorR view: 145 setLoop: 3 cel: 0)
		)
		(90
			(monitorL view: 145 setLoop: 3 cel: 1)
			(monitorR view: 145 setLoop: 3 cel: 1)
		)
		(91
			(monitorL view: 145 setLoop: 3 cel: 2)
			(monitorR view: 145 setLoop: 3 cel: 2)
		)
		(85
			(monitorL view: 152 setLoop: 2 cel: 0)
			(monitorR view: 152 setLoop: 2 cel: 0)
		)
		(88
			(switch param2
				(93
					(monitorL view: 151 setLoop: 0 cycleSpeed: 6 cel: 0)
					(monitorR view: 151 setLoop: 0 cycleSpeed: 6 cel: 0)
				)
				(95
					(monitorL view: 151 setLoop: 1 cel: 0)
					(monitorR view: 151 setLoop: 1 cel: 0)
				)
				(92
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

(procedure (localproc_1 param1)
	(switch param1
		(96
			(applauseSign setCycle: Fwd)
			(applause play: setLoop: -1)
		)
		(97
			(applause fade: 0 10 10 1)
			(applauseSign cel: 0 setCycle: 0)
		)
	)
)

(class cObj of Obj
	(properties)
)

(instance rm140 of LarryRoom
	(properties
		picture 140
		horizon 0
	)

	(method (init)
		(SetCursor 98 0 0)
		(gGlobalSound2 number: 0 stop:)
		(super init: &rest)
		(Palette 2 0 255 local8) ; PalIntensity
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
					(and
						(not local6)
						(== (event message:) KEY_RETURN)
						(& (event type:) evKEYBOARD)
					)
				)
			)
			(event claimed: 1)
			(proc98_0)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(= local6 newRoomNumber)
		(gCast eachElementDo: #hide)
		(gThePlane drawPic: -1)
		(roomTimer setReal: self 2)
		(if global205
			(proc79_7)
		)
	)

	(method (cue)
		(roomTimer dispose: delete:)
		(Palette 2 0 255 100) ; PalIntensity
		(super newRoom: local6)
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
		signal 24609
		cycleSpeed 4
		moveSpeed 4
	)
)

(instance rockHard of Prop
	(properties
		x 118
		y 112
		priority 112
		fixPriority 1
		view 140
		loop 1
		cel 3
		signal 18465
	)
)

(instance girl1 of Prop
	(properties
		x 200
		y 108
		priority 108
		fixPriority 1
		view 140
		loop 1
		signal 18465
	)
)

(instance girl2 of Prop
	(properties
		x 217
		y 110
		priority 110
		fixPriority 1
		view 140
		loop 1
		cel 1
		signal 18465
	)
)

(instance girl3 of Prop
	(properties
		x 233
		y 112
		priority 112
		fixPriority 1
		view 140
		loop 1
		cel 2
		signal 18465
	)
)

(instance monitorL of Prop
	(properties
		x 281
		y 13
		priority 30
		fixPriority 1
		view 145
		loop 7
		signal 18465
	)
)

(instance monitorR of Prop
	(properties
		x 19
		y 13
		priority 30
		fixPriority 1
		view 145
		loop 7
		signal 18465
	)
)

(instance waveLeft of Prop
	(properties
		x 120
		y 40
		priority 40
		fixPriority 1
		view 142
		loop 1
		cel 4
		signal 18465
		cycleSpeed 15
	)
)

(instance waveRight of Prop
	(properties
		x 195
		y 40
		priority 40
		fixPriority 1
		view 142
		cel 7
		signal 18465
		cycleSpeed 15
	)
)

(instance applauseSign of Prop
	(properties
		x 204
		y 2
		view 149
		cel 1
	)
)

(instance drumFx of Sound ; UNUSED
	(properties
		flags 4
		number 142
	)
)

(instance applause of Sound
	(properties
		flags 4
		number 141
		loop -1
	)
)

(instance sfx of Sound
	(properties)
)

(instance shalo of Actor
	(properties
		x -18
		y 131
		view 144
		cel 6
		signal 18465
		cycleSpeed 4
		moveSpeed 4
	)

	(method (cue)
		(super cue:)
		(switch (++ local7)
			(1
				(self cycleSpeed: 4 moveSpeed: 4 setMotion: MoveTo 35 135 self)
			)
			(2
				(self setMotion: MoveTo -15 130 self)
			)
			(3
				(self view: 98 dispose:)
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
				(client view: 141 setLoop: register cel: 0)
				(= ticks 30)
			)
			(2
				(client setCycle: End self)
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
				((= local11 (View new:))
					view: 143
					setLoop: 0
					cel: 0
					x: 0
					y: 24
					priority: 199
					fixPriority: 1
					signal: 18465
					init:
					hide:
				)
				((= local12 (View new:))
					view: 143
					setLoop: 1
					cel: 0
					x: 0
					y: 73
					priority: 199
					fixPriority: 1
					signal: 18465
					init:
					hide:
				)
				((= local13 (View new:))
					view: 143
					setLoop: 2
					cel: 0
					x: 0
					y: 116
					fixPriority: 1
					priority: 199
					signal: 18465
					init:
					hide:
				)
				((= local14 (Prop new:))
					view: 143
					setLoop: 3
					cel: 0
					x: 154
					y: 139
					priority: 200
					fixPriority: 1
					signal: 18465
					init:
					setCycle: End self
				)
			)
			(1
				(gGlobalSound1 number: 145 loop: -1 play: setVol: 80)
				(waveLeft cycleSpeed: 0)
				(waveRight cycleSpeed: 0)
				(= register 0)
				(= local15 60)
				(= cycles 2)
			)
			(2
				(switch (Random 0 30)
					(1
						(localproc_0 86 99)
					)
					(2
						(localproc_0 88 92)
					)
					(3
						(localproc_0 88 95)
					)
					(4
						(localproc_0 85 92)
					)
					(5
						(localproc_0 89)
					)
					(6
						(localproc_0 90)
					)
					(7
						(localproc_0 91)
					)
					(8
						(localproc_0 87)
					)
				)
				(switch (++ register)
					(1
						(local13 hide:)
						(local11 show:)
					)
					(2
						(local11 hide:)
						(local12 show:)
					)
					(3
						(local12 hide:)
						(local13 show:)
						(= register 0)
					)
				)
				(if (-- local15)
					(-- state)
					(= cycles 1)
				else
					(local14 cycleSpeed: 12 setCycle: CT 6 -1 self)
				)
			)
			(3
				(waveLeft cycleSpeed: 15)
				(waveRight cycleSpeed: 15)
				(local11 dispose:)
				(local12 dispose:)
				(local13 dispose:)
				(= ticks 10)
			)
			(4
				(local14 cycleSpeed: 6 setCycle: Beg self)
			)
			(5
				(gGlobalSound1 number: 140 loop: -1 play: setVol: 80)
				(local14 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance cartoonScr of Script
	(properties)

	(method (dispose &tmp temp0)
		(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
			(Lock rsVIEW [local0 temp0] 0)
			(UnLoad 128 [local0 temp0])
		)
		(sfx number: 0 dispose:)
		(proc79_12 144)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
					(Load rsVIEW [local0 temp0])
					(Lock rsVIEW [local0 temp0] 1)
				)
				(applauseSign init: cel: 0)
				(shalo
					view: 146
					setLoop: 0 1
					x: 47
					y: 124
					setCycle: Walk
					init:
					setMotion: MoveTo 67 124 self
				)
				(rockHard init: setScript: (fidgetScr new:) 0 3)
				(girl1 init: setScript: (fidgetScr new:) 0 0)
				(girl2 init: setScript: (fidgetScr new:) 0 1)
				(girl3 init: setScript: (fidgetScr new:) 0 2)
				(monitorL init:)
				(monitorR init:)
				(gEgo
					init:
					view: 140
					setLoop: 1
					cel: 4
					x: 88
					y: 114
					setPri: 30
				)
			)
			(1
				(if (not global205)
					(proc79_8 25)
				)
				(shalo setLoop: 3 cel: 0)
				(= ticks 30)
			)
			(2
				(gMessager sayRange: 0 0 1 1 3 self) ; "...and don't worry about thinking up answers while we're taping."
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
				(gMessager sayRange: 0 0 1 4 6 self) ; "But, wait, Ms. Shalo! I didn't give you any answers earlier. I haven't gone out with these women. In fact, I've never even seen them before!"
			)
			(7
				(if global205
					(proc79_7)
				)
				(gMessager say: 0 0 1 7) ; "(CHEAP PA SYSTEM DIRECTOR VOICE OVER) Places, people, places! Lights! Playback! In 5... 4... 3..."
				(= ticks 240)
			)
			(8
				(if (<= (++ local8) 100)
					(Palette 2 0 255 local8) ; PalIntensity
					(-- state)
				)
				(= ticks 3)
			)
			(9
				(if (gTalkers size:)
					(-- state)
				)
				(= ticks 10)
			)
			(10
				(gGlobalSound1
					number: 140
					loop: -1
					play:
					setVol: 80
					fade: 127 10 10 0
				)
				(waveLeft init: setCycle: Fwd)
				(waveRight init: setCycle: Fwd)
				(= ticks 30)
			)
			(11
				(proc79_11 144)
				(biff view: 98 setLoop: 0 x: -15 y: 130 init:)
				(localproc_1 96)
				(localproc_0 86 92)
				(gMessager say: 0 0 1 8 self) ; "(VOICE OVER ANNOUNCER) Live! From somewhere near Hollywood, California! It's the latest and greatest in embarrassment television: (WHINNY)"
			)
			(12
				(= ticks 60)
			)
			(13
				(sfx number: 144 loop: 1 play: self)
			)
			(14
				(gMessager say: 0 0 1 9 self) ; "STALLIONS!"
			)
			(15
				(localproc_0 86 94 self)
			)
			(16
				(= ticks 60)
			)
			(17
				(localproc_0 89)
				(gMessager say: 0 0 1 10 self) ; "Today featuring three hot young Fillies from the Mensa chapter of downtown Pasadena!"
			)
			(18
				(localproc_0 90)
				(= ticks 120)
			)
			(19
				(localproc_0 91)
				(= ticks 120)
			)
			(20
				(localproc_0 87)
				(gMessager say: 0 0 1 11 self) ; "And also featuring two of the hung-est Stallions we could pry away from Venice Beach!"
			)
			(21
				(localproc_0 88 92)
				(= ticks 120)
			)
			(22
				(gMessager say: 0 0 1 12 self) ; "And now, let's all give a big whinny for the star of our show: (NEIGH) (WHINNY) (SNICKER)"
			)
			(23
				(sfx number: 144 loop: 1 play: self)
				(localproc_0 86)
			)
			(24
				(gMessager say: 0 0 1 13) ; "BIFF STIFF!"
				(biff
					view: 144
					setLoop: 0 1
					setCycle: Walk
					cycleSpeed: 2
					moveSpeed: 2
					setMotion: MoveTo 35 135 self
				)
			)
			(25
				(localproc_0 87)
				(biff setMotion: MoveTo 52 125 self)
			)
			(26
				(biff setMotion: MoveTo 158 109 self)
			)
			(27
				(localproc_0 88 92)
				(= ticks 120)
			)
			(28
				(biff view: 150 setLoop: 3 cel: 2)
				(= ticks 60)
			)
			(29
				(localproc_0 86 98)
				(biff setLoop: 3 cycleSpeed: 6 setCycle: Fwd)
				(= ticks 90)
			)
			(30
				(biff setLoop: 4 cel: 0 setCycle: 0)
				(= ticks 30)
			)
			(31
				(localproc_1 97)
				(gGlobalSound1 fade: 100 10 10 0)
				(biff cycleSpeed: 12 setCycle: End self)
			)
			(32
				(= ticks 60)
			)
			(33
				(biff cycleSpeed: 12 setCycle: Beg self)
			)
			(34
				(localproc_0 85 92)
				(biff view: 147)
				(cond
					((> gHowFast 10)
						(= ticks 240)
					)
					((> gHowFast 3)
						(= ticks 120)
					)
					(else
						(= ticks 60)
					)
				)
			)
			(35
				(localproc_0 85 93)
				(gMessager say: 0 0 1 14 self) ; "Welcome back, everybody. Let's meet our contestants."
			)
			(36
				(localproc_0 88 92)
				(gMessager say: 0 0 1 15 self) ; "Stallion number two is a professional body builder and part-time out-of-work concrete form dismantler who credits his physical success to HerbaByte. Let's hear it for LARRY LAFFER!"
			)
			(37
				(localproc_1 96)
				(= ticks 120)
			)
			(38
				(localproc_1 97)
				(localproc_0 87)
				(gMessager say: 0 0 1 16 self) ; "Stallion number one is also a professional body builder and an apprentice condom sizer who guarantees that, around him, women come first! Really slam 'em together for ROCK HARD!"
			)
			(39
				(localproc_1 96)
				(= ticks 120)
			)
			(40
				(localproc_0 89)
				(gMessager sayRange: 0 0 1 17 18 self) ; "(COMING DOWN IN INTENSITY) As you regular fans know, both of these Stallions recently had a dream date with each of our three lovely Fillies."
			)
			(41
				(localproc_0 90)
				(localproc_1 97)
				(= ticks 120)
			)
			(42
				(localproc_0 91)
				(localproc_1 96)
				(= ticks 120)
			)
			(43
				(localproc_0 85 92)
				(gMessager say: 0 0 1 19 self) ; "OOPS, I'm sorry! I meant "heavy BREATHING!" HA, HA, HA!"
			)
			(44
				(= ticks 30)
			)
			(45
				(localproc_1 97)
				(gMessager say: 0 0 1 20 self) ; "And now, let's meet our three little Fillies!"
			)
			(46
				(localproc_0 89)
				(gMessager say: 0 0 2 1 self) ; "Filly number one is a nuclear chemist specializing in zero gravity liquid-fueled propulsion systems who has a mainframe computer right in her very own home. Yes, that's right: she really IS a rocket scientist! How about some animal noises for DR. SHARLA MANE!"
			)
			(47
				(localproc_1 96)
				(= ticks 240)
			)
			(48
				(localproc_1 97)
				(localproc_0 90)
				(gMessager say: 0 0 2 2 self) ; "Filly number two also hails from Pasadena where she leads a think tank specializing in international economics, monetary systems, and currency stabilization. Get it off for DR. SHARLA O'HARA!"
			)
			(49
				(localproc_1 96)
				(= ticks 240)
			)
			(50
				(localproc_1 97)
				(localproc_0 91)
				(gMessager say: 0 0 2 3 self) ; "And finally, Filly number three is one hunk of prime horseflesh: with PhDs in marine biology, sub-atomic nuclear physics, and film studies, a woman who expects more from her man than just intelligent conversation! Hoot it up a while for DR. SHARLA TANN!"
			)
			(51
				(localproc_1 96)
				(= ticks 240)
			)
			(52
				(localproc_0 85 92)
				(= ticks 120)
			)
			(53
				(localproc_1 97)
				(biff view: 150 setLoop: 5 cel: 0 setCycle: End self)
			)
			(54
				(biff view: 148)
				(localproc_0 85 93)
				(gMessager say: 0 0 2 4 self) ; "I'm sure you all know the rules, so let's get right to the game: Larry, you're first."
			)
			(55
				(localproc_0 88 95)
				(= ticks 120)
			)
			(56
				(localproc_0 88 93)
				(= ticks 120)
			)
			(57
				(gMessager say: 0 0 2 5 self) ; "Me? Uh, I dunno. I'm not really prepared..."
			)
			(58
				(localproc_0 88 92)
				(= ticks 120)
			)
			(59
				(localproc_0 88 93)
				(gMessager say: 0 0 2 6 self) ; "Oh, what the hell! I'll take Greek Mythology for $500, Alex!"
			)
			(60
				(localproc_0 88 95)
				(gMessager say: 0 0 2 7 self) ; "That's about all of this we need to see, isn't it? Let's fast forward..."
				(self setScript: ffScr self)
			)
			(61)
			(62
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(= ticks 30)
			)
			(63
				(localproc_0 85 93)
				(gMessager say: 0 0 2 8 self) ; "...and we're back with our contestants. Larry, what now?"
			)
			(64
				(localproc_0 88 93)
				(gMessager say: 0 0 2 9 self) ; "Uh, could I buy a vowel, Pat?"
			)
			(65
				(localproc_0 88 92)
				(gMessager say: 0 0 2 10 self) ; "YIKES! This is not going well! Let's cut to the chase..."
				(self setScript: ffScr self)
			)
			(66)
			(67
				(localproc_1 96)
				(localproc_0 85 93)
				(gMessager say: 0 0 2 11 self) ; "And the winner of today's show: ROCK HARD!"
			)
			(68
				(localproc_0 85 93)
				(gMessager say: 0 0 2 12 self) ; "Rock and Sharla win an all-expense paid cruise down the lovely Mexican Riviera, with stops at Tijuana and Juarez!"
			)
			(69
				(localproc_0 84 94 self)
			)
			(70
				(cond
					((> gHowFast 10)
						(= ticks 120)
					)
					((> gHowFast 3)
						(= ticks 90)
					)
					(else
						(= ticks 60)
					)
				)
			)
			(71
				(localproc_0 88 92)
				(gMessager say: 0 0 2 13 self) ; "And our second prize goes to Larry Laffer: immediately after the show you'll travel by studio limo to the exclusive health spa and resort, "La Costa Lotta," where you'll spend a wonderful two (some-expense-paid) weeks!"
			)
			(72
				(localproc_0 83 94 self)
			)
			(73
				(cond
					((> gHowFast 10)
						(= ticks 120)
					)
					((> gHowFast 3)
						(= ticks 90)
					)
					(else
						(= ticks 60)
					)
				)
			)
			(74
				(localproc_0 85 93)
				(gMessager say: 0 0 2 14 self) ; "Thanks for watching, folks! And be sure to tune in again tomorrow for another episode of... (WHINNY)"
			)
			(75
				(gGlobalSound1 fade: 127 10 5 0)
				(localproc_0 86 99)
				(sfx number: 144 loop: 1 play: self)
			)
			(76
				(gMessager say: 0 0 2 15 self) ; "STALLIONS!"
			)
			(77
				(cond
					((> gHowFast 10)
						(= ticks 120)
					)
					((> gHowFast 3)
						(= ticks 90)
					)
					(else
						(= ticks 60)
					)
				)
			)
			(78
				(waveLeft dispose:)
				(waveRight dispose:)
				(gGlobalSound1 fade:)
				(localproc_1 97)
				(localproc_0 0)
				(Palette 2 0 255 60) ; PalIntensity
				(cond
					((> gHowFast 10)
						(= ticks 240)
					)
					((> gHowFast 3)
						(= ticks 120)
					)
					(else
						(= ticks 60)
					)
				)
			)
			(79
				(shalo
					view: 146
					setLoop: 0
					x: -15
					y: 130
					setCycle: Walk
					cycleSpeed: 4
					moveSpeed: 4
					init:
					setMotion: MoveTo 35 135 self
				)
			)
			(80
				(shalo setMotion: MoveTo 52 125 self)
			)
			(81
				(shalo setMotion: MoveTo 135 117 self)
			)
			(82
				(shalo setLoop: 4 cel: 0)
				(= ticks 60)
			)
			(83
				(shalo cel: 1)
				(= ticks 30)
			)
			(84
				(gMessager say: 0 0 2 16 self) ; "Rock, Honey, here's your tickets for the cruise. I'm afraid Sharla won't be going with you; she opted for the cash payoff instead. But you won't be lonely; I'll be waiting for you in your cabin!"
			)
			(85
				((ScriptID 1823 33) name: {Rock Hard}) ; Voice_Over_Announcer
				(gMessager say: 0 0 2 17 self) ; "(DISINTERESTED) Whatever."
			)
			(86
				(shalo cel: 0)
				(= ticks 30)
			)
			(87
				(shalo setLoop: 1 setCycle: Walk setMotion: MoveTo 102 124 self)
			)
			(88
				(shalo setLoop: 2 cel: 3)
				(= ticks 30)
			)
			(89
				(gMessager say: 0 0 2 18 self) ; "You come with me, Doofus!"
			)
			(90
				(= local7 0)
				(shalo setLoop: 1 setCycle: Walk setMotion: MoveTo 52 125 shalo)
				(= ticks 60)
			)
			(91
				(gEgo view: 900 setLoop: 8 cel: 2)
				(= ticks 60)
			)
			(92
				(gMessager say: 0 0 2 19 self) ; "That's Laffer!"
			)
			(93
				(cond
					((> gHowFast 10)
						(= ticks 120)
					)
					((> gHowFast 3)
						(= ticks 90)
					)
					(else
						(= ticks 60)
					)
				)
			)
			(94
				(gEgo
					normalize: 900 2
					cycleSpeed: 6
					moveSpeed: 6
					setLoop: 1 1
					setCycle: Walk
					setMotion: MoveTo 52 125 self
				)
			)
			(95
				(gEgo setMotion: MoveTo 35 135 self)
			)
			(96
				(gEgo setMotion: MoveTo -15 130 self)
			)
			(97
				(= ticks 30)
			)
			(98
				(gMessager say: 0 0 2 20 self) ; "Here's your limo, Lasser. Enjoy the ride!"
			)
			(99
				(= ticks 30)
			)
			(100
				(gEgo view: 98 x: 100 y: 100)
				(gCast eachElementDo: #dispose)
				(gGame hideControls:)
				(gThePlane drawPic: -1 10)
				(= cycles 2)
			)
			(101
				(Palette 2 0 255 100) ; PalIntensity
				(= ticks 60)
			)
			(102
				(gMessager sayRange: 0 0 2 21 23 self) ; "Wow! What a cherry '73 Pacer!!"
			)
			(103
				(gCurRoom newRoom: 800)
			)
		)
	)
)

