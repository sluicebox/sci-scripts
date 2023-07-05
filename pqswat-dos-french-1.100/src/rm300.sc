;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use Button)
(use QuadFeature)
(use PQSlider)
(use Actor)
(use System)

(public
	rm300 0
)

(instance rm300 of GalleryRoom
	(properties
		picture 200
		infoRoomSignal 40
	)

	(method (init)
		(Load rsAUDIO 10001)
		(Lock rsAUDIO 10001 1)
		(Load rsVIEW 2025)
		(Load rsVIEW 999)
		(Load rsVIEW 10)
		(Load rsVIEW 38)
		(Load rsVIEW 23)
		(Load rsVIEW 46)
		(if (IsFlag 32)
			(= global108 1)
			(SetFlag 15)
			(SetFlag 12)
			(SetFlag 72)
		)
		((= gCast (Cast new:)) add:)
		(gCast
			add:
				giGovt45
				giJHP45Mag
				giFMJ45Mag
				giRobar308
				giFederal308
				giGasGun
				giGasRound
				giGasGrenade
				giDopeBook
				giGhilleSuit
				giHeadset
				giVest
				giBelt
				giGasMask
				giHelmet
				giHood
				giGloves
		)
		(super init: &rest)
		(gBackMusic number: 10001 setLoop: -1 play:)
		(gearButn init:)
		(detailButn init:)
		(upArrowButn init:)
		(rightArrowButn init:)
		(downArrowButn init:)
		(leftArrowButn init:)
		(middleButn init:)
		(selectButn init:)
		(scrollUpButn init:)
		(scrollDownButn init:)
		(sliderObj init: setup:)
		(gGame handsOn:)
		(if (== gPrevRoomNum 320)
			(SetFlag 106)
		)
	)

	(method (setHilite param1 param2)
		(super setHilite: param1)
		(if (and (or (< argc 2) param2) (param1 noun:))
			(if (== param1 giGloves)
				(gMessager say: (param1 noun:) 0 4)
			else
				(gMessager say: (param1 noun:) 0 3)
			)
		)
	)

	(method (showDetail param1)
		(cond
			((OneOf param1 giGasGrenade giGasGun giGasRound)
				(classified
					x:
						(+
							(param1 x:)
							(/ (CelWide (param1 view:) (param1 loop:) 1) 2)
						)
					y:
						(+
							(param1 y:)
							(/ (CelHigh (param1 view:) (param1 loop:) 1) 2)
						)
					setPri: 1000
					init: (((gCurRoom gPlane:) casts:) at: 0)
				)
				(gMessager say: 10 0 4 0 classified) ; "No further details are available at this time."
			)
			((OneOf param1 giGloves giHood)
				(gMessager say: 10 0 4 0) ; "No further details are available at this time."
			)
			(
				(and
					(super showDetail: param1 &rest)
					param1
					(param1 noun:)
					(Message msgGET gCurRoomNum (param1 noun:) 0 2 1)
				)
				(gMessager say: (param1 noun:) 0 2)
			)
		)
	)

	(method (dispose)
		(Lock rsAUDIO 10001 0)
		(gBackMusic fade: 0 2 21 1)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 100)
			(ClearFlag 32)
		)
		(cond
			((and (not (IsFlag 32)) (or (== newRoomNumber 310) (== newRoomNumber 320)))
				(gMessager say: 1 0 1) ; "Selection of your tactical gear is required at this time."
			)
			((and (IsFlag 21) (not (IsFlag 53)) (== newRoomNumber 310))
				(ClearFlag 72)
				(super newRoom: 320 &rest)
			)
			((and (IsFlag 54) (!= gPrevRoomNum 315))
				(SetFlag 55)
				(ClearFlag 15)
				(ClearFlag 12)
				(ClearFlag 72)
				(super newRoom: newRoomNumber &rest)
			)
			((and (IsFlag 106) (== newRoomNumber 320))
				(ClearFlag 32)
				(ClearFlag 106)
				(SetFlag 80)
				(ClearFlag 15)
				(ClearFlag 12)
				(ClearFlag 72)
				(super newRoom: newRoomNumber &rest)
			)
			(else
				(ClearFlag 15)
				(ClearFlag 12)
				(ClearFlag 72)
				(super newRoom: newRoomNumber &rest)
			)
		)
	)

	(method (slideGalPlane param1)
		(super slideGalPlane: param1)
		(if (< argc 2)
			(sliderObj adjust: param1)
		)
	)
)

(instance classified of Prop
	(properties
		view 2008
	)

	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance gearButn of Button
	(properties
		x 552
		y 84
		view 2025
		keyMessage 103
	)

	(method (doVerb)
		(if (gCurRoom showGear:)
			(scrollUpButn setActive: 1)
			(scrollDownButn setActive: 1)
			(sliderObj active: 1)
		)
	)
)

(instance detailButn of Button
	(properties
		x 552
		y 129
		view 2025
		loop 1
		keyMessage 100
	)

	(method (doVerb)
		(if
			(and
				(gCurRoom showDetail: (gCurRoom curItem:))
				(not
					(OneOf
						(gCurRoom curItem:)
						giGloves
						giHood
						giGasGrenade
						giGasGun
						giGasRound
					)
				)
			)
			(scrollUpButn setActive: 0)
			(scrollDownButn setActive: 0)
			(sliderObj active: 0)
		)
	)
)

(instance upArrowButn of Button
	(properties
		x 582
		y 189
		view 2025
		loop 5
		keyMessage 1
	)

	(method (doVerb &tmp temp0 temp1)
		(if (gCurRoom magnified:)
			(switch
				(= temp0
					((gCurRoom detailList:)
						at: (- ((gCurRoom detailList:) size:) 1)
					)
				)
				(giVest
					(= temp1 (if (giVest scratch:) 13 else 17))
				)
				(giRobar308
					(= temp1 (if (giRobar308 scratch:) 9 else 5))
				)
				(else
					(= temp1 5)
				)
			)
			(switch temp0
				(giGovt45
					(gCurRoom setDetailView: (temp0 mView:) 1 (temp0 mCel:))
				)
				(giGasMask
					(gCurRoom setDetailView: (temp0 mView:) 1 (temp0 mCel:))
				)
				(giBelt
					(gCurRoom setDetailView: (temp0 mView:) 1 (temp0 mCel:))
				)
				(giFMJ45Mag
					(gCurRoom showPropAni: 2030 0 0)
				)
				(giHeadset
					(gCurRoom showPropAni: 2003 1 0)
				)
				(giGhilleSuit
					(gCurRoom setDetailView: 3017 0 0)
				)
				(giFederal308
					(gCurRoom showPropAni: 3003 1 0)
				)
				(giRobar308
					(cond
						(((gCurRoom gCast:) contains: flipRifle)
							(gCurRoom setDetailView: 3018 1 0)
						)
						((not (giRobar308 scratch:))
							(flipRifle init: (gCurRoom gCast:))
							(giRobar308 scratch: 1)
							(gCurRoom setDetailView: 3018 0 0)
						)
						(else
							(gCurRoom
								setDetailView: (temp0 mView:) 0 (temp0 mCel:)
							)
						)
					)
				)
				(giVest
					(gCurRoom
						setDetailView:
							(temp0 mView:)
							(if (giVest scratch:) 6 else 1)
							(temp0 mCel:)
					)
					(flipJacket show:)
				)
				(else
					(gCurRoom
						setDetailView:
							(temp0 mView:)
							(temp0 mLoop:)
							(temp0 mCel:)
					)
				)
			)
			(if (and (temp0 noun:) (Message msgGET gCurRoomNum (temp0 noun:) 0 temp1 1))
				(gMessager say: (temp0 noun:) 0 temp1)
			)
		else
			(gCurRoom moveHilite: 0 -1)
		)
	)
)

(instance rightArrowButn of Button
	(properties
		x 602
		y 196
		view 2025
		loop 6
		keyMessage 3
	)

	(method (doVerb &tmp temp0 temp1)
		(if (gCurRoom magnified:)
			(switch
				(= temp0
					((gCurRoom detailList:)
						at: (- ((gCurRoom detailList:) size:) 1)
					)
				)
				(giGovt45
					(gCurRoom setDetailView: (temp0 mView:) 2 (temp0 mCel:))
				)
				(giRobar308
					(if (not (giRobar308 scratch:))
						(gCurRoom setDetailView: (temp0 mView:) 2 (temp0 mCel:))
					else
						(gCurRoom setDetailView: 3018 2 0)
					)
				)
				(giGasMask
					(gCurRoom setDetailView: (temp0 mView:) 2 (temp0 mCel:))
				)
				(giBelt
					(gCurRoom setDetailView: (temp0 mView:) 2 (temp0 mCel:))
				)
				(giHeadset
					(gCurRoom showPropAni: 2003 2 0)
				)
				(giFederal308
					(gCurRoom showPropAni: 3003 2 0)
				)
				(giGhilleSuit
					(gCurRoom setDetailView: 3027 0 0)
				)
				(giVest
					(gCurRoom
						setDetailView:
							(temp0 mView:)
							(if (giVest scratch:) 7 else 2)
							(temp0 mCel:)
					)
					(flipJacket show:)
				)
				(else
					(gCurRoom
						setDetailView:
							(temp0 mView:)
							(temp0 mLoop:)
							(temp0 mCel:)
					)
				)
			)
			(switch temp0
				(giVest
					(= temp1 (if (giVest scratch:) 14 else 18))
				)
				(giRobar308
					(= temp1 (if (giRobar308 scratch:) 10 else 6))
				)
				(else
					(= temp1 6)
				)
			)
			(if
				(and
					(temp0 noun:)
					(or
						(Message msgGET gCurRoomNum (temp0 noun:) 0 temp1 1)
						(Message msgGET gCurRoomNum (temp0 noun:) 0 temp1 2)
					)
				)
				(if (== temp0 giDopeBook)
					(gMessager say: (temp0 noun:) 0 temp1 2)
				else
					(gMessager say: (temp0 noun:) 0 temp1)
				)
			)
		else
			(gCurRoom moveHilite: 1 0)
		)
	)
)

(instance downArrowButn of Button
	(properties
		x 584
		y 213
		view 2025
		loop 7
		keyMessage 5
	)

	(method (doVerb &tmp temp0 temp1)
		(if (gCurRoom magnified:)
			(switch
				(= temp0
					((gCurRoom detailList:)
						at: (- ((gCurRoom detailList:) size:) 1)
					)
				)
				(giGovt45
					(gCurRoom setDetailView: (temp0 mView:) 3 (temp0 mCel:))
				)
				(giRobar308
					(if (not (giRobar308 scratch:))
						(gCurRoom setDetailView: (temp0 mView:) 3 (temp0 mCel:))
					else
						(gCurRoom setDetailView: 3018 3 0)
					)
				)
				(giGasMask
					(gCurRoom setDetailView: (temp0 mView:) 3 (temp0 mCel:))
				)
				(giBelt
					(gCurRoom setDetailView: (temp0 mView:) 3 (temp0 mCel:))
				)
				(giHeadset
					(gCurRoom showPropAni: 2003 3 0)
				)
				(giVest
					(gCurRoom
						setDetailView:
							(temp0 mView:)
							(if (giVest scratch:) 8 else 3)
							(temp0 mCel:)
					)
					(flipJacket show:)
				)
				(else
					(gCurRoom
						setDetailView:
							(temp0 mView:)
							(temp0 mLoop:)
							(temp0 mCel:)
					)
				)
			)
			(switch temp0
				(giVest
					(= temp1 (if (giVest scratch:) 15 else 19))
				)
				(giRobar308
					(= temp1 (if (giRobar308 scratch:) 11 else 21))
				)
				(else
					(= temp1 21)
				)
			)
			(if
				(and
					(temp0 noun:)
					(or
						(Message msgGET gCurRoomNum (temp0 noun:) 0 temp1 1)
						(Message msgGET gCurRoomNum (temp0 noun:) 0 temp1 3)
					)
				)
				(if (== temp0 giDopeBook)
					(gMessager say: (temp0 noun:) 0 temp1 3)
				else
					(gMessager say: (temp0 noun:) 0 temp1)
				)
			)
		else
			(gCurRoom moveHilite: 0 1)
		)
	)
)

(instance leftArrowButn of Button
	(properties
		x 578
		y 196
		view 2025
		loop 8
		keyMessage 7
	)

	(method (doVerb &tmp temp0 temp1)
		(if (gCurRoom magnified:)
			(switch
				(= temp0
					((gCurRoom detailList:)
						at: (- ((gCurRoom detailList:) size:) 1)
					)
				)
				(giGovt45
					(gCurRoom setDetailView: (temp0 mView:) 4 (temp0 mCel:))
				)
				(giRobar308
					(if (not (giRobar308 scratch:))
						(gCurRoom setDetailView: (temp0 mView:) 4 (temp0 mCel:))
					else
						(gCurRoom setDetailView: 3018 4 0)
					)
				)
				(giBelt
					(gCurRoom setDetailView: (temp0 mView:) 4 (temp0 mCel:))
				)
				(giGasMask
					(gCurRoom setDetailView: 2033 0 0)
				)
				(giHeadset
					(gCurRoom showVMD: 2041 giHeadset)
				)
				(giFederal308
					(gCurRoom showPropAni: 3013 0 0)
				)
				(giVest
					(if (giVest scratch:)
						(gCurRoom setDetailView: (temp0 mView:) 9 (temp0 mCel:))
						(flipJacket show:)
					else
						(flipJacket hide:)
						(gCurRoom showPropAni: 2011 0 0)
					)
				)
				(else
					(gCurRoom
						setDetailView:
							(temp0 mView:)
							(temp0 mLoop:)
							(temp0 mCel:)
					)
				)
			)
			(switch temp0
				(giVest
					(= temp1 (if (giVest scratch:) 16 else 20))
				)
				(giRobar308
					(= temp1 (if (giRobar308 scratch:) 12 else 8))
				)
				(else
					(= temp1 8)
				)
			)
			(if
				(and
					(temp0 noun:)
					(or
						(Message msgGET gCurRoomNum (temp0 noun:) 0 temp1 1)
						(Message msgGET gCurRoomNum (temp0 noun:) 0 temp1 2)
						(Message msgGET gCurRoomNum (temp0 noun:) 0 temp1 4)
					)
				)
				(cond
					((== temp0 giDopeBook)
						(gMessager say: (temp0 noun:) 0 temp1 4)
					)
					((and (== temp0 giVest) (giVest scratch:))
						(gMessager say: (temp0 noun:) 0 temp1 2)
					)
					(else
						(gMessager say: (temp0 noun:) 0 temp1)
					)
				)
			)
		else
			(gCurRoom moveHilite: -1 0)
		)
	)
)

(instance middleButn of Button
	(properties
		x 580
		y 192
		view 2025
		loop 4
		keyMessage 0
	)

	(method (doVerb))
)

(instance selectButn of Button
	(properties
		x 552
		y 256
		view 2025
		loop 2
	)

	(method (doVerb)
		(if (not (SetFlag 32))
			(= global108 1)
			((ScriptID 19 0) doit:) ; swatInvInit
			(SetFlag 15)
			(SetFlag 12)
			(SetFlag 72)
			(gSwatInterface showInterface:)
		)
	)
)

(instance giGovt45 of GalleryView
	(properties
		noun 5
		view 2001
		hCel 1
		mView 3001
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giJHP45Mag of GalleryView
	(properties
		noun 19
		view 2000
		loop 4
		hCel 1
		mView 2016
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giFMJ45Mag of GalleryView
	(properties
		noun 20
		view 2000
		loop 5
		hCel 1
		mView 2017
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giRobar308 of GalleryView
	(properties
		noun 6
		view 3000
		loop 1
		hCel 1
		mView 3002
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)

	(method (setupDetail))

	(method (clearDetail)
		(flipRifle dispose:)
		(= scratch 0)
	)
)

(instance flipRifle of Button
	(properties
		view 3014
	)

	(method (init)
		(self upCel: 0 downCel: 1 setPri: 600)
		(super init: &rest)
	)

	(method (doVerb)
		(flipRifle hide:)
		((gCurRoom detailProp:) setCycle: 0)
		(if (giRobar308 scratch:)
			(giRobar308 scratch: 0)
			(gCurRoom setDetailView: 3002 0 0)
		)
		(UpdateScreenItem (gCurRoom detailProp:))
		(flipRifle dispose:)
	)
)

(instance giFederal308 of GalleryView
	(properties
		noun 7
		view 3000
		loop 2
		hCel 1
		mView 3003
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giGasGun of GalleryView
	(properties
		noun 13
		view 3000
		loop 3
		hCel 1
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giGasRound of GalleryView
	(properties
		noun 3
		view 3000
		loop 5
		hCel 1
		mView 3005
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giGasGrenade of GalleryView
	(properties
		noun 9
		view 3000
		loop 4
		hCel 1
		mView 3006
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giGhilleSuit of GalleryView
	(properties
		noun 4
		view 3000
		loop 6
		hCel 1
		mView 3007
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giDopeBook of GalleryView
	(properties
		noun 14
		view 3000
		loop 7
		hCel 1
		mView 3008
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giHeadset of GalleryView
	(properties
		noun 17
		view 2001
		loop 2
		hCel 1
		mView 2003
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giVest of GalleryView
	(properties
		noun 16
		view 2001
		loop 3
		hCel 1
		mView 2004
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)

	(method (setupDetail)
		(flipJacket init: (gCurRoom gCast:))
	)

	(method (clearDetail)
		(flipJacket dispose:)
		(= scratch 0)
	)
)

(instance flipJacket of Button
	(properties
		view 2004
		loop 10
	)

	(method (init)
		(self upCel: 0 downCel: 1)
		(super init: &rest)
	)

	(method (doVerb)
		((gCurRoom detailProp:) setCycle: 0)
		(if upCel
			(giVest scratch: 0)
			(gCurRoom setDetailView: view 0 cel)
			(self upCel: 0 downCel: 1)
		else
			(giVest scratch: 1)
			(gCurRoom setDetailView: view 5 cel)
			(self upCel: 2 downCel: 3)
		)
		(self cel: upCel)
		(UpdateScreenItem self)
		(UpdateScreenItem (gCurRoom detailProp:))
	)
)

(instance giBelt of GalleryView
	(properties
		noun 2
		view 2001
		loop 4
		hCel 1
		mView 2005
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giGasMask of GalleryView
	(properties
		noun 8
		view 2001
		loop 5
		hCel 1
		mView 2006
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giHelmet of GalleryView
	(properties
		noun 12
		view 2001
		loop 6
		hCel 1
		mView 2007
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giHood of GalleryView
	(properties
		noun 10
		view 2001
		loop 7
		hCel 1
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giGloves of GalleryView
	(properties
		noun 11
		view 2001
		loop 8
		hCel 1
	)

	(method (init)
		(super init: &rest)
	)
)

(instance sliderObj of PQSlider
	(properties
		x 518
		view 2025
		loop 3
		topY 46
		bottomY 305
	)

	(method (setup)
		(super setup:)
		(= dataBottom (- (gCurRoom galNumPages:) 1))
		(= dataStep 1)
	)

	(method (updateData)
		(super updateData: &rest)
		(gCurRoom slideGalPlane: (- (+ dataCur 1) (gCurRoom galCurPage:)) 1)
	)
)

(instance scrollUpButn of Button
	(properties
		x 521
		y 26
		view 2025
		loop 9
		keyMessage 2
	)

	(method (setActive param1)
		(if (or (not argc) param1)
			(self active: 1)
		else
			(self active: 0)
		)
	)

	(method (doVerb)
		(gCurRoom slideGalPlane: -1)
	)
)

(instance scrollDownButn of Button
	(properties
		x 521
		y 314
		view 2025
		loop 10
		keyMessage 4
	)

	(method (setActive param1)
		(if (or (not argc) param1)
			(self active: 1)
		else
			(self active: 0)
		)
	)

	(method (doVerb)
		(gCurRoom slideGalPlane: 1)
	)
)

