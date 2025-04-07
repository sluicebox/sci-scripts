;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use oDildo)
(use oFidgetTimer)
(use TPSound)
(use ModalPlane)
(use PushButton)
(use soFlashCyberSniff)
(use foEExit)
(use Polygon)
(use Feature)
(use Motion)
(use System)

(public
	oAboutScreen 0
	oCreditMusic 1
)

(procedure (localproc_0 param1 &tmp temp0 temp1 [temp2 2] temp4 temp5)
	(= temp4 (param1 nIdentity:))
	(= temp5 (MakeMessageText 0 0 3 temp4 15))
	(oCredit hide: setString: temp5)
	(= temp0 (- (param1 x:) (/ (oCredit nWidth:) 2)))
	(= temp1 (Min (+ (param1 y:) 20) 215))
	(cond
		((== param1 foMarkS)
			(= temp1 202)
		)
		((== param1 foAlL)
			(= temp1 190)
		)
		((== param1 foBob)
			(= temp0 474)
			(= temp1 155)
		)
		((== param1 foAlE)
			(= temp0 0)
			(= temp1 218)
		)
	)
	(oCredit posn: temp0 temp1 show:)
	(oCreditBL hide: setString: temp5 posn: (- temp0 2) temp1 show:)
	(oCreditBT hide: setString: temp5 posn: temp0 (- temp1 2) show:)
	(oCreditBR hide: setString: temp5 posn: (+ temp0 2) temp1 show:)
	(oCreditBB hide: setString: temp5 posn: temp0 (+ temp1 2) show:)
	(temp5 dispose:)
)

(procedure (localproc_1)
	(oCredit setString:)
	(oCreditBL setString:)
	(oCreditBT setString:)
	(oCreditBR setString:)
	(oCreditBB setString:)
)

(instance oAboutScreen of ModalPlane
	(properties
		picture 14000
		priority 500
	)

	(method (init &tmp temp0)
		(super init: 0 0 639 479)
		((ScriptID 64017 0) set: 295) ; oFlags
		((ScriptID 64017 0) set: 15) ; oFlags
		(gSounds eachElementDo: #pause)
		(proc60_1 0)
		(oCreditMusic setMusic: 13000)
		(oCredit init: self setString:)
		(oCreditBL init: self setString:)
		(oCreditBT init: self setString:)
		(oCreditBR init: self setString:)
		(oCreditBB init: self setString:)
		(foAlE init: self)
		(foMarkM init: self)
		(foJen init: self)
		(foBill init: self)
		(foJasonZ init: self)
		(foMarkS init: self)
		(foAlL init: self)
		(foBob init: self)
		(foSteve init: self)
		(foJasonP init: self)
		(foDon init: self)
		(foLayne init: self)
		(foBen init: self)
		(foBryan init: self)
		(if (not ((ScriptID 64017 0) test: 293)) ; oFlags
			(oLocalDildo
				posn: 346 296
				setDest: -30 332
				loop: 1
				cel: 0
				setPri: 550
				nMyFlag: 293
				oAltScript: soDildo
				init: self
				setScalePercent: 100
			)
		)
		(= temp0 (MakeMessageText 0 0 1 1 14)) ; "Leisure Suit Larry in "Love For Sail!" is an "Up and Coming" Production.  Version"
		(if gVersion
			(temp0 cat: { })
			(temp0 cat: gVersion)
		)
		(oVersion init: self setString: temp0)
		(temp0 dispose:)
		(= temp0 0)
		(foExit init: self)
	)

	(method (dispose)
		(AboutFeature isHighlighted: 0)
		(oCredit dispose:)
		(oCreditBL dispose:)
		(oCreditBT dispose:)
		(oCreditBR dispose:)
		(oCreditBB dispose:)
		(oVersion dispose:)
		(oCreditMusic stop:)
		(gSounds eachElementDo: #pause 0)
		(proc60_1)
		((ScriptID 64017 0) clear: 295) ; oFlags
		(super dispose: &rest)
	)
)

(instance oLocalDildo of Dildo
	(properties)
)

(class AboutFeature of Feature
	(properties
		isHighlighted 0
		nIdentity 0
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (!= (event plane:) plane)
			(event localize: plane)
		)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (self onMe: event) (self isNotHidden:))
				(if (not isHighlighted)
					(self highlight:)
					(FrameOut)
				)
				(event claimed: 1)
				(return)
			)
			(isHighlighted
				(self highlight: 0)
				(FrameOut)
			)
		)
		(return 0)
	)

	(method (highlight param1)
		(if (and argc (not param1))
			(= isHighlighted 0)
			(localproc_1)
		else
			(= isHighlighted 1)
			(localproc_0 self)
		)
	)
)

(instance soDildo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oCreditMusic pause:)
				(oLocalDildo
					setStep: 8 10
					setCycle: Walk
					setMotion: MoveTo 310 332
				)
			)
			(1
				(oLocalDildo setStep: 5 10 setMotion: MoveTo -30 332)
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (or (== (oLocalDildo x:) 310) (< (oLocalDildo x:) 0))
			(self cue:)
		)
	)
)

(instance foAlE of AboutFeature
	(properties
		x 49
		y 237
		nIdentity 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 39 150 50 154 60 167 66 193 67 202 89 208 99 222 90 230 86 261 97 315 96 324 7 324 14 303 2 308 0 229 33 202 23 189 18 169 26 155
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foMarkM of AboutFeature
	(properties
		x 127
		y 242
		nIdentity 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 126 167 142 161 154 166 159 185 161 201 150 215 165 219 168 225 151 260 154 279 165 290 160 324 98 324 97 307 87 266 91 227 129 206 121 178
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foJen of AboutFeature
	(properties
		x 195
		y 240
		nIdentity 13
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 194 164 205 158 219 156 231 166 236 180 234 192 230 193 227 205 230 208 208 236 189 233 186 237 195 242 196 248 190 249 190 254 198 255 200 261 218 266 232 263 233 286 226 325 162 325 166 292 155 279 156 251 169 221 188 209 189 202 200 201 190 189 192 184 189 177
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foBill of AboutFeature
	(properties
		x 263
		y 238
		nIdentity 9
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 257 158 268 152 284 152 293 166 293 176 293 183 285 208 318 216 326 225 333 257 332 265 339 263 341 266 330 274 332 286 309 290 314 314 314 324 229 325 233 276 226 257 219 262 199 260 200 253 191 252 191 249 196 242 185 236 188 233 209 235 232 205 256 205 258 196 251 184 252 178 250 164
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foJasonZ of AboutFeature
	(properties
		x 371
		y 235
		nIdentity 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 348 148 357 146 372 156 375 177 373 190 382 196 398 198 417 211 429 266 412 299 411 324 330 324 335 312 313 303 315 291 333 286 340 264 333 260 330 230 325 223 330 208 342 203 334 191 331 179 324 175 331 153 341 146
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foMarkS of AboutFeature
	(properties
		x 446
		y 228
		nIdentity 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 420 139 437 134 451 139 457 157 459 175 445 191 475 208 487 239 483 246 457 236 449 246 449 263 459 275 449 281 450 312 456 323 412 323 412 299 431 265 417 210 406 202 416 171 416 149
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foAlL of AboutFeature
	(properties
		x 537
		y 217
		nIdentity 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 507 126 523 111 539 111 549 122 555 137 547 156 572 169 587 180 597 214 600 254 587 261 582 287 578 320 543 323 549 309 554 295 535 266 532 233 522 227 489 238 475 205 488 174 510 161
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foBob of AboutFeature
	(properties
		x 594
		y 202
		nIdentity 11
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 552 129 561 124 557 108 563 92 571 82 587 83 600 93 602 104 588 130 592 135 618 144 639 182 639 220 628 226 617 231 622 264 610 323 590 322 591 308 583 299 589 260 605 251 593 189 580 169 557 161 549 149 554 130 562 124
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foSteve of AboutFeature
	(properties
		x 478
		y 149
		nIdentity 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 450 103 462 93 473 91 484 100 489 113 486 133 492 141 509 146 509 162 486 173 474 191 473 208 447 183 447 176 456 169 457 149 454 141 457 136 452 126 453 120 450 117
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foJasonP of AboutFeature
	(properties
		x 388
		y 148
		nIdentity 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 360 106 373 98 380 98 387 95 398 99 405 116 402 130 395 143 401 150 416 156 413 170 416 179 406 189 406 202 391 194 381 195 376 186 375 170 369 153 360 146 371 141 364 123
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foDon of AboutFeature
	(properties
		x 287
		y 150
		nIdentity 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 278 93 288 83 305 81 318 87 317 103 312 125 321 135 343 146 328 156 323 173 325 182 331 183 337 200 328 207 325 219 304 209 286 207 286 194 292 186 292 166 281 150 261 152 251 164 251 182 254 197 253 203 233 199 232 190 236 178 232 166 243 145 241 128 245 127 250 143 257 135 282 130
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foLayne of AboutFeature
	(properties
		x 196
		y 157
		nIdentity 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 175 113 183 101 196 97 207 104 212 113 213 140 222 147 240 150 231 165 216 154 193 160 190 179 197 199 169 217 156 211 162 192 158 170 152 165 159 154 184 145
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foBen of AboutFeature
	(properties
		x 154
		y 127
		nIdentity 14
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 146 91 163 94 171 105 171 122 161 135 177 147 158 152 151 163 139 160 131 160 138 151 134 139 140 139 140 130 133 119 133 102
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foBryan of AboutFeature
	(properties
		x 101
		y 171
		nIdentity 12
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 113 124 120 123 131 129 135 148 136 153 128 163 129 164 120 173 128 202 102 221 88 206 71 201 66 198 66 183 83 169 91 156 101 126 110 122
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foExit of CUExitFeature
	(properties)

	(method (doVerb)
		(oAboutScreen dispose:)
	)
)

(instance oCreditMusic of TPSound
	(properties
		type 1
	)
)

(instance oCredit of TextItem
	(properties
		priority 600
		fixPriority 1
		fore 72
		font 7
		maxWidth 250
	)
)

(instance oCreditBL of TextItem
	(properties
		priority 595
		fixPriority 1
		font 7
		maxWidth 250
	)
)

(instance oCreditBT of TextItem
	(properties
		priority 595
		fixPriority 1
		font 7
		maxWidth 250
	)
)

(instance oCreditBR of TextItem
	(properties
		priority 595
		fixPriority 1
		font 7
		maxWidth 250
	)
)

(instance oCreditBB of TextItem
	(properties
		priority 595
		fixPriority 1
		font 7
		maxWidth 250
	)
)

(instance oVersion of TextItem
	(properties
		y 430
		priority 600
		fixPriority 1
		font 2510
		maxWidth 640
		nMinWidth 640
	)
)

