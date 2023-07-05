;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 764)
(include sci.sh)
(use Main)
(use GameControls)
(use IconBar)
(use File)

(class SaveIcon_a of IconI
	(properties
		name {SaveIcon}
		cursor 0
		maskView 1998
		maskCel 2
		number 0
		saveView 0
		noSaveView 0
	)

	(method (exists &tmp [temp0 20])
		(FileIO fiEXISTS (Format @temp0 764 0 gCurSaveDir (gGame name:) number)) ; "%s\%ssg.%03d"
	)

	(method (show param1 param2 param3)
		(cond
			((and (>= argc 3) param3)
				(&= signal $fffb)
				(= view (if (self exists:) saveView else noSaveView))
			)
			((self exists:)
				(= view noSaveView)
				(&= signal $fffb)
			)
			(else
				(= view saveView)
				(|= signal $0004)
			)
		)
		(super show: param1 param2)
	)

	(method (select)
		(if (super select: &rest)
			(gGame setCursor: cursor)
			(IconSave number: number)
		)
	)
)

(class IconSave of GameControls
	(properties
		oldCursor 0
		number 0
		gameName 0
		view 1998
		loop 12
		cel 0
		x 24
		highlightColor 0
		lowlightColor 19
	)

	(method (dispatchEvent event)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(= curIcon (= number 0))
			(return 1)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (show param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (and argc param1)
			(= temp6 diskSave)
			(= gameName param1)
			(= cel 0)
		else
			(= cel 1)
			(= temp6 diskRestore)
		)
		(= number 0)
		(= oldCursor (gGame setCursor: gNormalCursor))
		(self
			window:
				(gSystemWindow
					top: 50
					left: 110
					bottom: (+ 83 (* 5 (CelHigh view loop cel)))
					right: 210
					yourself:
				)
			add:
				game1
				game2
				game3
				game4
				game5
				game6
				game7
				game8
				game9
				game10
				temp6
				trash
				cancel
			eachElementDo: #highlightColor highlightColor
			eachElementDo: #lowlightColor lowlightColor
		)
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(|= state $0020)
		(window open:)
		(DrawCel view loop cel x y -1)
		(= temp4 3)
		(= temp3 14)
		(= temp0 1)
		(for
			((= temp1 (FirstNode elements)))
			(<= temp0 10)
			((= temp1 (NextNode temp1)))
			
			(= temp2 (NodeValue temp1))
			(temp2 show: temp4 temp3 (and argc param1))
			(= temp3 (temp2 nsBottom:))
			(if (== temp0 5)
				(= temp3 14)
				(= temp4 (+ 3 (temp2 nsRight:)))
			)
			(++ temp0)
		)
		(temp6 show: (+ (temp2 nsRight:) 2) 14)
		(trash show: (temp6 nsLeft:) (+ (temp6 nsBottom:) 3))
		(cancel show: 3 (+ (trash nsBottom:) 3))
		(gGame
			setCursor:
				gTheCursor
				1
				(+
					(cancel nsLeft:)
					(/ (- (cancel nsRight:) (cancel nsLeft:)) 2)
				)
				(- (cancel nsBottom:) 3)
		)
		(self doit:)
		(gGame setCursor: oldCursor)
		(self hide: dispose:)
		(= temp5
			(if curIcon
				(curIcon number:)
			else
				-1
			)
		)
		(DisposeScript 993)
		(return temp5)
	)

	(method (select param1 param2)
		(if (param1 select: (and (>= argc 2) param2))
			(if (param1 respondsTo: #number)
				(= curIcon param1)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance game1 of SaveIcon_a
	(properties
		view 1998
		loop 0
		cel 0
		cursor 801
		signal 257
		number 1
		saveView 1999
		noSaveView 1998
	)
)

(instance game2 of SaveIcon_a
	(properties
		view 1998
		loop 1
		cel 0
		cursor 802
		signal 257
		number 2
		saveView 1999
		noSaveView 1998
	)
)

(instance game3 of SaveIcon_a
	(properties
		view 1998
		loop 2
		cel 0
		cursor 803
		signal 257
		number 3
		saveView 1999
		noSaveView 1998
	)
)

(instance game4 of SaveIcon_a
	(properties
		view 1998
		loop 3
		cel 0
		cursor 804
		signal 257
		number 4
		saveView 1999
		noSaveView 1998
	)
)

(instance game5 of SaveIcon_a
	(properties
		view 1998
		loop 4
		cel 0
		cursor 805
		signal 257
		number 5
		saveView 1999
		noSaveView 1998
	)
)

(instance game6 of SaveIcon_a
	(properties
		view 1998
		loop 5
		cel 0
		cursor 806
		signal 257
		number 6
		saveView 1999
		noSaveView 1998
	)
)

(instance game7 of SaveIcon_a
	(properties
		view 1998
		loop 6
		cel 0
		cursor 807
		signal 257
		number 7
		saveView 1999
		noSaveView 1998
	)
)

(instance game8 of SaveIcon_a
	(properties
		view 1998
		loop 7
		cel 0
		cursor 808
		signal 257
		number 8
		saveView 1999
		noSaveView 1998
	)
)

(instance game9 of SaveIcon_a
	(properties
		view 1998
		loop 8
		cel 0
		cursor 809
		signal 257
		number 9
		saveView 1999
		noSaveView 1998
	)
)

(instance game10 of SaveIcon_a
	(properties
		view 1998
		loop 9
		cel 0
		cursor 810
		signal 257
		number 10
		saveView 1999
		noSaveView 1998
	)
)

(instance diskSave of IconI
	(properties
		view 1998
		loop 10
		cel 0
		signal 321
	)

	(method (select)
		(if (and (super select: &rest) (IconSave number:))
			(Format ; "%s\%ssg.%03d"
				(IconSave gameName:)
				764
				0
				gCurSaveDir
				(gGame name:)
				(IconSave number:)
			)
		)
	)
)

(instance diskRestore of IconI
	(properties
		view 1998
		loop 10
		cel 1
		signal 321
	)
)

(instance trash of IconI
	(properties
		view 1998
		loop 11
		cel 0
		signal 321
	)

	(method (select &tmp temp0 temp1 temp2 temp3 [temp4 20] [temp24 361] [temp385 21] temp406)
		(if (and (super select: &rest) (IconSave number:))
			((= temp0 (File new:))
				name: (Format @temp4 764 1 gCurSaveDir (gGame name:)) ; "%s\%ssg.dir"
				open: 2
			)
			(= temp3 (GetSaveFiles (gGame name:) temp24 temp385))
			(= temp406
				(if (IsObject (IconSave curIcon:))
					((IconSave curIcon:) number:)
				)
			)
			(= temp1 2570)
			(for ((= temp2 0)) (< temp2 temp3) ((++ temp2))
				(if (!= temp2 temp406)
					(temp0 write: @[temp385 temp2] 2)
					(temp0 writeString: @[temp24 (* temp2 18)])
					(temp0 write: @temp1 1)
				)
			)
			(= temp1 -1)
			(temp0 write: @temp1 2 close: dispose:)
			(Format @temp4 764 0 gCurSaveDir (gGame name:) (IconSave number:)) ; "%s\%ssg.%03d"
			(FileIO fiUNLINK @temp4)
			(IconSave curIcon: 0)
		)
	)
)

(class SaveIcon_b of IconI
	(properties
		name {SaveIcon}
		cursor 0
	)

	(method (select)
		(if (super select: &rest)
			(gGame setCursor: cursor)
		)
	)
)

(instance cancel of IconI
	(properties
		view 1998
		loop 13
		cel 0
		signal 321
	)

	(method (select)
		(if (super select: &rest)
			(IconSave curIcon: 0)
		)
	)
)

