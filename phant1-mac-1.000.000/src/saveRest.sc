;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use n1111)
(use Print)
(use Game)
(use User)
(use Actor)
(use System)

(public
	saveRest 0
)

(local
	local0
	local1
	local2 = 1
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (param1 cel:))
	(param1 cel: param2)
	(UpdateScreenItem param1)
	(FrameOut)
	(= temp2 1)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
		(temp0 localize: (ScriptID 0 11)) ; overlayPlane
		(cond
			((param1 onMe: temp0)
				(if (== (param1 cel:) temp1)
					(param1 cel: param2)
					(= temp2 1)
					(UpdateScreenItem param1)
					(FrameOut)
				)
			)
			((!= (param1 cel:) temp1)
				(param1 cel: temp1)
				(= temp2 0)
				(UpdateScreenItem param1)
				(FrameOut)
			)
		)
		(temp0 dispose:)
	)
	(temp0 dispose:)
	(param1 cel: temp1)
	(UpdateScreenItem param1)
	(return temp2)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 10) ((++ temp0))
		(if (== (gSaveManager getSaveType: temp0) 1)
			(return 1)
		)
	)
	(return 0)
)

(procedure (localproc_2 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 10) ((++ temp0))
		(if
			(and
				(!= (= temp1 (gSaveManager getSaveType: temp0)) -1)
				(& temp1 $0002)
			)
			(return 1)
		)
	)
	(return 0)
)

(instance saveRest of Room
	(properties
		picture 9800
		style 0
	)

	(method (init)
		(global114 stop: 1)
		(ClearFlag 145)
		(KillRobot 0 0)
		(gThePlane setRect: 0 0 319 199)
		(= global121 0)
		(gGame setCursor: gNormalCursor 0)
		(User canInput: 1)
		(ScriptID 902) ; nameGameRoom
		(ScriptID 901) ; selectGameRoom
		(ScriptID 23) ; HotSpot
		64946
		64922
		47
		(Load rsMESSAGE 91)
		(Load rsMESSAGE 901)
		(Load rsMESSAGE 902)
		(if (not (OneOf gPrevRoomNum 45 901 902)) ; selectGameRoom, nameGameRoom
			(DoAudio audPLAY 102 0 0 0 1)
			(= local2 0)
		)
		(if (OneOf gPrevRoomNum 45 901 902) ; selectGameRoom, nameGameRoom
			(= local2 0)
		)
		(= local1 (localproc_2))
		(super init:)
		(if (not (OneOf gPrevRoomNum 45 901 902)) ; selectGameRoom, nameGameRoom
			(gGame fade: 0 100 2)
		)
		(self setScript: doDialog)
	)

	(method (doit)
		(if (and (not local2) (== (DoAudio audPOSITION 102 0 0 0 1) -1))
			(DoAudio audPLAY 102 0 0 0 1)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(Lock rsVIEW 9806 0)
		(super dispose:)
	)
)

(instance doDialog of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGame setCursor: gNormalCursor 1)
				(Palette 2 0 255 100) ; PalIntensity
				(= local0 (= temp2 (= temp1 0)))
				(introButton init:)
				(newButton init:)
				(quitButton init:)
				(aboutButton init:)
				(if (localproc_1)
					(oldButton init:)
					(|= local0 $0001)
				)
				(if local1
					(movieButton init:)
					(|= local0 $0002)
				)
				(cond
					((== local0 0)
						(introButton posn: 15 44)
						(newButton posn: 15 75)
						(quitButton posn: 15 106)
						(aboutButton posn: 15 137)
					)
					((== local0 1)
						(introButton posn: 15 13)
						(newButton posn: 15 44)
						(oldButton posn: 15 75)
						(quitButton posn: 15 106)
						(aboutButton posn: 15 137)
					)
					((== local0 2)
						(introButton posn: 15 13)
						(newButton posn: 15 44)
						(quitButton posn: 15 75)
						(aboutButton posn: 15 106)
						(movieButton posn: 15 137)
					)
					(else
						(introButton posn: 15 13)
						(newButton posn: 15 44)
						(oldButton posn: 15 75)
						(quitButton posn: 15 106)
						(aboutButton posn: 15 137)
						(movieButton posn: 15 168)
					)
				)
			)
			(2
				(gCast eachElementDo: #dispose)
				(= cycles 5)
			)
			(3
				(switch register
					(0
						(= local2 1)
						(gCurRoom setScript: fadeMusicScr 0 100)
					)
					(1
						(gCurRoom newRoom: 901) ; selectGameRoom
					)
					(2
						(gCurRoom newRoom: 902) ; nameGameRoom
					)
					(3
						(gCurRoom newRoom: 45)
					)
				)
			)
		)
	)
)

(instance fadeMusicScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DoAudio audSTOP 102 0 0 0 1)
				(= cycles 1)
			)
			(1
				(if (!= (gGame getDisc: 1) 99)
					(gCurRoom newRoom: register)
				else
					(gCurRoom setScript: doDialog)
				)
			)
		)
	)
)

(instance introButton of View
	(properties
		view 9806
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (posn)
		(super posn: &rest)
		(introText init: x: (+ x 25) y: (- y 5))
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(doDialog register: 0 cue:)
		)
	)
)

(instance newButton of View
	(properties
		view 9806
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (posn)
		(super posn: &rest)
		(newText init: x: (+ x 25) y: (+ y 1))
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(if (== (gSaveManager saveFileCnt:) 10)
				(SetFlag 152)
				(ClearFlag 34)
				(doDialog register: 1 cue:)
			else
				(ClearFlag 152)
				(doDialog register: 2 cue:)
			)
		)
	)
)

(instance oldButton of View
	(properties
		view 9806
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (posn)
		(super posn: &rest)
		(oldText init: x: (+ x 25) y: (+ y 2))
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(ClearFlag 152)
			(ClearFlag 34)
			(doDialog register: 1 cue:)
		)
	)
)

(instance quitButton of View
	(properties
		view 9806
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (posn)
		(super posn: &rest)
		(quitText init: x: (+ x 25) y: (+ y 3))
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(= gQuit
				(Print
					addText: 0 0 0 1 -1 -1 91 ; "Are you sure you want to quit the game?"
					addButton: 1 0 0 0 2 0 11 1 91 ; MISSING MESSAGE
					addButton: 0 0 0 0 3 0 26 1 91 ; MISSING MESSAGE
					init:
				)
			)
		)
	)
)

(instance aboutButton of View
	(properties
		view 9806
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (posn)
		(super posn: &rest)
		(aboutText init: x: (+ x 25) y: y)
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(doDialog register: 3 cue:)
		)
	)
)

(instance movieButton of View
	(properties
		view 9806
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (posn)
		(super posn: &rest)
		(movieText init: x: (+ x 25) y: (- y 5))
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(ClearFlag 152)
			(SetFlag 34)
			(doDialog register: 1 cue:)
		)
	)
)

(instance introText of View
	(properties
		view 9806
		loop 1
	)
)

(instance newText of View
	(properties
		view 9806
		loop 1
		cel 1
	)
)

(instance oldText of View
	(properties
		view 9806
		loop 1
		cel 2
	)
)

(instance quitText of View
	(properties
		view 9806
		loop 1
		cel 3
	)
)

(instance aboutText of View
	(properties
		view 9806
		loop 1
		cel 4
	)
)

(instance movieText of View
	(properties
		view 9806
		loop 1
		cel 5
	)
)

