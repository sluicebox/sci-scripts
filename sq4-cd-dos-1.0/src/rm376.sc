;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 376)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
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
		(if (>= global191 5)
			(screen1 setCel: 2)
		)
		(screen1 init:)
		(screen2 init: setCycle: Fwd)
		(screen3 init: setCycle: Fwd)
		(screen4 init: setCycle: Fwd)
		(screen5 init: setPri: 12 setCycle: Fwd)
		(screen6 init:)
		(screen7 init:)
		(if (> (gGame detailLevel:) 2)
			(screen6 setCycle: Fwd)
			(screen7 setCycle: Fwd)
		)
		(screen10 init: setCycle: Fwd)
		(= [local7 0] kid)
		((= [local7 1] (kid new:)) loop: 8 x: 197 y: 175 cycleSpeed: 12 init:)
		((= [local7 2] (kid new:)) loop: 9 x: 240 y: 134 cycleSpeed: 18 init:)
		((= [local7 3] (kid new:)) loop: 10 x: 97 y: 114 cycleSpeed: 24 init:)
		((= [local7 4] (kid new:))
			loop: 11
			x: 80
			y: 128
			cycleSpeed: 6
			priority: 7
			signal: 16400
			init:
		)
		((= [local7 5] (kid new:)) loop: 12 x: 118 y: 172 cycleSpeed: 12 init:)
		((= [local7 6] (kid new:)) loop: 13 x: 285 y: 137 cycleSpeed: 24 init:)
		(kid init:)
		(basket init: addToPic:)
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
		(tCanTalker init: 0 0 basket)
		(switch gPrevRoomNum
			(531
				(gLongSong2 number: 19 vol: 127 loop: -1 flags: 1)
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
				(if (IsFlag 22)
					(Load rsSOUND 105)
					(bogusSP init:)
					(sp2
						init:
						setPri: -1
						posn: (+ (gEgo x:) 20) (gEgo y:)
					)
					(blast init: stopUpd:)
					(HandsOff)
					(self setScript: shootDown)
				)
				(if (and (== (++ global191) 5) (not (IsFlag 22)))
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
				(tSP2 say: 1) ; "HALT, WILCO!"
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
				(EgoDead 8 1) ; "Smoking is bad for your health."
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
				(tSP2 say: 1) ; "HALT, WILCO!"
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
				(EgoDead 8 1) ; "Smoking is bad for your health."
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
					cycleSpeed: 12
					setCycle: CT 1 1 self
				)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(EgoDead 8 29) ; "You were warned not to try to break into the change machine, but did you listen?"
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
				(blast
					view: 28
					init:
					setPri: 2
					posn: 35 113
					cel: 0
					setCycle: End self
				)
			)
			(1
				(blast posn: 25 84 cel: 0 setCycle: End self)
			)
			(2
				(screen1 setCel: 2)
				(blast posn: 0 121 cel: 0 setCycle: End self)
			)
			(3
				(blast posn: 22 103 cel: 0 setCycle: End self)
			)
			(4
				(blast posn: 47 109 cel: 0 setCycle: End self)
			)
			(5
				(gNarrator say: 13) ; "Whoa! This game's circuits have melted into a mass of molten silicon. But the fireworks were pretty!"
				(blast view: 499 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance pod of Sq4Prop
	(properties
		x 26
		y 161
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
			(1 ; Look
				(gNarrator say: 14) ; "You give the Time Pod a long glance. It resembles an overgrown titanium tennis shoe."
			)
			(4 ; Do
				(HandsOff)
				(if (not (shootDown client:))
					(gCurRoom setScript: egoEntersPod)
				)
			)
			(6 ; Smell
				(gNarrator say: 15) ; "It smells scorched."
			)
			(7 ; Taste
				(gNarrator say: 16) ; "It tastes scorched. Oxidized materials now coat your tongue."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sparks of Sq4Prop
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

(instance hatch of Sq4Prop
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

(instance sp1 of Sq4Actor
	(properties
		x 27
		y 156
		sightAngle 90
		view 377
		loop 4
		priority 13
		signal 18448
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 17) ; "It's one of Vohaul's Sequel Policemen!"
			)
			(2 ; Talk
				(gNarrator say: 1) ; "That would be most unwise!"
			)
			(6 ; Smell
				(gNarrator say: 2) ; "Seeing as how these guys are trying to kill you, your best line of defense would be a straight one out of here."
			)
			(7 ; Taste
				(gNarrator say: 3) ; "You'd best stay of sight out this guy!"
			)
			(4 ; Do
				(gNarrator say: 2) ; "Seeing as how these guys are trying to kill you, your best line of defense would be a straight one out of here."
			)
			(11 ; rabbit
				(gNarrator modNum: 700 say: 4) ; "Don't throw the bunny at the Sequel Policeman! He may have a hare trigger."
			)
			(9 ; rope
				(gNarrator say: 6) ; "Even if you were to lasso a Sequel Policeman, what would you do with him?"
			)
			(14 ; gum
				(gNarrator say: 7) ; "Try as you might, the gum just gets stuck to your fingers."
			)
			(17 ; pen
				(gNarrator say: 8) ; "He's going to SHOOT you, not write you a ticket!"
			)
			(12 ; battery
				(gNarrator say: 8) ; "He's going to SHOOT you, not write you a ticket!"
			)
			((OneOf theVerb 8 10 13 15 16 19 18) ; buckazoid, bomb, jar, tank, hintbook, plug, atmCard
				(gNarrator say: 5) ; "The Sequel Police are closely monitored by Vohaul. Bribing them would be out of the question."
			)
			((OneOf theVerb 20 21 22 23) ; cigar, matches, diskette, laptop
				(gNarrator say: 4) ; "You'd better not. You might need that later."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sp2 of Sq4Actor
	(properties
		sightAngle 90
		view 377
		loop 4
		priority 13
		signal 18448
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

	(method (doVerb)
		(sp1 doVerb: &rest)
	)
)

(instance blast of Sq4Prop
	(properties
		x 248
		y 155
		view 499
		loop 1
		priority 12
		signal 16400
	)
)

(instance bogusSP of Sq4View
	(properties
		x 63
		y 103
		view 376
		loop 15
		priority 12
		signal 16400
	)
)

(instance screen1 of Sq4Prop
	(properties
		x 25
		y 108
		view 376
		priority 2
		signal 16
		cycleSpeed 2
	)

	(method (doVerb theVerb invItem)
		(if (or (== theVerb 4) (== theVerb 8)) ; Do, buckazoid
			(cond
				((>= global191 5)
					(gNarrator say: 19) ; "The Ms. Astro Chicken machine looks as though it's taken its last buckazoid."
				)
				(gBuckazoidCount
					(if (not (-- gBuckazoidCount))
						(gEgo put: 0) ; buckazoid
					)
					(HandsOff)
					(gCurRoom setScript: playChicken)
				)
				(else
					(gNarrator say: 20) ; "You seem to be fresh out of buckazoids."
				)
			)
		else
			(switch theVerb
				(1 ; Look
					(gNarrator say: 12) ; "The sign says "Ms. Astro Chicken". How strange that nobody is playing it."
				)
				(6 ; Smell
					(gNarrator say: 9) ; "Gooey, greasy little fingers, and various appendages have left a coating that smells like a cross between cotton candy and dead gerbils."
				)
				(7 ; Taste
					(gNarrator say: 10) ; "Auugghh! You had to taste it! Well, it tastes more like dead gerbils than like cotton candy!"
				)
				(else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance screen2 of Sq4Prop
	(properties
		x 60
		y 99
		view 376
		loop 1
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 21) ; "Your best score on Cap'n Zappo was 251. This kid has... 15,290,912 !?"
			)
			(4 ; Do
				(gNarrator say: 11) ; "Back off. It's not your turn."
			)
			(6 ; Smell
				(gNarrator say: 9) ; "Gooey, greasy little fingers, and various appendages have left a coating that smells like a cross between cotton candy and dead gerbils."
			)
			(7 ; Taste
				(gNarrator say: 10) ; "Auugghh! You had to taste it! Well, it tastes more like dead gerbils than like cotton candy!"
			)
			((OneOf theVerb 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) ; buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
				(gNarrator say: 11) ; "Back off. It's not your turn."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen3 of Sq4Prop
	(properties
		x 82
		y 91
		sightAngle 90
		view 376
		loop 2
		cel 1
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 22) ; "The GHETTO BLASTER game is completely socially irredeemable, gratuitously violent, and without a doubt the most popular arcade game EVER!"
			)
			(4 ; Do
				(gNarrator say: 11) ; "Back off. It's not your turn."
			)
			(6 ; Smell
				(gNarrator say: 9) ; "Gooey, greasy little fingers, and various appendages have left a coating that smells like a cross between cotton candy and dead gerbils."
			)
			(7 ; Taste
				(gNarrator say: 10) ; "Auugghh! You had to taste it! Well, it tastes more like dead gerbils than like cotton candy!"
			)
			((OneOf theVerb 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) ; buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
				(gNarrator say: 11) ; "Back off. It's not your turn."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen4 of Sq4Prop
	(properties
		x 261
		y 84
		sightAngle 90
		view 376
		loop 3
		cel 1
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 23) ; "Boy! You'd think after all these years, they'd come up with something more sophisticated than frogs jumping from log to log."
			)
			(6 ; Smell
				(gNarrator say: 9) ; "Gooey, greasy little fingers, and various appendages have left a coating that smells like a cross between cotton candy and dead gerbils."
			)
			(7 ; Taste
				(gNarrator say: 10) ; "Auugghh! You had to taste it! Well, it tastes more like dead gerbils than like cotton candy!"
			)
			((OneOf theVerb 4 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) ; Do, buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
				(gNarrator say: 11) ; "Back off. It's not your turn."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen5 of Sq4Prop
	(properties
		x 294
		y 151
		view 376
		loop 4
		cel 1
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 24) ; "This SLIME FLYER machine has seen better days."
			)
			(6 ; Smell
				(gNarrator say: 9) ; "Gooey, greasy little fingers, and various appendages have left a coating that smells like a cross between cotton candy and dead gerbils."
			)
			(7 ; Taste
				(gNarrator say: 10) ; "Auugghh! You had to taste it! Well, it tastes more like dead gerbils than like cotton candy!"
			)
			((OneOf theVerb 4 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) ; Do, buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
				(gNarrator say: 11) ; "Back off. It's not your turn."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen6 of Sq4Prop
	(properties
		x 82
		y 29
		view 376
		loop 5
		cel 1
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 25) ; "It's some sort of video art form. Looks like a computer-generated fractal simulation of a washing machine."
			)
			(4 ; Do
				(gNarrator say: 26) ; "That's too high for you to reach."
			)
			(6 ; Smell
				(gNarrator say: 27) ; "That's too high for you to smell."
			)
			(7 ; Taste
				(gNarrator say: 28) ; "That's too high for you to taste."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen7 of Sq4Prop
	(properties
		x 240
		y 28
		view 376
		loop 6
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 29) ; "It's some sort of video art form. Looks like a hand throwing a pizza."
			)
			(4 ; Do
				(gNarrator say: 26) ; "That's too high for you to reach."
			)
			(6 ; Smell
				(gNarrator say: 27) ; "That's too high for you to smell."
			)
			(7 ; Taste
				(gNarrator say: 28) ; "That's too high for you to taste."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen10 of Sq4Prop
	(properties
		x 310
		y 114
		view 376
		loop 14
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 30) ; "This game; "DWEEB HUNTER" reminds you too much of your present predicament. And guess who the dweeb is!"
			)
			(6 ; Smell
				(gNarrator say: 9) ; "Gooey, greasy little fingers, and various appendages have left a coating that smells like a cross between cotton candy and dead gerbils."
			)
			(7 ; Taste
				(gNarrator say: 10) ; "Auugghh! You had to taste it! Well, it tastes more like dead gerbils than like cotton candy!"
			)
			((OneOf theVerb 4 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) ; Do, buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
				(gNarrator say: 11) ; "Back off. It's not your turn."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance basket of Sq4Prop
	(properties
		x 160
		y 187
		view 1376
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 31) ; "Gazing at the wastebasket, your impulse - nay, your very instinct - nay, the very fibres of your being - scream out for you to pick up that garbage. But you're too busy."
			)
			(4 ; Do
				(gNarrator say: 32) ; "You resist those inbred custodial tendencies to collect garbage. You have much more important garbage to tend to!"
			)
			(2 ; Talk
				(self setScript: sBasket)
			)
			(6 ; Smell
				(gNarrator say: 34) ; "Give your nose a break! It's a garbage can!"
			)
			((OneOf theVerb 4 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) ; Do, buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
				(gNarrator say: 35) ; "You'd better not throw that away. It'll probably come in handy later. I know it doesn't seem likely, but trust me on this one."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sBasket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gNarrator say: 33 self) ; "You're quite startled to hear the wastebasket respond..."
			)
			(1
				(tCanTalker say: 1 self) ; "Max, is that you? Agent 99? I always get these lousy disguises. Would you put a word in with the Chief for me? I wouldn't mind, but all these kids eat is ice cream and candy bars. Do you know how many Big Chewies I've eaten in the last hour? Not to mention the wad of Big Bang BubbleGum I've got stuck to my shoe phone... (sigh!)"
			)
			(2
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance kid of Sq4Prop
	(properties
		x 266
		y 172
		view 376
		loop 7
		signal 16385
		cycleSpeed 2
	)

	(method (isNotHidden)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 36) ; "Watching this fine youngster brings back fond memories of your youth. Little did you know that all of those hours playing "BLAZIN' PADDLES" were in preparation for being a space-guy-hero-type."
			)
			(4 ; Do
				(gNarrator say: 37) ; "Leave the kid alone. He's totally engrossed in his game."
			)
			(2 ; Talk
				(gNarrator say: 38) ; "Talking to a kid in the middle of an arcade game is almost as interesting as talking to the wall. Give it up."
			)
			(6 ; Smell
				(gNarrator say: 39) ; "Walking up to a young, active creature like this one and sniffing it could be considered unusual behavior."
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

(instance changeMachine of Sq4Feature
	(properties
		x 159
		y 117
	)

	(method (onMe param1)
		(return (& (OnControl CONTROL (param1 x:) (param1 y:)) $2000))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 40) ; "The change machine looks like a time machine more than a time machine looks like a time machine... for a change."
			)
			(4 ; Do
				(cond
					((not (gEgo inRect: 116 102 206 124))
						(gNarrator say: 41) ; "You're not close enough to the change machine to touch it."
					)
					((OneOf (gEgo view:) 373 374)
						(gNarrator say: 42) ; "A real lady wouldn't try to break a change machine."
					)
					((and local6 (not (gCurRoom script:)))
						(gCurRoom setScript: changeMachineDeathS)
					)
					(else
						(gNarrator say: 43) ; "Banging on the change machine will only activate its self-defense mechanisms."
						(= local6 1)
					)
				)
			)
			(8 ; buckazoid
				(gNarrator say: 44) ; "In all the known universe, the buckazoid is the lowest denomination of all. You can't get change for it."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sushiBar of Sq4Feature
	(properties)

	(method (onMe param1)
		(return (& (OnControl CONTROL (param1 x:) (param1 y:)) $0200))
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 45) ; "The dead fish in the sushi bar machine appear to have been dead far longer than they were fish. The sushi bar was not one of Buckazoid Bill's greatest ideas."
			)
			(4 ; Do
				(gNarrator say: 46) ; "Rocking the sushi bar machine is impossible. It's bolted to the floor."
			)
			(8 ; buckazoid
				(gNarrator say: 47) ; "In all the known universe, the lowly buckazoid is the lowest denomination of all. You can't even buy a dead fish with it."
			)
			(6 ; Smell
				(gNarrator say: 48) ; "It smells like old dead fish."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance arcadeRoom of Sq4Feature
	(properties
		sightAngle 180
	)

	(method (onMe)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 49) ; "As you look around the arcade, you see that some of your old favorites are still working: MONACO PRINCESS STUNT DRIVIN'; CHOKE 'N CROAK; GHETTO BLASTER; and DWEEB HUNTER. The air is filled with smoke, sweat and ozone, reminding you of your favorite cologne: "Night in Programming.""
			)
			(4 ; Do
				(gNarrator say: 50) ; "Touching anything in here might be dangerous to your health."
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

(instance tCanTalker of FaceTalker
	(properties
		modNum 376
		talkerNum 15
	)
)

(instance tRog of Sq4Talker ; UNUSED
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 14
		mouthOffsetX 26
		mouthOffsetY 32
		eyeOffsetX 25
		eyeOffsetY 21
		tStyle 2
	)
)

(instance tSP2 of Sq4Talker
	(properties
		z 400
		noun 14
		view 1016
		talkerNum 14
		mouthOffsetX 21
		mouthOffsetY 34
	)
)

