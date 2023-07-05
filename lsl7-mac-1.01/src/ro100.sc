;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use TPSound)
(use DialogPlane)
(use oHandsOnWhenCued)
(use n64866)
(use CueMe)
(use NewUser)
(use PushButton)
(use soFlashCyberSniff)
(use Plane)
(use Str)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	ro100 0
)

(local
	local0
	[local1 2] = [0 {}]
	local3
	local4
	local5
	local6
)

(procedure (localproc_0 param1 &tmp temp0)
	(if (voLoadMsg plane:)
		(voLoadMsg dispose:)
	)
	(if (= temp0 (MakeMessageText 0 0 79 1 14))
		(voLoadMsg text: (Str format: temp0 param1) init:)
		(temp0 dispose:)
	)
	(FrameOut)
)

(procedure (localproc_1)
	(if (voLoadMsg plane:)
		(voLoadMsg dispose:)
	)
)

(procedure (localproc_2 &tmp temp0)
	(= temp0 (Str new:))
	(temp0 format: {%s%s} gCurSaveDir {autosvsg.000})
	(if (FileIO fiEXISTS (KArray 9 temp0)) ; ArrayGetData
		(temp0 dispose:)
		(return 1)
	else
		(temp0 dispose:)
		(return 0)
	)
)

(instance ro100 of L7Room
	(properties
		picture 10000
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(self setScript: soPlayIntro)
	)

	(method (dispose)
		(gOEventHandler unregisterGlobalHandler: oAnyEventHandler)
		(gOSound1 stop:)
		(super dispose: &rest)
	)
)

(instance voLoadMsg of TextItem
	(properties
		x 10
		y 450
		fore 64
		back 0
		font 2510
	)

	(method (init)
		(super init: &rest)
		(= x (/ (- 640 nWidth) 2))
		(UpdateScreenItem self)
	)
)

(instance soCyberTest2000 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(= global267 0)
				(if (proc64896_19)
					(= local4 1)
				else
					(= local4 0)
				)
				(if
					(or
						(proc64896_21 1)
						(proc64896_21 2)
						(proc64896_21 3)
						(proc64896_21 4)
						(proc64896_21 5)
						(proc64896_21 6)
						(proc64896_21 7)
						(proc64896_21 8)
						(proc64896_21 9)
						(proc64896_21 10)
						(proc64896_21 11)
						(proc64896_21 12)
					)
					(= local3 1)
				else
					(= local3 0)
				)
				(if (and (not local3) (not local4))
					(self dispose:)
					(return)
				)
				(gCurRoom addRoomPlane: oBlackPlane)
				(TextDialog (MakeMessageText 0 0 75 1 14) (Str with: global288))
				(if local4
					(localproc_0 {Custom Image File})
					(if (not (= temp0 (proc64896_20 325 325)))
						(= temp3 (MakeMessageText 0 0 78 1 14))
						(= temp2 (Str format: temp3 {1.bmp}))
						(TextDialog temp2 (Str with: global288))
						(temp3 dispose:)
						(= global267 1)
					else
						(Bitmap 1 temp0) ; Dispose
					)
				)
				(if local3
					(for ((= temp4 1)) (<= temp4 12) ((++ temp4))
						(= temp1 (Str format: {Custom sound %d} temp4))
						(if (proc64896_21 temp4)
							(localproc_0 (temp1 data:))
							(oSimpleSound playSound: temp4)
							(oSimpleSound stop:)
						else
							(= temp3 (MakeMessageText 0 0 77 1 14))
							(= temp2 (Str format: temp3 (temp1 data:)))
							(TextDialog temp2 (Str with: global288))
							(temp3 dispose:)
						)
						(temp1 dispose:)
					)
				)
				(localproc_1)
				(if global267
					(TextDialog
						(MakeMessageText 0 0 81 1 14)
						(Str with: global288)
					)
				else
					(TextDialog
						(MakeMessageText 0 0 80 1 14)
						(Str with: global288)
					)
				)
				(gCurRoom deleteRoomPlane: oBlackPlane)
				(self dispose:)
			)
		)
	)
)

(instance oBlackPlane of Plane
	(properties)

	(method (init)
		(= picture -1)
		(super init: 0 0 639 479 &rest)
	)
)

(instance oSimpleSound of TPSound
	(properties)
)

(instance soPlayIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soCyberTest2000 self)
			)
			(1
				(poLarryCarryLogo
					view: 10100
					loop: 0
					cycleSpeed: 6
					posn: 274 294
					init:
				)
				(gGame handsOff:)
				(= cycles 3)
			)
			(2
				(= ticks 45)
			)
			(3
				(gOEventHandler registerGlobalHandler: oAnyEventHandler)
				(= local5 0)
				(oMusic setRelVol: 400 playSound: 10000 coEndMusic)
				(poLarryCarryLogo
					loop: 0
					cel: 0
					cycleSpeed: 8
					doit:
					setCycle: End self
				)
				(gMessager say: 3 0 0 2) ; "(GRUNT UNDER THE WEIGHT OF A GIANT GLOBE) UUuuhhhnnnnnggggh! (ABOUT 3 SECONDS)"
			)
			(4
				(Load 140 10002) ; WAVE
				(poLarryCarryLogo
					loop: 1
					cel: 0
					cycleSpeed: 11
					doit:
					setCycle: End self
				)
			)
			(5
				(poLarryCarryLogo
					loop: 1
					cel: 0
					cycleSpeed: 6
					doit:
					setCycle: ForwardCounter 3 self
				)
			)
			(6
				(poLarryCarryLogo
					loop: 1
					cycleSpeed: 3
					doit:
					setCycle: ForwardCounter 5 self
				)
			)
			(7
				(= local6 0)
				(oSound setRelVol: 400 playSound: 10002 coEndSound)
				(poLarryCarryLogo loop: 2 cel: 0 doit:)
				(= ticks 15)
			)
			(8
				(poLarryCarryLogo cycleSpeed: 6 setCycle: End self)
			)
			(9
				(if (and local5 local6)
					(= cycles 1)
				else
					(self changeState: (- state 1))
				)
			)
			(10
				(if (localproc_2)
					(gCurRoom setScript: soNavigationDialog)
				else
					(gCurRoom newRoom: 110) ; ro110
					(poLarryCarryLogo dispose:)
					(gCurRoom drawPic: -1)
					(gGame autosave: 0 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance soNavigationDialog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oSound stop:)
				(gMessager kill:)
				(oMusic setMusic: 13000)
				(= cycles 1)
			)
			(1
				(gOEventHandler unregisterGlobalHandler: oAnyEventHandler)
				(poLarryCarryLogo dispose:)
				(gCurRoom drawPic: 10500)
				(while 1
					(gGame handsOn:)
					(switch
						(= local0
							(if (= register (== (Platform 0) 1))
								(StackedButtonDialog
									4
									375
									215
									(MakeMessageText 2 0 4)
									(MakeMessageText 2 0 1)
									(MakeMessageText 2 0 2)
									(MakeMessageText 2 0 3)
								)
							else
								(StackedButtonDialog
									5
									375
									215
									(MakeMessageText 2 0 4)
									(MakeMessageText 2 0 1)
									(MakeMessageText 2 0 2)
									(MakeMessageText 2 0 5)
									(MakeMessageText 2 0 3)
								)
							)
						)
						(0
							(gGame autorestore:)
						)
						(1
							(gGame handsOn:)
							(proc64866_1)
							(gGame handsOff:)
						)
						(2
							(gCurRoom newRoom: 110) ; ro110
							(return 0)
							(self dispose:)
						)
						(3
							(if register
								(= gQuit 1)
								(return 0)
							else
								(kernel_158
									{http://www.sierra.com/entertainment/lsl7/}
								)
							)
						)
						(4
							(= gQuit 1)
							(return 0)
						)
					)
				)
			)
		)
	)
)

(instance poLarryCarryLogo of Prop
	(properties)
)

(instance oMusic of TPSound
	(properties
		type 1
	)
)

(instance oSound of TPSound
	(properties)
)

(instance coEndMusic of CueMe
	(properties)

	(method (cue)
		(= local5 1)
	)
)

(instance coEndSound of CueMe
	(properties)

	(method (cue)
		(= local6 1)
	)
)

(instance oAnyEventHandler of EventCode
	(properties)

	(method (handleEvent event)
		(if (or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD))
			(gOEventHandler unregisterGlobalHandler: oAnyEventHandler)
			(if (localproc_2)
				(gCurRoom setScript: soNavigationDialog)
			else
				(gCurRoom newRoom: 110) ; ro110
				(poLarryCarryLogo dispose:)
				(gCurRoom drawPic: -1)
				(gGame autosave: 0 1)
			)
		)
	)
)

