;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 107)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm107 0
)

(local
	local0
)

(instance rm107 of Rm
	(properties
		picture 52
		style 10
	)

	(method (init)
		(gCurRoom setRegions: 210) ; eureka
		(arm init:)
		(super init:)
		(gGame setScript: sGo)
		(gGame setCursor: 996 1)
	)
)

(instance sGo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(gSq5Music2 number: 161 setLoop: -1 play:)
				(shape12 posn: 170 138 init:)
				(shape151 posn: 190 145 init:)
				(shape152 posn: 163 77 init:)
				(= cycles 4)
			)
			(2
				(shape12 dispose:)
				(shape151 dispose:)
				(shape152 dispose:)
				(shape13 posn: 170 138 init:)
				(shape141 posn: 190 145 init:)
				(shape142 posn: 163 77 init:)
				(shape23 posn: 288 100 init:)
				(= cycles 4)
			)
			(3
				(shape13 dispose:)
				(shape141 dispose:)
				(shape142 dispose:)
				(shape23 dispose:)
				(shape17 posn: 168 145 init:)
				(shape141 posn: 190 145 init:)
				(shape151 posn: 163 77 init:)
				(shape22 posn: 288 100 init:)
				(= cycles 4)
			)
			(4
				(shape17 dispose:)
				(shape141 dispose:)
				(shape151 dispose:)
				(shape22 dispose:)
				(shape151 posn: 190 145 init:)
				(shape16 posn: 168 145 init:)
				(shape23 posn: 288 100 init:)
				(= cycles 4)
			)
			(5
				(shape151 dispose:)
				(shape16 dispose:)
				(shape23 dispose:)
				(shape16 posn: 168 145 init:)
				(shape191 posn: 195 136 init:)
				(shape192 posn: 163 77 init:)
				(= cycles 4)
			)
			(6
				(shape16 dispose:)
				(shape191 dispose:)
				(shape192 dispose:)
				(shape17 posn: 168 145 init:)
				(shape181 posn: 195 136 init:)
				(shape182 posn: 163 77 init:)
				(shape25 posn: 288 100 init:)
				(= cycles 4)
			)
			(7
				(shape17 dispose:)
				(shape181 dispose:)
				(shape182 dispose:)
				(shape25 dispose:)
				(shape181 posn: 195 136 init:)
				(shape13 posn: 170 138 init:)
				(shape191 posn: 163 77 init:)
				(shape24 posn: 288 100 init:)
				(= cycles 4)
			)
			(8
				(shape181 dispose:)
				(shape13 dispose:)
				(shape191 dispose:)
				(shape24 dispose:)
				(shape191 posn: 195 136 init:)
				(shape12 posn: 170 138 init:)
				(shape25 posn: 288 100 init:)
				(= cycles 4)
			)
			(9
				(shape191 dispose:)
				(shape12 dispose:)
				(shape25 dispose:)
				(= cycles 4)
			)
			(10
				(injure init:)
				(terminate init:)
				(= cycles 1)
			)
			(11
				(outline init:)
				(= cycles 1)
			)
			(12
				(outline setCel: 1)
				(= cycles 1)
			)
			(13
				(outline setCel: 2)
				(rogHead init:)
				(= cycles 1)
			)
			(14
				(rogHead setCel: 0)
				(egoHead init: setPri: 15 setCycle: End self)
			)
			(15
				(= cycles 5)
			)
			(16
				(egoHead setCycle: Beg self)
			)
			(17
				(rogHead setCel: 1)
				(= cycles 2)
			)
			(18
				(rogHead dispose:)
				(outline setCycle: End)
				(= cycles 1)
			)
			(19
				(egoHead dispose:)
				(outline dispose:)
				(eyess init: cycleSpeed: 10 setCycle: End self)
			)
			(20
				(eyess setCycle: Beg self)
				(arm setCycle: End self)
				(rogHead dispose:)
			)
			(21 0)
			(22
				(arm addToPic: setPri: 15)
				(= cycles 1)
			)
			(23
				(eyess dispose:)
				(= cycles 1)
				(gSq5Music2 fade:)
			)
			(24
				(Palette palSET_INTENSITY 238 239 0)
				(gSq5Music2 number: 162 setLoop: 1 play:)
				(= seconds 2)
				(= local0 (Graph grSAVE_BOX 0 65 96 320 1))
			)
			(25
				(DrawCel 167 5 0 119 12 0)
				(DrawCel 167 5 0 125 17 0)
				(DrawCel 167 5 0 153 18 0)
				(DrawCel 167 5 0 200 26 0)
				(DrawCel 167 5 0 182 37 0)
				(DrawCel 167 5 0 206 43 0)
				(DrawCel 167 5 0 230 33 0)
				(DrawCel 167 5 0 252 29 0)
				(DrawCel 167 5 0 244 33 0)
				(DrawCel 167 5 0 240 38 0)
				(DrawCel 167 5 0 170 61 0)
				(DrawCel 167 5 0 159 66 0)
				(DrawCel 167 5 0 152 72 0)
				(DrawCel 167 5 0 149 78 0)
				(DrawCel 167 5 0 138 83 0)
				(DrawCel 167 5 0 149 81 0)
				(DrawCel 167 5 0 148 87 0)
				(DrawCel 167 5 0 209 51 0)
				(DrawCel 167 5 0 218 52 0)
				(DrawCel 167 5 0 178 65 0)
				(DrawCel 167 5 0 198 62 0)
				(DrawCel 167 5 0 204 62 0)
				(DrawCel 167 5 0 213 58 0)
				(DrawCel 167 5 0 218 59 0)
				(DrawCel 167 5 0 215 67 0)
				(DrawCel 167 5 0 221 67 0)
				(DrawCel 167 5 0 213 74 0)
				(DrawCel 167 5 0 239 46 0)
				(DrawCel 167 5 0 237 56 0)
				(DrawCel 167 5 0 254 53 0)
				(DrawCel 167 5 0 248 56 0)
				(DrawCel 167 5 0 244 64 0)
				(DrawCel 167 5 0 274 40 0)
				(DrawCel 167 5 0 290 50 0)
				(DrawCel 167 5 0 292 51 0)
				(DrawCel 167 5 0 272 63 0)
				(DrawCel 167 5 0 281 61 0)
				(DrawCel 167 5 0 252 76 0)
				(DrawCel 167 5 0 262 71 0)
				(DrawCel 167 5 0 266 76 0)
				(DrawCel 167 5 0 283 70 0)
				(DrawCel 167 5 0 300 67 0)
				(DrawCel 167 5 0 303 68 0)
				(DrawCel 167 5 0 301 88 0)
				(DrawCel 167 5 0 292 92 0)
				(DrawCel 167 5 0 295 96 0)
				(= cycles 4)
			)
			(26
				(Graph grRESTORE_BOX local0)
				(Graph grUPDATE_BOX 0 65 96 320 1)
				(= local0 (Graph grSAVE_BOX 0 65 96 320 1))
				(DrawCel 167 5 1 108 12 0)
				(DrawCel 167 5 1 114 17 0)
				(DrawCel 167 5 1 142 18 0)
				(DrawCel 167 5 1 189 26 0)
				(DrawCel 167 5 1 171 37 0)
				(DrawCel 167 5 1 195 43 0)
				(DrawCel 167 5 1 219 33 0)
				(DrawCel 167 5 1 241 29 0)
				(DrawCel 167 5 1 233 33 0)
				(DrawCel 167 5 1 229 38 0)
				(DrawCel 167 5 1 159 61 0)
				(DrawCel 167 5 1 148 66 0)
				(DrawCel 167 5 1 141 72 0)
				(DrawCel 167 5 1 138 78 0)
				(DrawCel 167 5 1 127 83 0)
				(DrawCel 167 5 1 138 81 0)
				(DrawCel 167 5 1 137 87 0)
				(DrawCel 167 5 1 198 51 0)
				(DrawCel 167 5 1 207 52 0)
				(DrawCel 167 5 1 167 65 0)
				(DrawCel 167 5 1 187 62 0)
				(DrawCel 167 5 1 193 62 0)
				(DrawCel 167 5 1 202 58 0)
				(DrawCel 167 5 1 207 59 0)
				(DrawCel 167 5 1 204 67 0)
				(DrawCel 167 5 1 210 67 0)
				(DrawCel 167 5 1 202 74 0)
				(DrawCel 167 5 1 228 46 0)
				(DrawCel 167 5 1 226 56 0)
				(DrawCel 167 5 1 243 53 0)
				(DrawCel 167 5 1 237 56 0)
				(DrawCel 167 5 1 233 64 0)
				(DrawCel 167 5 1 263 40 0)
				(DrawCel 167 5 1 279 50 0)
				(DrawCel 167 5 1 281 51 0)
				(DrawCel 167 5 1 261 63 0)
				(DrawCel 167 5 1 270 61 0)
				(DrawCel 167 5 1 241 76 0)
				(DrawCel 167 5 1 251 71 0)
				(DrawCel 167 5 1 255 76 0)
				(DrawCel 167 5 1 272 70 0)
				(DrawCel 167 5 1 289 67 0)
				(DrawCel 167 5 1 292 68 0)
				(DrawCel 167 5 1 290 88 0)
				(DrawCel 167 5 1 281 92 0)
				(DrawCel 167 5 1 284 96 0)
				(= cycles 4)
			)
			(27
				(Graph grRESTORE_BOX local0)
				(Graph grUPDATE_BOX 0 65 96 320 1)
				(= local0 (Graph grSAVE_BOX 0 65 96 320 1))
				(DrawCel 167 5 2 95 12 0)
				(DrawCel 167 5 2 101 17 0)
				(DrawCel 167 5 2 129 18 0)
				(DrawCel 167 5 2 176 26 0)
				(DrawCel 167 5 2 158 37 0)
				(DrawCel 167 5 2 182 43 0)
				(DrawCel 167 5 2 206 33 0)
				(DrawCel 167 5 2 228 29 0)
				(DrawCel 167 5 2 220 33 0)
				(DrawCel 167 5 2 216 38 0)
				(DrawCel 167 5 2 146 61 0)
				(DrawCel 167 5 2 135 66 0)
				(DrawCel 167 5 2 128 72 0)
				(DrawCel 167 5 2 125 78 0)
				(DrawCel 167 5 2 114 83 0)
				(DrawCel 167 5 2 125 81 0)
				(DrawCel 167 5 2 124 87 0)
				(DrawCel 167 5 2 185 51 0)
				(DrawCel 167 5 2 194 52 0)
				(DrawCel 167 5 2 154 65 0)
				(DrawCel 167 5 2 174 62 0)
				(DrawCel 167 5 2 180 62 0)
				(DrawCel 167 5 2 189 58 0)
				(DrawCel 167 5 2 194 59 0)
				(DrawCel 167 5 2 191 67 0)
				(DrawCel 167 5 2 197 67 0)
				(DrawCel 167 5 2 189 74 0)
				(DrawCel 167 5 2 215 46 0)
				(DrawCel 167 5 2 213 56 0)
				(DrawCel 167 5 2 230 53 0)
				(DrawCel 167 5 2 224 56 0)
				(DrawCel 167 5 2 220 64 0)
				(DrawCel 167 5 2 250 40 0)
				(DrawCel 167 5 2 266 50 0)
				(DrawCel 167 5 2 268 51 0)
				(DrawCel 167 5 2 248 63 0)
				(DrawCel 167 5 2 257 61 0)
				(DrawCel 167 5 2 228 76 0)
				(DrawCel 167 5 2 238 71 0)
				(DrawCel 167 5 2 242 76 0)
				(DrawCel 167 5 2 259 70 0)
				(DrawCel 167 5 2 276 67 0)
				(DrawCel 167 5 2 279 68 0)
				(DrawCel 167 5 2 277 88 0)
				(DrawCel 167 5 2 268 92 0)
				(DrawCel 167 5 2 271 96 0)
				(= cycles 4)
			)
			(28
				(Graph grRESTORE_BOX local0)
				(Graph grUPDATE_BOX 0 65 96 320 1)
				(= local0 (Graph grSAVE_BOX 0 65 96 320 1))
				(DrawCel 167 5 3 55 12 0)
				(DrawCel 167 5 3 61 17 0)
				(DrawCel 167 5 3 89 18 0)
				(DrawCel 167 5 3 136 26 0)
				(DrawCel 167 5 3 118 37 0)
				(DrawCel 167 5 3 142 43 0)
				(DrawCel 167 5 3 166 33 0)
				(DrawCel 167 5 3 188 29 0)
				(DrawCel 167 5 3 180 33 0)
				(DrawCel 167 5 3 176 38 0)
				(DrawCel 167 5 3 106 61 0)
				(DrawCel 167 5 3 95 66 0)
				(DrawCel 167 5 3 88 72 0)
				(DrawCel 167 5 3 85 78 0)
				(DrawCel 167 5 3 74 83 0)
				(DrawCel 167 5 3 85 81 0)
				(DrawCel 167 5 3 84 87 0)
				(DrawCel 167 5 3 145 51 0)
				(DrawCel 167 5 3 154 52 0)
				(DrawCel 167 5 3 114 65 0)
				(DrawCel 167 5 3 134 62 0)
				(DrawCel 167 5 3 140 62 0)
				(DrawCel 167 5 3 149 58 0)
				(DrawCel 167 5 3 154 59 0)
				(DrawCel 167 5 3 151 67 0)
				(DrawCel 167 5 3 157 67 0)
				(DrawCel 167 5 3 149 74 0)
				(DrawCel 167 5 3 175 46 0)
				(DrawCel 167 5 3 173 56 0)
				(DrawCel 167 5 3 190 53 0)
				(DrawCel 167 5 3 184 56 0)
				(DrawCel 167 5 3 180 64 0)
				(DrawCel 167 5 3 210 40 0)
				(DrawCel 167 5 3 226 50 0)
				(DrawCel 167 5 3 228 51 0)
				(DrawCel 167 5 3 208 63 0)
				(DrawCel 167 5 3 217 61 0)
				(DrawCel 167 5 3 188 76 0)
				(DrawCel 167 5 3 198 71 0)
				(DrawCel 167 5 3 202 76 0)
				(DrawCel 167 5 3 219 70 0)
				(DrawCel 167 5 3 236 67 0)
				(DrawCel 167 5 3 239 68 0)
				(DrawCel 167 5 3 237 88 0)
				(DrawCel 167 5 3 228 92 0)
				(DrawCel 167 5 3 231 96 0)
				(= cycles 4)
			)
			(29
				(Graph grRESTORE_BOX local0)
				(Graph grUPDATE_BOX 0 65 96 320 1)
				(= local0 (Graph grSAVE_BOX 0 65 96 320 1))
				(DrawCel 167 5 3 49 18 0)
				(DrawCel 167 5 3 96 26 0)
				(DrawCel 167 5 3 78 37 0)
				(DrawCel 167 5 3 102 43 0)
				(DrawCel 167 5 3 126 33 0)
				(DrawCel 167 5 3 148 29 0)
				(DrawCel 167 5 3 140 33 0)
				(DrawCel 167 5 3 136 38 0)
				(DrawCel 167 5 3 66 61 0)
				(DrawCel 167 5 3 55 66 0)
				(DrawCel 167 5 3 48 72 0)
				(DrawCel 167 5 3 45 78 0)
				(DrawCel 167 5 3 34 83 0)
				(DrawCel 167 5 3 45 81 0)
				(DrawCel 167 5 3 44 87 0)
				(DrawCel 167 5 3 105 51 0)
				(DrawCel 167 5 3 114 52 0)
				(DrawCel 167 5 3 74 65 0)
				(DrawCel 167 5 3 94 62 0)
				(DrawCel 167 5 3 100 62 0)
				(DrawCel 167 5 3 109 58 0)
				(DrawCel 167 5 3 114 59 0)
				(DrawCel 167 5 3 111 67 0)
				(DrawCel 167 5 3 117 67 0)
				(DrawCel 167 5 3 109 74 0)
				(DrawCel 167 5 3 135 46 0)
				(DrawCel 167 5 3 133 56 0)
				(DrawCel 167 5 3 150 53 0)
				(DrawCel 167 5 3 144 56 0)
				(DrawCel 167 5 3 140 64 0)
				(DrawCel 167 5 3 170 40 0)
				(DrawCel 167 5 3 186 50 0)
				(DrawCel 167 5 3 188 51 0)
				(DrawCel 167 5 3 168 63 0)
				(DrawCel 167 5 3 177 61 0)
				(DrawCel 167 5 3 148 76 0)
				(DrawCel 167 5 3 158 71 0)
				(DrawCel 167 5 3 162 76 0)
				(DrawCel 167 5 3 179 70 0)
				(DrawCel 167 5 3 196 67 0)
				(DrawCel 167 5 3 199 68 0)
				(DrawCel 167 5 3 197 88 0)
				(DrawCel 167 5 3 188 92 0)
				(DrawCel 167 5 3 191 96 0)
				(DrawCel 167 5 3 244 41 0)
				(DrawCel 167 5 3 267 54 0)
				(DrawCel 167 5 3 213 63 0)
				(DrawCel 167 5 3 270 74 0)
				(DrawCel 167 5 3 166 25 0)
				(DrawCel 167 5 3 295 68 0)
				(DrawCel 167 5 3 238 83 0)
				(DrawCel 167 5 3 279 94 0)
				(= cycles 4)
			)
			(30
				(Graph grRESTORE_BOX local0)
				(Graph grUPDATE_BOX 0 65 96 320 1)
				(= local0 (Graph grSAVE_BOX 0 65 96 320 1))
				(DrawCel 167 5 3 50 43 0)
				(DrawCel 167 5 3 74 33 0)
				(DrawCel 167 5 3 96 29 0)
				(DrawCel 167 5 3 88 33 0)
				(DrawCel 167 5 3 84 38 0)
				(DrawCel 167 5 3 53 51 0)
				(DrawCel 167 5 3 62 52 0)
				(DrawCel 167 5 3 42 62 0)
				(DrawCel 167 5 3 48 62 0)
				(DrawCel 167 5 3 57 58 0)
				(DrawCel 167 5 3 62 59 0)
				(DrawCel 167 5 3 59 67 0)
				(DrawCel 167 5 3 65 67 0)
				(DrawCel 167 5 3 57 74 0)
				(DrawCel 167 5 3 83 46 0)
				(DrawCel 167 5 3 81 56 0)
				(DrawCel 167 5 3 98 53 0)
				(DrawCel 167 5 3 92 56 0)
				(DrawCel 167 5 3 88 64 0)
				(DrawCel 167 5 3 118 40 0)
				(DrawCel 167 5 3 134 50 0)
				(DrawCel 167 5 3 136 51 0)
				(DrawCel 167 5 3 116 63 0)
				(DrawCel 167 5 3 125 61 0)
				(DrawCel 167 5 3 96 76 0)
				(DrawCel 167 5 3 106 71 0)
				(DrawCel 167 5 3 110 76 0)
				(DrawCel 167 5 3 127 70 0)
				(DrawCel 167 5 3 144 67 0)
				(DrawCel 167 5 3 147 68 0)
				(DrawCel 167 5 3 139 96 0)
				(DrawCel 167 5 3 192 41 0)
				(DrawCel 167 5 3 215 54 0)
				(DrawCel 167 5 3 161 63 0)
				(DrawCel 167 5 3 218 74 0)
				(DrawCel 167 5 3 114 25 0)
				(DrawCel 167 5 3 243 68 0)
				(DrawCel 167 5 3 186 83 0)
				(DrawCel 167 5 3 227 94 0)
				(DrawCel 167 5 3 270 47 0)
				(DrawCel 167 5 3 228 61 0)
				(DrawCel 167 5 3 213 31 0)
				(DrawCel 167 5 3 285 84 0)
				(= cycles 4)
			)
			(31
				(Graph grRESTORE_BOX local0)
				(Graph grUPDATE_BOX 0 65 96 320 1)
				(= local0 (Graph grSAVE_BOX 0 65 96 320 1))
				(DrawCel 167 5 3 113 54 0)
				(DrawCel 167 5 3 59 63 0)
				(DrawCel 167 5 3 116 74 0)
				(DrawCel 167 5 3 141 68 0)
				(DrawCel 167 5 3 84 83 0)
				(DrawCel 167 5 3 168 47 0)
				(DrawCel 167 5 3 126 61 0)
				(DrawCel 167 5 3 111 31 0)
				(DrawCel 167 5 3 271 59 0)
				(DrawCel 167 5 3 205 25 0)
				(DrawCel 167 5 3 218 76 0)
				(= cycles 4)
			)
			(32
				(Graph grRESTORE_BOX local0)
				(Graph grUPDATE_BOX 0 65 96 320 1)
				(= local0 (Graph grSAVE_BOX 0 65 96 320 1))
				(DrawCel 167 5 3 70 68 0)
				(DrawCel 167 5 3 97 47 0)
				(DrawCel 167 5 3 55 61 0)
				(DrawCel 167 5 3 200 59 0)
				(DrawCel 167 5 3 134 25 0)
				(DrawCel 167 5 3 147 76 0)
				(DrawCel 167 5 3 271 79 0)
				(= cycles 4)
			)
			(33
				(Graph grRESTORE_BOX local0)
				(Graph grUPDATE_BOX 0 65 96 320 1)
				(= local0 (Graph grSAVE_BOX 0 65 96 320 1))
				(DrawCel 167 5 3 164 60 0)
				(= cycles 4)
			)
			(34
				(Graph grRESTORE_BOX local0)
				(Graph grUPDATE_BOX 0 65 96 320 1)
				(= cycles 1)
			)
			(35
				(gSq5Music1 fade:)
				(gSq5Music2 fade:)
				(= seconds 2)
			)
			(36
				(theMusic3 dispose:)
				(gCurRoom newRoom: 201)
				(self dispose:)
			)
		)
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance egoHead of Prop
	(properties
		x 52
		y 10
		view 167
		priority 15
		signal 24576
		cycleSpeed 10
	)

	(method (setCycle param1)
		(if param1
			(theMusic3 number: 160 setLoop: 1 play:)
		)
		(super setCycle: param1 &rest)
	)
)

(instance arm of Prop
	(properties
		x 158
		y 106
		view 167
		loop 4
		cel 1
		signal 24576
		cycleSpeed 12
	)

	(method (setCycle param1)
		(if param1
			(theMusic3 number: 160 setLoop: 1 play:)
		)
		(super setCycle: param1 &rest)
	)

	(method (dispose)
		(theMusic3 dispose:)
		(super dispose: &rest)
	)
)

(instance terminate of Prop
	(properties
		x 172
		y 142
		view 167
		loop 3
		cel 1
		signal 24576
		cycleSpeed 10
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)

	(method (doit)
		(if (== cel 2)
			(theMusic3 number: 1611 setLoop: 1 play:)
		)
		(super doit: &rest)
	)
)

(instance injure of Prop
	(properties
		x 168
		y 79
		view 167
		loop 7
		cel 6
		signal 24576
		cycleSpeed 20
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance eyess of Prop
	(properties
		x 94
		y 34
		view 167
		loop 8
		cel 1
		signal 24576
		cycleSpeed 10
	)
)

(instance rogHead of Prop
	(properties
		x 216
		y 89
		view 167
		loop 1
		cel 1
		signal 24576
		cycleSpeed 10
	)
)

(instance outline of Prop
	(properties
		x 216
		y 89
		view 167
		loop 2
		signal 24576
	)
)

(instance shape12 of Prop
	(properties
		x 170
		y 148
		view 167
		loop 6
	)
)

(instance shape151 of Prop
	(properties
		x 89
		y 127
		view 167
		loop 10
		cel 1
	)
)

(instance shape13 of Prop
	(properties
		x 162
		y 98
		view 167
		loop 9
		cel 1
	)
)

(instance shape141 of Prop
	(properties
		x 158
		y 102
		view 167
		loop 10
	)
)

(instance shape142 of Prop
	(properties
		x 160
		y 100
		view 167
		loop 10
	)
)

(instance shape152 of Prop
	(properties
		x 158
		y 102
		view 167
		loop 10
		cel 1
	)
)

(instance shape16 of Prop
	(properties
		x 164
		y 96
		view 167
		loop 11
	)
)

(instance shape17 of Prop
	(properties
		x 156
		y 104
		view 167
		loop 11
		cel 1
	)
)

(instance shape181 of Prop
	(properties
		x 166
		y 94
		view 167
		loop 12
	)
)

(instance shape182 of Prop
	(properties
		x 154
		y 106
		view 167
		loop 12
	)
)

(instance shape191 of Prop
	(properties
		x 168
		y 92
		view 167
		loop 12
		cel 1
	)
)

(instance shape192 of Prop
	(properties
		x 168
		y 92
		view 167
		loop 12
		cel 1
	)
)

(instance shape22 of Prop
	(properties
		x 152
		y 108
		view 167
		loop 13
	)
)

(instance shape23 of Prop
	(properties
		x 160
		y 94
		view 167
		loop 13
		cel 1
	)
)

(instance shape24 of Prop
	(properties
		x 160
		y 92
		view 167
		loop 14
	)
)

(instance shape25 of Prop
	(properties
		x 156
		y 96
		view 167
		loop 14
		cel 1
	)
)

