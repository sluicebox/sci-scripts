;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 376)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm376 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 7]
	local14
)

(instance rm376 of SQRoom
	(properties
		picture 376
		style 30
		south 375
	)

	(method (init)
		(HandsOn)
		(if (not (IsFlag 2))
			(self setRegions: 700) ; mall
		else
			(DisposeScript 700)
		)
		(Load rsVIEW 376)
		(screen1 init:)
		(screen2 init: setCycle: Fwd)
		(screen3 init: setCycle: Fwd)
		(screen4 init: setCycle: Fwd)
		(screen5 init: setPri: 12 setCycle: Fwd)
		(screen6 init: setCycle: Fwd)
		(screen7 init: setCycle: Fwd)
		(screen10 init: setCycle: Fwd)
		(= [local7 0] kid)
		((= [local7 1] (kid new:)) loop: 8 x: 197 y: 175 cycleSpeed: 1 init:)
		((= [local7 2] (kid new:)) loop: 9 x: 240 y: 134 cycleSpeed: 2 init:)
		((= [local7 3] (kid new:)) loop: 10 x: 97 y: 114 cycleSpeed: 3 init:)
		((= [local7 4] (kid new:))
			loop: 11
			x: 80
			y: 128
			cycleSpeed: 0
			priority: 7
			signal: 16400
			init:
		)
		((= [local7 5] (kid new:)) loop: 12 x: 118 y: 172 cycleSpeed: 1 init:)
		((= [local7 6] (kid new:)) loop: 13 x: 285 y: 137 cycleSpeed: 3 init:)
		(kid init:)
		(gLongSong number: 0 stop:)
		(gLongSong2 vol: 127 changeState:)
		(switch global101
			(2
				(kid setScript: aniKids 0 3)
			)
			(1
				(screen6 addToPic:)
				(screen7 addToPic:)
				(kid setScript: aniKids 0 2)
			)
			(0
				(gCast eachElementDo: #addToPic)
				(kid setScript: aniKids 0 1)
			)
		)
		(if (IsFlag 5)
			(pod cel: 7 init: stopUpd:)
			(hatch init: stopUpd:)
		else
			(= local0 1)
			(blast init: stopUpd:)
		)
		(changeMachine init:)
		(arcadeRoom init:)
		(super init:)
		(switch gPrevRoomNum
			(531
				(self
					setScript:
						(if (IsFlag 2)
							egoArrives
						else
							(gEgo
								view: 377
								loop: 3
								cel: 0
								posn: 27 156
								setPri: 12
								ignoreActors:
								illegalBits: 0
								normal: 0
								moveHead: 0
								init:
							)
							egoExitsPod
						)
				)
			)
			(375
				(gEgo posn: (if (> (gEgo y:) 57) 100 else 220) 188 init:)
				(if (and (IsFlag 20) (not (IsFlag 24)))
					(sp2 init: posn: (gEgo x:) 143)
					(blast init: stopUpd:)
					(self setScript: shootDown)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 187 0 -1 319 -1 319 188 257 189 235 181 230 174 231 168 238 163 262 153 289 149 267 132 257 132 255 138 226 138 219 126 238 123 213 108 132 107 130 110 115 110 110 114 96 117 86 127 73 132 61 132 38 144 43 148 59 156 80 158 69 172 59 172 49 177 31 183
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 199 185 172 185 168 189 150 189 146 185 120 185 124 175 97 171 103 161 128 162 140 123 175 123 192 165 217 165 221 178 198 179
							yourself:
						)
				)
			)
			(290 ; astro
				(gLongSong2 number: 19 vol: 127 loop: -1 playBed:)
				(NormalEgo 1 0 4)
				(gEgo posn: 58 143 init:)
				(HandsOn)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 187 0 -1 319 -1 319 188 257 189 235 181 230 174 231 168 238 163 262 153 289 149 267 132 257 132 255 138 226 138 219 126 238 123 213 108 132 107 130 110 115 110 110 114 96 117 86 127 73 132 61 132 38 144 43 148 59 156 80 158 69 172 59 172 49 177 31 183
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 199 185 172 185 168 189 150 189 146 185 120 185 124 175 97 171 103 161 128 162 140 123 175 123 192 165 217 165 221 178 198 179
							yourself:
						)
				)
			)
			(else
				(NormalEgo)
				(gEgo posn: 107 184 init:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 187 0 -1 319 -1 319 188 257 189 235 181 230 174 231 168 238 163 262 153 289 149 267 132 257 132 255 138 226 138 219 126 238 123 213 108 132 107 130 110 115 110 110 114 96 117 86 127 73 132 61 132 38 144 43 148 59 156 80 158 69 172 59 172 49 177 31 183
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 199 185 172 185 168 189 150 189 146 185 120 185 124 175 97 171 103 161 128 162 140 123 175 123 192 165 217 165 221 178 198 179
							yourself:
						)
				)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and local0 (== (gEgo onControl: 1) 2) (== (gEgo view:) 0))
			(gEgo setScript: spArrive)
		)
	)
)

(instance spArrive of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 5)
				(SetFlag 20)
				(kid setScript: 0)
				(for ((= temp0 0)) (<= temp0 6) ((++ temp0))
					([local7 temp0] addToPic:)
				)
				(gCast eachElementDo: #stopUpd)
				(= local0 0)
				(sparks init: setCycle: Fwd)
				(= cycles 10)
			)
			(1
				(pod init: setCycle: CT 6 1 self)
			)
			(2
				(gEgo setHeading: 230)
				(hatch init:)
				(pod cel: 7)
				(= cycles 1)
			)
			(3
				(pod stopUpd:)
				(sp1 init:)
				(= cycles 6)
			)
			(4
				(sparks dispose:)
				(hatch setCycle: End self)
				(gEgo stopUpd:)
			)
			(5
				(sp1 setCycle: End self)
			)
			(6
				(sp1
					view: 7
					setCycle: Walk
					setLoop: -1
					setCel: -1
					setPri: -1
					setStep: 2 3
				)
				(sp2 init: posn: 3 159 setMotion: MoveTo 27 156 self)
			)
			(7
				(sp1 setMotion: MoveTo 68 155)
				(sp2 posn: 27 156 setCycle: End self)
			)
			(8
				(sp2
					view: 7
					setCycle: Walk
					setLoop: -1
					setCel: -1
					setPri: -1
					setStep: 2 3
					stopUpd:
				)
				(hatch setCycle: Beg self)
			)
			(9
				(hatch stopUpd:)
				(sp1 setMotion: MoveTo 89 160 self)
			)
			(10
				(sp1 setMotion: MoveTo 69 237 self)
			)
			(11
				(sp1 dispose:)
				(HandsOn)
				(sp2 setMotion: MoveTo 60 145 self)
			)
			(12
				(sp2 setMotion: MoveTo 112 119 self)
			)
			(13
				(sp2 setMotion: MoveTo 203 119 self)
			)
			(14
				(sp2 setMotion: MoveTo 242 188 self)
			)
			(15
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance shootDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: 0)
				(sp2 setMotion: 0 view: 13 setLoop: 2 cel: 0)
				(= cycles 6)
			)
			(1
				(= local14
					(proc0_12
						{HALT, WILCO!}
						67
						(sp2 x:)
						50
						28
						global132
						29
						global139
					)
				)
				(gEgo setMotion: 0)
				(sp2 setPri: -1 stopUpd:)
				(= cycles 7)
			)
			(2
				(proc0_12 local14)
				(sp2 setCycle: CT 2 1 self)
			)
			(3
				(if (< (gEgo distanceTo: sp2) 50)
					(self changeState: 8)
				else
					(= local2 (- (sp2 y:) 31))
					(= local4 155)
					(= local5 (- (sp2 x:) 4))
					(= local3 248)
					(= local1
						(Graph grSAVE_BOX local2 (- local5 1) local4 (+ local3 1) 1)
					)
					(Graph
						grDRAW_LINE
						local2
						local5
						local4
						local3
						global133
						(- (gEgo priority:) 1)
						-1
					)
					(Graph grREDRAW_BOX local2 (- local5 1) local4 (+ local3 1))
					(= cycles 1)
				)
			)
			(4
				(sp2 cel: 0)
				(blast setCycle: End)
				(= cycles 2)
			)
			(5
				(Graph grRESTORE_BOX local1)
				(Graph grREDRAW_BOX local2 (- local5 1) local4 (+ local3 1))
				(= cycles 12)
			)
			(6
				(sp2 setCycle: CT 2 1 self)
			)
			(7
				(sp2 stopUpd:)
				(= cycles 1)
			)
			(8
				(HandsOff)
				(gEgo setMotion: 0)
				(= local2 (- (sp2 y:) 31))
				(= local4 (- (gEgo y:) 28))
				(= local5 (- (sp2 x:) 4))
				(= local3 (gEgo x:))
				(= local1 (Graph grSAVE_BOX local2 (- local5 1) local4 (+ local3 1) 1))
				(Graph
					grDRAW_LINE
					local2
					local5
					local4
					local3
					global133
					(- (gEgo priority:) 1)
					-1
				)
				(Graph grREDRAW_BOX local2 (- local5 1) local4 (+ local3 1))
				(= cycles 1)
			)
			(9
				(blast cel: 0 posn: local3 local4 setPri: 15 setCycle: End self)
			)
			(10
				(EgoDead 376 0) ; "Smoking is bad for your health."
			)
		)
	)
)

(instance shootOther of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setScript: 0)
				(sp2 setMotion: 0 view: 13 setLoop: register cel: 0)
				(= cycles 2)
			)
			(1
				(= local14
					(proc0_12
						{HALT, WILCO!}
						67
						(sp2 x:)
						30
						28
						global132
						29
						global139
					)
				)
				(gEgo setMotion: 0)
				(sp2 stopUpd:)
				(= cycles 7)
			)
			(2
				(proc0_12 local14)
				(sp2 setCycle: CT 1 1 self)
			)
			(3
				(if (== register 3)
					(= local5 (+ (sp2 x:) 6))
					(= local4 (- (sp2 y:) 33))
				else
					(= local5 (+ (sp2 x:) 27))
					(= local4 (- (sp2 y:) 29))
				)
				(= local3 (+ (gEgo x:) 2))
				(= local2 (- (gEgo y:) 34))
				(= local1 (Graph grSAVE_BOX local2 (- local5 1) local4 (+ local3 1) 1))
				(Graph
					grDRAW_LINE
					local4
					local5
					local2
					local3
					global133
					(- (gEgo priority:) 1)
					-1
				)
				(Graph grREDRAW_BOX local2 (- local5 1) local4 (+ local3 1))
				(= cycles 1)
			)
			(4
				(blast cel: 0 posn: local3 local2 setPri: 15 setCycle: End self)
			)
			(5
				(EgoDead 376 0) ; "Smoking is bad for your health."
			)
		)
	)
)

(instance egoArrives of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 8)
			)
			(1
				(pod init: setCycle: CT 2 1 self)
			)
			(2
				(sparks init: setCycle: Fwd)
				(pod setCycle: CT 6 1 self)
			)
			(3
				(pod setCel: 7 setPri: -1 stopUpd:)
				(hatch init: stopUpd:)
				(= cycles 12)
			)
			(4
				(sparks dispose:)
				(= cycles 1)
			)
			(5
				(gLongSong2 fade:)
				(gCurRoom newRoom: 531)
			)
		)
	)
)

(instance egoExitsPod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 5)
				(= local0 0)
				(pod setCel: 7 init: stopUpd:)
				(hatch init: setCycle: End self)
			)
			(1
				(= cycles 4)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(hatch setCycle: Beg self)
			)
			(4
				(hatch stopUpd:)
				(gEgo loop: 0 normal: 1 moveHead: 1 view: 0)
				(NormalEgo)
				(gEgo setMotion: PolyPath 51 146 self)
			)
			(5
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 187 0 -1 319 -1 319 188 257 189 235 181 230 174 231 168 238 163 262 153 289 149 267 132 257 132 255 138 226 138 219 126 238 123 213 108 132 107 130 110 115 110 110 114 96 117 86 127 73 132 61 132 38 144 43 148 59 156 80 158 69 172 59 172 49 177 31 183
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 199 185 172 185 168 189 150 189 146 185 120 185 124 175 97 171 103 161 128 162 140 123 175 123 192 165 217 165 221 178 198 179
							yourself:
						)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoEntersPod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 27 156 self)
			)
			(1
				(hatch setCycle: End self)
			)
			(2
				(gEgo
					view: 377
					loop: 3
					cel: 5
					posn: 27 156
					setPri: 13
					ignoreActors:
					illegalBits: 0
					normal: 0
					moveHead: 0
					setCycle: Beg self
				)
			)
			(3
				(= cycles 4)
			)
			(4
				(hatch setCycle: Beg self)
			)
			(5
				(ClearFlag 5)
				(gLongSong2 fade:)
				(gCurRoom newRoom: 531)
			)
		)
	)
)

(instance playChicken of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 58 143 self)
			)
			(1
				(gLongSong2 fade:)
				(gCurRoom newRoom: 290) ; astro
			)
		)
	)
)

(instance pod of Prop
	(properties
		x 26
		y 161
		description {time pod}
		lookStr {You give the Time Pod a long glance. It's not the most attractive vehicle you've ever seen. It resembles an overgrown titanium tennis shoe. A gold-tinted glass shield seals the top.}
		view 377
		priority 12
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: egoEntersPod)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sparks of Prop
	(properties
		x 32
		y 140
		view 377
		loop 1
		priority 13
		signal 16400
	)
)

(instance hatch of Prop
	(properties
		x 2
		y 132
		view 377
		loop 2
		priority 14
		signal 16400
	)
)

(instance sp1 of Actor
	(properties
		x 27
		y 156
		view 377
		loop 4
		priority 13
		signal 22544
		illegalBits 0
	)
)

(instance sp2 of Actor
	(properties
		view 377
		loop 4
		priority 13
		signal 22544
		illegalBits 0
		xStep 2
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((and (> x 203) (< y (gEgo y:)) (& (gEgo onControl: 1) $0004))
				(self setScript: shootDown)
			)
			(
				(and
					(== y 119)
					(or
						(& (gEgo onControl: 1) $0002)
						(gEgo inRect: 146 104 247 125)
					)
				)
				(self setScript: shootOther 0 0)
			)
			((and (> y (gEgo y:)) (< (gEgo x:) 148))
				(self setScript: shootOther 0 3)
			)
			((and (> y (+ (gEgo y:) 4)) (> x 170))
				(self setScript: shootOther 0 3)
			)
		)
	)
)

(instance blast of Prop
	(properties
		x 248
		y 155
		view 499
		loop 1
		priority 12
		signal 16400
	)
)

(instance screen1 of Prop
	(properties
		x 25
		y 108
		description {Ms Astro Chicken}
		lookStr {The sign says "Ms Astro Chicken" You wonder why nobody is playing it.}
		view 376
		priority 2
		signal 16
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: playChicken)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen2 of Prop
	(properties
		x 60
		y 99
		description {Cap'n Zappo machine}
		lookStr {Your best score on Cap'n Zappo was 251. This kid has... 15,290,912 !?}
		view 376
		loop 1
		signal 16384
		cycleSpeed 2
	)
)

(instance screen3 of Prop
	(properties
		x 82
		y 91
		description {GHETTO BLASTER game}
		lookStr {The GHETTO BLASTER game is completely socially irredemable, gratuitously violent, and without a doubt the BEST arcade game EVER!}
		view 376
		loop 2
		cel 1
		signal 16384
		cycleSpeed 2
	)
)

(instance screen4 of Prop
	(properties
		x 261
		y 84
		description {CHOKE 'N CROAK arcade machine}
		lookStr {Boy! You'd think after all these years, they'd come up with something more sophisticated than frogs jumping from log to log.}
		view 376
		loop 3
		cel 1
		signal 16384
		cycleSpeed 2
	)
)

(instance screen5 of Prop
	(properties
		x 294
		y 151
		description {SLIME FLYER machine}
		lookStr {This SLIME FLYER machine has seen better days. It looks like a left-over from your mis-spent youth.}
		view 376
		loop 4
		cel 1
		signal 16384
		cycleSpeed 2
	)
)

(instance screen6 of Prop
	(properties
		x 82
		y 29
		description {weirdo video}
		lookStr {It's some sort of video art-form. Looks like a computer-generated fractal simulation of somebody's laundry machine.}
		view 376
		loop 5
		cel 1
		signal 16384
		cycleSpeed 2
	)
)

(instance screen7 of Prop
	(properties
		x 240
		y 28
		description {weirdo video}
		lookStr {It's some sort of video art-form. Looks like a hand throwing a pizza.}
		view 376
		loop 6
		signal 16384
		cycleSpeed 2
	)
)

(instance screen10 of Prop
	(properties
		x 310
		y 114
		description {DWEEB-HUNTER arcade game}
		lookStr {This game; "DWEEB-HUNTER" reminds you too much of your present predicament. And guess who the dweeb is!}
		view 376
		loop 14
		signal 16384
		cycleSpeed 2
	)
)

(instance kid of Prop
	(properties
		x 266
		y 172
		description {kid}
		lookStr {Watching this fine youngster brings back fond memories of your youth. Little did you know that all of those hours playing "BLAZIN' PADDLES" were in preparation for being a space-guy-hero-type.}
		view 376
		loop 7
		signal 16385
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 376 1) ; "Leave the kid alone. He's totally engrossed in his game."
			)
			(5 ; Talk
				(Print 376 2) ; "Talking to a kid in the middle of an arcade game is like filking a droovie without a stoinker. In other words: forget it."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aniKids of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(for ((= temp0 0)) (<= temp0 register) ((++ temp0))
					([local7 (Random 0 6)] setCycle: Fwd)
				)
				(= seconds (Random 4 7))
			)
			(1
				(for ((= temp0 0)) (<= temp0 6) ((++ temp0))
					(if (not (& ([local7 temp0] signal:) $0004))
						([local7 temp0] stopUpd:)
					)
				)
				(= seconds (Random 3 5))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance changeMachine of Feature
	(properties
		description {change machine}
		lookStr {The change machine looks like a time machine more than a time machine looks like a time machine... for a change.}
	)

	(method (onMe param1)
		(return (& (OnControl CONTROL (param1 x:) (param1 y:)) $2000))
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local6
					(Print 376 3) ; "** HOOK - kill ego with laser?"
				else
					(Print 376 4) ; "Banging on the change machine will only activate its self- defense mechanisms."
					(= local6 1)
				)
			)
			(6 ; Inventory
				(if (== invItem 0) ; buckazoid
					(Print 376 5) ; "In all the known universe, the lowly buckazoid is the lowest denomination of all. You can't get change for it."
				else
					(super doVerb: theVerb invItem)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance arcadeRoom of Feature
	(properties
		description {arcade}
		lookStr {As you look around the arcade, you're delighted to see that some of your old favorites are still in operation: MONACO PRINCESS STUNT DRIVIN'; CHOKE 'N CROAK; GHETTO BLASTER; and DWEEB HUNTER. The air is filled with smoke, sweat and ozone, reminding you of your favorite cologne: "Night in Programming."}
	)

	(method (onMe)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 376 6) ; "You don't have time to play computer games, Roger!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

