;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63002)
(include sci.sh)
(use Main)
(use Str)
(use Polygon)
(use TextField)
(use User)
(use System)

(public
	IsFlag 0
	SetFlag 1
	ClearFlag 2
	proc63002_3 3
	proc63002_4 4
	proc63002_5 5
	proc63002_6 6
	proc63002_7 7
	proc63002_8 8
	proc63002_9 9
	proc63002_10 10
	proc63002_11 11
	proc63002_12 12
	proc63002_13 13
)

(local
	[local0 4] = [0 0 100 0]
	local4 = 4
	local5 = 2
	local6 = 1
)

(procedure (IsFlag param1 &tmp temp0)
	(return (& [global101 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (proc63002_3 param1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
		(if (IsFlag [param1 temp0])
			(return 1)
		)
	)
	(return 0)
)

(procedure (proc63002_4 param1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
		(if (not (IsFlag [param1 temp0]))
			(return 0)
		)
	)
	(return 1)
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1 1))
	(= [global101 (/ param1 16)]
		(| [global101 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [global101 (/ param1 16)]
		(& [global101 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(procedure (proc63002_5 &tmp temp0) ; UNUSED
	(for ((= temp0 100)) (> temp0 0) ((-= temp0 1))
		(Palette 2 3 255 temp0) ; PalIntensity
		(FrameOut)
	)
)

(procedure (proc63002_6 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (< temp0 100) ((+= temp0 1))
		(Palette 2 3 255 temp0) ; PalIntensity
		(FrameOut)
	)
)

(procedure (proc63002_7 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp2 (gP2SongPlyr volPercent:))
	(if global243
		(= temp5 100)
	else
		(= temp5 global241)
	)
	(if global211
		(gP2SongPlyr fadeOut: global212)
	else
		(gP2SongPlyr fadeTo: (/ (* temp2 temp5) 100))
	)
	(= temp0 (Str new:))
	(gTheCursor hide:)
	(for ((= temp1 0)) (< temp1 argc) ((++ temp1))
		(= global219 (ScriptID (+ 63025 (- gChapter 1))))
		(if (!= (= temp4 (global219 lookUp: [param1 temp1])) -1)
			(global219 set: temp4)
		)
		(temp0 format: {%d.vmd} [param1 temp1])
		(= temp6 0)
		(cond
			((ResCheck 152 [param1 temp1])
				(= temp6 152)
			)
			((ResCheck 151 [param1 temp1]) ; VMD
				(= temp6 151)
			)
		)
		(if temp6
			((ScriptID 0 2) hide:) ; topInterfacePlane
			(FrameOut)
			(Palette 2 3 31 100) ; PalIntensity
			(if (or (== [param1 temp1] 7960) (== [param1 temp1] 7965))
				(gP2SongPlyr stop:)
			)
			(if (== temp6 151)
				(PlayVMD 0 (temp0 data:)) ; Open
				(if (and (> argc 1) (< temp1 (- argc 1)))
					(PlayVMD
						1 ; Put
						0
						72
						(| (| (| $0050 local6) local5) local4)
						50
						0
						10000
					)
				else
					(PlayVMD
						1 ; Put
						0
						72
						(| (| (| (| global213 local6) local5) local4) $0010)
						50
						0
						10000
					)
				)
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
			else
				(if (and (> argc 1) (< temp1 (- argc 1)))
					(PlayDuck 2 0) ; DoFrameOut
				else
					(PlayDuck 2 1) ; DoFrameOut
				)
				(PlayDuck 6 global235) ; Volume
				(PlayDuck 1 [param1 temp1] 1 0 71 (Max global400 512)) ; Play
				(proc63002_8)
			)
			(Palette 2 3 31 0) ; PalIntensity
			((ScriptID 0 2) show:) ; topInterfacePlane
		else
			(PrintDebug {Movie %s} (temp0 data:))
			(PrintDebug {should play here.})
		)
	)
	(gTheCursor show:)
	(if (or (and global211 global212) (not global211))
		(gP2SongPlyr pause: 0)
		(gP2SongPlyr fadeTo: temp2)
	)
	(= global211 0)
	(= global212 1)
	(= global213 0)
	(= global243 0)
	(proc63002_8)
	(temp0 dispose:)
	(((ScriptID 0 2) cast:) eachElementDo: #update) ; topInterfacePlane
)

(procedure (proc63002_8 &tmp temp0)
	(while ((= temp0 (Event new: 3)) type:)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(procedure (localproc_0) ; UNUSED
	(proc64986_0 &rest)
)

(procedure (proc63002_9 &tmp temp0 temp1) ; UNUSED
	(= temp0 (Str format: {Y}))
	(proc64986_1 temp0 1 &rest)
	(= temp1 (OneOf (temp0 at: 0) 49 121 89))
)

(procedure (proc63002_10 &tmp temp0)
	(= temp0 (Polygon new:))
	(if argc
		(temp0 init: &rest)
	)
	(return temp0)
)

(procedure (proc63002_11 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4)
	(if (> (= temp4 (+ 20 global236)) 127)
		(= temp4 127)
	)
	(FrameOut)
	(= temp1 (Str new:))
	(if
		(or
			(not (= temp0 (Message msgSIZE param1 param2 param3 param4 param5)))
			(not (Message msgGET param1 param2 param3 param4 param5 (temp1 data:)))
		)
		(PrintDebug
			{Message not found:m%d n%d v%d c%d s%d\n}
			param1
			param2
			param3
			param4
			param5
		)
		(temp1 data: 0 dispose:)
		(return 0)
	)
	(if (== 0 (DoAudio audPLAY param1 param2 param3 param4 param5 1 temp4))
		(= temp2 (TextView new:))
		(temp2 y: 170 x: 144 setPri: 5000)
		(temp2 setText: param1 param2 param3 param4 param5 setSize: init:)
		(FrameOut)
		(while (= temp3 (Event new:))
			(if (& (temp3 type:) evMOUSEBUTTON)
				(break)
			)
			(temp3 dispose:)
		)
		(temp3 dispose:)
		(temp2 dispose:)
	else
		(while (= temp3 (Event new:))
			(if (!= -1 (DoAudio audPOSITION param1 param2 param3 param4 param5))
				(if (& (temp3 type:) evMOUSEBUTTON)
					(DoAudio audSTOP param1 param2 param3 param4 param5)
					(break)
				)
			else
				(break)
			)
			(temp3 dispose:)
		)
		(temp3 dispose:)
	)
	(temp1 data: 0 dispose:)
	(return (gGame handsOn:))
)

(procedure (proc63002_12 param1) ; UNUSED
	((if (gRoboGary isPlaying:) gRoboGary else gP2SongPlyr) fadeTo: param1 &rest)
)

(procedure (proc63002_13 param1 param2)
	(return
		(and
			(> (param1 bottom:) (param2 top:))
			(< (param1 top:) (param2 bottom:))
			(> (param1 right:) (param2 left:))
			(< (param1 left:) (param2 right:))
		)
	)
)

