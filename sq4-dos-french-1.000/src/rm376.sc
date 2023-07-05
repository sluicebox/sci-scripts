;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 376)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
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
	local15
)

(instance rm376 of SQRoom
	(properties
		picture 376
		style 10
		south 375
	)

	(method (init)
		(= local15 (gGame detailLevel:))
		(HandsOn)
		(if (not (IsFlag 2))
			(self setRegions: 700) ; mall
		else
			(DisposeScript 700)
		)
		(if (and local0 (IsFlag 29))
			(Load rsSOUND 105)
		)
		(Load rsVIEW 376)
		(screen2 detailLevel: 2 setCycle: Fwd init:)
		(screen3 detailLevel: 2 setCycle: Fwd init:)
		(screen4 detailLevel: 2 setCycle: Fwd init:)
		(screen5 detailLevel: 2 setPri: 12 setCycle: Fwd init:)
		(screen6 detailLevel: 3 setCycle: Fwd init:)
		(screen7 detailLevel: 3 setCycle: Fwd init:)
		(screen10 detailLevel: 2 setCycle: Fwd init:)
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
		(switch (gGame detailLevel:)
			(0
				(kid setScript: aniKids 0 1)
			)
			(1
				(kid setScript: aniKids 0 2)
			)
			(2
				(kid setScript: aniKids 0 3)
			)
			(3
				(kid setScript: aniKids 0 4)
			)
		)
		(if (IsFlag 5)
			(pod cel: 7 init: stopUpd:)
			(hatch init: stopUpd:)
		else
			(= local0 1)
			(blast init: stopUpd:)
		)
		(gFeatures
			add: changeMachine sushiBar arcadeRoom
			eachElementDo: #init
			doit:
		)
		(super init:)
		(gAddToPics add: screen1 basket eachElementDo: #init doit:)
		(switch gPrevRoomNum
			(531
				(gLongSong2 number: 19 vol: 127 loop: -1 flags: 1)
				(self
					setScript:
						(if (IsFlag 2)
							egoArrives
						else
							(gEgo
								view: 2001
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
				(if (or (IsFlag 3) (and (IsFlag 19) (not (IsFlag 22))))
					(Load rsSOUND 105)
					(sp2 init: setPri: -1 posn: (gEgo x:) 143)
					(blast init: stopUpd:)
					(HandsOff)
					(self setScript: shootDown)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 189 0 0 319 0 319 188 257 189 239 181 233 175 234 168 236 161 256 151 289 149 267 132 257 132 255 138 226 138 219 126 238 123 213 108 132 107 130 109 118 109 110 114 96 117 86 127 73 132 61 132 41 145 43 148 59 156 80 158 69 172 59 172 49 177 10 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 206 185 175 185 175 189 143 189 143 185 115 185 119 176 91 170 96 162 128 162 140 123 118 116 118 112 202 111 202 116 175 123 194 162 219 162 225 180 202 180
							yourself:
						)
				)
			)
			(290 ; astro
				(gLongSong2 number: 19 vol: 127 loop: -1 flags: 1 playBed:)
				(gEgo posn: 58 143 init:)
				(if (== (++ global191) 5)
					(screen1
						lookStr:
							{The Ms. Astro Chicken machine looks as though it's taken its last buckazoid and given its last "BACOCK!".}
					)
					(gCurRoom setScript: zapMsChickenS)
				)
				(HandsOn)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 189 0 0 319 0 319 188 257 189 239 181 233 175 234 168 236 161 256 151 289 149 267 132 257 132 255 138 226 138 219 126 238 123 213 108 132 107 130 109 118 109 110 114 96 117 86 127 73 132 61 132 41 145 43 148 59 156 80 158 69 172 59 172 49 177 10 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 206 185 175 185 175 189 143 189 143 185 115 185 119 176 91 170 96 162 128 162 140 123 118 116 118 112 202 111 202 116 175 123 194 162 219 162 225 180 202 180
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
							init: 0 189 0 0 319 0 319 188 257 189 239 181 233 175 234 168 236 161 256 151 289 149 267 132 257 132 255 138 226 138 219 126 238 123 213 108 132 107 130 109 118 109 110 114 96 117 86 127 73 132 61 132 41 145 43 148 59 156 80 158 69 172 59 172 49 177 10 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 206 185 175 185 175 189 143 189 143 185 115 185 119 176 91 170 96 162 128 162 140 123 118 116 118 112 202 111 202 116 175 123 194 162 219 162 225 180 202 180
							yourself:
						)
				)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (!= local15 (gGame detailLevel:))
			(if (> (= local15 (gGame detailLevel:)) 1)
				(screen6 setCycle: Fwd)
				(screen7 setCycle: Fwd)
			else
				(screen6 stopUpd:)
				(screen7 stopUpd:)
			)
		)
		(if
			(and
				local0
				(== (gEgo onControl: 1) 2)
				(== (gEgo view:) 0)
				(gCast contains: gEgo)
			)
			(gEgo setScript: spArrive)
		)
	)
)

(instance spArrive of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== state 4) (== (gLongSong prevSignal:) -1))
			(self cue:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gLongSong number: 838 vol: 127 loop: 1 play:)
				(HandsOff)
				(SetFlag 5)
				(SetFlag 19)
				(SetFlag 8)
				(kid setScript: 0)
				(for ((= temp0 0)) (<= temp0 6) ((++ temp0))
					([local7 temp0] addToPic:)
				)
				(= local0 0)
				(sparks init: setCycle: Fwd)
				(= cycles 10)
			)
			(1
				(gLongSong fade:)
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
				(gLongSong number: 124 loop: 1 play:)
				(sparks dispose:)
			)
			(5
				(gLongSong number: 142 play:)
				(hatch setCycle: End self)
			)
			(6
				(gLongSong number: 0 stop:)
				(sp1 setCycle: End self)
			)
			(7
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
			(8
				(sp1 setMotion: MoveTo 68 155)
				(sp2 posn: 27 156 setCycle: End self)
			)
			(9
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
			(10
				(hatch stopUpd:)
				(sp1 setMotion: MoveTo 89 160 self)
			)
			(11
				(sp1 setMotion: MoveTo 69 237 self)
			)
			(12
				(sp1 dispose:)
				(HandsOn)
				(sp2 setMotion: MoveTo 60 145 self)
			)
			(13
				(sp2 setMotion: MoveTo 112 119 self)
			)
			(14
				(sp2 setPri: 7 setMotion: MoveTo 203 119 self)
			)
			(15
				(sp2 setPri: -1 setMotion: MoveTo 242 188 self)
			)
			(16
				(sp2 setMotion: MoveTo 242 220 self)
			)
			(17
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
						376
						0
						67
						(sp2 x:)
						50
						28
						global132
						29
						(proc0_18 global139 global149)
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
						(proc0_18 global133 global132)
						(- (gEgo priority:) 1)
						-1
					)
					(Graph grREDRAW_BOX local2 (- local5 1) local4 (+ local3 1))
					(aSound number: 105 loop: 1 vol: 127 play:)
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
					(proc0_18 global133 global132)
					(- (gEgo priority:) 1)
					-1
				)
				(Graph grREDRAW_BOX local2 (- local5 1) local4 (+ local3 1))
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(9
				(blast cel: 0 posn: local3 local4 setPri: 15 setCycle: End self)
			)
			(10
				(EgoDead 8 1)
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
						376
						1
						67
						(sp2 x:)
						30
						28
						global132
						29
						(proc0_18 global139 global149)
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
					(proc0_18 global133 global132)
					(- (gEgo priority:) 1)
					-1
				)
				(Graph grREDRAW_BOX local2 (- local5 1) local4 (+ local3 1))
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(4
				(blast cel: 0 posn: local3 local2 setPri: 15 setCycle: End self)
			)
			(5
				(EgoDead 8 1)
			)
		)
	)
)

(instance egoArrives of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 8)
			)
			(1
				(pod init: setCycle: CT 2 1 self)
			)
			(2
				(gLongSong number: 838 loop: 1 vol: 127 play:)
				(sparks init: setCycle: Fwd)
				(pod setCycle: CT 6 1 self)
			)
			(3
				(pod setCel: 7 setPri: -1 stopUpd:)
				(hatch init: stopUpd:)
				(= cycles 12)
			)
			(4
				(gLongSong number: 0 stop:)
				(sparks dispose:)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(gLongSong2 fade: 80 15 10 0)
				(gCurRoom newRoom: 531)
			)
		)
	)
)

(instance egoExitsPod of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== state 0) (== (gLongSong prevSignal:) -1))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong number: 124 vol: 127 loop: 1 play:)
				(SetFlag 5)
				(= local0 0)
				(pod setCel: 7 init: stopUpd:)
				(hatch init:)
			)
			(1
				(gLongSong number: 142 play:)
				(hatch setCycle: End self)
			)
			(2
				(gLongSong stop:)
				(= cycles 4)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gLongSong play:)
				(hatch setCycle: Beg self)
			)
			(5
				(gLongSong number: 125 play:)
				(hatch stopUpd:)
				(gEgo loop: 0 normal: 1 moveHead: 1 view: 0)
				(NormalEgo)
				(gEgo setMotion: PolyPath 51 146 self)
			)
			(6
				(gLongSong number: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 189 0 0 319 0 319 188 257 189 239 181 233 175 234 168 236 161 256 151 289 149 267 132 257 132 255 138 226 138 219 126 238 123 213 108 132 107 130 109 118 109 110 114 96 117 86 127 73 132 61 132 41 145 43 148 59 156 80 158 69 172 59 172 49 177 10 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 206 185 175 185 175 189 143 189 143 185 115 185 119 176 91 170 96 162 128 162 140 123 118 116 118 112 202 111 202 116 175 123 194 162 219 162 225 180 202 180
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
				(gLongSong number: 142 loop: 1 vol: 127 play:)
				(hatch setCycle: End self)
			)
			(2
				(gLongSong stop:)
				(gEgo
					view: 2001
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
				(if (IsFlag 22)
					(SetScore 87 15)
					(= cycles 12)
				else
					(= cycles 4)
				)
			)
			(4
				(gLongSong play:)
				(hatch setCycle: Beg self)
			)
			(5
				(gLongSong number: 125 play:)
				(= cycles 2)
			)
			(6
				(gLongSong number: 0 stop:)
				(ClearFlag 5)
				(gLongSong2 fade: 80 15 10 0)
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
				(gEgo setHeading: 270 self)
			)
			(2
				(gLongSong2 fade:)
				(gCurRoom newRoom: 290) ; astro
			)
		)
	)
)

(instance changeMachineDeathS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 26
					cel: 0
					setMotion: 0
					cycleSpeed: 1
					setCycle: CT 1 1 self
				)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(EgoDead 8 29)
			)
		)
	)
)

(instance zapMsChickenS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(zapBlast
					view: 28
					init:
					setPri: 2
					posn: 35 113
					cel: 0
					setCycle: End self
				)
			)
			(1
				(zapBlast posn: 25 84 cel: 0 setCycle: End self)
			)
			(2
				(zapBlast posn: 0 121 cel: 0 setCycle: End self)
			)
			(3
				(zapBlast posn: 22 103 cel: 0 setCycle: End self)
			)
			(4
				(zapBlast posn: 47 109 cel: 0 setCycle: End self)
			)
			(5
				(Print 376 2) ; "Whoa! This game's circuits have melted into a mass of molten silicon. But the fireworks sure were pretty!"
				(zapBlast view: 499 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance pod of Prop
	(properties
		x 26
		y 161
		description {time pod}
		view 377
		priority 12
		signal 16400
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(& (OnControl PRIORITY (param1 x:) (param1 y:)) $1000)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(if (not (shootDown client:))
					(gCurRoom setScript: egoEntersPod)
				)
			)
			(11 ; Smell
				(Print 376 3) ; "It smells scorched."
			)
			(10 ; Taste
				(Print 376 4) ; "It tastes scorched. Oxidized materials now coat your tongue."
			)
			(2 ; Look
				(Print 376 5) ; "You give the Time Pod a long glance. It's not the most attractive vehicle you've ever seen. It resembles an overgrown titanium tennis shoe."
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

	(method (init)
		(super init: &rest)
		(aSound number: 838 loop: 1 play:)
	)

	(method (dispose)
		(aSound stop:)
		(super dispose:)
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

	(method (setCycle)
		(super setCycle: &rest)
		(hatchSound init: play:)
	)

	(method (motionCue)
		(hatchSound stop: loop: 0)
		(super motionCue: &rest)
	)
)

(instance sp1 of Actor
	(properties
		x 27
		y 156
		sightAngle 90
		view 2001
		loop 4
		priority 13
		signal 22544
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 376 6) ; "It's one of Vohaul's Sequel Policemen!"
			)
			(5 ; Talk
				(Print 376 7) ; "That would be most unwise!"
			)
			(11 ; Smell
				(Print 376 8) ; "Seeing as how these guys are trying to kill you, your best line of defense would be a straight one out of here."
			)
			(10 ; Taste
				(Print 376 9) ; "You'd best stay of sight out this guy!"
			)
			(3 ; Do
				(Print 376 8) ; "Seeing as how these guys are trying to kill you, your best line of defense would be a straight one out of here."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; buckazoid
						(Print 376 10) ; "The Sequel Police are closely monitored by Vohaul. Bribing them would be out of the question."
					)
					(1 ; rope
						(Print 376 11) ; "Even if you were to lasso a Sequel Policeman, what would you do with him?"
					)
					(3 ; rabbit
						(Print 376 12) ; "Ooooo! Don't throw the bunny at Sequel Policeman! He may have a hare trigger. (Sorry!)"
					)
					(4 ; battery
						(Print 376 13) ; "No way! That would be assault with intent to emit battery!"
					)
					(6 ; gum
						(Print 376 14) ; "Try as you might, the gum just gets stuck to your fingers."
					)
					(9 ; pen
						(Print 376 15) ; "He's gonna SHOOT you, not write you a ticket!"
					)
					(10 ; atmCard
						(Print 376 10) ; "The Sequel Police are closely monitored by Vohaul. Bribing them would be out of the question."
					)
					(else
						(Print 376 16) ; "You'd better not. You might need that later."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sp2 of Actor
	(properties
		sightAngle 90
		view 2001
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
			((< 200 (gEgo y:)))
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

	(method (doVerb)
		(sp1 doVerb: &rest)
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

(instance zapBlast of Prop
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
		description {Ms. Astro Chicken}
		view 376
		priority 2
		signal 16
		cycleSpeed 2
	)

	(method (doVerb theVerb invItem)
		(if (or (== theVerb 3) (and (== theVerb 4) (== invItem 0))) ; Do, Inventory, buckazoid
			(cond
				((>= global191 5)
					(Print 376 17) ; "The Ms. Astro Chicken machine looks as though it's taken its last buckazoid and given its last "BACOCK!"."
				)
				(gBuckazoidCount
					(if (not (-- gBuckazoidCount))
						(gEgo put: 0) ; buckazoid
					)
					(HandsOff)
					(gCurRoom setScript: playChicken)
				)
				(else
					(Print 376 18) ; "You seem to be fresh out of buckazoids. Darn the luck!"
				)
			)
		else
			(switch theVerb
				(11 ; Smell
					(Print 376 19) ; "Gooey, greasy little fingers, and various other types of appendages have left a coating of something that smells like a cross between cotton candy and dead gerbils."
				)
				(10 ; Taste
					(Print 376 20) ; "Auugghh! You had to taste it! This is going to linger for awhile. That coating of something that smells like a cross between cotton candy and dead gerbils tastes more like the latter!"
				)
				(2 ; Look
					(Print 376 21) ; "The sign says "Ms. Astro Chicken". You wonder why nobody is playing it."
				)
				(else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance screen2 of Prop
	(properties
		x 60
		y 99
		description {Cap'n Zappo machine}
		view 376
		loop 1
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 376 22) ; "Your best score on Cap'n Zappo was 251. This kid has... 15,290,912 !?"
			)
			(3 ; Do
				(Print 376 23) ; "Back off. It's not your turn."
			)
			(4 ; Inventory
				(Print 376 23) ; "Back off. It's not your turn."
			)
			(11 ; Smell
				(Print 376 19) ; "Gooey, greasy little fingers, and various other types of appendages have left a coating of something that smells like a cross between cotton candy and dead gerbils."
			)
			(10 ; Taste
				(Print 376 20) ; "Auugghh! You had to taste it! This is going to linger for awhile. That coating of something that smells like a cross between cotton candy and dead gerbils tastes more like the latter!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen3 of Prop
	(properties
		x 82
		y 91
		description {GHETTO BLASTER game}
		sightAngle 90
		view 376
		loop 2
		cel 1
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 376 24) ; "The GHETTO BLASTER game is completely socially irredeemable, gratuitously violent, and without a doubt the most popular arcade game EVER!"
			)
			(3 ; Do
				(Print 376 23) ; "Back off. It's not your turn."
			)
			(4 ; Inventory
				(Print 376 23) ; "Back off. It's not your turn."
			)
			(11 ; Smell
				(Print 376 19) ; "Gooey, greasy little fingers, and various other types of appendages have left a coating of something that smells like a cross between cotton candy and dead gerbils."
			)
			(10 ; Taste
				(Print 376 20) ; "Auugghh! You had to taste it! This is going to linger for awhile. That coating of something that smells like a cross between cotton candy and dead gerbils tastes more like the latter!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen4 of Prop
	(properties
		x 261
		y 84
		description {CHOKE 'N CROAK arcade machine}
		sightAngle 90
		view 376
		loop 3
		cel 1
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 376 25) ; "Boy! You'd think after all these years, they'd come up with something more sophisticated than frogs jumping from log to log."
			)
			(3 ; Do
				(Print 376 23) ; "Back off. It's not your turn."
			)
			(4 ; Inventory
				(Print 376 23) ; "Back off. It's not your turn."
			)
			(11 ; Smell
				(Print 376 19) ; "Gooey, greasy little fingers, and various other types of appendages have left a coating of something that smells like a cross between cotton candy and dead gerbils."
			)
			(10 ; Taste
				(Print 376 20) ; "Auugghh! You had to taste it! This is going to linger for awhile. That coating of something that smells like a cross between cotton candy and dead gerbils tastes more like the latter!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen5 of Prop
	(properties
		x 294
		y 151
		description {SLIME FLYER machine}
		view 376
		loop 4
		cel 1
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 376 26) ; "This SLIME FLYER machine has seen better days. It looks like a leftover from your misspent youth."
			)
			(3 ; Do
				(Print 376 23) ; "Back off. It's not your turn."
			)
			(4 ; Inventory
				(Print 376 23) ; "Back off. It's not your turn."
			)
			(11 ; Smell
				(Print 376 19) ; "Gooey, greasy little fingers, and various other types of appendages have left a coating of something that smells like a cross between cotton candy and dead gerbils."
			)
			(10 ; Taste
				(Print 376 20) ; "Auugghh! You had to taste it! This is going to linger for awhile. That coating of something that smells like a cross between cotton candy and dead gerbils tastes more like the latter!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen6 of Prop
	(properties
		x 82
		y 29
		description {weirdo video}
		view 376
		loop 5
		cel 1
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 376 27) ; "It's some sort of video art form. Looks like a computer-generated fractal simulation of somebody's laundry machine."
			)
			(3 ; Do
				(Print 376 28) ; "That's too high for you to reach."
			)
			(11 ; Smell
				(Print 376 29) ; "That's too high for you to smell."
			)
			(10 ; Taste
				(Print 376 30) ; "That's too high for you to taste."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen7 of Prop
	(properties
		x 240
		y 28
		description {weirdo video}
		view 376
		loop 6
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 376 31) ; "It's some sort of video art form. Looks like a hand throwing a pizza."
			)
			(3 ; Do
				(Print 376 32) ; "That's too high for you to reach."
			)
			(11 ; Smell
				(Print 376 33) ; "That's too high for you to smell."
			)
			(10 ; Taste
				(Print 376 34) ; "That's too high for you to taste."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen10 of Prop
	(properties
		x 310
		y 114
		description {DWEEB HUNTER arcade game}
		view 376
		loop 14
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 376 35) ; "This game; "DWEEB HUNTER" reminds you too much of your present predicament. And guess who the dweeb is!"
			)
			(3 ; Do
				(Print 376 23) ; "Back off. It's not your turn."
			)
			(4 ; Inventory
				(Print 376 23) ; "Back off. It's not your turn."
			)
			(11 ; Smell
				(Print 376 19) ; "Gooey, greasy little fingers, and various other types of appendages have left a coating of something that smells like a cross between cotton candy and dead gerbils."
			)
			(10 ; Taste
				(Print 376 20) ; "Auugghh! You had to taste it! This is going to linger for awhile. That coating of something that smells like a cross between cotton candy and dead gerbils tastes more like the latter!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance basket of View
	(properties
		x 160
		y 187
		description {wastebasket}
		view 376
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 376 36) ; "Gazing at the wastebasket, your impulse - nay, your very instinct - nay, the very fibres of your being - scream out for you to pick up the refuse and empty the basket of its waste. But you're much too busy for that right now."
			)
			(3 ; Do
				(Print 376 37) ; "Resist those inbred custodial tendencies to collect garbage. You have much more important garbage to tend to!"
			)
			(5 ; Talk
				(Print 376 38) ; "You're quite startled to hear the wastebasket respond..."
				(Print 376 39) ; "Max, is that you? Agent 99? I always get these lousy disguises. Would you put a word in with the Chief for me? I wouldn't mind, but all these kids eat is ice cream and candy bars. Do you know how many Big Chewies I've eaten in the last hour? Not to mention the wad of Big Bang BubbleGum I've got stuck to my shoe phone... (sigh!)"
			)
			(11 ; Smell
				(Print 376 40) ; "Give your nose a break! It's a garbage can!"
			)
			(10 ; Taste
				(Print 376 41) ; "A garbage can?!"
			)
			(4 ; Inventory
				(Print 376 42) ; "You'd better not throw that away. It'll probably come in handy later. I know it doesn't seem likely, but trust me on this one."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance kid of Prop
	(properties
		x 266
		y 172
		description {kid}
		view 2000
		loop 7
		signal 16385
		cycleSpeed 2
	)

	(method (isNotHidden)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 376 43) ; "Watching this fine youngster brings back fond memories of your youth. Little did you know that all of those hours playing "BLAZIN' PADDLES" were in preparation for being a space-guy-hero-type."
			)
			(3 ; Do
				(Print 376 44) ; "Leave the kid alone. He's totally engrossed in his game."
			)
			(5 ; Talk
				(Print 376 45) ; "Talking to a kid in the middle of an arcade game is almost as interesting as talking to the wall. Give it up."
			)
			(11 ; Smell
				(Print 376 46) ; "Perhaps you haven't been around a young, active being lately. I can tell you that walking up to one and giving it a sniff could be considered unstable and even dangerous behaviour."
			)
			(10 ; Taste
				(Print 376 47) ; "Perhaps you haven't read the nose message."
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
				(self register: (gGame detailLevel:) changeState: 0)
			)
		)
	)
)

(instance changeMachine of Feature
	(properties
		x 159
		y 117
		description {change machine}
	)

	(method (onMe param1)
		(return (& (OnControl CONTROL (param1 x:) (param1 y:)) $2000))
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 376 48) ; "The change machine looks like a time machine more than a time machine looks like a time machine... for a change."
			)
			(3 ; Do
				(cond
					((not (gEgo inRect: 116 102 206 124))
						(Print 376 49) ; "You're not close enough to the change machine to touch it."
					)
					((OneOf (gEgo view:) 373 374)
						(Print 376 50) ; "A real lady wouldn't try to break a change machine."
					)
					((and local6 (not (gCurRoom script:)))
						(gCurRoom setScript: changeMachineDeathS)
					)
					(else
						(Print 376 51) ; "Banging on the change machine will only activate its self-defense mechanisms."
						(= local6 1)
					)
				)
			)
			(4 ; Inventory
				(if (== invItem 0) ; buckazoid
					(Print 376 52) ; "In all the known universe, the lowly buckazoid is the lowest denomination of all. You can't get change for it."
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

(instance sushiBar of Feature
	(properties
		description {sushi bar machine}
	)

	(method (onMe param1)
		(return (& (OnControl CONTROL (param1 x:) (param1 y:)) $0200))
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 376 53) ; "The dead fish in the sushi bar machine appear to have been dead far longer than they were fish. The sushi bar wasn't one of Buckazoid Bill's greatest ideas."
			)
			(3 ; Do
				(Print 376 54) ; "Rocking the sushi bar machine is impossible. It's bolted to the floor."
			)
			(4 ; Inventory
				(if (== invItem 0) ; buckazoid
					(Print 376 55) ; "In all the known universe, the lowly buckazoid is the lowest denomination of all. You can't even get a dead fish for it."
				else
					(super doVerb: theVerb invItem)
				)
			)
			(11 ; Smell
				(Print 376 56) ; "It smells like old dead fish."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance arcadeRoom of Feature
	(properties
		description {arcade}
		sightAngle 180
	)

	(method (onMe)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 376 57) ; "As you look around the arcade, you're delighted to see that some of your old favorites are still in operation: MONACO PRINCESS STUNT DRIVIN'; CHOKE 'N CROAK; GHETTO BLASTER; and DWEEB HUNTER. The air is filled with smoke, sweat and ozone, reminding you of your favorite cologne: "Night in Programming.""
			)
			(3 ; Do
				(Print 376 58) ; "Touching anything in here might be dangerous to your health."
			)
			(11 ; Smell
				(Print 376 59) ; "The aroma of the sushi bar dominates the air in here. However, you can also detect the smell of smoke, sweat and ozone, reminding you of your favorite cologne: "Night in Programming.""
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aSound of Sound
	(properties)
)

(instance hatchSound of Sound
	(properties
		number 142
	)
)

