;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use n013)
(use Fens)
(use verseScript)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm600 0
)

(local
	local0
	local1
	local2
	local3
	[local4 10]
	[local14 9] = [104 161 128 169 51 279 40 3 266]
	[local23 9] = [149 144 141 136 156 143 127 149 140]
	[local32 12]
	[local44 11] = [0 319 90 225 159 136 244 0 160 319 57]
	[local55 11] = [109 109 116 122 105 131 139 128 145 129 139]
	[local66 11] = [1 1 0 2 2 2 0 2 1 2 0]
	[local77 16]
	[local93 4] = [3 3 2 3]
	[local97 9] = [2 3 3 3 2 3 3 3 2]
	[local106 15] = [2 3 3 3 2 3 3 3 2 3 2 2 3 3 2]
	[local121 4] = [3 6 3 1]
	[local125 9] = [1 2 5 5 6 5 7 7 4]
	[local134 15] = [1 2 5 5 6 5 7 7 4 7 6 6 6 4 1]
	[local149 4] = [57 260 0 3]
	[local153 9] = [21 7 66 191 229 297 239 289 261]
	[local162 15] = [23 50 66 191 152 297 239 289 261 247 214 283 198 312 311]
	[local177 4] = [135 167 160 127]
	[local181 9] = [129 145 142 193 150 195 152 152 142]
	[local190 15] = [156 139 142 193 156 195 153 152 142 189 189 133 141 182 170]
	[local205 7] = [1600 0 1 1 1 1 0]
	[local212 4] = [1600 4 1 0]
	[local216 4] = [1600 5 1 0]
	[local220 10] = [1600 6 1 1 1 1 1 1 1 0]
	[local230 7] = [1600 13 1 2 2 1 0]
	[local237 5] = [1600 18 1 2 0]
	[local242 5] = [1600 20 2 1 0]
	[local247 4] = [1600 28 1 0]
	[local251 9] = [673 0 2 4 19 33 22 20 21]
)

(procedure (localproc_0)
	((theWater onMeCheck:) dispose:)
	((thePlants onMeCheck:) dispose:)
	((gCurRoom obstacles:) dispose:)
	(gCurRoom obstacles: 0)
	(gFeatures add: thePlants theWater theSky theGround)
	(if (== local1 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 165 264 171 198 162 179 165 149 164 107 164 52 174 19 165 0 165 0 0 319 0
					yourself:
				)
		)
		(thePlants
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 319 161 299 146 273 152 271 165 261 165 252 151 214 143 201 153 178 134 160 129 145 151 138 141 141 128 127 121 111 122 104 131 96 146 96 124 88 122 71 142 65 130 55 132 41 150 0 146 0 164 52 171 108 160 218 160 260 166 279 166
					yourself:
				)
		)
		(theWater
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 319 120 292 115 257 123 144 131 40 120 0 122 0 162 53 171 121 157 251 161 266 166 319 160 319 145 228 148 245 136 319 124
					yourself:
				)
		)
	else
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 165 300 165 267 174 212 164 170 164 140 165 121 162 44 170 32 165 0 165
					yourself:
				)
		)
		(thePlants
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 0 161 20 146 46 152 48 165 58 165 67 151 105 143 118 153 141 134 159 129 174 151 181 141 178 128 192 121 208 122 215 131 223 146 223 124 231 122 248 142 254 130 264 132 278 150 319 146 319 164 267 171 211 160 101 160 59 166 40 166
					yourself:
				)
		)
		(theWater
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 0 120 27 115 62 123 175 131 279 120 318 122 319 162 266 171 198 157 68 161 53 166 0 160 0 145 91 148 74 136 0 124
					yourself:
				)
		)
	)
)

(procedure (localproc_1) ; UNUSED
	((theWater onMeCheck:) dispose:)
	(if (== local1 1)
		(theWater
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 319 120 292 115 257 123 144 131 40 120 0 122 0 162 53 171 121 157 251 161 266 166 319 160 319 145 228 148 245 136 319 124
					yourself:
				)
		)
	else
		(theWater
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 0 120 27 115 62 123 175 131 279 120 318 122 319 162 266 171 198 157 68 161 53 166 0 160 0 145 91 148 74 136 0 124
					yourself:
				)
		)
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 11) ((++ temp0))
		(= [local32 temp0] (cloud new:))
		([local32 temp0]
			x: [local44 temp0]
			y: [local55 temp0]
			loop: [local66 temp0]
			init:
		)
		(gAddToPics add: [local32 temp0])
	)
	(gAddToPics doit:)
)

(procedure (localproc_3 param1 &tmp temp0 temp1)
	(= temp1
		(switch param1
			(0 4)
			(1 9)
			(2 15)
		)
	)
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		(= [local77 temp0] (aPlant new:))
		([local77 temp0]
			view: 600
			loop:
				(switch param1
					(0 [local93 temp0])
					(1 [local97 temp0])
					(2 [local106 temp0])
				)
			cel:
				(switch param1
					(0 [local121 temp0])
					(1 [local125 temp0])
					(2 [local134 temp0])
				)
			x:
				(switch param1
					(0 [local149 temp0])
					(1 [local153 temp0])
					(2 [local162 temp0])
				)
			y:
				(switch param1
					(0 [local177 temp0])
					(1 [local181 temp0])
					(2 [local190 temp0])
				)
			init:
		)
		(gAddToPics add: [local77 temp0])
	)
	(gAddToPics doit:)
)

(procedure (localproc_4 &tmp temp0)
	(for ((= temp0 0)) (< temp0 9) ((++ temp0))
		((= [local4 temp0] (wave new:))
			x: [local14 temp0]
			y: [local23 temp0]
			setPri: 1
			init:
		)
	)
)

(instance rm600 of Rm
	(properties
		picture 600
		style 5
		north 610
	)

	(method (init &tmp temp0)
		(= temp0 (if (> gHowFast 0) 2 else 3))
		(if (== gPrevRoomNum 590)
			(self style: 12)
		)
		(super init:)
		(gTheIconBar disable: 5)
		(gEgo actions: (ScriptID 601 7)) ; egoActions
		(localproc_2)
		(localproc_3 0)
		(if (not (IsFlag 0))
			(localproc_4)
		)
		(AddToFeatures thePlants theWater theSky theGround)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 165 300 165 267 174 212 164 170 164 140 165 121 162 44 170 32 165 0 165
					yourself:
				)
		)
		(NormalEgo)
		(switch gPrevRoomNum
			(690
				(gEgo
					view: 585
					normal: 0
					moveHead: 0
					setLoop: 2
					setStep: temp0 temp0
					cycleSpeed: 18
					cel: 0
					posn: 319 140
					setCycle: Walk
					init:
					setScript: rescueOfFulk
				)
				(= local2 1)
			)
			(700
				((ScriptID 601 1) ; rgnBoat
					view: 21
					loop: 2
					cel: 2
					posn: 98 132
					setPri: ((ScriptID 601 2) priority:) ; monk
					ignoreActors: 1
					init:
				)
				((ScriptID 601 10) cel: 3 posn: 133 156 init:) ; pole
				(HandsOff)
				(NormalEgo 4)
				(gEgo posn: 125 165 init: setMotion: MoveTo 140 180 self)
				((ScriptID 601) notify: 700) ; Fens
			)
			(590
				(gEgo
					posn: 15 (gEgo y:)
					init:
					setMotion: PolyPath 26 182 self
				)
				(proc601_11 2)
				(= local3 (proc601_5 2))
				(HandsOff)
			)
			(else
				(gEgo posn: 160 185 init:)
			)
		)
	)

	(method (notify)
		((ScriptID 601) ; Fens
			notify:
				(switch local1
					(0 2)
					(1 3)
					(2 4)
				)
		)
	)

	(method (cue)
		(if local3
			(= local3 0)
			(Converse 1 @local247 11 0 self) ; "I'm not going to wait here all day."
		)
		(HandsOn)
		(super cue:)
	)

	(method (doit)
		(++ local0)
		(if (not (IsFlag 115))
			(cond
				((== local1 1)
					(if (== (mod local0 5) 0)
						(Palette palANIMATE 225 255 1)
					)
				)
				((== (mod local0 5) 0)
					(Palette palANIMATE 225 255 -1)
				)
			)
		)
		(cond
			((gEgo script:))
			((== (gEgo edgeHit:) 3)
				(gEgo setScript: walkDown)
			)
			((and (>= (gEgo x:) 310) (== local1 2))
				(gEgo setMotion: 0 setScript: bumpBog)
			)
			((and (>= (gEgo x:) 319) (< local1 2))
				(gEgo setScript: headEast)
			)
			((== (gEgo edgeHit:) 4)
				(gEgo setScript: headWest)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (dispose)
		(gRgnMusic2 stop:)
		(self setScript: 0)
		(super dispose:)
	)
)

(instance cloud of PicView
	(properties
		z 15
		lookStr 22 ; "The fog grows ever thicker. It would be easy to become lost within."
		view 590
		signal 24576
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(Say 1600 23 1) ; "How can one grasp insubstantial tendrils of mist?"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance aPlant of PicView
	(properties
		lookStr 24 ; "Only stunted bushes and thick reeds grow near these fens."
		signal 16384
	)
)

(instance wave of Prop
	(properties
		view 600
		loop 5
		signal 16384
		cycleSpeed 18
	)

	(method (init)
		(if (Random 0 1)
			(self setCel: (Random 0 2) setCycle: Fwd)
		else
			(self setCel: (Random 0 2) setCycle: Rev)
		)
		(super init:)
	)
)

(instance theWater of Feature
	(properties
		lookStr 26 ; "Faith, that is dark and unwholesome water, just deep enough to drown a man."
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(Say 1600 27 1) ; "I care not to touch this water."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 120 27 115 62 123 175 131 279 120 318 122 319 162 266 171 198 157 68 161 53 166 0 160 0 145 91 148 74 136 0 124
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance thePlants of Feature
	(properties
		lookStr 24 ; "Only stunted bushes and thick reeds grow near these fens."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 161 20 146 46 152 48 165 58 165 67 151 105 143 118 153 141 134 159 129 174 151 181 141 178 128 192 121 208 122 215 131 223 146 223 124 231 122 248 142 254 130 264 132 278 150 319 146 319 164 267 171 211 160 101 160 59 166 40 166
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance theSky of Feature
	(properties
		nsBottom 80
		nsRight 319
		lookStr 30 ; "A perpetual gloom hangs over these fens."
	)
)

(instance theGround of Feature
	(properties
		nsTop 80
		nsBottom 189
		nsRight 319
		lookStr 29 ; "The ground here is boggy and unpleasant."
	)
)

(instance fulkScroll of View ; UNUSED
	(properties
		x 240
		y 155
		view 771
		loop 3
		priority 15
		signal 16400
	)
)

(instance waterRing of View ; UNUSED
	(properties
		x 240
		y 150
		view 771
		loop 5
		priority 15
		signal 16400
	)
)

(instance fulk of Actor
	(properties
		view 674
		loop 5
		signal 16384
	)
)

(instance bumpBog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1600 25 self) ; "There's a thicket and marshy ground up ahead. I'll have to turn back."
			)
			(1
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 15) (gEgo y:) self
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath -10 global105 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 45) self
				)
			)
			(1
				(gCurRoom newRoom: 590)
			)
		)
	)
)

(instance headEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 335 (gEgo y:) self)
			)
			(1
				(HandsOff)
				(++ local1)
				(if (gCast contains: (ScriptID 601 1)) ; rgnBoat
					((ScriptID 601 1) dispose:) ; rgnBoat
				)
				(if (gCast contains: (ScriptID 601 2)) ; monk
					((ScriptID 601 2) dispose:) ; monk
				)
				(if (gCast contains: (ScriptID 601 10)) ; pole
					((ScriptID 601 10) dispose:) ; pole
				)
				(gAddToPics eachElementDo: #dispose release:)
				(gFeatures release:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ClearFlag 14)
				(if (== local1 1)
					(gCurRoom drawPic: 600 16396)
					(localproc_3 1)
				else
					(gCurRoom style: 12 drawPic: 600)
					(localproc_3 2)
				)
				(localproc_0)
				(localproc_2)
				(if (== gDay 13)
					(proc601_11 (+ local1 2))
				)
				(= local3 (proc601_5 (+ local1 2)))
				(gEgo posn: (- (gEgo x:) 320) (gEgo y:))
				(= ticks 30)
			)
			(2
				(gEgo setMotion: PolyPath 30 (gEgo y:) self)
			)
			(3
				(if local3
					(Converse 1 @local247 11 0 self) ; "I'm not going to wait here all day."
				else
					(self cue:)
				)
			)
			(4
				(= local3 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance headWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath -15 (gEgo y:) self)
			)
			(1
				(if (not local1)
					(gCurRoom newRoom: 590)
				else
					(-- local1)
					(if (gCast contains: (ScriptID 601 1)) ; rgnBoat
						((ScriptID 601 1) dispose:) ; rgnBoat
					)
					(if (gCast contains: (ScriptID 601 2)) ; monk
						((ScriptID 601 2) dispose:) ; monk
					)
					(if (gCast contains: (ScriptID 601 10)) ; pole
						((ScriptID 601 10) dispose:) ; pole
					)
					(gAddToPics eachElementDo: #dispose release:)
					(gFeatures release:)
					(ClearFlag 14)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(if (== local1 1)
						(gCurRoom drawPic: 600 16395)
						(localproc_3 1)
					else
						(gCurRoom style: 11 drawPic: 600)
						(localproc_3 0)
					)
					(localproc_0)
					(localproc_2)
					(if (== gDay 13)
						(proc601_11 (+ local1 2))
					)
					(gEgo posn: (+ (gEgo x:) 320) (gEgo y:))
					(= local3 (proc601_5 (+ local1 2)))
					(= ticks 30)
				)
			)
			(2
				(gEgo setMotion: PolyPath 290 (gEgo y:) self)
			)
			(3
				(if local3
					(Converse 1 @local247 11 0 self) ; "I'm not going to wait here all day."
				else
					(self cue:)
				)
			)
			(4
				(= local3 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance rescueOfFulk of Script
	(properties)

	(method (doit)
		(if (== local2 1)
			((ScriptID 601 1) ; rgnBoat
				x: (- (gEgo x:) 68)
				y: (- (gEgo y:) 25)
				setPri: (- (gEgo priority:) 1)
			)
			(fulk x: (- (gEgo x:) 26) y: (gEgo y:))
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 601 1) ; rgnBoat
					setLoop: 2
					setCel: 2
					posn: (- (gEgo x:) 68) (- (gEgo y:) 25)
					ignoreActors: 1
					init:
				)
				(fulk
					posn: (- (gEgo x:) 26) (gEgo y:)
					ignoreActors: 1
					init:
				)
				(gEgo setMotion: MoveTo 138 155 self)
			)
			(1
				(= local2 0)
				(fulk cycleSpeed: 12 setCycle: CT 6 1 self)
				(gEgo setCel: 5)
				((ScriptID 601 1) setPri: -1) ; rgnBoat
			)
			(2
				(fulk
					setLoop: 5
					cycleSpeed: 6
					setMotion: MoveTo (fulk x:) (+ (fulk y:) 16)
					setCycle: End self
				)
			)
			(3
				(fulk
					view: 671
					setLoop: -1
					setPri: -1
					setStep: 2 2
					setCycle: StopWalk 672
					setMotion: MoveTo 80 184 self
				)
			)
			(4
				(fulk setHeading: 90 self)
			)
			(5
				(= ticks 12)
			)
			(6
				(NormalEgo)
				(gGame setSpeed: global141)
				(gEgo setMotion: MoveTo (gEgo x:) 170 self)
			)
			(7
				(= temp0 (if (> gHowFast 0) 2 else 3))
				((ScriptID 601 1) ; rgnBoat
					setStep: temp0 temp0
					setMotion:
						MoveTo
						(+ ((ScriptID 601 1) x:) 220) ; rgnBoat
						(- ((ScriptID 601 1) y:) 50) ; rgnBoat
				)
				(Face gEgo fulk self)
			)
			(8
				(= ticks 12)
			)
			(9
				(Converse 1 @local205 @local251 0 self) ; "My poor words of gratitude could never express what is in my heart."
			)
			(10
				(gEgo setMotion: MoveTo (+ (fulk x:) 20) (fulk y:) self)
			)
			(11
				(Face gEgo fulk)
				(= ticks 18)
			)
			(12
				(fulk
					view: 674
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(13
				(fulk view: 671)
				(= ticks 24)
			)
			(14
				(Converse 1 @local212 @local251 0 self) ; "Now open the end of the wooden cylinder and tap gently into your hand what is hidden within."
			)
			(15
				(Converse 1 @local216 8 0 self) ; "By the Virgin! A magnificent ring of lapis lazuli set in silver."
			)
			(16
				(Converse 1 @local220 @local251 0 self) ; "No ordinary ring, either. My master -- God save the King! -- saved the life of a magician during the siege of Jerusalem."
			)
			(17
				(SetScore 25)
				(if (gEgo has: 10) ; fireRing
					(Converse 2 @local230 8 0 @local251 0 self) ; "Then rest easy, my friend, for I have your ring's mate in my possession already!"
					(if (gEgo has: 16) ; fulkScroll
						(gEgo put: 16) ; fulkScroll
					)
				else
					(Converse 2 @local237 8 0 @local251 0 self) ; "I give you my word to put my wits to it. If it can be done, I will find a way."
					(gEgo get: 16) ; fulkScroll
				)
				(gEgo get: 18) ; waterRing
			)
			(18
				(Converse 2 @local242 8 0 @local251 0 self) ; "Farewell then! I'm off to find Queen Eleanor and serve her until my master -- bless him! -- is returned to us."
			)
			(19
				(fulk
					cycleSpeed: 6
					xStep: 3
					yStep: 2
					setCycle: StopWalk 672
					setMotion: MoveTo -30 (fulk y:) self
				)
			)
			(20
				(gEgo setMotion: MoveTo 150 240 self)
			)
			(21
				(HandsOn)
				((ScriptID 601 1) setCycle: 0 setMotion: 0) ; rgnBoat
				(gCurRoom newRoom: 160)
			)
		)
	)
)

