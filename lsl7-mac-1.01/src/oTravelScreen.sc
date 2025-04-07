;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use ro220)
(use CueMe)
(use ModalPlane)
(use PushButton)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	oTravelScreen 0
)

(local
	local0
)

(instance oTravelScreen of Plane
	(properties
		picture 9000
		priority 500
	)

	(method (init &tmp temp0)
		(super init: 0 0 639 479)
		((ScriptID 64017 0) set: 158) ; oFlags
		((ScriptID 64000 0) disable:) ; oMainMenu
		(foOpaque init: self)
		(self setPri: 500 drawPic: picture)
		(proc220_1)
		(foExit init: self)
		(voDestination init: self)
		(foBridgeEx init: self)
		(foCaptainSuite init: self)
		(foBoardingDeck init: self)
		(foLounge init: self)
		(foHorseShoeArea init: self)
		(foPoopDeck init: self)
		(foPromenadeDeck init: self)
		(foSwimmingPool init: self)
		(if ((ScriptID 64017 0) test: 80) ; oFlags
			(foBoningSuite init: self)
			(voBoningATP init: self)
		)
		(foRestaurant init: self)
		(foLobbyUpper init: self)
		(foLobbyLower init: self)
		(foCasinoLobby init: self)
		(foCasino init: self)
		(foBreakRoom init: self)
		(if ((ScriptID 64017 0) test: 33) ; oFlags
			(foBowling init: self)
		)
		(foBallroom init: self)
		(if ((ScriptID 64017 0) test: 33) ; oFlags
			(foLuvMaster init: self)
		)
		(if ((ScriptID 64017 0) test: 33) ; oFlags
			(foCookOff init: self)
		)
		(foLibrary init: self)
		(if ((ScriptID 64017 0) test: 33) ; oFlags
			(foBestDressed init: self)
		)
		(foPinSetter init: self)
		(if ((ScriptID 64017 0) test: 18) ; oFlags
			(foDewmiCabin init: self)
			(voDewmiATP init: self)
		)
		(foBeaverHold init: self)
		(foLuggageHold init: self)
		(foKitchen init: self)
		(foLarryRoom init: self)
		(foFocsle init: self)
		(foPurserDesk init: self)
		(voHighlight init: self hide:)
		(voThumbnail init: self hide:)
	)

	(method (dispose)
		((ScriptID 64017 0) clear: 158) ; oFlags
		((ScriptID 64000 0) enable:) ; oMainMenu
		(super dispose: &rest)
	)
)

(class TravelFeature of Feature
	(properties
		isHighlighted 0
		nNewRoom 0
		nIdentity 0
		nThumb 0
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (handleEvent event &tmp temp0 temp1)
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
				)
				(if (& (event type:) evMOUSEBUTTON)
					(= temp1 0)
					(CueObj state: 0 cycles: 0 client: self theVerb: 0)
					(CueObj changeState: 3)
				)
				(event claimed: 1)
				(return)
			)
			(isHighlighted
				(self highlight: 0)
			)
		)
		(return 0)
	)

	(method (highlight param1 &tmp temp0)
		(if (and argc (not param1))
			(= isHighlighted 0)
			(voDestination setString:)
			(voHighlight hide:)
			(voThumbnail hide:)
		else
			(= isHighlighted 1)
			(if
				(or
					(and (OneOf gCurRoomNum 210 211) (== nIdentity 0)) ; ro210, ro211
					(and (OneOf gCurRoomNum 220 222) (== nIdentity 1)) ; ro220, ro222
					(and (== gCurRoomNum 230) (== nIdentity 4)) ; ro230
					(and (OneOf gCurRoomNum 240 245 246) (== nIdentity 5)) ; ro240, ro245, ro246
					(and (== gCurRoomNum 250) (== nIdentity 12)) ; ro250
					(and (OneOf gCurRoomNum 255 256) (== nIdentity 11)) ; ro255, ro256
					(and (== gCurRoomNum 260) (== nIdentity 3)) ; ro260
					(and (== gCurRoomNum 262) (== nIdentity 2)) ; ro262
					(and
						(== gCurRoomNum 261) ; ro261
						(or
							(and (== global219 230) (== nIdentity 4))
							(and (== global219 260) (== nIdentity 3))
							(and (== global219 262) (== nIdentity 2))
						)
					)
					(and (OneOf gCurRoomNum 300 301 302) (== nIdentity 6)) ; ro300, ro301, ro302
					(and (OneOf gCurRoomNum 310 311 312) (== nIdentity 27)) ; ro310, ro311, ro313
					(and (OneOf gCurRoomNum 330 331) (== nIdentity 8)) ; ro330, ro331
					(and (== gCurRoomNum 340) (== nIdentity 17)) ; ro340
					(and (== gCurRoomNum 341) (== nIdentity 9)) ; ro341
					(and (OneOf gCurRoomNum 360 363) (== nIdentity 18)) ; ro360, ro363
					(and (OneOf gCurRoomNum 370 371) (== nIdentity 19)) ; ro370, ro371
					(and (OneOf gCurRoomNum 380 381 387) (== nIdentity 20)) ; ro380, ro381, ro387
					(and (== gCurRoomNum 390) (== nIdentity 21)) ; ro390
					(and
						(OneOf gCurRoomNum 400 401 402 403) ; ro400, ro401, ro402, ro403
						(== nIdentity 13)
					)
					(and (== gCurRoomNum 410) (== nIdentity 14)) ; ro410
					(and (== gCurRoomNum 420) (== nIdentity 16)) ; ro420
					(and (OneOf gCurRoomNum 430 432 433) (== nIdentity 10)) ; ro430, ro432, ro433
					(and (== gCurRoomNum 440) (== nIdentity 15)) ; ro440
					(and (OneOf gCurRoomNum 500 501) (== nIdentity 22)) ; ro500, ro501
					(and (OneOf gCurRoomNum 510 511) (== nIdentity 26)) ; ro510, roLiarsRoom
					(and (OneOf gCurRoomNum 520 521) (== nIdentity 23)) ; ro520, ro521
					(and (OneOf gCurRoomNum 530 531) (== nIdentity 25)) ; ro530, ro531
					(and (== gCurRoomNum 540) (== nIdentity 7)) ; ro540
					(and (OneOf gCurRoomNum 550 551) (== nIdentity 24)) ; ro550, ro551
				)
				(= temp0 (MakeMessageText 0 0 6 1 90)) ; "You Are Here!"
			else
				(= temp0 (MakeMessageText noun 0 0 1 90))
			)
			(if temp0
				(voDestination setString: temp0)
				(temp0 dispose:)
				(= temp0 0)
			)
			(voHighlight loop: nIdentity cel: 0 show:)
			(voThumbnail loop: nIdentity cel: nThumb show:)
		)
	)

	(method (doVerb)
		(if (and (== gCurRoomNum 511) (!= nNewRoom 511)) ; roLiarsRoom
			(if local0
				(gCurRoom setScript: soLeave 0 self)
			else
				(= local0 1)
				(gMessager say: 0 0 5 0 0 90) ; "I'm tired of playing this game, Dewmi. Do you mind if I leave now?"
			)
		else
			(gCurRoom newRoom: nNewRoom)
			(= isHighlighted 0)
			(if (== gNewRoomNum gCurRoomNum)
				(oTravelScreen dispose:)
			)
		)
	)
)

(instance voDestination of TextItem
	(properties
		x 507
		y 436
		fixPriority 1
		font 2510
		maxWidth 120
		nMinWidth 120
	)

	(method (init)
		(= back skip)
		(= priority (+ (oTravelScreen priority:) 1))
		(super init: &rest)
	)
)

(instance voHighlight of View
	(properties
		x 639
		y 479
		view 9550
	)
)

(instance voThumbnail of View
	(properties
		x 517
		y 360
		view 9500
	)
)

(instance voBoningATP of View
	(properties
		x 639
		y 479
		priority 470
		fixPriority 1
		view 9555
	)
)

(instance voDewmiATP of View
	(properties
		x 639
		y 479
		priority 470
		fixPriority 1
		view 9555
		loop 1
	)
)

(instance foBridgeEx of TravelFeature
	(properties
		noun 1
		x 508
		y 87
		nNewRoom 210
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 167 28 135 38 128 48 145 57 185 62 225 48
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foCaptainSuite of TravelFeature
	(properties
		noun 2
		x 508
		y 87
		nNewRoom 220
		nIdentity 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 172 25 227 8 283 28 226 49
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foFocsle of TravelFeature
	(properties
		noun 4
		x 561
		y 252
		nNewRoom 262
		nIdentity 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 125 113 143 106 218 145 175 149 128 142 111 130 123 112
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foPromenadeDeck of TravelFeature
	(properties
		noun 5
		x 508
		y 87
		nNewRoom 260
		nIdentity 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 204 137 336 93 352 101 219 144
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foLounge of TravelFeature
	(properties
		noun 6
		x 508
		y 87
		nNewRoom 240
		nIdentity 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 279 71 336 93 217 131 196 128 165 117 169 109
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foBoardingDeck of TravelFeature
	(properties
		noun 7
		x 508
		y 87
		nNewRoom 230
		nIdentity 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 271 64 304 53 396 84 353 100
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foHorseShoeArea of TravelFeature
	(properties
		noun 15
		x 508
		y 87
		nNewRoom 250
		nIdentity 12
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 392 120 449 99 474 110 444 121 496 139 532 128 563 141 486 169 477 161 478 143 442 130 409 129
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foPoopDeck of TravelFeature
	(properties
		noun 16
		x 508
		y 87
		nNewRoom 255
		nIdentity 11
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 447 121 477 110 526 127 496 137
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foSwimmingPool of TravelFeature
	(properties
		noun 8
		x 508
		y 87
		nNewRoom 301
		nIdentity 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 266 46 240 91 222 188 266 123 288 64 298 8 303 1 304
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foBoningSuite of TravelFeature
	(properties
		noun 9
		x 508
		y 87
		nNewRoom 311
		nIdentity 27
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 111 125 95 134 93 156 104 167 145 176 185 174 221 164 219 154 181 157 148 153 126 149 112 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foRestaurant of TravelFeature
	(properties
		noun 11
		x 567
		y 62
		nNewRoom 330
		nIdentity 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 198 191 303 156 395 188 289 225
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foLobbyUpper of TravelFeature
	(properties
		noun 13
		x 567
		y 62
		nNewRoom 340
		nIdentity 17
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 403 130 447 135 473 145 477 156 460 167 415 177 376 174 348 163 345 150 350 159 372 149 403 144
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(foLobbyLower doVerb: &rest)
	)
)

(instance foLobbyLower of TravelFeature
	(properties
		noun 13
		x 567
		y 62
		nNewRoom 340
		nIdentity 17
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 367 248 409 242 444 246 472 257 477 267 465 277 438 285 386 287 351 274 344 262
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== gCurRoomNum 250) ; ro250
			((ScriptID 64017 0) set: 313) ; oFlags
		)
		(super doVerb: theVerb)
	)
)

(instance foCasinoLobby of TravelFeature
	(properties
		noun 30
		x 379
		y 140
		nNewRoom 360
		nIdentity 18
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 416 239 445 230 513 253 481 264 469 251 443 244
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foCasino of TravelFeature
	(properties
		noun 19
		x 432
		y 118
		nNewRoom 370
		nIdentity 19
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 433 224 485 208 506 216 529 208 572 224 552 230 579 241 530 259
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foBreakRoom of TravelFeature
	(properties
		noun 20
		x 534
		y 99
		nNewRoom 380
		nIdentity 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 487 206 508 199 524 206 509 214
					yourself:
				)
		)
		(super init: &rest)
		(if ((ScriptID 64017 0) test: 95) ; oFlags
			(= nThumb 1)
		)
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 95) ; oFlags
			(= nNewRoom 380)
		else
			(= nNewRoom 381)
		)
		(super doVerb:)
	)
)

(instance foBowling of TravelFeature
	(properties
		noun 22
		x 534
		y 99
		nNewRoom 390
		nIdentity 21
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 511 198 550 186 639 217 601 232
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foBallroom of TravelFeature
	(properties
		noun 17
		x 534
		y 99
		nNewRoom 402
		nIdentity 13
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 143 322 236 355 109 396 29 364
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foLuvMaster of TravelFeature
	(properties
		noun 18
		x 314
		y 233
		nNewRoom 410
		nIdentity 14
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 160 318 175 313 213 325 196 331
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foCookOff of TravelFeature
	(properties
		noun 21
		x 429
		y 184
		nNewRoom 420
		nIdentity 16
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 265 318 303 330 286 338 247 324
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foLibrary of TravelFeature
	(properties
		noun 14
		x 494
		y 156
		nNewRoom 430
		nIdentity 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 362 130 382 123 399 130 400 141 372 147 369 134
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foBestDressed of TravelFeature
	(properties
		noun 29
		x 429
		y 184
		nNewRoom 440
		nIdentity 15
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 293 251 287 286 300 268 307
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foPinSetter of TravelFeature
	(properties
		noun 26
		x 429
		y 184
		nNewRoom 500
		nIdentity 22
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 610 241 614 263 638 255 638 229
					yourself:
				)
		)
		(super init: &rest)
		(if ((ScriptID 64017 0) test: 129) ; oFlags
			(= nThumb 1)
		)
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 129) ; oFlags
			(= nNewRoom 500)
		else
			(= nNewRoom 501)
		)
		(super doVerb:)
	)
)

(instance foDewmiCabin of TravelFeature
	(properties
		noun 24
		x 309
		y 318
		nNewRoom 510
		nIdentity 26
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 233 395 261 387 262 406 233 415
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(cond
			((OneOf gCurRoomNum 510 511) ; ro510, roLiarsRoom
				(oTravelScreen dispose:)
			)
			(((ScriptID 64017 0) test: 131) ; oFlags
				(super doVerb:)
			)
			((gEgo has: ((ScriptID 64037 0) get: 52)) ; oInvHandler, ioMoney
				(gMessager say: 24 0 3 0 oCueMe 90) ; "Who is it?"
			)
			(else
				(gMessager say: 24 0 2 0 0 90) ; "Who is it?"
			)
		)
	)
)

(instance oCueMe of CueMe
	(properties)

	(method (cue)
		(gCurRoom newRoom: (foDewmiCabin nNewRoom:))
		(TravelFeature isHighlighted: 0)
	)
)

(instance foBeaverHold of TravelFeature
	(properties
		noun 27
		x 194
		y 409
		nNewRoom 520
		nIdentity 23
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 599 274 638 257 638 286 597 302
					yourself:
				)
		)
		(super init: &rest)
		(if ((ScriptID 64017 0) test: 133) ; oFlags
			(= nThumb 1)
		)
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 133) ; oFlags
			(= nNewRoom 520)
		else
			(= nNewRoom 521)
		)
		(super doVerb:)
	)
)

(instance foLuggageHold of TravelFeature
	(properties
		noun 23
		x 194
		y 409
		nNewRoom 530
		nIdentity 25
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 191 477 308 439 314 458 254 479
					yourself:
				)
		)
		(super init: &rest)
		(if ((ScriptID 64017 0) test: 135) ; oFlags
			(= nThumb 1)
		)
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 135) ; oFlags
			(= nNewRoom 530)
		else
			(= nNewRoom 531)
		)
		(super doVerb:)
	)
)

(instance foKitchen of TravelFeature
	(properties
		noun 10
		x 469
		y 299
		nNewRoom 540
		nIdentity 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 122 217 196 193 287 226 216 250
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foLarryRoom of TravelFeature
	(properties
		noun 25
		x 561
		y 252
		nNewRoom 550
		nIdentity 24
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 546 330 556 328 556 345 545 347
					yourself:
				)
		)
		(super init: &rest)
		(if ((ScriptID 64017 0) test: 157) ; oFlags
			(= nThumb 1)
		)
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 157) ; oFlags
			(= nNewRoom 550)
		else
			(= nNewRoom 551)
		)
		(super doVerb:)
	)
)

(instance foPurserDesk of TravelFeature
	(properties
		noun 12
		x 561
		y 252
		nNewRoom 341
		nIdentity 9
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 331 140 361 131 368 136 369 147 349 157 346 147
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foOpaque of OpaqueFeature
	(properties
		nsRight 639
		nsBottom 479
	)
)

(instance foExit of CUExitFeature
	(properties)

	(method (doVerb)
		(oTravelScreen dispose:)
	)
)

(instance soLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: ((ScriptID 64037 0) get: 52)) ; oInvHandler, ioMoney
				(gMessager say: 0 0 4 0 self 90) ; "Okay. See you around."
			)
			(1
				(register isHighlighted: 0)
				(gCurRoom newRoom: (register nNewRoom:))
				(self dispose:)
			)
		)
	)
)

