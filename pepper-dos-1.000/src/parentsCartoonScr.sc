;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 121)
(include sci.sh)
(use Main)
(use rm120)
(use CycleBet)
(use BalloonTalker)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	parentsCartoonScr 0
	momText 1
	dadText 2
	lockjawChewGumScr 3
	climbPipeScr 4
)

(local
	local0
	local1
)

(instance mom of Actor
	(properties
		view 123
		signal 26640
	)
)

(instance dad of Actor
	(properties
		view 123
		signal 26640
	)
)

(instance momText of BalloonTalker
	(properties
		x 4
		y 74
		talkWidth 135
		tailPosn 4
	)

	(method (say)
		(mom setCycle: Fwd)
		(super say: &rest)
	)

	(method (dispose)
		(mom setCycle: 0 cel: 0 forceUpd: stopUpd:)
		(super dispose: &rest)
	)
)

(instance dadText of BalloonTalker
	(properties
		x 104
		y 68
		talkWidth 175
		tailPosn 3
	)

	(method (say)
		(dad setCycle: Fwd)
		(super say: &rest)
	)

	(method (dispose)
		(dad setCycle: 0 cel: 0 forceUpd: stopUpd:)
		(super dispose: &rest)
	)
)

(instance parentsCartoonScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 1209 setLoop: 1 play: self)
				(ShakeScreen 5 (Random 1 3))
			)
			(1
				(mom x: 156 y: 83 setLoop: 1 cel: 0 setPri: 3 init:)
				(dad x: 97 y: 83 setLoop: 0 cel: 0 setPri: 3 init:)
				(= ticks 30)
			)
			(2
				(mom setMotion: MoveTo 144 83 self)
				(dad setMotion: MoveTo 121 83 self)
				((ScriptID 895 1) normal: 0) ; lockjaw
			)
			(3)
			(4
				(gLongSong2 number: 1209 setLoop: 1 play: self)
				(ShakeScreen 5 (Random 1 3))
				(gCast eachElementDo: #stopUpd)
			)
			(5
				(gMessager say: 1 0 1 0 self 121) ; "I can't take this anymore. Uncle Fred's gotta go back to the nursing home."
			)
			(6
				(gLongSong2 loop: 0)
				(mom setLoop: 6 cel: 0 setMotion: MoveTo 156 83 self)
				(dad cel: 0 setMotion: MoveTo 156 83 self)
			)
			(7
				(mom x: 1000 dispose:)
			)
			(8
				(dad x: 1000 dispose:)
				(= cycles 2)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance lockjawChewGumScr of Script
	(properties)

	(method (dispose)
		((ScriptID 895 1) normal: 1) ; lockjaw
		(gGame handsOn:)
		(super dispose: &rest)
		(DisposeScript 121)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(= local1 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(proc120_2 1)
				(SetFlag 6)
				(= cycles 2)
			)
			(1
				((ScriptID 895 0) setMotion: PolyPath 228 155 self) ; pepper
			)
			(2
				((ScriptID 895 0) setHeading: 225) ; pepper
				((ScriptID 895 1) ; lockjaw
					normal: 0
					normalize:
					ignoreActors: 1
					setMotion: PolyPath 207 154 self
				)
				(gGame points: 196 1)
			)
			(3
				((ScriptID 895 1) setLoop: 8 cel: 4 setCycle: 0 forceUpd:) ; lockjaw
				((ScriptID 895 0) stopUpd:) ; pepper
				(= cycles 3)
			)
			(4
				(gMessager say: 2 104 0 1 self 121) ; "Here you go, Lockjaw! Just what you always wanted!"
			)
			(5
				((ScriptID 895 1) x: 1000 hide: stopUpd:) ; lockjaw
				(gEgo
					view: 121
					setLoop: 2
					cel: 0
					cycleSpeed: 5
					posn: 215 154
					setCycle: End self
				)
			)
			(6
				(gLongSong2 number: 1204 loop: 1 play: self)
				(gEgo setLoop: 5 cel: 0 setCycle: Fwd)
			)
			(7
				(gLongSong2 number: 1205 loop: 1 play: self)
				(gEgo cycleSpeed: 4 setLoop: 3 cel: 0 setCycle: CT 5 1 self)
			)
			(8)
			(9
				(gLongSong2 number: 1208 loop: 1 play: self)
				(gEgo cel: 6)
			)
			(10
				(= ticks 30)
			)
			(11
				(gLongSong2 number: 1203 loop: 1 play: self)
				(gEgo cycleSpeed: 6 cel: 9 setCycle: CycleBet 9 11 2)
				(= cycles 2)
			)
			(12
				((ScriptID 2000 3) winX: 70 winY: 116 tailPosn: 1) ; PepperTalker
				(gMessager say: 2 104 0 2 self 121) ; "Ha ha ha ha! Wow! What a totally talented dog!"
			)
			(13
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(gEgo setCycle: End self)
			)
			(14)
			(15
				((= register (Prop new:))
					view: 121
					setLoop: 6
					cel: 0
					x: 218
					y: 143
					setPri: 15
					ignoreActors: 1
					init:
					cycleSpeed: 6
					setCycle: End self
				)
				(gLongSong2 number: 949 loop: 1 play: self)
			)
			(16)
			(17
				(register dispose:)
				(gEgo
					cycleSpeed: 6
					setLoop: 4
					cel: 0
					x: (- (gEgo x:) 2)
					y: (+ (gEgo y:) 1)
					setCycle: CT 2 1 self
				)
			)
			(18
				(gLongSong2 number: 1206 loop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(19)
			(20
				((ScriptID 895 1) ; lockjaw
					normalize:
					view: 838
					setLoop: 1
					cel: 0
					setCycle: End
					cycleSpeed: 6
					x: 207
					y: 154
					show:
					approachX: 207
					approachY: 166
				)
				(gEgo
					normalize: 800
					x: 228
					y: 155
					loop: 8
					cel: 5
					cycleSpeed: local0
				)
				((ScriptID 120 4) init: posn: 261 154) ; softGum
				(proc120_2)
				(= seconds 3)
			)
			(21
				(self dispose:)
			)
		)
	)
)

(instance climbPipeScr of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 121)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 1) normal: 0) ; lockjaw
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath 64 117 self
				)
			)
			(1
				(gEgo setLoop: 6 setMotion: MoveTo 67 116 self)
			)
			(2
				(gEgo loop: 8 cel: 6 heading: 45)
				(= ticks 30)
			)
			(3
				(gMessager say: 3 7 2 0 self 121) ; "Hmm, maybe I'll just shinny on up this drainpipe..."
			)
			(4
				(self setScript: parentsCartoonScr self)
			)
			(5
				(proc120_2 1)
				((ScriptID 895 1) ; lockjaw
					normalize:
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath 46 115 self
				)
			)
			(6
				((ScriptID 895 1) setLoop: 8 setCycle: 0 cel: 6 x: 46 y: 115) ; lockjaw
				(= ticks 60)
			)
			(7
				((ScriptID 895 1) hide:) ; lockjaw
				((ScriptID 895 0) ; pepper
					view: 122
					setLoop: 2
					cel: 0
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(8
				(gMessager say: 1 7 3 1 self 121) ; "Lockjaw! Let go of my leg, you hairball!"
			)
			(9
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(10
				((ScriptID 895 1) show:) ; lockjaw
				((ScriptID 895 0) ; pepper
					normalize:
					loop: 8
					cel: 6
					heading: 45
					x: 67
					y: 116
				)
				(= ticks 90)
			)
			(11
				((ScriptID 895 0) setHeading: 125 self) ; pepper
			)
			(12
				(= cycles 2)
			)
			(13
				((ScriptID 895 0) setLoop: 4 setMotion: MoveTo 85 136 self) ; pepper
			)
			(14
				((ScriptID 895 0) setHeading: 270 self) ; pepper
				((ScriptID 895 1) cel: 0) ; lockjaw
			)
			(15
				((ScriptID 895 1) cel: 4) ; lockjaw
				(= ticks 30)
			)
			(16
				(gMessager say: 1 7 3 2 5 self 121) ; "Whiiiiine!"
			)
			(17
				((ScriptID 895 1) ; lockjaw
					normalize:
					setLoop: 5
					setMotion: MoveTo 23 129 self
				)
			)
			(18
				((ScriptID 895 1) view: 838 setLoop: 1 cel: 0 setCycle: End) ; lockjaw
				(gEgo setMotion: PolyPath 45 111 self)
			)
			(19
				(gEgo setMotion: MoveTo 49 104 self)
			)
			(20
				(gEgo setPri: 1 setHeading: 180 self)
			)
			(21
				(= cycles 2)
			)
			(22
				(gMessager say: 1 7 3 6 self 121) ; "Go get it, boy! Go fetch!"
			)
			(23
				(gGame setEgo: (ScriptID 895 1)) ; lockjaw
				((ScriptID 120 3) approachX: 17 approachY: 116) ; flowerBed
				(= cycles 2)
			)
			(24
				(gEgo normalize:)
				(gGame handsOn:)
				(SetCursor 150 0)
				(self dispose:)
			)
		)
	)
)

