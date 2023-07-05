;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Bats)
(use Print)
(use Scaler)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm600 0
)

(local
	local0
	local1
	[local2 2]
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 66] = [620 2 3 194 166 620 2 4 180 161 620 2 5 174 170 620 2 6 164 173 620 2 7 150 187 620 3 0 136 200 620 3 1 122 210 620 3 2 96 208 620 3 3 76 201 620 3 5 58 196 620 3 5 45 183 620 3 7 49 170 620 4 0 49 170 -999]
	[local76 33] = [5 0 160 144 5 1 174 146 5 2 182 151 5 4 185 157 5 6 190 158 5 7 197 160 5 8 196 164 5 9 197 170 -32768]
)

(class XAnimate of MoveTo
	(properties
		curX 0
		curY 0
		anArray 0
		index 0
	)

	(method (init param1 param2 param3 &tmp [temp0 2])
		(= client param1)
		(= anArray param2)
		(= caller param3)
		(= index -1)
		(self setView:)
	)

	(method (setView)
		(if (!= (WordAt anArray (++ index)) -999)
			(client view: (WordAt anArray index))
			(client setLoop: (WordAt anArray (++ index)))
			(client cel: (WordAt anArray (++ index)))
			(= curX (WordAt anArray (++ index)))
			(= curY (WordAt anArray (++ index)))
			(super init: client curX curY)
		else
			(Prints {INCORRECT PARAMETERS})
			(SetDebug)
		)
	)

	(method (moveDone)
		(if (== (WordAt anArray (++ index)) -999)
			(= completed 1)
			(if caller
				(= gDoMotionCue 1)
			else
				(self motionCue:)
			)
		else
			(-- index)
			(self setView:)
		)
	)
)

(instance rm600 of Eco2Room
	(properties
		noun 15
		picture 600
		style 10
		north 630
		vanishingY -150
	)

	(method (init)
		(LoadMany rsVIEW 0 52 626 600 620)
		(exitnorth init:)
		(shelf init:)
		(tunnel init:)
		(pile init:)
		(opening init:)
		(hole init:)
		(bat1 init:)
		(fireMarshall init:)
		(ripple_1 init:)
		(ripple_2 init:)
		(ripple_3 init:)
		(ripple_4 init:)
		(waterEff init:)
		(flier init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 310 52 256 52 243 67 206 74 151 69 151 90 163 93 226 75 235 78 206 130 231 157 130 147 114 137 119 127 101 127 111 136 104 145 12 145 12 177 157 165 312 173 312 127 319 127 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 297 75 297 140 265 157 228 133 227 122 251 122 251 120 231 113 241 75
					yourself:
				)
		)
		(if (== gPrevRoomNum 630)
			(gGameSound1 number: 604 setLoop: 1 play:)
			(gGameSound2 number: 692 setLoop: -1 play:)
			(flier cue:)
			(bat1 cue:)
			(= local4 1)
			(= local6 1)
			(self setScript: fromTemple)
		else
			(fishermanBat init:)
			(tentBat init:)
			(punkBat init:)
			(freeTailBat init:)
			(passPorts init:)
			(self setScript: downTheHatch)
		)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((& (gEgo onControl:) $0002)
				(if local6
					(gCurRoom setScript: outtaHere)
				else
					(gCurRoom setScript: stopIt)
				)
			)
			((& (gEgo onControl:) $0004)
				(gCurRoom setScript: noFall)
			)
		)
	)

	(method (dispose)
		(batSound dispose:)
		(super dispose:)
	)
)

(instance exitnorth of ExitFeature
	(properties
		nsLeft 255
		nsBottom 41
		nsRight 309
		cursor 13
		exitDir 1
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((not (gUser input:)))
			((not (self onMe: gMouseX (- gMouseY 10))))
			(
				(or
					(and (== (event type:) evKEYBOARD) (!= (event message:) KEY_RETURN))
					(and (== (event type:) evMOUSEBUTTON) (event modifiers:))
					(not (OneOf (event type:) evMOUSEBUTTON evKEYBOARD))
				)
				(= lastCursor -1)
			)
			((OneOf (gTheCursor cel:) 10 11 12 13)
				(= temp0 (= temp1 0))
				(= temp0
					(if toX
						toX
					else
						(switch exitDir
							(1 gMouseX)
							(3 gMouseX)
							(2 320)
							(4 0)
							(else 999)
						)
					)
				)
				(= temp1
					(if toY
						toY
					else
						(switch exitDir
							(1 0)
							(3 190)
							(2
								(- gMouseY 10)
							)
							(4
								(- gMouseY 10)
							)
							(else 999)
						)
					)
				)
				(cond
					((== gPrevRoomNum 630)
						(gEgo setMotion: PolyPath temp0 temp1)
					)
					((< (gEgo y:) 85)
						(gEgo setMotion: PolyPath 273 48)
					)
					(else
						(gEgo setMotion: PolyPath 293 145)
					)
				)
				(event claimed: 1)
			)
			(else
				(event claimed: 0)
			)
		)
		(event claimed:)
	)
)

(instance shelf of Feature
	(properties
		x 206
		y 9
		z -60
		noun 1
		nsTop 51
		nsLeft 94
		nsBottom 87
		nsRight 319
		sightAngle 40
	)
)

(instance tunnel of Feature
	(properties
		x 31
		y 32
		noun 2
		nsTop 10
		nsLeft 11
		nsBottom 55
		nsRight 51
	)

	(method (doVerb theVerb)
		(if (not local4)
			(cond
				((OneOf theVerb 4 3) ; Do, Walk
					(gCurRoom setScript: stopIt)
				)
				(local6
					(gCurRoom setScript: outtaHere)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pile of Feature
	(properties
		x 51
		y 152
		noun 3
		nsTop 139
		nsLeft 4
		nsBottom 166
		nsRight 99
	)
)

(instance opening of Feature
	(properties
		x 282
		y 23
		noun 4
		nsTop 15
		nsLeft 252
		nsBottom 43
		nsRight 312
	)

	(method (doVerb theVerb)
		(if (not local4)
			(cond
				((== theVerb 4) ; Do
					(gCurRoom setScript: stopIt)
				)
				(local6
					(gCurRoom setScript: outtaHere)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance hole of Feature
	(properties
		x 284
		y 98
		noun 6
		nsTop 89
		nsLeft 265
		nsBottom 108
		nsRight 303
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(opening doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bat1 of Prop
	(properties
		x 115
		y 10
		noun 17
		view 600
		loop 4
		signal 16384
		cycleSpeed 16
		detailLevel 3
	)

	(method (init)
		(self setCycle: (randCycle new:))
		(super init:)
	)

	(method (cue)
		(if (not (Random 0 3))
			(batSound number: 602 setLoop: 1 play: self)
		else
			(self setScript: (STimer new:) self 2)
		)
	)
)

(instance batSound of Sound
	(properties)
)

(instance ripple_1 of Prop
	(properties
		name {ripple#1}
		x 279
		y 179
		view 600
		loop 7
		signal 16384
		cycleSpeed 10
		detailLevel 4
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance ripple_2 of Prop
	(properties
		name {ripple#2}
		x 157
		y 176
		view 600
		loop 8
		signal 16384
		cycleSpeed 10
		detailLevel 4
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance ripple_3 of Prop
	(properties
		name {ripple#3}
		x 55
		y 181
		view 600
		loop 9
		signal 16384
		cycleSpeed 10
		detailLevel 4
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance ripple_4 of Prop
	(properties
		name {ripple#4}
		x 133
		y 172
		view 600
		loop 10
		signal 16384
		cycleSpeed 10
		detailLevel 4
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance waterEff of Prop
	(properties
		x 65
		y 95
		view 600
		loop 11
		priority 1
		signal 16400
		cycleSpeed 10
		detailLevel 4
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (cue)
		(local9 stopUpd:)
	)
)

(instance passPorts of View
	(properties
		x 243
		y 120
		noun 14
		approachX 233
		approachY 122
		view 600
		loop 6
		signal 16384
	)

	(method (init)
		(super init:)
		(self stopUpd: approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: getPass)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flier of Actor
	(properties
		x 150
		y -30
		noun 17
		view 600
		loop 1
		cel 1
		priority 21
		signal 24593
	)

	(method (cue)
		(self
			cel: 0
			setStep: 3 2
			setLoop: 1
			setCycle: Fwd
			setMotion: MoveTo (Random 0 250) (Random 0 100) self
		)
	)
)

(instance paquita of Actor
	(properties
		x 20
		y 9
		noun 8
		approachX 30
		approachY 145
		view 50
		loop 2
		cel 3
		signal 24576
	)

	(method (init)
		(super init:)
		(self approachVerbs: 2 4 58 42 60 59 61 62) ; Talk, Do, punkPass, tentPass, fishPass, freeTailPass, fruitPass, adamBatPass
	)

	(method (doVerb theVerb)
		(cond
			((self perform: gWriteEcorderData theVerb 36) 0)
			((== theVerb 2) ; Talk
				(if (gEgo has: 20)
					(|= local8 $1000)
					(Bats points: 1 10)
					(gMessager say: noun theVerb 6) ; "I have to admit I am hungry. It has been many hours since the fire."
				else
					(Bats points: 1 4)
					(super doVerb: theVerb)
				)
			)
			((OneOf theVerb 58 42 60 59 61 62) ; punkPass, tentPass, fishPass, freeTailPass, fruitPass, adamBatPass
				(gCurRoom setScript: passPaquita 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 36))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance book of View
	(properties
		x 263
		y 113
		view 618
		loop 5
		signal 16384
	)

	(method (init)
		(super init:)
		(self hide:)
	)
)

(instance fireMarshall of Actor
	(properties
		x 262
		y 115
		noun 7
		approachX 243
		approachY 146
		view 618
		signal 16384
	)

	(method (init)
		(super init:)
		(book init:)
		(self stopUpd: approachVerbs: 4 2 58 42 60 59 61 62 13 8 setPri: 3) ; Do, Talk, punkPass, tentPass, fishPass, freeTailPass, fruitPass, adamBatPass, amulet, passport
	)

	(method (doVerb theVerb)
		(cond
			((self perform: gWriteEcorderData theVerb 39) 0)
			((== theVerb 13) ; amulet
				(Bats points: 5 16)
				(gCurRoom setScript: giveAmulet)
			)
			((== theVerb 2) ; Talk
				(|= local7 $0008)
				(self setLoop: 0 cel: 0 setCycle: End self)
			)
			((== theVerb 8) ; passport
				(if local1
					(super doVerb: theVerb)
				else
					(= local1 1)
					(gMessager say: noun 8 12) ; "We don't accept this kind of document here. Only Chiropteran passes are acceptable here."
				)
			)
			((OneOf theVerb 58 42 60 59 61 62) ; punkPass, tentPass, fishPass, freeTailPass, fruitPass, adamBatPass
				(gCurRoom setScript: passAdam 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(cond
			(local6
				(= local9 self)
				(self cel: (self lastCel:) setCycle: Beg waterEff)
				(gMessager say: noun 2 9) ; "Why are you delaying your departure? I have already processed your clearance."
			)
			((& local7 $0008)
				(&= local7 $fff7)
				(if (gEgo has: 21)
					(|= local8 $2000)
					(Bats points: 1 8)
					(gMessager say: noun 2 0 0 self) ; "Show me your identification! I'm very busy!"
				else
					(Bats points: 1 14)
					(gMessager say: noun 2 4 0 self) ; "Can I get through to the other side? There's no way I can climb out of here."
				)
			)
			(else
				(= local9 self)
				(self cel: (self lastCel:) setCycle: Beg waterEff)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 39))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance fishermanBat of Actor
	(properties
		x 201
		y 168
		z 30
		noun 12
		approachX 180
		approachY 162
		view 620
		loop 2
		cel 1
		priority 14
		signal 24592
	)

	(method (init)
		(super init:)
		(self stopUpd: approachVerbs: 2 58 42 60 59 61 62) ; Talk, punkPass, tentPass, fishPass, freeTailPass, fruitPass, adamBatPass
	)

	(method (doVerb theVerb)
		(cond
			((self perform: gWriteEcorderData theVerb 38) 0)
			((== theVerb 2) ; Talk
				(if (not local0)
					(if (gEgo has: 19)
						(|= local8 $4000)
						(self setScript: 0)
						(Bats points: 1 7)
						(gMessager say: noun theVerb 6) ; "They won't let me through to the refuge without my papers."
					else
						(Bats points: 1 13)
						(super doVerb: theVerb)
					)
				)
			)
			((OneOf theVerb 58 42 60 59 61 62) ; punkPass, tentPass, fishPass, freeTailPass, fruitPass, adamBatPass
				(if (not local0)
					(gCurRoom setScript: passFish 0 theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 38))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance tentBat of Actor
	(properties
		x 131
		y 103
		noun 11
		approachX 112
		approachY 145
		view 624
		signal 24576
	)

	(method (init)
		(super init:)
		(self stopUpd: approachVerbs: 4 2 58 42 60 59 61 62) ; Do, Talk, punkPass, tentPass, fishPass, freeTailPass, fruitPass, adamBatPass
	)

	(method (doVerb theVerb)
		(cond
			((self perform: gWriteEcorderData theVerb 37) 0)
			((== theVerb 2) ; Talk
				(|= local7 $0002)
				(self setLoop: 0 cel: 0 setCycle: End self)
			)
			((OneOf theVerb 58 42 60 59 61 62) ; punkPass, tentPass, fishPass, freeTailPass, fruitPass, adamBatPass
				(gCurRoom setScript: passTent 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (& local7 $0002)
			(&= local7 $fffd)
			(if (gEgo has: 16)
				(|= local8 $8000)
				(Bats points: 1 5)
				(gMessager say: noun 2 6 0 self) ; "I'm cold!"
			else
				(Bats points: 1 11)
				(gMessager say: noun 2 0 0 self) ; "I had the best leaf picked out."
			)
		else
			(= local9 self)
			(self cel: (self lastCel:) setCycle: Beg waterEff)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 37))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance themeSong of Sound
	(properties
		number 606
	)
)

(instance punkBat of Actor
	(properties
		x 128
		y 63
		noun 9
		approachX 152
		approachY 87
		view 626
		signal 24576
	)

	(method (init)
		(super init:)
		(self stopUpd: approachVerbs: 4 2 58 42 60 59 61 62) ; Do, Talk, punkPass, tentPass, fishPass, freeTailPass, fruitPass, adamBatPass
	)

	(method (doVerb theVerb)
		(cond
			((self perform: gWriteEcorderData theVerb 41) 0)
			((== theVerb 2) ; Talk
				(|= local7 $0001)
				(self setLoop: 0 cel: 0 setCycle: End self)
				(if (gEgo has: 17)
					(gGameSound1 pause:)
					(themeSong play: setLoop: -1)
				)
			)
			((OneOf theVerb 58 42 60 59 61 62) ; punkPass, tentPass, fishPass, freeTailPass, fruitPass, adamBatPass
				(gCurRoom setScript: passPunk 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (& local7 $0001)
			(&= local7 $fffe)
			(if (gEgo has: 17)
				(|= local8 $0100)
				(Bats points: 1 9)
				(gMessager say: noun 2 6 0 self) ; "I was flyin' along. It was a groove, like my tunes were happenin', you know what I mean?"
			else
				(Bats points: 1 15)
				(gMessager say: noun 2 0 0 self) ; "Hey, good buddy, maybe you can help me out."
			)
		else
			(= local9 self)
			(if (gEgo has: 17)
				(themeSong pause:)
				(gGameSound1 play:)
			)
			(self cel: (self lastCel:) setCycle: Beg waterEff)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 41))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance freeTailBat of Actor
	(properties
		x 205
		y 39
		noun 13
		approachX 186
		approachY 73
		view 628
		loop 2
		signal 24576
	)

	(method (init)
		(super init:)
		(self stopUpd: approachVerbs: 4 2 58 42 60 59 61 62) ; Do, Talk, punkPass, tentPass, fishPass, freeTailPass, fruitPass, adamBatPass
	)

	(method (doVerb theVerb)
		(cond
			((self perform: gWriteEcorderData theVerb 40) 0)
			((== theVerb 2) ; Talk
				(|= local7 $0004)
				(self setLoop: 0 cel: 0 setCycle: End self)
			)
			((OneOf theVerb 58 42 60 59 61 62) ; punkPass, tentPass, fishPass, freeTailPass, fruitPass, adamBatPass
				(gCurRoom setScript: passFree 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (& local7 $0004)
			(&= local7 $fffb)
			(if (gEgo has: 18)
				(|= local8 $0200)
				(Bats points: 1 6)
				(gMessager say: noun 2 6 0 self) ; "I was on my usual migration when the fire broke out. The Treetop Motel had burned to the ground."
			else
				(Bats points: 1 12)
				(gMessager say: noun 2 0 0 self) ; "The fire was sure hot. I'd say it was hotter than a Mexican chile and you know how hot that is!"
			)
		else
			(= local9 self)
			(self cel: (self lastCel:) setCycle: Beg waterEff)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 40))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance outtaHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo
					setScale: Scaler 97 41 128 24
					setMotion: MoveTo 305 141 self
				)
			)
			(2
				(gEgo setPri: 0 setMotion: MoveTo 273 124 self)
			)
			(3
				(gEgo setMotion: MoveTo 241 85 self)
			)
			(4
				(gEgo setMotion: MoveTo 269 59 self)
			)
			(5
				(gEgo setMotion: MoveTo 281 41 self)
			)
			(6
				(gEgo setMotion: MoveTo 243 24 self)
			)
			(7
				(gCurRoom newRoom: 630)
			)
		)
	)
)

(instance getPass of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 5 setLoop: 0 setCycle: 0 cel: 0)
				(= cycles 5)
			)
			(1
				(gEgo setCycle: CT 3 1 self)
			)
			(2
				(if (not local4)
					(gMessager say: 14 4 4) ; "Those are official documents. You have no authority to touch them."
				else
					(Bats points: 5)
					(gEgo get: 17 16 18 19 21 20)
					(gMessager say: 14 4) ; "Adam picks up the stack of visas."
					(passPorts dispose:)
				)
				(= cycles 5)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doFishing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local5
					(= seconds (Random 5 25))
				else
					(= local5 1)
					(self cue:)
				)
			)
			(1
				(= local0 1)
				(fishermanBat
					setStep: 7 4
					moveSpeed: 2
					setMotion: XAnimate @local10 self
				)
			)
			(2
				(fishermanBat
					setLoop: 4
					cycleSpeed: 3
					setCycle: Walk
					setMotion: MoveTo 160 144 self
				)
			)
			(3
				(fishermanBat cycleSpeed: 12 setCycle: MCyc @local76 self)
			)
			(4
				(= local0 0)
				(fishermanBat loop: 2 cel: 1 stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance fromTemple of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					x: 243
					y: 24
					init:
					normalize:
					setPri: 0
					setScale: Scaler 97 41 128 24
				)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: MoveTo 281 41 self)
			)
			(2
				(gEgo setMotion: MoveTo 269 59 self)
			)
			(3
				(gEgo setMotion: MoveTo 241 85 self)
			)
			(4
				(gEgo setMotion: MoveTo 273 124 self)
			)
			(5
				(gEgo setMotion: MoveTo 305 141 self)
			)
			(6
				(gEgo setPri: -1 setScale: 0 setMotion: MoveTo 264 163 self)
			)
			(7
				(gMessager say: 7 2 10 0 self) ; "I have already processed you. I suggest that you talk to Chiropterus."
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance downTheHatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 11
					x: 39
					y: 40
					setCel: 0
					setLoop: 1
					setPri: 3
					setStep: 3 6
					moveSpeed: 3
					setScale: 0
					init:
				)
				(= seconds 2)
			)
			(1
				(gGameSound1 number: 601 setLoop: 1 play:)
				(gEgo setMotion: MoveTo 32 61 self)
			)
			(2
				(gEgo setCel: 2 setMotion: MoveTo 45 87 self)
			)
			(3
				(gEgo setCel: 3 setMotion: MoveTo 54 104 self)
			)
			(4
				(gEgo setCel: 4 setMotion: MoveTo 71 122 self)
			)
			(5
				(gEgo setCel: 5 setMotion: MoveTo 78 128 self)
			)
			(6
				(gEgo
					setStep: 15 15
					moveSpeed: 1
					setLoop: 0
					setCel: 3
					setMotion: MoveTo 80 143 self
				)
			)
			(7
				(gEgo setCel: 4 setMotion: MoveTo 78 149 self)
			)
			(8
				(gGameSound1 number: 600 setLoop: 1 play: self)
				(gEgo setCel: 8 setPri: -1 setMotion: MoveTo 78 154 self)
			)
			(9
				(ShakeScreen 1)
			)
			(10
				(gGameSound2 number: 692 setLoop: -1 play:)
				(= seconds 1)
			)
			(11
				(gGameSound1 number: 604 setLoop: -1 play:)
				(gEgo
					setLoop: 2
					cel: 0
					x: 107
					y: 154
					moveSpeed: 6
					setCycle: End self
				)
			)
			(12
				(gEgo
					view: 0
					loop: 8
					cel: 0
					setLoop: -1
					setLoop: (ScriptID 0 8) ; stopGroop
					setStep: 3 2
					setCycle: StopWalk -1
					setSpeed: global136
				)
				(flier cue:)
				(bat1 cue:)
				(fishermanBat setScript: doFishing)
				(paquita init: setScript: paquitaFly)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance paquitaFly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(paquita
					origStep: 2570
					setStep: 6 6
					moveSpeed: 4
					cycleSpeed: 4
					setCycle: Walk
					setPri: 14
					setMotion: MoveTo 123 83 self
				)
			)
			(1
				(paquita setMotion: MoveTo 53 67 self)
			)
			(2
				(paquita
					view: 52
					x: 29
					y: 87
					setLoop: 3
					cel: 0
					setPri: -1
					setCycle: End self
				)
			)
			(3
				(paquita stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance stopIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= cycles 5)
			)
			(1
				(fireMarshall
					setLoop: 2
					x: 274
					setCycle: Fwd
					setMotion: MoveTo (+ (gEgo x:) 5) (fireMarshall y:) self
				)
				(book show:)
			)
			(2
				(gMessager say: 7 0 3 0 self) ; "Stop! This entrance is for bats with official clearance."
			)
			(3
				(gEgo setMotion: PolyPath 262 161 self)
			)
			(4
				(fireMarshall setMotion: MoveTo 274 (fireMarshall y:) self)
			)
			(5
				(book hide:)
				(fireMarshall x: 262 y: 115 setCycle: 0 setLoop: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance noFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= cycles 5)
			)
			(1
				(proc0_5 gEgo 274 36 self)
			)
			(2
				(gMessager say: 3 4 2 0 self) ; "I don't think I can jump that far!"
			)
			(3
				(gEgo setMotion: PolyPath 275 68 self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveAmulet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(proc0_5 gEgo fireMarshall self)
			)
			(2
				(gEgo
					view: 4
					setLoop: (+ (gEgo cel:) 1)
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(3
				(if local4
					(gMessager say: 7 13 0 0 self) ; "Yes, yes, you indicated that you are the official representative."
				else
					(paquita setScript: flyNow)
					(gMessager say: 7 13 12 0 self) ; "Oh, Forest Heart. Well!"
				)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo normalize: 0 6)
				(if local4
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(6
				(gMessager say: 7 13 13 0 self) ; "He loves to talk that way. He wants you to pass out the visas. The visa will let you stay in the refuge for a little while."
			)
			(7
				(fireMarshall setCycle: End self)
			)
			(8
				(fireMarshall stopUpd:)
				(= local4 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance flyNow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(paquita
					view: 50
					setPri: 15
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 260 124 self
				)
			)
			(1
				(paquita view: 51 loop: 0 cel: 7 setCycle: CT 3 -1 self)
			)
			(2
				(paquita
					view: 52
					loop: 0
					cel: 0
					x: 234
					y: 145
					setLoop: 3
					setCycle: End self
				)
			)
			(3
				(paquita
					view: 50
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 53 67 self
				)
				(giveAmulet cue:)
			)
			(4
				(paquita
					view: 52
					x: 29
					y: 87
					setLoop: 3
					cel: 0
					setPri: -1
					setCycle: End self
				)
			)
			(5
				(paquita stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance passFish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(proc0_5 gEgo fishermanBat self)
			)
			(2
				(gEgo view: 4 setCycle: End self)
			)
			(3
				(gEgo normalize: 0)
				(if (& local8 $4000)
					(gMessager say: 12 register 0 0 self)
				else
					(gMessager say: 7 2 6 0 self) ; "Interview the refugees, then hand out the visas."
				)
			)
			(4
				(if (and (== register 60) (& local8 $4000))
					(Bats points: 5)
					(gEgo put: 19)
					(doFishing dispose:)
					(fishermanBat
						setScript: 0
						moveSpeed: 6
						setStep: 6 6
						setLoop: 6
						setCycle: Walk
						setStep: 10 10
						setMotion: MoveTo 152 230 self
					)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(5
				(gGame handsOn:)
				(fishermanBat dispose:)
				(|= local8 $0001)
				(self dispose:)
			)
		)
	)
)

(instance passTent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo view: 4 loop: 7 setCycle: End self)
			)
			(2
				(gEgo normalize: 0 6)
				(if (& local8 $8000)
					(gMessager say: 11 register 0 0 self)
				else
					(gMessager say: 7 2 6 0 self) ; "Interview the refugees, then hand out the visas."
				)
			)
			(3
				(if (and (== register 42) (& local8 $8000))
					(Bats points: 5)
					(gEgo put: 16)
					(tentBat setLoop: 2 setCycle: End self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(4
				(tentBat
					setLoop: 3
					setCycle: Walk
					setStep: 10 10
					setMotion: MoveTo 268 58 self
				)
			)
			(5
				(tentBat setLoop: 3 setMotion: MoveTo 285 31 self)
			)
			(6
				(tentBat
					setPri: 0
					setStep: 6 4
					setScale: Scaler 100 28 49 26
					setMotion: MoveTo 257 21 self
				)
			)
			(7
				(gGame handsOn:)
				(|= local8 $0002)
				(tentBat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance passPunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(proc0_5 gEgo punkBat self)
			)
			(2
				(if (== register 58)
					(gGameSound1 pause:)
					(themeSong play:)
				)
				(gEgo view: 4 setLoop: 6 setCycle: CT 2 1 self)
			)
			(3
				(punkBat setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(punkBat setCycle: Beg self)
			)
			(6
				(gEgo normalize: 0 7)
				(if (& local8 $0100)
					(gMessager say: 9 register 0 0 self)
				else
					(gMessager say: 7 2 6 0 self) ; "Interview the refugees, then hand out the visas."
				)
			)
			(7
				(if (and (== register 58) (& local8 $0100))
					(Bats points: 5)
					(gEgo put: 17)
					(punkBat x: 135 y: 78 setLoop: 2 setCycle: End self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(8
				(punkBat
					setPri: 15
					setLoop: 3
					cel: 0
					setStep: 12 10
					setCycle: Walk
					setMotion: MoveTo 294 42 self
				)
			)
			(9
				(punkBat setLoop: 4 setMotion: MoveTo 297 38 self)
			)
			(10
				(themeSong fade: 0 10 11 1)
				(punkBat
					setPri: -1
					setStep: 6 6
					setScale: Scaler 100 52 42 22
					setLoop: 5
					setMotion: MoveTo 260 22 self
				)
			)
			(11
				(gGame handsOn:)
				(themeSong dispose:)
				(gGameSound1 play:)
				(|= local8 $0004)
				(punkBat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance passFree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo
					view: 4
					setLoop: (+ (gEgo cel:) 1)
					setCycle: CT 2 1 self
				)
			)
			(2
				(freeTailBat setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(freeTailBat setCycle: Beg self)
			)
			(5
				(gEgo normalize: 0 6)
				(if (& local8 $0200)
					(gMessager say: 13 register 0 0 self)
				else
					(gMessager say: 7 2 6 0 self) ; "Interview the refugees, then hand out the visas."
				)
			)
			(6
				(if (and (== register 59) (& local8 $0200))
					(Bats points: 5)
					(gEgo put: 18)
					(freeTailBat setLoop: 2 setCycle: End self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(7
				(freeTailBat
					setLoop: 3
					setStep: 10 10
					setCycle: Walk
					setMotion: MoveTo 223 57 self
				)
			)
			(8
				(freeTailBat setPri: 3 setLoop: 4 setMotion: MoveTo 290 36 self)
			)
			(9
				(freeTailBat
					setLoop: 5
					setPri: 0
					setStep: 4 4
					setScale: Scaler 100 35 43 24
					setMotion: MoveTo 257 20 self
				)
			)
			(10
				(gGame handsOn:)
				(|= local8 $0008)
				(freeTailBat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance passPaquita of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo view: 4 setLoop: 3 setCycle: End self)
			)
			(2
				(gEgo normalize: 0 3)
				(if (& local8 $1000)
					(gMessager say: 8 register 0 0 self)
				else
					(gMessager say: 7 2 6 0 self) ; "Interview the refugees, then hand out the visas."
				)
			)
			(3
				(if (and (== register 61) (& local8 $1000))
					(Bats points: 5)
					(gEgo put: 20)
					(paquita
						view: 50
						setLoop: -1
						setPri: 15
						setCycle: Walk
						setMotion: MoveTo 265 (+ (paquita y:) 20) self
					)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(4
				(paquita
					setPri: 14
					setScale: Scaler 100 39 100 23
					setMotion: MoveTo 246 69 self
				)
			)
			(5
				(paquita setMotion: MoveTo 285 35 self)
			)
			(6
				(paquita setPri: 0 setMotion: MoveTo 259 18 self)
			)
			(7
				(gGame handsOn:)
				(|= local8 $0010)
				(paquita dispose:)
				(self dispose:)
			)
		)
	)
)

(instance passAdam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo view: 4 cel: 0 setCycle: End self)
			)
			(2
				(gEgo normalize: 0)
				(if (== register 62)
					(if (== (& local8 $001f) 31)
						(gMessager say: 7 8 8 0 self) ; "I'm just going to add 'Humanus humongeous' to this."
					else
						(gMessager say: 7 8 7 0 self) ; "I have indicated to you that passage may be obtained by presentation of the appropriate documents."
						(gGame handsOn:)
						(self dispose:)
					)
				else
					(if (& local8 $2000)
						(gMessager say: 7 2 6 0 self) ; "Interview the refugees, then hand out the visas."
					else
						(gMessager say: 7 register 0 0 self)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(3
				(Bats points: 5)
				(gEgo put: 21)
				(fireMarshall setLoop: 1 setCycle: End self)
			)
			(4
				(gMessager say: 7 8 16 0 self) ; "Welcome to our country."
			)
			(5
				(= local6 1)
				(fireMarshall setScript: leaveTimer)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(if (not (gCurRoom script:))
					(gGame handsOff:)
					(gMessager say: 7 2 9 0 self) ; "Why are you delaying your departure? I have already processed your clearance."
				else
					(self dispose:)
				)
			)
			(2
				(gGame handsOn:)
				(self changeState: 0)
			)
		)
	)
)

(instance randCycle of Fwd
	(properties)

	(method (doit &tmp temp0)
		(cond
			((> (= temp0 (self nextCel:)) (client lastCel:))
				(self cycleDone:)
			)
			((not (Random 0 3))
				(client cel: temp0)
			)
		)
	)
)

