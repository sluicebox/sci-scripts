;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 185)
(include sci.sh)
(use Main)
(use PQRoom)
(use Button)
(use PQSlider)
(use DSelector)
(use Str)
(use Array)
(use Print)
(use Dialog)
(use Motion)
(use Actor)
(use System)

(public
	rm185 0
)

(local
	local0
	local1 = -1
)

(procedure (localproc_0 param1 param2 param3 param4 param5 &tmp temp0)
	(if (not (Message msgGET param4 param1 param2 param3 1))
		(return)
	)
	(= temp0 (Str new: 400))
	(Message msgGET param4 param1 param2 param3 1 (temp0 data:))
	(param5 copy: (temp0 data:))
	(while (Message msgNEXT (temp0 data:))
		(param5 cat: (temp0 data:))
	)
	(temp0 dispose:)
)

(procedure (localproc_1 param1 &tmp temp0)
	(= temp0 (Str new: 50))
	(switch global122
		(1
			(localproc_0 4 21 3 1850 temp0)
			(param1 setText: temp0)
			(localproc_0 6 21 4 1850 temp0)
			(param1 setText: temp0)
			(localproc_0 8 21 5 1850 temp0)
			(param1 setText: temp0)
			(localproc_0 15 21 8 1850 temp0)
			(param1 setText: temp0)
		)
		(2
			(localproc_0 5 21 1 1851 temp0)
			(param1 setText: temp0)
			(localproc_0 3 21 1 1851 temp0)
			(param1 setText: temp0)
			(localproc_0 4 21 1 1851 temp0)
			(param1 setText: temp0)
			(localproc_0 2 21 1 1851 temp0)
			(param1 setText: temp0)
			(localproc_0 1 21 1 1851 temp0)
			(param1 setText: temp0)
		)
		(3
			(localproc_0 2 0 1 1852 temp0)
			(param1 setText: temp0)
			(localproc_0 8 0 1 1852 temp0)
			(param1 setText: temp0)
			(localproc_0 4 0 1 1852 temp0)
			(param1 setText: temp0)
			(localproc_0 6 0 1 1852 temp0)
			(param1 setText: temp0)
			(localproc_0 5 0 1 1852 temp0)
			(param1 setText: temp0)
			(localproc_0 1 0 1 1852 temp0)
			(param1 setText: temp0)
			(localproc_0 7 0 1 1852 temp0)
			(param1 setText: temp0)
		)
		(4
			(localproc_0 4 0 1 1853 temp0)
			(param1 setText: temp0)
			(localproc_0 3 0 1 1853 temp0)
			(param1 setText: temp0)
			(localproc_0 5 0 1 1853 temp0)
			(param1 setText: temp0)
			(localproc_0 6 0 1 1853 temp0)
			(param1 setText: temp0)
		)
	)
	(temp0 dispose:)
	(param1 textList:)
)

(procedure (localproc_2 param1 &tmp temp0 temp1)
	(= temp0 (gGame isHandsOn:))
	(gGame handsOff:)
	(= temp1 (Str new:))
	(switch global122
		(1
			(switch param1
				(0
					(localproc_0 5 21 3 1850 temp1)
				)
				(1
					(localproc_0 7 21 4 1850 temp1)
				)
				(2
					(localproc_0 9 21 5 1850 temp1)
				)
				(3
					(localproc_0 14 21 8 1850 temp1)
				)
			)
		)
		(2
			(switch param1
				(0
					(localproc_0 5 21 0 1851 temp1)
				)
				(1
					(localproc_0 3 21 0 1851 temp1)
				)
				(2
					(localproc_0 4 21 0 1851 temp1)
				)
				(3
					(localproc_0 2 21 0 1851 temp1)
				)
				(4
					(localproc_0 1 21 0 1851 temp1)
				)
			)
		)
		(3
			(switch param1
				(0
					(localproc_0 2 0 0 1852 temp1)
				)
				(1
					(localproc_0 8 0 0 1852 temp1)
				)
				(2
					(localproc_0 4 0 0 1852 temp1)
				)
				(3
					(localproc_0 6 0 0 1852 temp1)
				)
				(4
					(localproc_0 5 0 0 1852 temp1)
				)
				(5
					(localproc_0 1 0 0 1852 temp1)
				)
				(6
					(localproc_0 7 0 0 1852 temp1)
				)
			)
		)
		(4
			(switch param1
				(0
					(localproc_0 4 0 0 1853 temp1)
				)
				(1
					(localproc_0 3 0 0 1853 temp1)
				)
				(2
					(localproc_0 5 0 0 1853 temp1)
				)
				(3
					(localproc_0 6 0 0 1853 temp1)
				)
			)
		)
	)
	(if (temp1 size:)
		(swatLogo hide:)
		(bigPrint addText: (temp1 data:) posn: 20 60)
		(bigPrint init:)
		(sliderObj setup: (temp1 data:))
	else
		(bigPrint dispose:)
		(swatLogo show:)
	)
	(temp1 dispose:)
	(if temp0
		(gGame handsOn:)
	)
)

(procedure (localproc_3 param1 param2)
	(switch global122
		(1
			(switch local1
				(0
					(cond
						((or (< param1 -190) (< param2 74))
							(still view: 1871)
						)
						((or (< param1 -148) (< param2 116))
							(still view: 1870)
						)
						((or (< param1 -122) (< param2 142))
							(still view: 1869)
						)
						((or (< param1 -87) (< param2 177))
							(still view: 1868)
						)
						((or (< param1 -66) (< param2 198))
							(still view: 1867)
						)
						((or (< param1 -39) (< param2 225))
							(still view: 1866)
						)
						((or (< param1 -24) (< param2 240))
							(still view: 1865)
						)
					)
				)
				(1
					(cond
						((or (< param1 -147) (< param2 50))
							(still view: 1875)
						)
						((or (< param1 -75) (< param2 122))
							(still view: 1874)
						)
						((or (< param1 -62) (< param2 135))
							(still view: 1873)
						)
					)
				)
				(2
					(cond
						((or (< param1 -86) (< param2 5))
							(still view: 1879)
						)
						((or (< param1 -61) (< param2 30))
							(still view: 1878)
						)
						((or (< param1 -35) (< param2 56))
							(still view: 1860)
						)
					)
				)
				(3
					(cond
						((or (< param1 -95) (< param2 4))
							(still view: 1863)
						)
						((or (< param1 -80) (< param2 19))
							(still view: 1862)
						)
						((or (< param1 -44) (< param2 55))
							(still view: 1861)
						)
						((or (< param1 -33) (< param2 66))
							(still view: 1860)
						)
						((or (< param1 -25) (< param2 74))
							(still view: 1859)
						)
						((or (< param1 -14) (< param2 85))
							(still view: 1858)
						)
					)
				)
			)
		)
		(3
			(switch local1
				(0
					(cond
						((or (< param1 -51) (< param2 8))
							(still view: 1824)
						)
						((or (< param1 -41) (< param2 18))
							(still view: 1823)
						)
						((or (< param1 -29) (< param2 30))
							(still view: 1822)
						)
						((or (< param1 -10) (< param2 49))
							(still view: 1821)
						)
						((or (< param1 -4) (< param2 58))
							(still view: 1857)
						)
						((or (< param1 -2) (< param2 60))
							(still view: 1818)
						)
					)
				)
				(1
					(if (or (<= param1 -22) (<= param2 8))
						(still view: 1835)
					)
				)
				(2
					(cond
						((or (<= param1 -31) (<= param2 21))
							(still view: 1896)
						)
						((or (<= param1 -25) (<= param2 27))
							(still view: 1895)
						)
						((or (<= param1 -22) (<= param2 30))
							(still view: 1894)
						)
						((or (<= param1 -18) (<= param2 34))
							(still view: 1893)
						)
						((or (<= param1 -3) (<= param2 49))
							(still view: 1892)
						)
					)
				)
				(3
					(cond
						((or (<= param1 -31) (<= param2 4))
							(still view: 1816)
						)
						((or (<= param1 -29) (<= param2 6))
							(still view: 1815)
						)
						((or (<= param1 -25) (<= param2 10))
							(still view: 1814)
						)
						((or (<= param1 -14) (<= param2 21))
							(still view: 1813)
						)
						((or (<= param1 -12) (<= param2 23))
							(still view: 1812)
						)
						((or (<= param1 -10) (<= param2 25))
							(still view: 1811)
						)
						((or (<= param1 -7) (<= param2 28))
							(still view: 1810)
						)
						((or (<= param1 -5) (<= param2 30))
							(still view: 1809)
						)
						((or (<= param1 -3) (<= param2 32))
							(still view: 1899)
						)
					)
				)
				(4
					(cond
						((or (<= param1 -27) (<= param2 4))
							(still view: 1833)
						)
						((or (<= param1 -22) (<= param2 9))
							(still view: 1832)
						)
						((or (<= param1 -18) (<= param2 13))
							(still view: 1831)
						)
						((or (<= param1 -13) (<= param2 18))
							(still view: 1830)
						)
						((or (<= param1 -7) (<= param2 24))
							(still view: 1829)
						)
						((or (<= param1 -5) (<= param2 26))
							(still view: 1828)
						)
						((or (<= param1 -3) (<= param2 28))
							(still view: 1827)
						)
						((or (<= param1 -1) (<= param2 30))
							(still view: 1829)
						)
					)
				)
				(5
					(still view: 1897)
				)
				(6
					(cond
						((or (<= param1 -35) (<= param2 8))
							(still view: 1890)
						)
						((or (<= param1 -18) (<= param2 25))
							(still view: 1889)
						)
						((or (<= param1 -12) (<= param2 31))
							(still view: 1888)
						)
					)
				)
			)
		)
		(4
			(switch local1
				(1
					(cond
						((or (<= param1 -24) (<= param2 14))
							(still view: 1843)
						)
						((or (<= param1 -9) (<= param2 29))
							(still view: 1842)
						)
						((or (<= param1 -3) (<= param2 35))
							(still view: 1841)
						)
					)
				)
			)
		)
	)
	(UpdateScreenItem still)
)

(instance rm185 of PQRoom
	(properties
		picture 185
		infoRoomSignal 5
	)

	(method (init)
		(= modNum
			(switch global122
				(1 1850)
				(2 1851)
				(3 1852)
				(4 1853)
			)
		)
		(super init: &rest)
		(topicName init:)
		(still init:)
		(myBigUp init:)
		(myBigDown init:)
		(selectUp init:)
		(selectDown init:)
		(selectTopic init:)
		(sliderObj init:)
		(self setScript: showOpening)
		(if (!= (gBackMusic number:) 18501)
			(gBackMusic number: 18501 loop: -1 play:)
		)
	)

	(method (dispose)
		(if (bigPrint dialog:)
			((bigPrint dialog:) dispose:)
		)
		(if (not (OneOf gNewRoomNum 190 180)) ; tacticsMenu
			(Lock rsAUDIO 18501 0)
			(gBackMusic fade: 0 2 21 1)
		)
		(super dispose:)
	)
)

(instance showOpening of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (= local0 (localproc_1 ourSelector))
					(ourSelector
						setSize:
						init: gCast gFtrInitializer
						updatePlane:
						draw:
					)
				)
				(swatLogo init:)
				(if (IsFlag 20)
					(swatLogo cel: (- (NumCels swatLogo) 1))
					(UpdateScreenItem swatLogo)
				)
				(= ticks 5)
			)
			(1
				(if (not (SetFlag 20))
					(swatLogo setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bigPrint of Print
	(properties
		font 20071
		width 250
		fore 28
		back 0
		x 68
		y 69
		modeless 2
	)

	(method (dispose)
		(if (gPrints contains: self)
			(gPrints delete: self)
		)
		(plane dispose:)
		(= mode
			(= ticks (= title (= first (= saveCursor (= plane (= bitmap 0))))))
		)
		(gSounds pause: 0)
		(DisposeClone self)
	)

	(method (showSelf &tmp [temp0 2] temp2 temp3 [temp4 2])
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		((= plane
				(if plane
					(plane new:)
				else
					(gSystemPlane new:)
				)
			)
			setRect: 68 71 322 266
			back: (if (== back -1) 0 else back)
			priority: 7
			picture: -2
		)
		(dialog
			plane: plane
			name: {PODialog}
			caller: self
			text: title
			ticks: ticks
			margin: margin
			modeless: modeless
			onScreen: onScreen
			init:
		)
		(dialog setSize:)
		(dialog center:)
		(= temp2
			(if (== x -1)
				(dialog nsLeft:)
			else
				x
			)
		)
		(= temp3
			(if (== y -1)
				(dialog nsTop:)
			else
				y
			)
		)
		(dialog moveTo: temp2 temp3 eachElementDo: #updatePlane)
		(plane setRect: 68 71 322 266)
		(UpdatePlane plane)
		(FrameOut)
		(gPrints addToFront: self)
	)

	(method (handleEvent))
)

(instance sliderObj of PQSlider
	(properties
		x 331
		view 1850
		loop 2
		topY 90
		bottomY 242
	)

	(method (adjust param1)
		(+= dataTop param1)
		(+= dataBottom param1)
		(super adjust: 0 &rest)
	)

	(method (setup param1 &tmp temp0)
		(super setup:)
		(= temp0 (IntArray with: 0 0 0 0))
		(if (and argc param1)
			(Text 0 (temp0 data:) {W} (bigPrint font:) 0 0) ; TextSize
			(= dataStep (* (temp0 at: 3) 2))
			(temp0 at: 0 0 0 0 0)
			(Text 0 (temp0 data:) param1 (bigPrint font:) (bigPrint width:) 0) ; TextSize
			(= dataTop 0)
			(= dataBottom
				(-
					(/ (temp0 at: 3) dataStep)
					(/
						(/
							(-
								((bigPrint plane:) bottom:)
								((bigPrint plane:) top:)
							)
							dataStep
						)
						2
					)
				)
			)
			(if (< dataBottom dataTop)
				(= dataBottom dataTop)
			)
			(self positionThumb:)
		)
		(temp0 dispose:)
	)

	(method (updateData param1 &tmp temp0)
		(MovePlaneItems (bigPrint plane:) 0 (* (Abs dataTop) dataStep))
		(= dataCur 0)
		(= dataTop (- (/ (* param1 totalHeight) 100)))
		(= dataBottom (+ totalHeight dataTop))
		(self positionThumb:)
		(localproc_3 dataTop dataBottom)
		(MovePlaneItems (bigPrint plane:) 0 (* dataTop dataStep))
		(UpdatePlane (bigPrint plane:))
		(FrameOut)
	)
)

(instance ourSelector of DSelector
	(properties
		x 220
		y 307
		font 20071
		length 5
		width 242
		fore 28
		back 0
	)

	(method (init param1)
		(= upButton (= downButton -1))
		(gMouseDownHandler add: self)
		(super init: param1 &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (scrollDown param1 &tmp temp0)
		(= temp0 (if argc param1 else 1))
		(if (>= (+= current temp0) (textList size:))
			(= current (- (textList size:) 1))
		)
		(if (== current (- (textList size:) 1))
			(= first
				(Min
					(- (textList size:) 1)
					(Max 0 (- current 1))
				)
			)
		else
			(= first (- current 1))
		)
		(self draw:)
	)

	(method (scrollUp param1 &tmp temp0)
		(= temp0 (if argc param1 else 1))
		(if (< (-= current temp0) 0)
			(= current 0)
		)
		(if (not current)
			(= first current)
		else
			(= first (- current 1))
		)
		(self draw:)
	)

	(method (setSize param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3 (IntArray new:))
		(= temp4 (= temp0 0))
		(= textHeight 0)
		(if (or (and argc param1) (not width))
			(for
				((= temp1 (KList 3 (textList elements:)))) ; FirstNode
				temp1
				((= temp1 (textList nextNode:)))
				
				(textList nextNode: (KList 6 temp1)) ; NextNode
				(= temp2 (KList 8 temp1)) ; NodeValue
				(if (not width)
					(Text 0 (temp3 data:) (temp2 text:) font 0 0) ; TextSize
					(= temp0 (Max (temp3 at: 2) temp0))
				else
					(Text 0 (temp3 data:) (temp2 text:) font width 0) ; TextSize
				)
				(if (and argc param1)
					(= temp4 (Max (+ (temp3 at: 3) leading) temp4))
				)
			)
		)
		(Text 0 (temp3 data:) {M} font 0 0) ; TextSize
		(= textHeight (Max temp4 (+ (temp3 at: 3) leading)))
		(+= textHeight 4)
		(temp3 dispose:)
		(self
			setNSRect: 0 0 (Max width temp0) (- (* textHeight length) 3)
		)
		(= nsLeft 218)
		(= nsTop 307)
		(= nsRight 422)
		(= nsBottom 336)
	)
)

(instance selectUp of Button
	(properties
		x 430
		y 304
		view 1850
		downCel 2
	)

	(method (doVerb)
		(ourSelector scrollUp:)
	)
)

(instance selectDown of Button
	(properties
		x 430
		y 321
		view 1850
		loop 1
		downCel 2
	)

	(method (doVerb)
		(ourSelector scrollDown:)
	)
)

(instance myBigUp of Button
	(properties
		x 334
		y 72
		view 1850
		downCel 2
		doVerbCalled 1
	)

	(method (doVerb)
		(if (not (bigPrint plane:))
			(return)
		)
		(if (< (sliderObj dataTop:) 0)
			(MovePlaneItems (bigPrint plane:) 0 (sliderObj dataStep:))
			(sliderObj adjust: 1)
			(UpdatePlane (bigPrint plane:))
			(FrameOut)
		)
	)

	(method (trace)
		(super trace: &rest)
		(self active: 0)
		(localproc_3 (sliderObj dataTop:) (sliderObj dataBottom:))
		(self active: 1)
	)
)

(instance myBigDown of Button
	(properties
		x 334
		y 252
		view 1850
		loop 1
		downCel 2
		doVerbCalled 1
	)

	(method (doVerb)
		(if (not (bigPrint plane:))
			(return)
		)
		(if (> (sliderObj dataBottom:) 0)
			(MovePlaneItems (bigPrint plane:) 0 (- (sliderObj dataStep:)))
			(sliderObj adjust: -1)
			(UpdatePlane (bigPrint plane:))
			(FrameOut)
		)
	)

	(method (trace)
		(super trace: &rest)
		(self active: 0)
		(localproc_3 (sliderObj dataTop:) (sliderObj dataBottom:))
		(self active: 1)
	)
)

(instance swatLogo of Prop
	(properties
		x 118
		y 254
		view 2
	)
)

(instance selectTopic of Button
	(properties
		x 186
		y 304
		view 1850
		loop 3
	)

	(method (doVerb)
		(if local0
			(if (bigPrint dialog:)
				((bigPrint dialog:) dispose:)
			)
			(localproc_2 (ourSelector current:))
		)
		(switch global122
			(1
				(switch (ourSelector current:)
					(0
						(= local1 0)
						(still view: 1864)
					)
					(1
						(= local1 1)
						(still view: 1872)
					)
					(2
						(= local1 2)
						(still view: 1861)
					)
					(3
						(= local1 3)
						(still view: 1857)
					)
				)
			)
			(2
				(switch (ourSelector current:)
					(0
						(= local1 0)
						(still view: 1881)
					)
					(1
						(= local1 1)
						(still view: 1883)
					)
					(2
						(= local1 2)
						(still view: 1882)
					)
					(3
						(= local1 3)
						(still view: 1884)
					)
					(4
						(= local1 4)
						(still view: 1885)
					)
				)
			)
			(3
				(switch (ourSelector current:)
					(0
						(= local1 0)
						(still view: 1817)
					)
					(1
						(= local1 1)
						(still view: 1834)
					)
					(2
						(= local1 2)
						(still view: 1891)
					)
					(3
						(= local1 3)
						(still view: 1898)
					)
					(4
						(= local1 4)
						(still view: 1825)
					)
					(5
						(= local1 5)
						(still view: 1897)
					)
					(6
						(= local1 6)
						(still view: 1886)
					)
				)
			)
			(4
				(switch (ourSelector current:)
					(0
						(= local1 0)
						(still view: 1839)
					)
					(1
						(= local1 1)
						(still view: 1840)
					)
					(2
						(= local1 2)
						(still view: 1837)
					)
					(3
						(= local1 3)
						(still view: 1838)
					)
				)
			)
			(else
				(return)
			)
		)
	)
)

(instance topicName of View
	(properties
		y 14
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(switch global122
			(1
				(= view 1854)
				(= x 128)
			)
			(2
				(= view 1851)
				(= x 144)
			)
			(3
				(= view 1852)
				(= x 188)
			)
			(4
				(= view 1853)
				(= x 98)
			)
			(else
				(return)
			)
		)
		(super init: &rest)
	)
)

(instance still of View
	(properties
		x 408
		y 80
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(switch global122
			(1
				(= view 1856)
			)
			(2
				(= view 1880)
			)
			(3
				(= view 1886)
			)
			(4
				(= view 1836)
			)
			(else
				(return)
			)
		)
		(super init: &rest)
	)
)

