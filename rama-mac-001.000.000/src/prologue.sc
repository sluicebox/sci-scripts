;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Location)
(use Compass)
(use SoundManager)
(use VMDMovie)
(use SpeedTest)
(use DText)
(use Str)
(use Print)
(use Sound)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	prologue 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7 = 4
	local8
	local9
	local10
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(if (== local7 4)
		(return 0)
	else
		(= temp2 (Str new:))
		(temp2 name: {tmpStr})
		(temp2 format: &rest)
		(= temp0 (temp2 size:))
		(tmpDlg
			font: 0
			text: (temp2 data:)
			fore: 200
			back: 0
			setPri: 500
			setSize: 700
			x: 20
			y: 350
			init: ((global124 casts:) at: 0)
		)
		(temp2 dispose:)
	)
)

(class PrologueRoom of Location
	(properties
		currentIndex 0
		currentRes 0
	)

	(method (init &tmp temp0)
		((ScriptID 16 0) init:) ; Prologue_Interface
		(super init:)
		(self setPicObj: currentCameraAngle)
		(Compass clear:)
		(self drawPic: 61)
		(if (not (demoFile open: 1))
			(Prints {Missing Data File})
			(if (ResCheck rsSCRIPT 1015)
				(demoFile dispose:)
				(gCurRoom newRoom: 1015) ; easyPickins
				(return)
			else
				(gGame quitGame:)
			)
		)
		(= temp0 0)
		(= gHowFast (SpeedTest))
		(= local0 (Str with: {\t ;\n""}))
		(local0 name: {seperators})
		(= local1 (Str with: {\t\n;"}))
		(local1 name: {stringSeperators})
		(= local4 (Str newWith: 8))
		(local4 name: {resourceName})
		(if (and temp0 (not (ResCheck rsSCRIPT 1015)))
			(= local7 5)
			(copyres_bat open: 2)
			(= local2 (Str new:))
			(local2 name: {output String})
			(copyres_bat writeString: {echo y|del sound\\*.*\n\0d\n})
			(copyres_bat writeString: {echo y|del vmd\\*.*\n\0d\n})
			(copyres_bat writeString: {echo y|del pic\\*.*\n\0d\n})
			(copyres_bat writeString: {echo y|del view\\*.*\n\0d\n})
			(copyres_bat
				writeString: {echo y|copy m:\\prog\\vmd\\4100?.vmd vmd\n\0d\n}
			)
		else
			(= local8 (Platform 1))
		)
		(= currentRes (MyResourceItem new:))
		(currentRes init:)
		(while (demoFile read: currentRes)
			(if (and temp0 (not (ResCheck rsSCRIPT 1015)))
				(switch (currentRes resType:)
					(0
						(local2
							format:
								{echo y|copy m:\\prog\\vmd\\%s.vmd vmd\n\0d\n}
								local4
						)
					)
					(1
						(local2
							format:
								{echo y|copy m:\\prog\\pic\\%s.p56 pic\n\0d\n}
								local4
						)
					)
					(2
						(local2
							format:
								{echo y|copy m:\\prog\\sound\\%s.wav sound\n\0d\n}
								local4
						)
					)
					(3
						(local2
							format:
								{echo y|copy m:\\prog\\view\\%s.v56 view\n\0d\n}
								local4
						)
					)
				)
				(copyres_bat writeString: (local2 data:))
			)
			(resourceList addToEnd: currentRes)
			(= currentRes (MyResourceItem new:))
			(currentRes init:)
		)
		(currentRes dispose:)
		(if (and temp0 (not (ResCheck rsSCRIPT 1015)))
			(copyres_bat dispose:)
			(local2 dispose:)
		)
		(local1 dispose:)
		(local0 dispose:)
		(local4 dispose:)
		(demoFile dispose:)
		(= currentIndex 0)
		(gGame handsOn:)
	)

	(method (dispose)
		(resourceList dispose:)
		(super dispose:)
	)

	(method (getNextResource param1 &tmp temp0 temp1 temp2)
		(if (>= currentIndex (resourceList size:))
			(= currentIndex 0)
		)
		(if (or (== (myWave prevSignal:) -1) (not param1))
			(= currentRes (resourceList at: currentIndex))
			(++ currentIndex)
			(if (< currentIndex (resourceList size:))
				(= temp0 (resourceList at: currentIndex))
				(= local5 (temp0 startTime:))
			else
				(= currentIndex 0)
				(= temp0 (resourceList at: 0))
				(= local5 (temp0 startTime:))
			)
		else
			(= currentRes (resourceList at: currentIndex))
			(cond
				((== (currentRes resType:) 2)
					(if (< currentIndex (resourceList size:))
						(= temp0 (resourceList at: (+ currentIndex 1)))
						(= local5 (temp0 startTime:))
						(++ currentIndex)
					else
						(= currentIndex 0)
						(= temp0 (resourceList at: 0))
						(= local5 (temp0 startTime:))
					)
				)
				((> (currentRes startTime:) param1)
					(= local5 (currentRes startTime:))
					(return 0)
				)
				((== (currentRes startTime:) -1))
				(else
					(for
						((= temp1 (+ currentIndex 1)))
						(< temp1 (resourceList size:))
						((++ temp1))
						
						(= temp0 (resourceList at: temp1))
						(if
							(or
								(and
									(<= (currentRes startTime:) param1)
									(< param1 (temp0 startTime:))
								)
								(== (temp0 startTime:) -1)
							)
							(= local5 (temp0 startTime:))
							(= local9 (currentRes startTime:))
							(= currentIndex temp1)
							(return currentRes)
						else
							(= currentRes temp0)
						)
					)
					(= currentIndex temp1)
				)
			)
		)
		(= local9 (currentRes startTime:))
		(return currentRes)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(149
				(if (ResCheck rsSCRIPT 1015)
					(gCurRoom newRoom: 1015) ; easyPickins
				else
					(gGame quitGame:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((OneOf (event message:) KEY_ALT_x KEY_ALT_x KEY_ESCAPE)
				(if (ResCheck rsSCRIPT 1015)
					(gCurRoom newRoom: 1015) ; easyPickins
				else
					(gGame quitGame:)
				)
			)
			((== local9 -1)
				(if (& (event type:) evMOUSEBUTTON)
					(if (== (currentRes resType:) 4)
						(DemoScript prevAudTime: 0)
					)
					(DemoScript lastTicks: gGameTime)
					(DemoScript cue:)
					(event claimed: 1)
					(return)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(class MyResourceItem of Obj
	(properties
		resType 0
		resNumber 0
		resName 0
		seconds 0
		loop -1
		startCel -1
		endCel -1
		textDesc 0
		startTime -1
		pixelDouble 0
	)

	(method (init)
		(super init: &rest)
		(= textDesc (Str newWith: 20))
		(textDesc name: {textDesc})
	)

	(method (dispose)
		(if textDesc
			(textDesc dispose:)
		)
		(if resName
			(resName dispose:)
		)
		(super dispose:)
	)
)

(instance resourceList of List
	(properties)
)

(instance currentCameraAngle of CameraAngle
	(properties
		picture 60
		edgeN 0
		edgeS 0
		edgeE 0
		edgeW 0
	)
)

(instance copyres_bat of File
	(properties
		name {copyres.bat}
	)
)

(instance demoFile of File
	(properties)

	(method (open param1 &tmp temp0)
		(= temp0 (Str newWith: 128 global126))
		(temp0 cat: {prologue.dat})
		(= name (KArray 8 (temp0 data:))) ; ArrayDup
		(super open: param1)
	)

	(method (readString param1 param2 &tmp temp0)
		(if (= temp0 (super readString: param1 param2))
			(param1 strip: 135 136)
		)
		(return temp0)
	)

	(method (read param1 &tmp temp0 temp1 temp2)
		(= temp1 (Str newWith: 132))
		(temp1 name: {read string})
		(= temp2 (Str new:))
		(temp2 name: {token})
		(while
			(and
				(self readString: temp1 132)
				(or (not (temp1 size:)) ((temp1 subStr: 0 1) compare: {;}))
			)
		)
		(if
			(and
				(temp1 size:)
				(not ((temp1 subStr: 0 1) compare: {;}))
				(temp1 getToken: local0 temp2)
				(!= (temp2 at: 0) 0)
			)
			(temp2 upper:)
			(cond
				((temp2 compare: {VMD})
					(param1 resType: 0)
				)
				((temp2 compare: {PIC})
					(param1 resType: 1)
				)
				((temp2 compare: {WAV})
					(param1 resType: 2)
				)
				((temp2 compare: {VIEW})
					(param1 resType: 3)
				)
				((temp2 compare: {END})
					(param1 resType: 4)
				)
				(else
					(PrintDebug {error reading type})
					(return 0)
				)
			)
			(temp1 getToken: local0 temp2)
			(param1 resName: (Str new:))
			((param1 resName:) format: {%s} temp2)
			(local4 format: {%s} temp2)
			(param1 resNumber: (temp2 asInteger:))
			(switch (param1 resType:)
				(0
					(temp1 getToken: local0 temp2)
					(param1 startTime: (* (temp2 asInteger:) 6))
					(if
						(and
							(<= gHowFast 800)
							(ResCheck 151 (+ (param1 resNumber:) 1000)) ; VMD
						)
						(param1 resNumber: (+ (param1 resNumber:) 1000))
						(param1 pixelDouble: 1)
					)
				)
				(1
					(temp1 getToken: local0 temp2)
					(param1 startTime: (* (temp2 asInteger:) 6))
				)
				(2
					(temp1 getToken: local0 temp2)
					(temp2 strip: 135 136)
					(param1 seconds: (temp2 asInteger:))
					(param1 startTime: 0)
				)
				(3
					(Load rsVIEW (param1 resNumber:))
					(temp1 getToken: local0 temp2)
					(temp2 strip: 135 136)
					(param1 loop: (temp2 asInteger:))
					(temp1 getToken: local0 temp2)
					(temp2 strip: 135 136)
					(param1 startCel: (temp2 asInteger:))
					(temp1 getToken: local0 temp2)
					(temp2 strip: 135 136)
					(param1 endCel: (temp2 asInteger:))
					(temp1 getToken: local0 temp2)
					(param1 startTime: (* (temp2 asInteger:) 6))
				)
				(4
					(temp1 getToken: local0 temp2)
					(if (< (temp2 asInteger:) 0)
						(param1 startTime: -1)
					else
						(param1 startTime: (* (temp2 asInteger:) 6))
					)
				)
			)
			(if (temp1 size:)
				(temp1 strip: 135 136)
				(if ((temp1 subStr: 0 1) compare: {;})
					((param1 textDesc:) fill: 0 19 32)
				else
					(temp1 getToken: local1 (param1 textDesc:))
					((param1 textDesc:) strip: 135 136)
				)
			else
				((param1 textDesc:) fill: 0 19 32)
			)
			(= temp0 1)
		else
			(= temp0 0)
		)
		(temp2 dispose:)
		(temp1 dispose:)
		(return temp0)
	)
)

(instance myVMDMovie of VMDMovie
	(properties
		endPic 60
		showCursor 1
	)
)

(instance myView of Prop
	(properties
		x 296
		y 146
	)
)

(instance myWave of Sound
	(properties
		flags 1
	)

	(method (init)
		(= local6 1)
		(super init: &rest)
	)

	(method (dispose)
		(= local6 0)
		(super dispose: &rest)
	)
)

(class DemoScript of Script
	(properties
		audioTime 0
		prevAudTime 0
		prevResType 4
		currentRes 0
		endDemo 0
	)

	(method (updateTime &tmp temp0)
		(if (gSounds size:)
			(= temp0 (Abs (- gGameTime lastTicks)))
			(= lastTicks gGameTime)
			(= audioTime (DoAudio audPOSITION))
		else
			(= audioTime 0)
		)
		(if (and (<= audioTime 0) prevAudTime)
			(= local10 1)
			(= audioTime (+ prevAudTime temp0))
		)
		(= prevAudTime audioTime)
	)

	(method (cue &tmp temp0)
		(self updateTime:)
		(if currentRes
			(= prevResType (currentRes resType:))
		)
		(if (= temp0 (gCurRoom getNextResource: audioTime))
			(= currentRes temp0)
			(localproc_0
				{Name: %s Start Time: %d CurrentTime: %d next start: %d SR: %d CD: %d Mem %d Err %d}
				(currentRes resName:)
				(/ (currentRes startTime:) 6)
				(/ audioTime 6)
				(/ local5 6)
				gHowFast
				local8
				(MemoryInfo 0)
				local10
			)
			(self changeState: (+ state 1) &rest)
		)
	)

	(method (doit)
		(if (currentRes textDesc:)
			(global123 displayOptionsText: ((currentRes textDesc:) data:))
		)
		(self updateTime:)
		(if (== local9 -1)
			(localproc_0 {Waiting %d} (/ audioTime 6))
		else
			(if (<= local5 audioTime)
				(self cue:)
			)
			(if currentRes
				(localproc_0
					{Name: %s Start Time: %d CurrentTime: %d next start: %d SR: %d CD: %d Mem %d Err %d}
					(currentRes resName:)
					(/ (currentRes startTime:) 6)
					(/ audioTime 6)
					(/ local5 6)
					gHowFast
					local8
					(MemoryInfo 0)
					local10
				)
			else
				(localproc_0
					{Name: NULL Start Time: %d CurrentTime: ** next start: %d SR: %d CD: %d Mem %d Err %d}
					(/ audioTime 6)
					(/ local5 6)
					gHowFast
					local8
					(MemoryInfo 0)
					local10
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if (currentRes textDesc:)
					(global123
						displayOptionsText: ((currentRes textDesc:) data:)
					)
				)
				(switch (currentRes resType:)
					(0
						(myVMDMovie movieName: (currentRes resNumber:))
						(= state -1)
						(if (currentRes pixelDouble:)
							(myVMDMovie options: 1)
						else
							(myVMDMovie options: 0)
						)
						(gTheCursor setTempCursor: ramanWaitCursor 150)
						(= temp3 0)
						(if (== 1 0)
							(= temp3 1)
							(= temp1 (myVMDMovie options:))
							(myVMDMovie options: 5)
							(myVMDMovie boostRGB: 30)
						)
						(myVMDMovie play:)
						(if temp3
							(myVMDMovie options: temp1)
							(myVMDMovie boostRGB: 0)
							(= temp3 0)
							(= temp1 (= temp2 0))
						)
					)
					(1
						(gCurRoom drawPic: 60)
						(FrameOut)
						(= state -1)
						(gCurRoom drawPic: (currentRes resNumber:))
					)
					(3
						(gCurRoom drawPic: 60)
						(FrameOut)
						(myView view: (currentRes resNumber:))
						(myView loop: (currentRes loop:))
						(myView cel: (currentRes startCel:))
						(myView init: global117)
						(myView setCycle: CT (currentRes endCel:) 1 self)
					)
					(2
						(if local6
							(myWave stop:)
						)
						(= local6 1)
						(= state -1)
						(DoAudio 12 0) ; AudMixCheck
						(myWave number: (currentRes resNumber:))
						(myWave play: 127 0 setLoop: (currentRes seconds:))
						(myWave prevSignal: 0)
					)
					(4
						(= local10 (= prevAudTime 0))
						(= endDemo (== (currentRes resNumber:) -1))
					)
				)
			)
			(1
				(= ticks (= seconds (= cycles 0)))
				(= state -1)
				(switch prevResType
					(3
						(myView dispose:)
						(self changeState: 0)
					)
					(4
						(if endDemo
							(if (ResCheck rsSCRIPT 1015)
								(gCurRoom newRoom: 1015) ; easyPickins
							else
								(gGame quitGame:)
							)
						else
							(if (and local6 (not (== (myWave prevSignal:) -1)))
								(myWave stop:)
							)
							(gCurRoom drawPic: 60)
							(myWave prevSignal: 0)
							(FrameOut)
							(self changeState: 0)
						)
					)
				)
			)
		)
	)
)

(instance tmpDlg of DText
	(properties)
)

(instance ramanWaitCursor of View
	(properties
		view 997
	)
)

(instance prologue of PrologueRoom
	(properties)

	(method (init)
		(super init: &rest)
		(SoundManager stopMusic:)
		(if (> (resourceList size:) 0)
			(self setScript: demoScript)
		)
	)
)

(instance demoScript of DemoScript
	(properties)
)

