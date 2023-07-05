;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use GloryWindow)
(use IconBar)
(use LoadMany)
(use GameControls)
(use Window)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm130 0
)

(local
	[local0 2]
	local2
)

(procedure (localproc_0 param1)
	(param1 init: show:)
	(if (not local2)
		(DrawPic 130 9)
		(Animate (gCast elements:) 0)
		(if (== param1 startPanel)
			(localproc_0 playPanel)
		else
			(localproc_0 startPanel)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (GetTime))
	(for ((= temp2 5000)) temp2 ((-- temp2))
		(= temp3 102)
	)
	(for ((= temp2 5000)) temp2 ((-- temp2))
		(Animate)
	)
	(= temp1 (GetTime))
	(= temp3
		(switch (/ (Abs (- temp1 temp0)) 10)
			(0 3)
			(1 2)
			(2 1)
			(else 0)
		)
	)
)

(instance rm130 of Rm
	(properties
		picture 1
	)

	(method (init)
		(HandsOff)
		(SetCursor 0)
		(User canInput: 1)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(gTheIconBar disable:)
		(SetPort 0 0 200 320 0 0)
		(super init:)
		(if (OneOf gPrevRoomNum 140 54 102 63) ; import
			(III setLoop: 4 setCel: 6 x: 85 y: 121 init:)
			(wagesSign setLoop: 0 setCel: 8 init:)
			(SetPort 0 0 190 320 10 0)
			(DrawPic 130 0)
			(gLongSong changeTo: 2)
			(seeMeGo start: 16)
		)
		(self setScript: seeMeGo)
		(= global102 (localproc_1))
	)

	(method (dispose)
		(startPanel dispose:)
		(playPanel dispose:)
		(gTheIconBar enable:)
		(LoadMany 0 956 978)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((OneOf (event type:) evKEYBOARD evMOUSEBUTTON evJOYDOWN)
				(if (< (seeMeGo state:) 4)
					(gLongSong client: 0)
					(gLongSong2 client: 0)
					(seeMeGo seconds: 0 cycles: 0 ticks: 0 changeState: 4)
				else
					(gLongSong client: 0)
					(gLongSong2 client: 0)
					(seeMeGo seconds: 0 cycles: 0 ticks: 0 changeState: 18)
				)
				(event claimed: 1)
			)
			((== (event type:) evMOUSERELEASE)
				(event claimed: 1)
			)
		)
		(super handleEvent: event &rest)
	)
)

(instance seeMeGo of Script
	(properties)

	(method (doit)
		(if (< (self state:) 4)
			(Palette palANIMATE 95 218 -1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 1 play: self)
			)
			(1
				(glint init: setCycle: End)
			)
			(2
				(glint2 init: setCycle: CT 6 1)
			)
			(3
				(glint2 setCycle: End)
			)
			(4
				(SetPort 0 0 190 320 10 0)
				(DrawPic 130 6)
				(glint dispose:)
				(glint2 dispose:)
				(gloryDude cel: 0 init:)
				(gLongSong number: 2 play:)
				(= seconds 2)
			)
			(5
				(gloryDude setCycle: End self)
			)
			(6
				(gLongSong2 number: 7 play: self)
				(= ticks 15)
			)
			(7
				(lFx init: setCycle: Fwd)
			)
			(8
				(lFx dispose:)
				(gLongSong2 number: 8 play: self)
				(sFx init: setPri: 14 setCycle: Fwd)
			)
			(9
				(sFx setLoop: 2 cel: 0 x: 206 y: 55 setCycle: End self)
				(gLongSong2 number: 11 play:)
			)
			(10
				(sFx dispose:)
				(beam init: setPri: 14 setCycle: End self)
			)
			(11
				(gLongSong2 number: 9 play:)
				(beam dispose:)
				(III init: setCycle: End self)
			)
			(12
				(III setCycle: Beg self)
			)
			(13
				(III x: 85 y: 121 setLoop: 4 cel: 0 setCycle: CT 1 1 self)
			)
			(14
				(Palette palSET_INTENSITY 0 255 400)
				(III setCycle: End self)
				(Palette palSET_INTENSITY 0 255 100)
			)
			(15
				(wagesSign init: cycleSpeed: 5 setCycle: CT 3 1 self)
			)
			(16
				(gLongSong2 number: 131 play:)
				(wagesSign setCycle: End self)
			)
			(17
				(= ticks 180)
			)
			(18
				(gLongSong hold:)
				(gloryDude dispose:)
				(wagesSign addToPic:)
				(III addToPic:)
				(beam dispose:)
				(sFx dispose:)
				(lFx dispose:)
				(= cycles 3)
			)
			(19
				(Palette palSET_INTENSITY 72 255 60)
				(SetCursor 1)
				(gGame setCursor: gNormalCursor 1 160 90)
				(localproc_0 startPanel)
			)
		)
	)
)

(instance III of Prop
	(properties
		x 54
		y 100
		view 134
		loop 5
	)
)

(instance gloryDude of Prop
	(properties
		x 201
		y 135
		view 131
		loop 2
	)
)

(instance wagesSign of Prop
	(properties
		x 260
		y 175
		view 135
		cel 1
	)

	(method (init)
		(= x (proc0_21 160 160 160 160 260))
		(= y (proc0_21 185 185 185 185 175))
		(super init: &rest)
	)
)

(instance lFx of Prop
	(properties
		x 204
		y 29
		view 134
	)
)

(instance sFx of Prop
	(properties
		x 203
		y 57
		view 134
		loop 1
	)
)

(instance beam of Prop
	(properties
		x 164
		y 72
		view 134
		loop 3
	)
)

(instance glint of Prop
	(properties
		x 134
		y 34
		view 133
		loop 1
		cycleSpeed 8
	)
)

(instance glint2 of Prop
	(properties
		x 60
		y 155
		view 133
		cycleSpeed 8
	)
)

(instance startWin of Window
	(properties
		top 32
		left 61
		bottom 160
		right 258
		type 131
	)

	(method (open &tmp temp0)
		(super open: &rest)
		(Graph grFILL_BOX 10 10 108 176 1 57 -1)
		(Graph grUPDATE_BOX 9 9 109 175 1)
		(DrawCel 132 8 0 1 1 -1)
		(DrawCel 132 9 0 1 107 -1)
		(for ((= temp0 0)) (<= temp0 8) ((++ temp0))
			(DrawCel 132 10 0 6 (+ (* temp0 11) 12) -1)
			(DrawCel 132 10 1 176 (+ (* temp0 11) 12) -1)
		)
	)
)

(instance startPanel of GameControls
	(properties)

	(method (init)
		(= window startWin)
		(self
			add: introItem playItem restoreItem instructItem quitItem
			eachElementDo: #signal 387
		)
		(playItem signal: (| (playItem signal:) $0040))
		(quitItem signal: (| (quitItem signal:) $0040))
		(super init: &rest)
	)

	(method (dispatchEvent)
		(= gGameTime (GetTime))
		(super dispatchEvent: &rest)
	)
)

(class startItem of IconI
	(properties
		view 132
		cel 0
		nsLeft 24
		highlightColor 46
		lowlightColor 57
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp4 (if (and argc param1) highlightColor else lowlightColor))
		(= temp0 (+ nsTop 1))
		(= temp1 (+ nsLeft 1))
		(= temp2 (- nsBottom 2))
		(= temp3 (- nsRight 2))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) nsBottom (+ nsRight 3) 1)
	)
)

(instance introItem of startItem
	(properties
		loop 0
		nsTop 16
	)

	(method (select)
		(if (super select: &rest)
			(= local2 1)
			(startPanel state: (& (startPanel state:) $ffdf))
			(gCurRoom newRoom: 63)
		)
	)
)

(instance playItem of startItem
	(properties
		loop 1
		nsTop 34
	)

	(method (select)
		(if (super select: &rest)
			(startPanel state: (& (startPanel state:) $ffdf))
		)
	)
)

(instance restoreItem of startItem
	(properties
		loop 2
		nsTop 52
	)

	(method (select)
		(if (super select: &rest)
			(Palette palSET_INTENSITY 72 255 100)
			(gGame restore:)
			(Palette palSET_INTENSITY 72 255 60)
		)
	)
)

(instance instructItem of startItem
	(properties
		loop 3
		nsTop 70
	)

	(method (select)
		(if (super select: &rest)
			(= local2 1)
			(startPanel state: (& (startPanel state:) $ffdf))
			(gCurRoom newRoom: 102)
		)
	)
)

(instance quitItem of startItem
	(properties
		loop 4
		nsTop 88
	)

	(method (select)
		(if (super select: &rest)
			(= local2 1)
			(= gQuit 1)
		)
	)
)

(instance playPanel of GameControls
	(properties)

	(method (init)
		(= window ((GloryWindow new:) top: 60 left: 82 bottom: 128 right: 234))
		(self add: createItem importItem cancelItem eachElementDo: #signal 387)
		(cancelItem signal: (| (cancelItem signal:) $0040))
		(super init: &rest)
	)

	(method (dispatchEvent)
		(= gGameTime (GetTime))
		(gCurRoom doit:)
		(super dispatchEvent: &rest)
	)
)

(instance createItem of startItem
	(properties
		loop 5
		nsLeft 2
		nsTop 5
	)

	(method (select)
		(if (super select: &rest)
			(= local2 1)
			(playPanel state: (& (playPanel state:) $ffdf))
			(startPanel state: (& (startPanel state:) $ffdf))
			(gLongSong fade: 0 2 5 1)
			(gCurRoom newRoom: 140)
		)
	)
)

(instance importItem of startItem
	(properties
		loop 6
		nsLeft 2
		nsTop 26
	)

	(method (select)
		(if (super select: &rest)
			(= local2 1)
			(playPanel state: (& (playPanel state:) $ffdf))
			(startPanel state: (& (startPanel state:) $ffdf))
			(gCurRoom newRoom: 54) ; import
		)
	)
)

(instance cancelItem of startItem
	(properties
		loop 7
		nsLeft 2
		nsTop 47
	)

	(method (select)
		(if (super select: &rest)
			(playPanel state: (& (startPanel state:) $ffdf))
		)
	)
)

(instance newMH of EventHandler ; UNUSED
	(properties)
)

(instance newKH of EventHandler ; UNUSED
	(properties)
)

