;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Button)
(use QuadFeature)
(use PQSlider)
(use Actor)
(use System)

(public
	rm200 0
)

(instance rm200 of GalleryRoom
	(properties
		picture 200
		infoRoomSignal 1048
	)

	(method (init)
		(Load rsAUDIO 10001)
		(Lock rsAUDIO 10001 1)
		(Load rsVIEW 2025)
		(Load rsVIEW 13)
		(if (IsFlag 31)
			(= global108 0)
			(SetFlag 15)
			(SetFlag 12)
			(SetFlag 72)
		)
		((= gCast (Cast new:)) add:)
		(gCast
			add:
				g45Light
				magJHP45
				magFMJ45
				mp5
				magSTHP9
				magFMJ9
				m16
				gauge12
				buck12Gauge
				slug12Guage
				flashBang
				mirror
				batteringRam
				headSet
				vest
				belt
				gasMask
				helmet
				hood
				gloves
				shield
		)
		(super init: &rest)
		(gBackMusic number: 10001 setLoop: -1 play:)
		(= gear_butn (gearButn init: yourself:))
		(= detail_butn (detailButn init: yourself:))
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
	)

	(method (setHilite param1 param2)
		(super setHilite: param1)
		(if (and (or (< argc 2) param2) (param1 noun:))
			(gMessager say: (param1 noun:) 0 2)
		)
	)

	(method (showDetail param1 &tmp temp0)
		(= temp0 0)
		(cond
			((OneOf param1 batteringRam mirror hood gloves)
				(gMessager say: 19 0 1 1) ; "No further details are available at this time."
			)
			((== param1 gauge12)
				(if
					(and
						(= temp0 (super showDetail: gauge12 &rest))
						param1
						(param1 noun:)
						(Message msgGET gCurRoomNum (param1 noun:) 0 3 1)
					)
					0
				)
			)
			(
				(and
					(= temp0 (super showDetail: param1 &rest))
					param1
					(param1 noun:)
					(Message msgGET gCurRoomNum (param1 noun:) 0 3 1)
				)
				(gMessager say: (param1 noun:) 0 3)
			)
		)
		(return temp0)
	)

	(method (dispose)
		(Lock rsAUDIO 10001 0)
		(gBackMusic fade: 0 2 21 1)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (OneOf newRoomNumber 205 195) (not (IsFlag 31)))
			(gMessager say: 25 0 16) ; "Selection of your tactical gear is required at this time."
		else
			(ClearFlag 12)
			(ClearFlag 15)
			(ClearFlag 72)
			(super newRoom: newRoomNumber &rest)
		)
	)

	(method (slideGalPlane param1)
		(super slideGalPlane: param1)
		(if (< argc 2)
			(sliderObj adjust: param1)
		)
	)
)

(instance classified of Prop ; UNUSED
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
		x 553
		y 129
		view 2025
		loop 1
		keyMessage 100
	)

	(method (doVerb)
		(if (gCurRoom showDetail: (gCurRoom curItem:))
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
				(headSet
					(gCurRoom showPropAni: 2003 1 0)
				)
				(magFMJ45
					(gCurRoom showPropAni: 2030 0 0)
				)
				(magSTHP9
					(gCurRoom showPropAni: 2031 0 0)
				)
				(magFMJ9
					(gCurRoom showPropAni: 2030 0 0)
				)
				(g45Light
					(gCurRoom setDetailView: (temp0 mView:) 1 (temp0 mCel:))
				)
				(belt
					(gCurRoom setDetailView: (temp0 mView:) 1 (temp0 mCel:))
				)
				(gasMask
					(gCurRoom setDetailView: (temp0 mView:) 1 (temp0 mCel:))
				)
				(mp5
					(gCurRoom setDetailView: (temp0 mView:) 1 (temp0 mCel:))
				)
				(gauge12
					(gCurRoom setDetailView: (temp0 mView:) 1 (temp0 mCel:))
				)
				(m16
					(gCurRoom setDetailView: (temp0 mView:) 1 (temp0 mCel:))
				)
				(vest
					(gCurRoom
						setDetailView:
							(temp0 mView:)
							(if (vest scratch:) 6 else 1)
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
				(vest
					(= temp1 (if (vest scratch:) 12 else 8))
				)
				(else
					(= temp1 4)
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
				(headSet
					(gCurRoom showPropAni: 2003 2 0)
				)
				(mp5
					(gCurRoom showPropAni: 2012 3 0)
				)
				(gauge12
					(gCurRoom showPropAni: 2013 2 0)
				)
				(g45Light
					(gCurRoom setDetailView: (temp0 mView:) 2 (temp0 mCel:))
				)
				(belt
					(gCurRoom setDetailView: (temp0 mView:) 2 (temp0 mCel:))
				)
				(gasMask
					(gCurRoom setDetailView: (temp0 mView:) 2 (temp0 mCel:))
				)
				(m16
					(gCurRoom setDetailView: (temp0 mView:) 2 (temp0 mCel:))
				)
				(vest
					(gCurRoom
						setDetailView:
							(temp0 mView:)
							(if (vest scratch:) 7 else 2)
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
				(vest
					(= temp1 (if (vest scratch:) 13 else 9))
				)
				(else
					(= temp1 5)
				)
			)
			(if (and (temp0 noun:) (Message msgGET gCurRoomNum (temp0 noun:) 0 temp1 1))
				(gMessager say: (temp0 noun:) 0 temp1)
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
				(headSet
					(gCurRoom showPropAni: 2003 3 0)
				)
				(mp5
					(gCurRoom showPropAni: 2012 2 0)
				)
				(gauge12
					(gCurRoom setDetailView: (temp0 mView:) 3 (temp0 mCel:))
				)
				(g45Light
					(gCurRoom setDetailView: (temp0 mView:) 3 (temp0 mCel:))
				)
				(belt
					(gCurRoom setDetailView: (temp0 mView:) 3 (temp0 mCel:))
				)
				(gasMask
					(gCurRoom setDetailView: (temp0 mView:) 3 (temp0 mCel:))
				)
				(m16
					(gCurRoom setDetailView: (temp0 mView:) 3 (temp0 mCel:))
				)
				(vest
					(gCurRoom
						setDetailView:
							(temp0 mView:)
							(if (vest scratch:) 8 else 3)
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
				(vest
					(= temp1 (if (vest scratch:) 14 else 10))
				)
				(else
					(= temp1 6)
				)
			)
			(if (and (temp0 noun:) (Message msgGET gCurRoomNum (temp0 noun:) 0 temp1 1))
				(gMessager say: (temp0 noun:) 0 temp1)
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
				(vest
					(if (vest scratch:)
						(gCurRoom setDetailView: (temp0 mView:) 9 (temp0 mCel:))
						(flipJacket show:)
					else
						(flipJacket hide:)
						(gCurRoom showPropAni: 2011 0 0)
					)
				)
				(headSet
					(gCurRoom showVMD: 2041 headSet)
				)
				(gasMask
					(gCurRoom setDetailView: 2033 0 0)
				)
				(mp5
					(gCurRoom showVMD: 201 mp5)
				)
				(gauge12
					(gCurRoom setDetailView: (temp0 mView:) 4 (temp0 mCel:))
				)
				(g45Light
					(gCurRoom setDetailView: (temp0 mView:) 4 (temp0 mCel:))
				)
				(belt
					(gCurRoom setDetailView: (temp0 mView:) 4 (temp0 mCel:))
				)
				(m16
					(gCurRoom setDetailView: (temp0 mView:) 4 (temp0 mCel:))
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
				(vest
					(= temp1 (if (vest scratch:) 15 else 11))
				)
				(flashBang
					(= temp1 11)
				)
				(else
					(= temp1 7)
				)
			)
			(if (and (temp0 noun:) (Message msgGET gCurRoomNum (temp0 noun:) 0 temp1 1))
				(gMessager say: (temp0 noun:) 0 temp1)
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
		(if (not (SetFlag 31))
			(= global108 0)
			((ScriptID 19 0) doit:) ; swatInvInit
			(SetFlag 15)
			(SetFlag 12)
			(SetFlag 72)
			(gSwatInterface showInterface:)
		)
	)
)

(instance g45Light of GalleryView
	(properties
		noun 2
		view 2001
		hCel 1
		mView 3001
		mLoop 0
		mCel 0
	)
)

(instance magJHP45 of GalleryView
	(properties
		noun 6
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

(instance magFMJ45 of GalleryView
	(properties
		noun 7
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

(instance mp5 of GalleryView
	(properties
		noun 3
		view 2000
		hCel 1
		mView 2012
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance magSTHP9 of GalleryView
	(properties
		noun 8
		view 2000
		loop 6
		hCel 1
		mView 2018
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance magFMJ9 of GalleryView
	(properties
		noun 9
		view 2000
		loop 7
		hCel 1
		mView 2019
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance m16 of GalleryView
	(properties
		noun 26
		view 2000
		loop 13
		hCel 1
		mView 2026
		mLoop 0
		mCel 0
	)
)

(instance gauge12 of GalleryView
	(properties
		noun 4
		view 2000
		loop 1
		hCel 1
		mView 2013
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)

	(method (setupDetail)
		(gCurRoom setScript: showGun)
	)
)

(instance buck12Gauge of GalleryView
	(properties
		noun 5
		view 2000
		loop 2
		hCel 1
		mView 2014
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance slug12Guage of GalleryView
	(properties
		noun 24
		view 2000
		loop 3
		hCel 1
		mView 2015
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance flashBang of GalleryView
	(properties
		noun 23
		view 2000
		loop 9
		hCel 1
		mView 2021
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance mirror of GalleryView
	(properties
		noun 18
		view 2000
		loop 11
		hCel 1
	)

	(method (init)
		(super init: &rest)
	)
)

(instance batteringRam of GalleryView
	(properties
		noun 16
		view 2000
		loop 12
		hCel 1
		mView 2024
		mLoop 0
		mCel 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance headSet of GalleryView
	(properties
		noun 12
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

(instance vest of GalleryView
	(properties
		noun 13
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
			(gCurRoom setDetailView: view 0 cel)
			(self upCel: 0 downCel: 1)
			(vest scratch: 0)
		else
			(gCurRoom setDetailView: view 5 cel)
			(self upCel: 2 downCel: 3)
			(vest scratch: 1)
		)
		(self cel: upCel)
		(UpdateScreenItem self)
		(UpdateScreenItem (gCurRoom detailProp:))
	)
)

(instance belt of GalleryView
	(properties
		noun 14
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

(instance gasMask of GalleryView
	(properties
		noun 15
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

(instance helmet of GalleryView
	(properties
		noun 22
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

(instance hood of GalleryView
	(properties
		noun 20
		view 2001
		loop 7
		hCel 1
	)

	(method (init)
		(super init: &rest)
	)
)

(instance gloves of GalleryView
	(properties
		noun 19
		view 2001
		loop 8
		hCel 1
	)

	(method (init)
		(super init: &rest)
	)
)

(instance shield of GalleryView
	(properties
		noun 21
		view 2000
		loop 10
		hCel 1
		mView 2022
		mLoop 0
		mCel 0
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

(instance showGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 0 3 1 self) ; "The Benelli Super-90 semi-automatic shotgun has rifle-type sights on a nineteen and three quarter inch barrel with a cylinder-bore choke and a seven round magazine."
			)
			(1
				(gCurRoom showVMD: 200 gauge12)
				(= cycles 1)
			)
			(2
				(gMessager say: 4 0 3 3 self) ; "To enhance the tactical officer's performance with the shotgun in low-light situations D Platoon armorers mount a SureFire light assembly on to the weapon."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

