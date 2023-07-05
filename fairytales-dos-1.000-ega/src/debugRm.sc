;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use n010)
(use Interface)
(use PolyEdit)
(use WriteFeature)
(use Window)
(use User)
(use Actor)
(use System)

(public
	debugRm 0
)

(local
	local0
)

(procedure (localproc_0 &tmp temp0)
	(while (!= ((= temp0 (Event new:)) message:) KEY_ALT_o)
		(if (== (temp0 message:) KEY_ALT_g)
			(gGame doit:)
		else
			(temp0 dispose:)
		)
	)
)

(instance debugRm of Script
	(properties)

	(method (handleEvent event &tmp temp0 temp1 [temp2 2] temp4 [temp5 80] temp85 temp86)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((& (event modifiers:) emCTRL)
						(event claimed: 1)
						(User canControl: 1)
						(while (!= evMOUSERELEASE ((= temp0 (Event new:)) type:))
							(GlobalToLocal temp0)
							(Animate (gCast elements:) 0)
							(gEgo posn: (temp0 x:) (temp0 y:) setMotion: 0)
							(temp0 dispose:)
						)
						(temp0 dispose:)
					)
					((& (event modifiers:) emSHIFT)
						(event claimed: 1)
						(= temp1
							(Print
								(Format @temp5 800 0 (event x:) (event y:)) ; "%d/%d"
								#at
								(- (event x:) 21)
								(- (event y:) 17)
								#font
								999
								#dispose
							)
						)
						(while (!= evMOUSERELEASE ((= temp0 (Event new:)) type:))
							(temp0 dispose:)
						)
						(temp1 dispose:)
						(temp0 dispose:)
					)
				)
			)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_ALT_t
						(SetFlag 4)
						(= temp85 (GetNumber {Which room number?}))
						(gCurRoom newRoom: temp85)
					)
					(KEY_QUESTION
						(Print 800 1 #window SysWindow) ; "Debug Key commands: ALT-A  Cursor Position ALT-B  Polygon Editor ALT-C  Control ALT-E  Show ego ALT-F  Set/Clr Flag ALT-G  Go one cycle   (in single-step mode only) ALT-L  Open Log File ALT-M  Show memory ALT-O  Single-Step ALT-P  Priority ALT-S  Show cast ALT-T  Teleport ALT-V  Visual ALT-W  Feature Writer ALT-X  eXit game quickly"
					)
					(KEY_ALT_a
						(Printf 800 2 (event x:) (event y:)) ; "Cursor X: %d Y: %d"
					)
					(KEY_ALT_b
						(PolyEdit doit:)
					)
					(KEY_ALT_s
						(for
							((= temp4 (gCast first:)))
							temp4
							((= temp4 (gCast next: temp4)))
							
							(= temp1 (NodeValue temp4))
							(Print
								(Format ; "view: %d (x,y):%d,%d STOPUPD=%d IGNRACT=%d ILLBITS=$%x"
									@temp5
									800
									3
									(temp1 view:)
									(temp1 x:)
									(temp1 y:)
									(/ (& (temp1 signal:) $0004) 4)
									(/ (& (temp1 signal:) $4000) 16384)
									(if
										(or
											(== (temp1 superClass:) Actor)
											(== (temp1 superClass:) Ego)
										)
										(temp1 illegalBits:)
									else
										-1
									)
								)
								#window
								SysWindow
								#title
								(temp1 name:)
								#icon
								(temp1 view:)
								(temp1 loop:)
								(temp1 cel:)
							)
						)
					)
					(KEY_ALT_m
						(gGame showMem:)
					)
					(KEY_ALT_e
						(Format ; "ego x:%d y:%d loop:%d cel:%d"
							@temp5
							800
							4
							(gEgo x:)
							(gEgo y:)
							(gEgo loop:)
							(gEgo cel:)
						)
						(Print @temp5 #icon (gEgo view:) 0 0)
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_p
						(Show 2)
					)
					(KEY_ALT_c
						(Show 4)
					)
					(KEY_ALT_k
						(if local0
							(gGame doit:)
						)
					)
					(KEY_ALT_l
						(if (> (MemoryInfo 0) 1536) ; LargestPtr
							((ScriptID 952) doit: @gSysLogPath) ; sysLogger
						else
							(Print 800 5) ; "Not Enough Memory!!"
						)
						(event claimed: 1)
					)
					(KEY_ALT_o
						(if local0
							(= local0 0)
						else
							(= local0 1)
							(localproc_0)
						)
					)
					(KEY_ALT_f
						(= temp4 0)
						(= temp4 (GetNumber {Flag Number:}))
						(if (IsFlag temp4)
							(Print 800 6) ; "clearing flag"
							(ClearFlag temp4)
						else
							(Print 800 7) ; "setting flag"
							(SetFlag temp4)
						)
					)
					(KEY_ALT_w
						(CreateObject doit:)
					)
					(KEY_ALT_x
						(= gQuit 1)
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
		(DisposeScript 800)
	)
)

