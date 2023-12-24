;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use PPath)
(use Feature)
(use LoadMany)
(use Window)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm140 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 3]
	local8
	local9
	local10
	local11
	local12
	[local13 15]
	[local28 15]
	[local43 15]
	[local58 75]
	[local133 75]
	[local208 75]
	[local283 4]
	local287
	local288
	local289 = 1
	[local290 4] = [85 161 85 161]
	[local294 4] = [54 102 102 54]
	[local298 3] = [8 3 0]
	local301 = -1
	[local302 107] = [215 189 213 180 214 169 224 162 239 159 252 159 267 163 282 128 269 131 253 133 241 130 233 125 229 119 229 113 231 108 233 103 240 98 251 97 265 101 276 106 282 111 290 111 299 107 301 96 301 86 298 80 292 74 284 70 276 70 269 72 260 77 255 82 245 85 231 80 223 70 223 64 226 56 234 48 240 43 247 42 254 47 261 53 270 60 285 64 293 69 306 67 311 60 309 52 301 46 246 102 241 102 237 105 236 111 -32768]
	[local409 89] = [319 189 298 181 274 178 260 167 249 162 242 139 249 122 240 115 238 107 242 118 252 128 264 134 276 134 289 124 284 113 275 105 259 95 248 92 237 92 230 94 223 105 218 113 206 121 190 125 178 121 166 107 165 105 169 88 260 100 252 94 254 88 264 81 272 81 281 82 288 86 295 90 302 100 299 111 286 114 272 104 263 102 251 104 246 110 236 111 -32768]
	[local498 79] = [319 78 311 79 306 76 300 77 293 89 288 107 282 118 277 127 269 136 254 144 232 151 216 150 198 153 181 150 181 156 163 155 146 147 141 135 145 121 153 111 165 102 180 97 191 91 204 91 218 92 231 92 240 98 254 113 271 120 284 120 291 109 291 100 281 93 274 90 264 90 254 95 246 99 240 101 236 111 -32768]
	[local577 15] = [277 170 209 184 163 176 157 164 127 161 62 183 20 168 -32768]
	[local592 9] = [24 169 137 186 256 175 277 169 -32768]
	[local601 15] = [0 13 247 13 247 13 247 13 247 13 247 47 213 81 179]
	[local616 15] = [0 33 33 61 61 89 89 117 117 152 152 152 152 152 152]
	[local631 12] = [77 80 87 70 33 84 82 86 74 69 84 0]
	local643
	[local644 48] = [15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15]
	[local692 48]
)

(procedure (localproc_0 param1)
	(switch param1
		(1
			(if (< local1 40)
				(+= local1 8)
				(return 1)
			else
				(return 0)
			)
		)
		(2
			(if (mod local1 8)
				(-= local1 1)
				(return 1)
			else
				(return 0)
			)
		)
		(3
			(if (> local1 7)
				(-= local1 8)
				(return 1)
			else
				(return 0)
			)
		)
		(4
			(if (!= (mod local1 8) 7)
				(+= local1 1)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(procedure (localproc_1 &tmp [temp0 5] temp5 temp6 temp7)
	(= temp5 0)
	(= temp6 (& [local644 local1] $000f))
	(if (or (== (= temp7 (localproc_3 1)) 15) (== temp7 temp6))
		(= [temp0 (++ temp5)] 1)
	)
	(if (or (== (= temp7 (localproc_3 2)) 15) (== temp7 temp6))
		(= [temp0 (++ temp5)] 2)
	)
	(if (or (== (= temp7 (localproc_3 3)) 15) (== temp7 temp6))
		(= [temp0 (++ temp5)] 3)
	)
	(if (or (== (= temp7 (localproc_3 4)) 15) (== temp7 temp6))
		(= [temp0 (++ temp5)] 4)
	)
	(if temp5
		(localproc_0 [temp0 (Random 1 temp5)])
		(return temp5)
	else
		(return 0)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 [temp3 30])
	(for ((= local1 0)) (< local1 48) ((++ local1))
		(= temp1 [local644 local1])
		(= temp0 0)
		(if (== (localproc_3 1) temp1)
			(+= temp0 1)
		)
		(if (== (localproc_3 2) temp1)
			(+= temp0 2)
		)
		(if (== (localproc_3 3) temp1)
			(+= temp0 4)
		)
		(if (== (localproc_3 4) temp1)
			(+= temp0 8)
		)
		(|= [local644 local1] (* temp0 16))
		(= temp2 (+ (* temp1 5) [local13 temp1]))
		(= [local58 temp2] (mod local1 8))
		(= [local133 temp2] (/ local1 8))
		(= [local208 temp2] temp0)
		(++ [local13 temp1])
	)
)

(procedure (localproc_3 param1)
	(switch param1
		(1
			(if (< local1 40)
				(return (& [local644 (+ local1 8)] $000f))
			else
				(return 0)
			)
		)
		(2
			(if (mod local1 8)
				(return (& [local644 (- local1 1)] $000f))
			else
				(return 0)
			)
		)
		(3
			(if (> local1 7)
				(return (& [local644 (- local1 8)] $000f))
			else
				(return 0)
			)
		)
		(4
			(if (!= (mod local1 8) 7)
				(return (& [local644 (+ local1 1)] $000f))
			else
				(return 0)
			)
		)
	)
)

(procedure (localproc_4 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp0 0)
	(= temp1 100)
	(= temp2 0)
	(= temp3 0)
	(= temp4 0)
	(= temp5 0)
	(if (and (= temp2 (localproc_3 3)) (!= temp2 15))
		(= temp4 (polyominoid at: temp2))
		(if (< (= temp0 (temp4 size:)) temp1)
			(= temp1 temp0)
			(= temp5 temp4)
			(= temp3 temp2)
		)
	)
	(if (and (= temp2 (localproc_3 2)) (!= temp2 15))
		(= temp4 (polyominoid at: temp2))
		(if (< (= temp0 (temp4 size:)) temp1)
			(= temp1 temp0)
			(= temp5 temp4)
			(= temp3 temp2)
		)
	)
	(if (and (= temp2 (localproc_3 4)) (!= temp2 15))
		(= temp4 (polyominoid at: temp2))
		(if (< (= temp0 (temp4 size:)) temp1)
			(= temp1 temp0)
			(= temp5 temp4)
			(= temp3 temp2)
		)
	)
	(if (and (= temp2 (localproc_3 1)) (!= temp2 15))
		(= temp4 (polyominoid at: temp2))
		(if (< (= temp0 (temp4 size:)) temp1)
			(= temp1 temp0)
			(= temp5 temp4)
			(= temp3 temp2)
		)
	)
	(if (< temp1 5)
		(= [local644 local1] temp3)
		(temp5 size: (++ temp1))
		(++ local2)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_5 &tmp temp0)
	(= local1 0)
	(= local2 0)
	(= local4 0)
	(= local4 0)
	(= local8 0)
	(= local9 0)
	(= local10 0)
	(= local11 0)
	(= local12 0)
	(= local3 0)
	(= local287 0)
	(= local288 0)
	(= local643 0)
	(for ((= temp0 0)) (< temp0 15) ((++ temp0))
		(= [local13 temp0] 0)
		(= [local28 temp0] 0)
		(= [local43 temp0] 0)
		(= [local644 temp0] 15)
		(= [local58 temp0] 0)
		(= [local133 temp0] 0)
		(= [local208 temp0] 0)
	)
	(for ((= temp0 15)) (< temp0 48) ((++ temp0))
		(= [local644 temp0] 15)
		(= [local58 temp0] 0)
		(= [local133 temp0] 0)
		(= [local208 temp0] 0)
	)
	(for ((= temp0 48)) (< temp0 75) ((++ temp0))
		(= [local58 temp0] 0)
		(= [local133 temp0] 0)
		(= [local208 temp0] 0)
	)
	(polyominoid dispose:)
)

(procedure (localproc_6 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp6 local10)
	(= local10 (* (/ local11 16) -19))
	(= local11 (* (/ temp6 19) 16))
	(= temp3 (* (= temp2 (((polyominoid puzzleCast:) at: 0) pieceNum:)) 5))
	(= temp4 ((polyominoid puzzleCast:) size:))
	(localproc_7 temp2 temp4 3)
	(for ((= temp5 0)) (< temp5 temp4) ((++ temp5))
		(= temp0 ((polyominoid puzzleCast:) at: temp5))
		(temp0 yOffset: (temp0 xOffset:) xOffset: (* (temp0 yOffset:) -1))
		(= temp1 (<< (temp0 cel:) $0001))
		(temp0 cel: (| (& $000f temp1) (>> (& $0010 temp1) $0004)))
		(= [local58 temp3] (temp0 xOffset:))
		(= [local133 temp3] (temp0 yOffset:))
		(= [local208 temp3] (temp0 cel:))
		(++ temp3)
	)
	(localproc_12 temp2)
	(localproc_7 temp2 temp4 1)
)

(procedure (localproc_7 param1 param2 param3 &tmp temp0 temp1 temp2)
	(for ((= temp2 0)) (< temp2 param2) ((++ temp2))
		(= temp0 [local58 (+ (* param1 5) temp2)])
		(= temp1 [local133 (+ (* param1 5) temp2)])
		(DrawCel
			140
			3
			param3
			(+ [local601 param1] (* temp0 5))
			(+ [local616 param1] (* temp1 4))
			-1
		)
	)
)

(procedure (localproc_8 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp2 -1)
	(= temp3 0)
	(for ((= temp1 0)) (< temp1 6) ((++ temp1))
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(if (== (& [local644 (++ temp2)] $000f) param1)
				(DrawCel
					140
					1
					(/ [local644 temp2] 16)
					(+ 55 (* temp0 19))
					(+ 38 (* temp1 16))
					-1
				)
				(if (== (++ temp3) param2)
					(if (== (+= local2 param2) 48)
						(polyominoid setScript: solveSound)
					)
					(return)
				)
			)
		)
	)
)

(procedure (localproc_9 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp2 -1)
	(= temp3 0)
	(for ((= temp1 0)) (< temp1 6) ((++ temp1))
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(if (== (& [local644 (++ temp2)] $000f) param1)
				(DrawCel 140 1 0 (+ 55 (* temp0 19)) (+ 38 (* temp1 16)) -1)
				(= [local644 temp2] 15)
				(if (== (++ temp3) param2)
					(-= local2 param2)
					(return)
				)
			)
		)
	)
)

(procedure (localproc_10 param1 param2 &tmp temp0 temp1 temp2)
	(= temp2 -1)
	(for ((= temp1 0)) (< temp1 6) ((++ temp1))
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(if (!= [local644 (++ temp2)] 15)
				(DrawCel
					140
					1
					(/ [local644 temp2] 16)
					(+ param1 (* temp0 19))
					(+ param2 (* temp1 16))
					-1
				)
			)
		)
	)
)

(procedure (localproc_11 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
	(= temp5 0)
	(for ((= temp9 1)) (<= temp9 local4) ((++ temp9))
		(= temp0 [local58 (= temp4 (+= temp5 5))])
		(= temp1 [local58 temp4])
		(= temp2 [local133 temp4])
		(= temp3 [local133 temp4])
		(for ((= temp8 0)) (< temp8 [local13 temp9]) ((++ temp8))
			(if (< [local58 temp4] temp0)
				(= temp0 [local58 temp4])
			)
			(if (> [local58 temp4] temp1)
				(= temp1 [local58 temp4])
			)
			(if (< [local133 temp4] temp2)
				(= temp2 [local133 temp4])
			)
			(if (> [local133 temp4] temp3)
				(= temp3 [local133 temp4])
			)
			(++ temp4)
		)
		(= temp6 (/ (+ temp0 temp1) 2))
		(= temp7 (/ (+ temp2 temp3) 2))
		(+= temp6 (mod (+ temp0 temp1) 2))
		(+= temp7 (mod (+ temp2 temp3) 2))
		(= temp4 temp5)
		(for ((= temp8 0)) (< temp8 [local13 temp9]) ((++ temp8))
			(-= [local58 temp4] temp6)
			(-= [local133 temp4] temp7)
			(++ temp4)
		)
	)
)

(procedure (localproc_12 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp0 (- [local13 param1] 1))
	(= temp5 (* param1 5))
	(= temp1 1)
	(while temp1
		(= temp1 0)
		(for ((= temp6 temp5)) (< temp6 (+ temp5 temp0)) ((++ temp6))
			(if
				(or
					(> [local133 temp6] [local133 (+ temp6 1)])
					(and
						(< [local58 temp6] [local58 (+ temp6 1)])
						(== [local133 temp6] [local133 (+ temp6 1)])
					)
				)
				(= temp2 [local58 temp6])
				(= temp3 [local133 temp6])
				(= temp4 [local208 temp6])
				(= [local58 temp6] [local58 (+ temp6 1)])
				(= [local133 temp6] [local133 (+ temp6 1)])
				(= [local208 temp6] [local208 (+ temp6 1)])
				(= [local58 (+ temp6 1)] temp2)
				(= [local133 (+ temp6 1)] temp3)
				(= [local208 (+ temp6 1)] temp4)
				(= temp1 1)
			)
		)
	)
)

(procedure (localproc_13 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp1 0)
	(= temp0 [local13 param1])
	(for
		((= temp3 (= temp2 (* param1 5))))
		(< temp3 (+ temp2 temp0))
		((++ temp3))
		
		(+= temp1 (* [local58 temp3] 19))
	)
	(= local10 (= temp1 (/ (*= temp1 2) temp0)))
)

(procedure (localproc_14 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp1 0)
	(= temp0 [local13 param1])
	(for
		((= temp3 (= temp2 (* param1 5))))
		(< temp3 (+ temp2 temp0))
		((++ temp3))
		
		(+= temp1 (* [local133 temp3] 16))
	)
	(= local11 (= temp1 (/ (*= temp1 2) temp0)))
)

(procedure (localproc_15)
	(= local8 local10)
	(= local9 local11)
	(+= local8 19)
	(+= local9 16)
	(/= local8 2)
	(/= local9 2)
)

(procedure (localproc_16 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(for ((= temp4 0)) param1 ((|= temp4 (<< $0001 temp3)))
		(-- param1)
		(while (& $0001 (>> local287 (= temp3 (Random 1 local4))))
		)
		(|= local287 (<< $0001 temp3))
	)
	(= temp2 -1)
	(for ((= temp1 0)) (< temp1 6) ((++ temp1))
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(if (& $0001 (>> temp4 (& [local692 (++ temp2)] $000f)))
				(gCSoundFX number: 145 setLoop: 1 play: 127)
				(DrawCel
					140
					2
					(/ [local692 temp2] 16)
					(+ 36 (* temp0 6))
					(+ 2 (* temp1 5))
					-1
				)
			)
		)
	)
)

(procedure (localproc_17 &tmp temp0 temp1 temp2 temp3)
	(localproc_18 0 34 35 87 53 19 -1 1)
	(= temp2 -1)
	(for ((= temp1 0)) (< temp1 6) ((++ temp1))
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(if (& $0001 (>> local287 (& [local692 (++ temp2)] $000f)))
				(DrawCel
					140
					2
					(/ [local692 temp2] 16)
					(+ 36 (* temp0 6))
					(+ 2 (* temp1 5))
					-1
				)
			)
		)
	)
)

(procedure (localproc_18 param1 param2 param3 param4 param5 param6 param7 param8)
	(Graph grFILL_BOX param1 param2 param3 param4 param8 param5 param7)
	(Graph grDRAW_LINE param1 param2 param1 param4 22 -1 -1)
	(Graph grDRAW_LINE (+ param1 1) param2 (+ param1 1) param4 18 -1 -1)
	(Graph grDRAW_LINE (+ param1 2) param2 (+ param1 2) param4 17 -1 -1)
	(Graph grDRAW_LINE (+ param1 1) param2 param3 param2 21 -1 -1)
	(Graph grDRAW_LINE (+ param1 2) (+ param2 1) (- param3 1) (+ param2 1) 18 -1 -1)
	(Graph grDRAW_LINE (+ param1 3) (+ param2 2) (- param3 2) (+ param2 2) 26 -1 -1)
	(Graph grDRAW_LINE param1 param4 param3 param4 18 -1 -1)
	(Graph grDRAW_LINE (+ param1 1) (- param4 1) (- param3 1) (- param4 1) 22 -1 -1)
	(Graph grDRAW_LINE (+ param1 2) (- param4 2) (- param3 2) (- param4 2) 20 -1 -1)
	(Graph grDRAW_LINE param3 param2 param3 (- param4 1) 17 -1 -1)
	(Graph grDRAW_LINE (- param3 1) (+ param2 1) (- param3 1) (- param4 2) 22 -1 -1)
	(Graph grDRAW_LINE (- param3 2) (+ param2 2) (- param3 2) (- param4 3) 21 -1 -1)
	(Graph grUPDATE_BOX (- param1 5) (- param2 5) (+ param3 5) (+ param4 5) 1)
)

(procedure (localproc_19 param1 &tmp temp0 temp1)
	(if (or (param1 nsBottom:) (param1 nsRight:))
		(= temp0 (/ (+ (param1 nsLeft:) (param1 nsRight:)) 2))
		(= temp1 (/ (+ (param1 nsTop:) (param1 nsBottom:)) 2))
		(gGame setCursor: gTheCursor 1 temp0 temp1)
	else
		(gGame setCursor: gTheCursor 1 (param1 nsLeft:) (param1 nsTop:))
	)
)

(instance rm140 of Rm
	(properties
		noun 10
		picture 140
		north 160
		south 130
	)

	(method (init &tmp temp0)
		(LoadMany rsVIEW 140 144)
		(LoadMany rsSOUND 112 113 114 144 208 258 259 261)
		(= local12 gDifficulty)
		(sky init:)
		(palmTrees init:)
		(volcano init:)
		(treeCoconuts init:)
		(groundCoconuts init:)
		(caveEntrance init:)
		(dude init:)
		(beach init:)
		(beachBlocks init:)
		(bunny init:)
		(conchShell init:)
		(bush init:)
		(cliff init:)
		(smoke init:)
		(gCMusic number: 5 setLoop: -1 play:)
		(gKeyDownHandler add: polyKeyboard)
		(rm140 setScript: tikiMotion)
		(super init: &rest)
		(= local0 1)
		(if (not (IsFlag 34))
			(PicNotValid 1)
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(DrawCel 140 0 0 [local290 temp0] [local294 temp0] -1)
			)
			(= local0 0)
			(PicNotValid 0)
		)
		(Animate (gCast elements:) 0)
		(if (not (IsFlag 34))
			(gMessager say: 6 9 0 1 0 20) ; "You will find my battery deep, deep within the interior of my island. However, to discourage unwanted trespassers, who have nothing better to do than steal my ideas and inventions, I have installed security puzzles throughout my island. Therefore, just follow the trail of my security puzzles and you will find my battery. If you have any problems solving them, just give me a call."
		)
	)

	(method (doit &tmp temp0)
		(if (and (GameIsRestarting) (not (IsFlag 34)))
			(PicNotValid 1)
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(DrawCel 140 0 0 [local290 temp0] [local294 temp0] -1)
			)
			(localproc_10 83 52)
			(PicNotValid 0)
			(Graph grUPDATE_BOX 1 1 190 310 1)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(polyominoid dispose:)
		(DisposeScript 50)
		(gKeyDownHandler delete: polyKeyboard)
		(super dispose: &rest)
	)
)

(instance facadeBlock of Actor
	(properties
		noun 9
		view 140
		priority 1
		signal 18448
	)
)

(instance dude of Prop
	(properties
		x 260
		y 99
		noun 3
		onMeCheck 32
		view 144
		signal 18448
	)

	(method (init)
		(super init: &rest)
		(self hide:)
	)

	(method (doVerb theVerb)
		(if (not script)
			(switch theVerb
				(4
					(self setScript: flyEat)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (isNotHidden)
		(return 1)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)
)

(instance bunny of Prop
	(properties
		x 31
		y 89
		noun 2
		onMeCheck 16
		view 144
		loop 1
		signal 18448
		cycleSpeed 12
	)

	(method (isNotHidden)
		(return 1)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)
)

(instance smoke of Prop
	(properties
		x 171
		y 1
		noun 5
		view 144
		loop 2
		signal 22544
	)

	(method (init)
		(self startUpd: setCycle: Fwd self)
		(super init: &rest)
	)
)

(instance spider of Actor
	(properties
		noun 22
		view 144
		loop 6
		priority 10
		signal 18448
		cycleSpeed 1
		illegalBits 0
		moveSpeed 2
	)

	(method (cue)
		(self dispose:)
	)
)

(instance fly of Actor
	(properties
		noun 20
		view 144
		loop 3
		priority 15
		signal 18448
		cycleSpeed 1
		moveSpeed 2
	)
)

(instance sky of Feature
	(properties
		noun 5
		onMeCheck 16384
	)
)

(instance palmTrees of Feature
	(properties
		noun 8
		onMeCheck 256
	)
)

(instance volcano of Feature
	(properties
		noun 14
		onMeCheck 1024
	)
)

(instance treeCoconuts of Feature
	(properties
		noun 18
		onMeCheck 128
	)
)

(instance groundCoconuts of Feature
	(properties
		noun 17
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) local289 (not (spider cycler:)))
			(spider
				cel: 0
				x: [local577 0]
				y: [local577 1]
				init:
				setCycle: Fwd
				setMotion: PPath @local577 spider
			)
			(= local289 0)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance caveEntrance of Feature
	(properties
		noun 9
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(if (IsFlag 34)
			(= noun 16)
			(if (== theVerb 4)
				(gCSoundFX stop:)
				(rm140 setScript: roomExit)
			else
				(super doVerb: theVerb &rest)
			)
		else
			(if (== theVerb 4)
				(gCSoundFX number: 259 setLoop: 1 play: 127 flySound)
			)
			(super doVerb: theVerb &rest)
		)
	)
)

(instance beach of Feature
	(properties
		noun 6
		onMeCheck 2048
	)
)

(instance beachBlocks of Feature
	(properties
		noun 4
		onMeCheck 4
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4
				(cond
					((< local301 0)
						(gGame setCursor: 997 1)
						(polyominoid init:)
						(= local301 gDifficulty)
					)
					((!= local301 gDifficulty)
						(gGame setCursor: 997 1)
						(polyominoid dispose: init:)
						(= local301 gDifficulty)
					)
				)
				(smoke stopUpd:)
				(Animate (gCast elements:) 0)
				(gCSoundFX stop:)
				(if (fly cycler:)
					(fly dispose:)
					(flyEat dispose:)
				)
				(tikiMotion dispose:)
				(bunny hide:)
				(dude hide:)
				(switch (polyominoid show:)
					(1
						(polyominoid dispose:)
						(= local301 -1)
						(if (not local0)
							(= local0 1)
							(localproc_10 83 52)
							(rm140 setScript: openDoor)
						)
					)
					(0
						(rm140 setScript: tikiMotion)
						(if (not (IsFlag 34))
							(for ((= temp0 0)) (< temp0 4) ((++ temp0))
								(DrawCel
									140
									0
									0
									[local290 temp0]
									[local294 temp0]
									-1
								)
							)
							(Graph grUPDATE_BOX 1 1 190 310 1)
							(localproc_10 83 52)
						)
					)
				)
				(smoke startUpd:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance conchShell of Feature
	(properties
		noun 12
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(gCSoundFX number: 258 setLoop: 0 play: 127 flySound)
			(if (and (== theVerb 4) (not local289) (not (spider cycler:)))
				(spider
					cel: 0
					x: [local592 0]
					y: [local592 1]
					init:
					setCycle: Fwd
					setMotion: PPath @local592 spider
				)
				(= local289 1)
			)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance polyKeyboard of EventHandler
	(properties)

	(method (handleEvent event)
		(if (== (+ (event message:) JOY_UP) [local631 local643])
			(++ local643)
		else
			(= local643 0)
		)
		(if (not [local631 local643])
			(gCSoundFX number: 119 setLoop: 1 play: 127)
			(= global115 969)
			(= local643 0)
		)
	)
)

(instance bush of Feature
	(properties
		noun 15
		onMeCheck 4096
	)
)

(instance cliff of Feature
	(properties
		noun 7
		onMeCheck 8192
	)
)

(instance tikiMotion of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(= state newState)
		(cond
			((not state)
				(= ticks (Random 600 1200))
			)
			((== state 1)
				(if (Random 0 1)
					(= state 3)
				)
				(= cycles 1)
			)
			((== state 2)
				(= temp0 1)
				(if (Random 0 1)
					(= temp0 5)
				)
				(bunny show: loop: temp0 cel: 0 setCycle: End self)
			)
			((== state 3)
				(bunny hide:)
				(= state -1)
				(= cycles 1)
			)
			((== state 4)
				(= register (Random 10 12))
				(= cycles 1)
			)
			((< state register)
				(dude cel: (Random 0 2) show:)
				(= ticks 40)
			)
			(else
				(dude hide:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance flyEat of Script
	(properties)

	(method (doit)
		(if (== state 0)
			(if (< (fly x:) 260)
				(dude cel: 0)
			)
			(if (> (fly x:) 285)
				(dude cel: 2)
			)
			(if (and (> (fly x:) 260) (< (fly x:) 285))
				(dude cel: 1)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tikiMotion dispose:)
				(bunny hide:)
				(dude hide:)
				(gCSoundFX number: 114 setLoop: -1 play: 127)
				(switch (Random 1 3)
					(1
						(fly
							cel: 0
							x: [local302 0]
							y: [local302 1]
							init:
							setCycle: Fwd
							setMotion: PPath @local302 self
						)
					)
					(2
						(fly
							cel: 0
							x: [local409 0]
							y: [local409 1]
							init:
							setCycle: Fwd
							setMotion: PPath @local409 self
						)
					)
					(3
						(fly
							cel: 0
							x: [local498 0]
							y: [local498 1]
							init:
							setCycle: Fwd
							setMotion: PPath @local498 self
						)
					)
				)
				(dude show:)
				(self doit:)
			)
			(1
				(dude show: loop: 4 cel: 0 x: 233 y: 99 setCycle: CT 3 1 self)
			)
			(2
				(fly dispose:)
				(dude setCycle: End self)
				(gCSoundFX number: 261 setLoop: 0 play: 127)
			)
			(3
				(= ticks 60)
			)
			(4
				(rm140 setScript: tikiMotion)
				(dude loop: 0 x: 260 y: 99 hide:)
				(self dispose:)
			)
		)
	)
)

(instance openDoor of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					(= [local283 temp0]
						((facadeBlock new:)
							cel: 1
							x: [local290 temp0]
							y: [local294 temp0]
							init:
							yourself:
						)
					)
				)
				(DrawPic 140 9 1)
				(Animate (gCast elements:) 0)
				(= cycles 1)
			)
			(1
				(gCSoundFX number: 113 setLoop: -1 play: 127)
				(for ((= temp0 0)) (< temp0 3) ((++ temp0))
					([local283 temp0] setMotion: MoveTo [local290 temp0] 150)
				)
				([local283 3] setMotion: MoveTo [local290 3] 150 self)
			)
			(2
				(gCSoundFX number: 149 loop: 1 play: self)
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					([local283 temp0] dispose:)
				)
				(rm140 setScript: tikiMotion)
				(self dispose:)
			)
		)
	)
)

(instance roomExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: 997 1)
				(gCMusic fade: 0 10 10 0 self)
			)
			(1
				(gCurRoom newRoom: (rm140 north:))
				(self dispose:)
			)
		)
	)
)

(instance flySound of HandsOffScript
	(properties)

	(method (cue)
		(if (fly cycler:)
			(gCSoundFX number: 114 setLoop: -1 play: 127)
		)
	)
)

(class block of Prop
	(properties
		view 140
		loop 1
		priority 15
		signal 19
		xOffset 0
		yOffset 0
		xComOffset 0
		yComOffset 0
		pieceNum 0
		blockNum 0
	)

	(method (doit)
		(self
			posn:
				(+ 28 (polyominoid eventX:) xComOffset)
				(+ 14 (polyominoid eventY:) yComOffset)
		)
		(super doit: &rest)
	)

	(method (setUp)
		(= xComOffset (- (* xOffset 19) local8))
		(= yComOffset (- (* yOffset 16) local9))
	)
)

(instance polyWin of SysWindow
	(properties
		top 14
		left 28
		bottom 185
		right 296
		back 45
		priority -1
	)

	(method (open)
		(super open: &rest)
		(DrawCel 140 4 0 34 24 -1)
		(Graph grFILL_BOX 40 57 136 209 1 73 -1 -1)
		(Graph grUPDATE_BOX 38 55 138 211 1)
	)
)

(instance polyominoid of PuzzleBar
	(properties
		solvedFlag 34
		noun 1
		personalID 12
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= window polyWin)
		(localproc_5)
		(self add: gridIcon)
		(while (!= local2 48)
			(self add: (= temp0 (piece new:)))
			(= temp1 (temp0 number: (++ local4) init:))
			(if (and (== local4 14) (< local2 48))
				(= temp1 0)
			)
			(if (not temp1)
				(localproc_5)
				(self add: gridIcon)
			)
		)
		(if (== (temp0 size:) 0)
			(self delete: temp0)
			(temp0 dispose:)
			(-- local4)
		)
		(self add: rotateIcon)
		(self puzzleCast: (Set new:))
		(localproc_2)
		(localproc_11)
		(for ((= temp2 0)) (< temp2 48) ((++ temp2))
			(= [local692 temp2] [local644 temp2])
			(= [local644 temp2] 15)
		)
		(= local2 0)
		(for ((= temp2 0)) (< temp2 local4) ((++ temp2))
			(= temp5 (Random 0 3))
			(for ((= temp3 0)) (< temp3 temp5) ((++ temp3))
				(for ((= temp4 0)) (< temp4 [local13 temp2]) ((++ temp4))
					(= temp6 [local133 (= temp8 (+ (* temp2 5) temp4))])
					(= [local133 temp8] [local58 temp8])
					(= [local58 temp8] (* temp6 -1))
					(= temp7 (<< [local208 temp8] $0001))
					(= [local208 temp8]
						(| (& $000f temp7) (>> (& $0010 temp7) $0004))
					)
				)
			)
		)
		(super init: &rest)
		(self add: backgroundIcon)
	)

	(method (doit)
		(gGame setCursor: 900 1)
		(if local3
			(localproc_17)
		)
		(super doit: &rest)
	)

	(method (show)
		(if ((polyominoid puzzleCast:) size:)
			(gGame setCursor: 996 1)
		)
		(super show: &rest)
	)

	(method (highlight)
		(if (and (< (polyominoid eventY:) 21) (== gTheCursor 996))
			((polyominoid puzzleCast:) eachElementDo: #hide)
			(polyominoid animateOnce:)
			(gGame setCursor: 900 1)
		)
		(if
			(and
				(== gTheCursor 900)
				(>= (polyominoid eventY:) 21)
				((polyominoid puzzleCast:) size:)
			)
			(gGame setCursor: 996 1)
			((polyominoid puzzleCast:) eachElementDo: #show)
			(polyominoid animateOnce:)
		)
		(super highlight: &rest)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14)
		(cond
			((== (event type:) evKEYBOARD)
				(if
					(or
						(== (event message:) KEY_r)
						(== (event message:) KEY_R)
						(== (event message:) KEY_SPACE)
					)
					(rotateIcon select:)
				)
			)
			((& (event type:) evMOUSEBUTTON)
				(if (== (event modifiers:) emSHIFT)
					(rotateIcon select:)
					(event type: evNULL)
				)
			)
			((& (event type:) $0040) ; direction
				(= temp6 0)
				(= temp2 (polyominoid eventX:))
				(= temp3 (polyominoid eventY:))
				(-= temp2 55)
				(-= temp3 38)
				(-= temp2 local8)
				(-= temp3 local9)
				(/= temp2 19)
				(/= temp3 16)
				(= global116
					(= temp5
						(if
							(and
								highlightedIcon
								(!= highlightedIcon backgroundIcon)
							)
							(self indexOf: highlightedIcon)
						else
							0
						)
					)
				)
				(switch (event message:)
					(JOY_UP
						(cond
							((not temp5)
								(if temp3
									(-- temp3)
								else
									(= temp5 (- size 3))
								)
							)
							((== temp5 1)
								(= temp5 (- size 4))
							)
							((== temp5 2)
								(= temp5 (- size 2))
							)
							((< temp5 11)
								(-= temp5 2)
							)
							((< temp5 (- size 4))
								(= temp6 1)
								(= temp5 0)
								(= temp2 3)
								(= temp3 5)
							)
							((== temp5 (- size 4))
								(= temp5 9)
							)
							((== temp5 (- size 3))
								(= temp5 (- size 5))
							)
							((== temp5 (- size 2))
								(= temp5 10)
							)
						)
					)
					(JOY_DOWN
						(cond
							((not temp5)
								(if (< temp3 5)
									(++ temp3)
								else
									(= temp5 (- size 5))
								)
							)
							((< temp5 9)
								(+= temp5 2)
							)
							((== temp5 9)
								(= temp5 (- size 4))
							)
							((== temp5 10)
								(= temp5 (- size 2))
							)
							((< temp5 (- size 5))
								(= temp5 (- size 3))
							)
							((== temp5 (- size 5))
								(= temp5 (- size 3))
							)
							((== temp5 (- size 4))
								(= temp5 1)
							)
							((== temp5 (- size 3))
								(= temp6 2)
								(= temp5 0)
								(= temp2 3)
								(= temp3 0)
							)
							((== temp5 (- size 2))
								(= temp5 2)
							)
						)
					)
					(JOY_RIGHT
						(cond
							((not temp5)
								(if (< temp2 7)
									(++ temp2)
								else
									(= temp5
										(- (+ 4 temp3) (mod (+ 4 temp3) 2))
									)
								)
							)
							((and (mod temp5 2) (< temp5 8))
								(= temp6 3)
								(= temp5 0)
								(= temp2 0)
								(= temp3 2)
							)
							((and (not (mod temp5 2)) (< temp5 11))
								(-- temp5)
							)
							((and (== (- (- size 5) temp5) 1) (mod temp5 2))
								(++ temp5)
							)
							((and (mod temp5 2) (< temp5 (- size 5)))
								(+= temp5 2)
							)
							((and (not (mod temp5 2)) (< temp5 (- size 5)))
								(-= temp5 2)
							)
							((== temp5 (- size 5))
								(if (mod (- size 5) 2)
									(-- temp5)
								else
									(-= temp5 2)
								)
							)
							((< temp5 (- size 2))
								(++ temp5)
							)
							((== temp5 (- size 2))
								(= temp5 (- size 4))
							)
						)
					)
					(JOY_LEFT
						(cond
							((not temp5)
								(if temp2
									(-- temp2)
								else
									(= temp5 (+ temp3 (- 3 (mod temp3 2))))
								)
							)
							((and (mod temp5 2) (< temp5 10))
								(++ temp5)
							)
							((and (not (mod temp5 2)) (< temp5 9))
								(= temp6 4)
								(= temp5 0)
								(= temp2 7)
								(= temp3 2)
							)
							((== temp5 9)
								(++ temp5)
							)
							((and (mod temp5 2) (< temp5 (- size 5)))
								(-= temp5 2)
							)
							(
								(and
									(== (- (- size 5) temp5) 1)
									(not (mod temp5 2))
								)
								(++ temp5)
							)
							((and (not (mod temp5 2)) (< temp5 (- size 5)))
								(+= temp5 2)
							)
							((== temp5 (- size 5))
								(if (mod (- size 5) 2)
									(-= temp5 2)
								else
									(-- temp5)
								)
							)
							((== temp5 (- size 4))
								(= temp5 (- size 2))
							)
							((< temp5 (- size 1))
								(-- temp5)
							)
						)
					)
				)
				(if temp5
					(= temp4 (self at: temp5))
					(localproc_19 temp4)
				else
					(= temp0 (+ (* temp2 19) 55 local8))
					(= temp1 (+ (* temp3 16) 38 local9))
					(if temp6
						(= temp8 0)
						(= temp9 0)
						(= temp10 0)
						(= temp11 0)
						(for
							((= temp7 0))
							(< temp7 ((polyominoid puzzleCast:) size:))
							((++ temp7))
							
							(= temp14 ((polyominoid puzzleCast:) at: temp7))
							(= temp12 (temp14 xOffset:))
							(cond
								(
									(and
										(< (= temp13 (temp14 yOffset:)) 0)
										(< temp13 temp8)
									)
									(= temp8 temp13)
								)
								((and (> temp13 0) (> temp13 temp9))
									(= temp9 temp13)
								)
								((and (< temp12 0) (< temp12 temp10))
									(= temp10 temp12)
								)
								((and (> temp12 0) (> temp12 temp11))
									(= temp11 temp12)
								)
							)
						)
						(switch temp6
							(1
								(-= temp1 (* temp9 16))
							)
							(2
								(-= temp1 (* temp8 16))
							)
							(3
								(-= temp0 (* temp10 19))
							)
							(4
								(-= temp0 (* temp11 19))
							)
						)
					)
					(gGame setCursor: gTheCursor 1 temp0 temp1)
				)
				(event type: evNULL)
			)
		)
		(if (and puzzleStatus (& (event type:) $0105)) ; evJOYDOWN | evMOUSEKEYBOARD
			(event dispose:)
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (buyClue &tmp temp0 temp1 temp2)
		(if (not (= temp2 (- local4 local3)))
			(gMessager say: 21 1) ; "What?! You want even MORE hints? Ok, here's one for 'ya... "Look for even more exciting games from Team Love Squids"!"
			(return)
		)
		(if (super buyClue:)
			(++ local288)
			(if (not local3)
				(localproc_18 0 34 35 87 53 19 -1 1)
			)
			(if (not (= temp1 (/ local4 (* (+ 3 gDifficulty) local288))))
				(= temp1 1)
			)
			(if (< temp2 temp1)
				(= temp1 temp2)
			)
			(+= local3 temp1)
			(localproc_16 temp1)
		)
	)
)

(class piece of CodeIcon
	(properties
		value 2
		number 0
		size 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= nsLeft (- [local601 number] 10))
		(= nsTop (- [local616 number] 8))
		(= nsRight (+ nsLeft 27))
		(= nsBottom (+ nsTop 22))
		(while temp3 ; UNINIT
			(= temp2 1)
			(= temp3 1)
			(= local1 (= size 0))
			(= temp5 0)
			(= temp4 0)
			(= temp6 0)
			(= temp0 0)
			(= temp7 (+ 3 (> (Random 1 10) [local298 gDifficulty])))
			(while (< (& [local644 local1] $000f) 15)
				(++ local1)
				(if (>= local2 48)
					(return 1)
				)
			)
			(= [local644 local1] number)
			(++ size)
			(while temp2
				(cond
					((= temp6 (localproc_1))
						(if (== [local644 local1] 15)
							(= temp0 0)
							(= [local644 local1] number)
							(if (== (++ size) temp7)
								(= temp2 0)
								(= temp3 0)
							)
						)
						(if (and (== (++ temp0) 20) (> size 2))
							(= temp2 0)
							(= temp3 0)
						)
						(if (== temp6 temp4 1)
							(= [local644 temp5] 15)
							(localproc_4)
							(= temp2 0)
						else
							(= temp4 temp6)
							(= temp5 local1)
						)
					)
					((localproc_4)
						(= temp2 0)
					)
					(else
						(return 0)
					)
				)
			)
		)
		(+= local2 size)
		(return 1)
	)

	(method (show)
		(localproc_12 number)
		(localproc_7 number size value)
	)

	(method (highlight param1 &tmp [temp0 5])
		(cond
			(param1
				(if (== value 2)
					(localproc_7 number size 0)
					(= value 0)
				)
			)
			((not value)
				(localproc_7 number size 2)
				(= value 2)
			)
		)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(= temp3 1)
		(if (== value 1)
			(= temp3 0)
		)
		(if (= temp1 ((polyominoid puzzleCast:) size:))
			(= temp0 (((polyominoid puzzleCast:) at: 0) pieceNum:))
			((polyominoid at: temp0) value: 2)
			((polyominoid puzzleCast:) eachElementDo: #hide)
			(polyominoid animateOnce:)
			(localproc_7 temp0 temp1 2)
			((polyominoid puzzleCast:)
				eachElementDo: #dispose
				eachElementDo: #delete
				release:
			)
			(if (not temp3)
				(polyominoid showCast: 0)
				(gGame setCursor: 900 1)
			)
		)
		(if temp3
			(gCSoundFX number: 144 setLoop: 0 play: 127)
			(localproc_7 number size 1)
			(= value 1)
			(localproc_13 number)
			(localproc_14 number)
			(localproc_15)
			(for ((= temp2 0)) (< temp2 size) ((++ temp2))
				((polyominoid puzzleCast:)
					add:
						((block new:)
							xOffset: [local58 (+ (* number 5) temp2)]
							yOffset: [local133 (+ (* number 5) temp2)]
							cel: [local208 (+ (* number 5) temp2)]
							pieceNum: number
							blockNum: (+ temp2 1)
							setUp:
							yourself:
						)
				)
			)
			(polyominoid showCast: 1)
			(gGame setCursor: 996 1)
		)
	)
)

(instance rotateIcon of CodeIcon
	(properties
		view 140
		loop 5
		cel 3
		nsLeft 120
		nsTop 140
	)

	(method (select)
		(if ((polyominoid puzzleCast:) size:)
			(gCSoundFX number: 208 setLoop: 0 play: 127)
			(localproc_6)
			(localproc_15)
			((polyominoid puzzleCast:) eachElementDo: #setUp)
		else
			(super select: &rest)
		)
	)
)

(instance gridIcon of CodeIcon
	(properties
		nsLeft 55
		nsTop 38
		nsRight 205
		nsBottom 132
	)

	(method (highlight))

	(method (show)
		(if local4
			(localproc_10 55 38)
		)
	)

	(method (select &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(= temp11 1)
		(= temp0 (polyominoid eventX:))
		(= temp1 (polyominoid eventY:))
		(-= temp0 55)
		(-= temp1 38)
		(if (= temp10 ((polyominoid puzzleCast:) size:))
			(+= temp0 5)
			(+= temp1 4)
			(-= temp0 local8)
			(-= temp1 local9)
			(/= temp0 19)
			(/= temp1 16)
			(= temp6 (+ temp0 (* temp1 8)))
			(for ((= temp13 0)) (< temp13 temp10) ((++ temp13))
				(= temp9 ((polyominoid puzzleCast:) at: temp13))
				(= temp2 (temp9 xOffset:))
				(= temp3 (temp9 yOffset:))
				(= temp7 (+ temp2 (* temp3 8)))
				(= temp4 (+ temp0 temp2))
				(= temp5 (+ temp1 temp3))
				(if (and (>= temp4 0) (<= temp4 7) (>= temp5 0) (<= temp5 5))
					(if (!= [local644 (= temp8 (+ temp6 temp7))] 15)
						(= temp11 0)
						(break)
					)
				else
					(= temp11 0)
					(break)
				)
			)
			(if temp11
				(gCSoundFX number: 112 setLoop: 0 play: 127)
				(= [local28 (temp9 pieceNum:)] (+ 55 (* temp0 19) local8))
				(= [local43 (temp9 pieceNum:)] (+ 38 (* temp1 16) local9))
				(for ((= temp13 0)) (< temp13 temp10) ((++ temp13))
					(= temp9 ((polyominoid puzzleCast:) at: temp13))
					(= temp7 (+ (temp9 xOffset:) (* (temp9 yOffset:) 8)))
					(= temp8 (+ temp6 temp7))
					(= [local644 temp8]
						(+ (temp9 pieceNum:) (* (temp9 cel:) 16))
					)
				)
				((polyominoid puzzleCast:) eachElementDo: #hide)
				(polyominoid animateOnce:)
				(localproc_8 (temp9 pieceNum:) temp10)
				((polyominoid puzzleCast:)
					eachElementDo: #dispose
					eachElementDo: #delete
					release:
				)
				(polyominoid showCast: 0)
				(gGame setCursor: 900 1)
			else
				(gCSoundFX number: 136 setLoop: 0 play:)
			)
		else
			(/= temp0 19)
			(/= temp1 16)
			(if
				(!=
					(= temp12
						(& [local644 (= temp6 (+ temp0 (* temp1 8)))] $000f)
					)
					15
				)
				(gCSoundFX number: 144 setLoop: 0 play: 127)
				(= temp10 ((polyominoid at: temp12) size:))
				(localproc_13 temp12)
				(localproc_14 temp12)
				(localproc_15)
				(for ((= temp13 0)) (< temp13 temp10) ((++ temp13))
					((polyominoid puzzleCast:)
						add:
							((block new:)
								xOffset: [local58 (+ (* temp12 5) temp13)]
								yOffset: [local133 (+ (* temp12 5) temp13)]
								cel: [local208 (+ (* temp12 5) temp13)]
								pieceNum: temp12
								blockNum: (+ temp13 1)
								setUp:
								yourself:
							)
					)
				)
				(localproc_9 temp12 temp10)
				(gGame setCursor: 996 1 [local28 temp12] [local43 temp12])
				(polyominoid showCast: 1)
			)
		)
	)
)

(instance backgroundIcon of CodeIcon
	(properties
		nsTop 21
		nsRight 268
		nsBottom 177
	)

	(method (show))

	(method (highlight))

	(method (select &tmp temp0 temp1)
		(if (= temp0 ((polyominoid puzzleCast:) size:))
			(= temp1 (((polyominoid puzzleCast:) at: 0) pieceNum:))
			((polyominoid at: temp1) value: 2)
			((polyominoid puzzleCast:) eachElementDo: #hide)
			(polyominoid animateOnce:)
			(localproc_7 temp1 temp0 2)
			((polyominoid puzzleCast:)
				eachElementDo: #dispose
				eachElementDo: #delete
				release:
			)
			(polyominoid showCast: 0)
			(gGame setCursor: 900 1)
		)
	)
)

(instance solveSound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(polyominoid pHandsOff: 1)
				(gCSoundFX number: 106 setLoop: 1 play: 127 self)
			)
			(1
				(polyominoid pHandsOff: 0)
				(polyominoid solvePuzzle:)
				(self dispose:)
			)
		)
	)
)

