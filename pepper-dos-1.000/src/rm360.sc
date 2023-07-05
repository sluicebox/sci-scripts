;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use BalloonTalker)
(use ADRoom)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm360 0
	offSrnT 1
	spec3T 18
)

(local
	local0
	local1
	local2
	local3
)

(instance rm360 of ADRoom
	(properties
		noun 1
		picture 360
		east 350
		west 370
		vanishingY 73
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(= global215 4)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(LoadMany rsVIEW 350 360 790)
		(gEgo init: normalize: setScale: Scaler 100 77 180 73)
		(gWalkHandler addToFront: river)
		(gWalkHandler addToFront: foliage)
		(gWalkHandler addToFront: gCurRoom)
		(gMouseDownHandler addToFront: gCurRoom)
		(gKeyDownHandler addToFront: gCurRoom)
		(gDirectionHandler addToFront: gCurRoom)
		(cond
			((== gPrevRoomNum 610)
				(gEgo x: 85 y: 172 setHeading: 0)
				(gGame handsOn:)
			)
			((== gPrevRoomNum 350)
				(Load rsVIEW 352)
				(gEgo view: 352 setLoop: 8 setCel: 0 x: 320 y: 200)
				(kite init:)
				(gGame handsOff:)
				(gCurRoom setScript: sExitRiver)
			)
			(else
				(gEgo x: 85 y: 172 setHeading: 0)
			)
		)
		(fat init: setScript: sFatWiggles)
		(skinny init: setScript: sSkinnyWiggles)
		(nRiverFlows init:)
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 125 189 124 164 291 167 317 145 293 90 276 92 258 79 236 80 225 92 166 85 163 95 120 97 119 80 102 80 97 88 67 86 34 132 0 132
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 156 109 169 122 149 131 125 125 136 109
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 193 145 173 157 152 145 167 134
					yourself:
				)
		)
		(dummy init:)
		(if (> (gGame detailLevel:) 2)
			(dummy setScript: sCycleRiver)
		)
		(foliage init: setOnMeCheck: 1 16384)
		(openWindow init:)
		(hedges init: setOnMeCheck: 1 8192)
		(hidingTree1 init:)
		(hidingTree2 init:)
		(hidingTree3 init:)
		(hidingTree4 init:)
		(hills init: setOnMeCheck: 1 4096)
		(mansion init:)
		(otherTrees init: setOnMeCheck: 1 2048)
		(river init: setOnMeCheck: 1 1026)
		(windows1 init:)
		(windows2 init:)
		(windows3 init:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(gWalkHandler delete: river)
		(gWalkHandler delete: foliage)
		(gWalkHandler delete: gCurRoom)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(gDirectionHandler delete: gCurRoom)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(= temp1 (event type:))
		(= temp0 (event message:))
		(if
			(or
				(and (== temp1 evMOUSEBUTTON) (not (event modifiers:)))
				(and (== temp1 evKEYBOARD) (== temp0 KEY_RETURN))
			)
			(cond
				((and (not (gUser controls:)) (not (gUser input:)))
					(event claimed: 1)
				)
				(
					(or
						(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
						(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
					)
					(cond
						((hidingTree1 onMe: event)
							(event claimed: 1)
							(cond
								(local0
									(self setScript: sGetCaught 0 4)
								)
								((and (not local1) (not local2) (not local3))
									(= local0 1)
									(self setScript: sSneekTree1)
								)
								(else
									(self setScript: sGetCaught 0 4)
								)
							)
						)
						((hidingTree2 onMe: event)
							(event claimed: 1)
							(cond
								(local1
									(self setScript: sGetCaught 0 5)
								)
								((and local0 (not local2) (not local3))
									(= local1 1)
									(self setScript: sSneekTree2)
								)
								(else
									(self setScript: sGetCaught 0 4)
								)
							)
						)
						((hidingTree3 onMe: event)
							(event claimed: 1)
							(cond
								(local2
									(self setScript: sGetCaught 0 6)
								)
								((and local0 local1 (not local3))
									(= local2 1)
									(self setScript: sSneekTree3)
								)
								(else
									(self setScript: sGetCaught 0 4)
								)
							)
						)
						((hidingTree4 onMe: event)
							(event claimed: 1)
							(cond
								(local3
									(self setScript: sGetCaught 0 7)
								)
								((and local0 local1 local2)
									(= local3 1)
									(self setScript: sSneekTree4)
								)
								(else
									(self setScript: sGetCaught 0 4)
								)
							)
						)
						((openWindow onMe: event)
							(event claimed: 1)
							(if (and local0 local1 local2 local3)
								(self setScript: sEnterHouse)
							else
								(self setScript: sGetCaught 0 1)
							)
						)
						((or (fat onMe: event) (skinny onMe: event))
							(event claimed: 1)
							(self setScript: sGetCaught 0 3)
						)
						((hedges onMe: event)
							(event claimed: 1)
							(self setScript: sGetCaught 0 8)
						)
						((mansion onMe: event)
							(event claimed: 1)
							(self setScript: sGetCaught 0 9)
						)
						(
							(or
								(windows3 onMe: event)
								(windows2 onMe: event)
								(windows1 onMe: event)
							)
							(event claimed: 1)
							(self setScript: sGetCaught 0 10)
						)
						(
							(or
								(foliage onMe: event)
								(river onMe: event)
								(hills onMe: event)
							)
							(super handleEvent: event)
						)
						(else
							(event claimed: 1)
							(self setScript: sGetCaught 0 11)
						)
					)
				)
			)
		)
	)
)

(instance sGetCaught of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 15) self
				)
			)
			(2
				(switch register
					(1
						(gMessager say: 10 7 6 0 self) ; "Sucker! He left his window open!"
					)
					(2
						(gMessager say: 11 85 0 0 self) ; "Hey, you big dummies! What did you do with my dog?!?"
					)
					(3
						(gMessager say: 11 7 0 0 self) ; "Hey, I'll take you all on at once! With one paw tied behind my back! Yeah!"
					)
					(4
						(gMessager say: 2 7 1 0 self) ; "I'll just sneak over to this tree..."
					)
					(5
						(gMessager say: 2 7 2 0 self) ; "Okay, so far, so good."
					)
					(6
						(gMessager say: 2 7 3 0 self) ; "Yeah! Almost there!"
					)
					(7
						(gMessager say: 2 7 4 0 self) ; "All right! Home free!"
					)
					(8
						(gMessager say: 4 7 0 0 self) ; "Maybe I can sneak through these hedges..."
					)
					(9
						(gMessager say: 8 7 0 0 self) ; "I'll just sneak in through the back!"
					)
					(10
						(gMessager say: 9 7 0 0 self) ; "Okay, I'll creep in through the window!"
					)
					(11
						(= cycles 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(cond
					((== register 2)
						(gMessager say: 12 0 8 0 self) ; "So, you want your dog, do you?"
					)
					((== register 3)
						(gMessager say: 12 0 9 0 self) ; "Will you look at that, Wilberforce? The poor little lad's gone barmy!"
					)
					(else
						(gMessager say: 12 0 7 0 self) ; "Hey! Hey, look, Wilberforce! There's someone on the lawn, there is!"
					)
				)
			)
			(4
				(= global199 7)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sEnterHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and local0 local1 local2 local3)
					(gGame points: 353 2)
					(= cycles 1)
				else
					(self setScript: sGetCaught 0 1)
				)
			)
			(1
				(gMessager say: 10 7 5 0 self) ; "All RIGHT!"
			)
			(2
				(rmSound number: 363 loop: 1 play: self)
				(gEgo
					view: 360
					loop: 4
					cel: 0
					setScale: 0
					posn: 112 66
					setCycle: End self
				)
			)
			(3 0)
			(4
				(gLongSong fade:)
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance sExitRiver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 13) ; Kite
				(= cycles 5)
			)
			(1
				(kite
					setLoop: 6
					setPri: 13
					setCycle: Fwd
					setMotion: MoveTo 109 159 self
				)
			)
			(2
				(kite setMotion: MoveTo -30 128)
			)
			(3
				(gEgo setLoop: 7 cel: 9 posn: 66 170 setCycle: Beg self)
				(kite setStep: 3 8 setCycle: End setMotion: MoveTo -100 10)
			)
			(4
				(gEgo
					normalize: 790 7
					posn: (+ (gEgo x:) 19) (+ (gEgo y:) 2)
				)
				(gGame handsOn:)
				(gMouseDownHandler addToFront: gCurRoom)
				(gKeyDownHandler addToFront: gCurRoom)
				(gDirectionHandler addToFront: gCurRoom)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (<= state 2)
			(gEgo x: (+ (kite x:) 34) y: (+ (kite y:) 50))
			(if (& (gEgo onControl: 1) $0002)
				(self cue:)
			)
		)
		(super doit: &rest)
	)
)

(instance sFatWiggles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fat setCycle: CT 4 1 self)
			)
			(1
				(fat setCycle: CT (Random 0 3) -1 self)
			)
			(2
				(= seconds (Random 2 5))
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sSkinnyWiggles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(skinny setCycle: CT 4 1 self)
			)
			(1
				(skinny setCycle: CT (Random 0 3) -1 self)
			)
			(2
				(= seconds (Random 2 5))
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sCycleRiver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gGame detailLevel:) 2)
					(Palette palANIMATE 64 69 20)
				else
					(self dispose:)
				)
				(= ticks 10)
			)
			(1
				(self init:)
			)
		)
	)
)

(instance sSneekTree1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 349 2)
				(= cycles 1)
			)
			(1
				(gEgo stopUpd:)
				(gMessager say: 2 7 1 0 self) ; "I'll just sneak over to this tree..."
			)
			(2
				(gEgo setMotion: MoveTo 140 175 self)
			)
			(3
				(Face gEgo mansion self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSneekTree2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 350 2)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 360
					loop: 2
					cel: 0
					posn: 131 175
					setScale: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(gEgo setCycle: CT 6 1 self)
			)
			(4
				(= ticks 60)
			)
			(5
				(gEgo setCycle: CT 9 1 self)
			)
			(6
				(rmSound number: 360 loop: 1 play:)
				(gEgo setPri: 12)
				(= cycles 1)
			)
			(7
				(gEgo setCycle: End self)
			)
			(8
				(gEgo
					normalize: 790 3
					setScale: Scaler 100 77 180 73
					posn: 148 154
				)
				(= cycles 1)
			)
			(9
				(gEgo setMotion: MoveTo 162 140 self)
			)
			(10
				(gEgo stopUpd:)
				(gMessager say: 2 7 2 0 self) ; "Okay, so far, so good."
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSneekTree3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 351 2)
				(= cycles 1)
			)
			(1
				(rmSound number: 361 loop: 1 play:)
				(= cycles 1)
			)
			(2
				(gEgo
					view: 360
					setLoop: 5
					cel: 0
					posn: 163 140
					setScale: 0
					setPri: (+ (gEgo priority:) 1)
					setCycle: Walk
					setMotion: MoveTo 135 116 self
				)
			)
			(3
				(gEgo normalize: 790 3 setScale: Scaler 100 77 180 73)
				(= cycles 1)
			)
			(4
				(gEgo stopUpd:)
				(gMessager say: 2 7 3 0 self) ; "Yeah! Almost there!"
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSneekTree4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 352 2)
				(= cycles 1)
			)
			(1
				(rmSound number: 362 loop: 1 play:)
				(= cycles 1)
			)
			(2
				(gEgo
					view: 360
					setLoop: 5
					cel: 0
					setScale: 0
					setPri: (+ (gEgo priority:) 1)
					setCycle: Walk
					setMotion: MoveTo 115 81 self
				)
			)
			(3
				(gEgo normalize: 790 3 setScale: Scaler 100 77 180 73)
				(= cycles 1)
			)
			(4
				(gEgo stopUpd:)
				(gMessager say: 2 7 4 0 self) ; "All right! Home free!"
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkHedges of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 4 85 0 1 self) ; "Psst! Anybody in there?"
			)
			(1
				(gMessager say: 4 85 0 2 self) ; "The hedges don't answer."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance fat of Prop
	(properties
		x 251
		y 90
		noun 11
		view 350
		loop 3
		cel 1
		cycleSpeed 30
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Talk
				(gCurRoom setScript: sGetCaught 0 2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skinny of Prop
	(properties
		x 279
		y 91
		noun 11
		view 350
		loop 2
		cel 2
		signal 16384
		cycleSpeed 30
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Talk
				(gCurRoom setScript: sGetCaught 0 2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dummy of Prop
	(properties
		x 10
		y 1000
		view 350
	)
)

(instance kite of Actor
	(properties
		x 263
		y 146
		view 352
		loop 6
		cel 2
		priority 10
		signal 16400
	)
)

(instance foliage of Feature
	(properties
		x 300
		y 180
		noun 7
		sightAngle 20
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gMessager say: 7 7) ; "Pepper doesn't need the plant."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance openWindow of Feature
	(properties
		x 106
		y 45
		noun 10
		nsTop 25
		nsLeft 94
		nsBottom 66
		nsRight 121
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(= global215 4)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hedges of Feature
	(properties
		y 30
		noun 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Talk
				(gCurRoom setScript: sTalkHedges)
			)
			(84 ; Trivia
				(= global215 97)
				(gMessager say: 4 84) ; "TRUE. Ornamental hedges and |r||c0|topiary|c||r| were very popular in 18th century Europe. The idea was later exported to America. The palace at Versailles, France was particularly famous for its beautiful gardens."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hidingTree1 of Feature
	(properties
		x 147
		y 149
		noun 2
		nsTop 119
		nsLeft 134
		nsBottom 171
		nsRight 160
		sightAngle 40
	)

	(method (doVerb theVerb)
		(= global215 4)
		(super doVerb: theVerb)
	)
)

(instance hidingTree2 of Feature
	(properties
		x 174
		y 120
		noun 2
		nsTop 97
		nsLeft 152
		nsBottom 143
		nsRight 188
		sightAngle 40
	)

	(method (doVerb theVerb)
		(= global215 4)
		(super doVerb: theVerb)
	)
)

(instance hidingTree3 of Feature
	(properties
		x 149
		y 98
		noun 2
		nsTop 68
		nsLeft 137
		nsBottom 119
		nsRight 161
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: sSneekTree3)
			)
			(7 ; Do
				(gCurRoom setScript: sSneekTree3)
			)
			(84 ; Trivia
				(= global215 4)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hidingTree4 of Feature
	(properties
		x 136
		y 61
		noun 2
		nsTop 34
		nsLeft 124
		nsBottom 88
		nsRight 148
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: sSneekTree4)
			)
			(7 ; Do
				(gCurRoom setScript: sSneekTree4)
			)
			(84 ; Trivia
				(= global215 4)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hills of Feature
	(properties
		y 10
		noun 6
	)
)

(instance mansion of Feature
	(properties
		x 182
		y 37
		noun 8
		nsLeft 75
		nsBottom 74
		nsRight 290
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(rmSound number: 927 play:)
				(gMessager say: 8 84) ; "|c1|TRUE. Penn Mansion was built by William Penn, who owned large portions of Philadelphia. He was generally considered to be a just governor. Once his sons inherited the property, however, they decided to stay in London and party instead of taking care of their lands.|c|"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance otherTrees of Feature
	(properties
		y 10
		noun 6
	)
)

(instance river of Feature
	(properties
		x 10
		y 170
		noun 5
		sightAngle 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gMessager say: 5 7) ; "Pepper doesn't want to get back into the river. She just got out."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance windows3 of Feature
	(properties
		x 159
		y 45
		noun 9
		nsTop 25
		nsLeft 147
		nsBottom 65
		nsRight 171
		sightAngle 40
	)
)

(instance windows2 of Feature
	(properties
		x 208
		y 44
		noun 9
		nsTop 25
		nsLeft 198
		nsBottom 63
		nsRight 219
		sightAngle 40
	)
)

(instance windows1 of Feature
	(properties
		x 256
		y 43
		noun 9
		nsTop 25
		nsLeft 247
		nsBottom 62
		nsRight 266
		sightAngle 40
	)
)

(instance offSrnT of BalloonTalker
	(properties
		x 91
		y 83
		talkWidth 150
		tailPosn 4
	)
)

(instance spec3T of BalloonTalker
	(properties
		x 122
		y 78
		talkWidth 150
		tailPosn 4
	)
)

(instance rmSound of Sound
	(properties)
)

(instance nRiverFlows of Sound
	(properties
		flags 1
		number 3600
		loop -1
	)
)

