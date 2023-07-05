;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7800)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use SaveManager)
(use SoundManager)
(use newYorkRegion)
(use n1111)
(use VMDMovie)
(use Plane)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	octoTeacher 0
)

(local
	local0
	local1
	local2
	local3
)

(instance octoTeacher of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(if (and (IsFlag 190) (proc1111_24 191) (not local2))
			(= local1 1)
		)
		(switch gPrevRoomNum
			(7601 ; octoMusTeaDoor
				(self
					addPicObj: faceTeacher faceNW faceMuseum faceSE faceTeacher
				)
			)
			(7602 ; octoMusDoorCU
				(self
					addPicObj: faceTeacher faceNW faceMuseum faceSE faceTeacher
				)
			)
			(7803 ; octoTeaGate
				(self
					addPicObj: faceTeacher faceNW faceMuseum faceSE faceTeacher
				)
			)
			(else
				(self
					addPicObj: faceMuseum faceSE faceTeacher faceNW faceMuseum
				)
			)
		)
	)

	(method (serialize param1 &tmp temp0)
		(if param1
			(super serialize: param1 0)
			(= local0 (SaveManager readWord:))
			(= local3 (SaveManager readWord:))
			(= local2 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local0)
			(SaveManager writeWord: local3)
			(SaveManager writeWord: local2)
		)
	)

	(method (dispose)
		(if (!= (SoundManager musicNum:) 7000)
			(SoundManager playMusic: 0 -1 7200)
		)
		(= local0 0)
		(= local3 0)
		(= local2 0)
		(= local1 0)
		(super dispose: &rest)
	)
)

(instance faceMuseum of CameraAngle
	(properties
		heading 45
		picture 7803
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToMuseum init:)
		(gCurRoom exitN: exitToMuseum)
		(super init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 135
		picture 7805
		edgeS 0
		edgeN 0
	)
)

(instance faceTeacher of CameraAngle
	(properties
		heading 225
		edgeS 0
		edgeN 0
	)

	(method (init)
		(cond
			(local3
				(switch global261
					(5
						(= picture 7830)
					)
					(7
						(= picture 7827)
					)
				)
				(catCard init: setHotspot: 2)
				(teacher_225 init: case: 9)
				(SoundManager fadeMusic: 0 20 8 1 0)
			)
			((and (IsFlag 191) (== (proc70_9 6) 7800))
				(= picture (if (== global261 test5) 7820 else 7818))
				(teacher_225 init: case: 9)
				(gCurRoom setScript: sRightAnswer)
			)
			((proc1111_24 190)
				(= picture 7815)
				(= global262 0)
				(gCurRoom drawPic: 7815)
				(gCurRoom setScript: sShowDemo)
				(SoundManager fadeMusic: 0 20 8 1 0)
				(teacher_225 init: case: 9)
			)
			(local1
				(= picture 7817)
				(teacher_225 init: case: 9)
				(gCurRoom setScript: sGiveTest)
				(SoundManager fadeMusic: 0 20 8 1 0)
			)
			(local2
				(= picture (if (== global261 test5) 7820 else 7818))
				(teacher_225 init: case: 10)
				(SoundManager fadeMusic: 0 20 8 1 0)
			)
			((proc1111_24 191)
				(= picture 7824)
				(teacher_225 init: case: 11)
				(SoundManager fadeMusic: 0 20 8 1 0)
			)
			(else
				(= picture 7807)
				(crunchie init: global117)
				(exitToGate init:)
				(gCurRoom exitN: exitToGate)
			)
		)
		(stuffCast init:)
		(stuffPlane
			name: {theStuffPlane}
			picture: -2
			priority: (+ (global116 priority:) 2)
			init: 223 190 258 220
		)
		(stuffPlane addCast: stuffCast)
		(chartOf41 init: stuffCast)
		(Spinner init: global117)
		(spinner_225 init:)
		(leftExit plane: stuffPlane init:)
		(foodDish_225 init:)
		(blackBoard_225 init:)
		(drum_225 init:)
		(super init: &rest)
	)

	(method (dispose)
		(stuffCast dispose:)
		(stuffPlane dispose:)
		(super dispose:)
	)
)

(instance leftExit of Feature
	(properties
		nsBottom 288
		nsRight 88
		nsTop 1
	)

	(method (init)
		(= plane stuffPlane)
		(super init: &rest)
		(self setHotspot: 9)
		((plane extMH:) delete: self)
		((plane extMH:) addToEnd: self)
		((plane theFtrs:) delete: self)
		((plane theFtrs:) addToEnd: self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setDirCursor: leftCursor)
			)
			(else
				(if gVMDMovie
					(gVMDMovie mouseDownAction: 1)
				)
				(gCurRoom yaw: -1)
			)
		)
	)
)

(instance stuffPlane of Plane
	(properties)
)

(instance stuffCast of Cast
	(properties)
)

(instance faceNW of CameraAngle
	(properties
		heading 315
		picture 7801
		edgeS 0
		edgeN 0
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsBottom 205
		nsLeft 240
		nsRight 385
		nsTop 143
		nextRoom 7601
	)
)

(instance exitToGate of ExitFeature
	(properties
		nsBottom 177
		nsLeft 225
		nsRight 394
		nsTop 96
		nextRoom 7803
	)
)

(instance sGiveTest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 0)
				(if local0
					(++ local0)
				else
					(if (proc1111_24 192)
						(SetFlag 192)
						(= global261 7)
					else
						(ClearFlag 192)
						(= global261 5)
					)
					(= local0 1)
					(gCurRoom drawPic: 7817)
					(Spinner init: global117 setActive: 1)
				)
				(= seconds 3)
			)
			(1
				(switch global261
					(5
						(test5 play: self)
					)
					(7
						(test7 play: self)
					)
				)
				(= local2 1)
				(teacher_225 case: 10)
				(Spinner setActive: 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sWrongAnswer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 0)
				(= seconds 1)
				(proc201_1 25)
			)
			(1
				(switch global261
					(5
						(if (< local0 3)
							(= local1 1)
							(wrong5 play: self)
						else
							(= local1 0)
							(teacher_225 case: 11)
							(finalWrong5 play: self)
						)
					)
					(7
						(if (< local0 3)
							(= local1 1)
							(wrong7 play: self)
						else
							(= local1 0)
							(teacher_225 case: 11)
							(finalWrong7 play: self)
						)
					)
				)
			)
			(2
				(if local1
					(self setScript: sGiveTest self)
				else
					(= cycles 1)
				)
			)
			(3
				(Spinner setActive: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRightAnswer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 0)
				(= seconds 1)
				(proc201_1 26)
			)
			(1
				(Spinner setLoop: 2 setCel: 0)
				(UpdateScreenItem Spinner)
				(switch global261
					(5
						(rightAnswer5 play: self)
					)
					(7
						(rightAnswer7 play: self)
					)
				)
			)
			(2
				(catCard init: setHotspot: 2)
				(= local3 1)
				(SetFlag 191)
				(FrameOut)
				(teacher_225 case: 9)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(teacher_225 dispose:)
				(catCard dispose:)
				(= seconds 2)
			)
			(1
				(crunchie init: global117)
				(chartOf41 init: stuffCast)
				(Spinner view: 7851 setLoop: 0 setCel: 46)
				(switch global261
					(5
						(leaveRoom5 play: self)
					)
					(7
						(leaveRoom7 play: self)
					)
				)
			)
			(2
				(SoundManager playMusic: 0 -1 7000)
				(Spinner setActive: 1)
				(exitToGate init:)
				(gCurRoom exitN: exitToGate)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShowDemo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
				(gGame handsOff:)
			)
			(1
				(testExample play: self)
			)
			(2
				(gGame handsOff:)
				(SetFlag 190)
				(self setScript: sGiveTest self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance testExample of VMDMovie
	(properties
		movieName 7850
		begPic 7815
		endPic 7816
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance test7 of VMDMovie
	(properties
		x 266
		movieName 7851
		begPic 7817
		endPic 7818
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance test5 of VMDMovie
	(properties
		x 266
		movieName 7852
		begPic 7819
		endPic 7820
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance wrong7 of VMDMovie
	(properties
		x 266
		movieName 7857
		begPic 7821
		endPic 7825
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance wrong5 of VMDMovie
	(properties
		x 266
		movieName 7858
		begPic 7823
		endPic 7825
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance finalWrong7 of VMDMovie
	(properties
		x 266
		movieName 7855
		begPic 7821
		endPic 7822
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance finalWrong5 of VMDMovie
	(properties
		x 266
		movieName 7856
		begPic 7823
		endPic 7824
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance rightAnswer7 of VMDMovie
	(properties
		movieName 7859
		begPic 7826
		endPic 7827
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance leaveRoom7 of VMDMovie
	(properties
		movieName 7860
		begPic 7828
		endPic 7807
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance rightAnswer5 of VMDMovie
	(properties
		movieName 7861
		begPic 7829
		endPic 7830
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance leaveRoom5 of VMDMovie
	(properties
		movieName 7862
		begPic 7831
		endPic 7807
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance spinner_225 of Feature
	(properties
		noun 56
		nsBottom 262
		nsLeft 183
		nsRight 227
		nsTop 175
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(class Spinner of Prop
	(properties
		noun 56
		x 174
		y 165
		active 0
		face 0
		turnSteps 15
		numOfFaces 4
		choice 0
	)

	(method (init &tmp temp0)
		(if (IsFlag 190)
			(if (and (IsFlag 191) (!= (proc70_9 6) 7800))
				(= view 7851)
			else
				(= view 7850)
			)
			(if local3
				(self setLoop: 2 setCel: 0)
			else
				(= cel global262)
				(= face
					(switch cel
						(0 0)
						(15 3)
						(30 2)
						(45 1)
					)
				)
				(self setActive: 1 setLoop: 0)
			)
			(super init: global117 &rest)
			(gExtMouseHandler addToFront: self)
			(self setHotspot: 144)
			(rightTurn init: setHotspot: 2)
			(gExtMouseHandler addToFront: rightTurn)
			(leftTurn init: setHotspot: 2)
			(gExtMouseHandler addToFront: leftTurn)
		)
	)

	(method (setActive param1)
		(= active param1)
	)

	(method (turnRight &tmp temp0 temp1)
		(if active
			(= active 0)
			(= temp1 (+ (self lastCel:) 1))
			(if (> (+ cel turnSteps) (self lastCel:))
				(= temp0 (self lastCel:))
			else
				(= temp0 (mod (+ cel turnSteps) temp1))
			)
			(= face (mod (+ (- face 1) numOfFaces) numOfFaces))
			(spinnerSnd play:)
			(self setCycle: CT temp0 1 self)
		)
	)

	(method (turnLeft &tmp temp0 temp1)
		(if active
			(= active 0)
			(= temp1 (+ (self lastCel:) 1))
			(= temp0 (mod (+ (- cel turnSteps) temp1) temp1))
			(= face (mod (+ face 1) numOfFaces))
			(spinnerSnd play:)
			(self setCycle: CT temp0 -1 self)
		)
	)

	(method (cue)
		(self setActive: 1)
		(if (== cel (self lastCel:))
			(= cel 0)
		)
		(= global262 cel)
	)

	(method (checkAnswer)
		(if local2
			(= local2 0)
			(self setActive: 0)
			(if (== choice global261)
				(gCurRoom setScript: sRightAnswer)
			else
				(gCurRoom setScript: sWrongAnswer)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(event localize: global116)
		(cond
			(
				(and
					(not (event type:))
					(self onMe: event)
					(!= (= temp1 (self whichNum: event)) -3)
				)
				(self doVerb: 1)
				(event claimed: 1)
			)
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(!= (= temp1 (self whichNum: event)) -3)
				)
				(event claimed: 1)
				(= choice temp1)
				(self checkAnswer:)
			)
			(else
				(event globalize:)
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if
					(or
						local3
						(and
							(gTheCursor isInvCursor:)
							(== 114 (proc70_7 (gTheCursor invItem:)))
						)
					)
					(super doVerb: theVerb)
				else
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (whichNum param1)
		(if
			(and
				(gTheCursor isInvCursor:)
				(== 114 (proc70_7 (gTheCursor invItem:)))
			)
			(return -3)
		)
		(cond
			((InRect 189 179 222 198 param1)
				(return (+ 1 (* face numOfFaces)))
			)
			((InRect 189 200 222 219 param1)
				(return (+ 2 (* face numOfFaces)))
			)
			((InRect 189 221 222 240 param1)
				(return (+ 3 (* face numOfFaces)))
			)
			((InRect 189 242 222 261 param1)
				(return (+ 4 (* face numOfFaces)))
			)
			(else
				(return -3)
			)
		)
	)

	(method (dispose)
		(gExtMouseHandler delete: self)
		(gExtMouseHandler delete: rightTurn)
		(gExtMouseHandler delete: leftTurn)
		(rightTurn dispose:)
		(leftTurn dispose:)
		(super dispose: &rest)
	)
)

(instance rightTurn of Feature
	(properties
		nsBottom 178
		nsLeft 214
		nsRight 229
		nsTop 161
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (and (not local3) (Spinner isNotHidden:))
					(super doVerb: theVerb)
				)
			)
			(2
				(Spinner turnRight:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftTurn of Feature
	(properties
		nsBottom 178
		nsLeft 173
		nsRight 188
		nsTop 161
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (and (not local3) (Spinner isNotHidden:))
					(super doVerb: theVerb)
				)
			)
			(2
				(Spinner turnLeft:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chartOf41 of View
	(properties
		noun 60
		loop 1
		cel 1
		view 7850
	)

	(method (init)
		(if (== (proc70_9 7) 7800)
			(super init: &rest)
			(if (and (IsFlag 191) (!= (proc70_9 6) 7800))
				(self setHotspot: 2 144)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 7)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance crunchie of View
	(properties
		x 240
		y 284
		loop 1
		view 7850
	)

	(method (init)
		(if (== (proc70_9 89) 7800)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 89)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance catCard of Feature
	(properties
		nsBottom 200
		nsLeft 283
		nsRight 300
		nsTop 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 6)
				(= local3 0)
				(switch global261
					(5
						(gCurRoom drawPic: 7831)
					)
					(7
						(gCurRoom drawPic: 7828)
					)
				)
				(gCurRoom setScript: sLeaveRoom)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftCursor of View
	(properties
		view 600
	)
)

(instance drum_225 of Feature
	(properties
		noun 58
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 307 257 322 250 338 256 342 275 329 285 314 284 304 275 308 258
					yourself:
				)
		)
	)
)

(instance blackBoard_225 of Feature
	(properties
		noun 57
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 366 106 376 90 445 94 455 109 453 217 423 240 404 241 368 220 368 107
					yourself:
				)
		)
	)
)

(instance teacher_225 of Feature
	(properties
		noun 55
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 253 220 282 192 293 148 305 136 327 136 349 149 352 194 379 234 338 237 288 239 239 217
					yourself:
				)
		)
	)
)

(instance foodDish_225 of Feature
	(properties
		noun 59
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 247 262 252 258 284 258 286 261 286 277 278 283 242 279 243 269 248 261
					yourself:
				)
		)
	)
)

(instance spinnerSnd of Sound
	(properties
		number 7800
		flags 5
	)
)

